package com.tencent.mars.zstd;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ZstdDirectBufferCompressingStream implements Closeable, Flushable {
    private boolean closed = false;
    private int consumed = 0;
    private byte[] dict = null;
    private ZstdDictCompress fastDict = null;
    private boolean initialized = false;
    private int level = 3;
    private int produced = 0;
    private final long stream;
    private ByteBuffer target;

    private native int compressDirectByteBuffer(long j, ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4);

    private static native long createCStream();

    private native int endStream(long j, ByteBuffer byteBuffer, int i, int i2);

    private native int flushStream(long j, ByteBuffer byteBuffer, int i, int i2);

    private static native int freeCStream(long j);

    private native int initCStream(long j, int i);

    private native int initCStreamWithDict(long j, byte[] bArr, int i, int i2);

    private native int initCStreamWithFastDict(long j, ZstdDictCompress zstdDictCompress);

    private static native long recommendedCOutSize();

    /* Access modifiers changed, original: protected */
    public ByteBuffer flushBuffer(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public ZstdDirectBufferCompressingStream(ByteBuffer byteBuffer, int i) {
        this.target = byteBuffer;
        this.level = i;
        if (byteBuffer.isDirect()) {
            this.stream = createCStream();
            return;
        }
        throw new IllegalArgumentException("Target buffer should be a direct buffer");
    }

    public static int recommendedOutputBufferSize() {
        return (int) recommendedCOutSize();
    }

    public ZstdDirectBufferCompressingStream setDict(byte[] bArr) {
        if (this.initialized) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.dict = bArr;
        this.fastDict = null;
        return this;
    }

    public ZstdDirectBufferCompressingStream setDict(ZstdDictCompress zstdDictCompress) {
        if (this.initialized) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.dict = null;
        this.fastDict = zstdDictCompress;
        return this;
    }

    public void compress(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Source buffer should be a direct buffer");
        } else if (this.closed) {
            throw new IOException("Stream closed");
        } else {
            int initCStreamWithFastDict;
            if (!this.initialized) {
                if (this.fastDict != null) {
                    initCStreamWithFastDict = initCStreamWithFastDict(this.stream, this.fastDict);
                } else if (this.dict != null) {
                    initCStreamWithFastDict = initCStreamWithDict(this.stream, this.dict, this.dict.length, this.level);
                } else {
                    initCStreamWithFastDict = initCStream(this.stream, this.level);
                }
                if (Zstd.isError((long) initCStreamWithFastDict)) {
                    throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName((long) initCStreamWithFastDict));
                }
                this.initialized = true;
            }
            while (byteBuffer.hasRemaining()) {
                if (!this.target.hasRemaining()) {
                    this.target = flushBuffer(this.target);
                    if (!this.target.isDirect()) {
                        throw new IllegalArgumentException("Target buffer should be a direct buffer");
                    } else if (!this.target.hasRemaining()) {
                        throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
                    }
                }
                initCStreamWithFastDict = compressDirectByteBuffer(this.stream, this.target, this.target.position(), this.target.remaining(), byteBuffer, byteBuffer.position(), byteBuffer.remaining());
                if (Zstd.isError((long) initCStreamWithFastDict)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) initCStreamWithFastDict));
                }
                this.target.position(this.target.position() + this.produced);
                byteBuffer.position(byteBuffer.position() + this.consumed);
            }
        }
    }

    public void flush() {
        if (!this.closed && this.initialized) {
            int flushStream;
            do {
                flushStream = flushStream(this.stream, this.target, this.target.position(), this.target.remaining());
                if (Zstd.isError((long) flushStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) flushStream));
                }
                this.target.position(this.target.position() + this.produced);
                this.target = flushBuffer(this.target);
                if (!this.target.isDirect()) {
                    throw new IllegalArgumentException("Target buffer should be a direct buffer");
                } else if (flushStream > 0 && !this.target.hasRemaining()) {
                    throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
                }
            } while (flushStream > 0);
        }
    }

    public void close() {
        if (!this.closed) {
            try {
                if (this.initialized) {
                    int endStream;
                    do {
                        endStream = endStream(this.stream, this.target, this.target.position(), this.target.remaining());
                        if (Zstd.isError((long) endStream)) {
                            throw new IOException("Compression error: " + Zstd.getErrorName((long) endStream));
                        }
                        this.target.position(this.target.position() + this.produced);
                        this.target = flushBuffer(this.target);
                        if (!this.target.isDirect()) {
                            throw new IllegalArgumentException("Target buffer should be a direct buffer");
                        } else if (endStream > 0 && !this.target.hasRemaining()) {
                            throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
                        }
                    } while (endStream > 0);
                }
                freeCStream(this.stream);
                this.closed = true;
                this.initialized = false;
                this.target = null;
            } catch (Throwable th) {
                freeCStream(this.stream);
                this.closed = true;
                this.initialized = false;
                this.target = null;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        close();
    }
}
