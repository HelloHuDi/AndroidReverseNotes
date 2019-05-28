package com.tencent.mars.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ZstdOutputStream extends FilterOutputStream {
    private static final int dstSize = ((int) recommendedCOutSize());
    private boolean closeFrameOnFlush;
    private byte[] dict;
    private byte[] dst;
    private long dstPos;
    private ZstdDictCompress fastDict;
    private boolean frameClosed;
    private boolean isClosed;
    private int level;
    private long srcPos;
    private long stream;
    private boolean useChecksum;

    private native int compressStream(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private static native long createCStream();

    private native int endStream(long j, byte[] bArr, int i);

    private native int flushStream(long j, byte[] bArr, int i);

    private static native int freeCStream(long j);

    private native int initCStream(long j, int i, int i2);

    private native int initCStreamWithDict(long j, byte[] bArr, int i, int i2, int i3);

    private native int initCStreamWithFastDict(long j, ZstdDictCompress zstdDictCompress, int i);

    private static native long recommendedCOutSize();

    public ZstdOutputStream(OutputStream outputStream, int i, boolean z, boolean z2) {
        super(outputStream);
        this.srcPos = 0;
        this.dstPos = 0;
        this.dst = null;
        this.isClosed = false;
        this.frameClosed = true;
        this.dict = null;
        this.fastDict = null;
        this.closeFrameOnFlush = z;
        this.level = i;
        this.useChecksum = z2;
        this.stream = createCStream();
        this.dst = new byte[dstSize];
    }

    public ZstdOutputStream(OutputStream outputStream, int i, boolean z) {
        this(outputStream, i, z, false);
    }

    public ZstdOutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, false);
    }

    public ZstdOutputStream(OutputStream outputStream) {
        this(outputStream, 3, false);
    }

    public ZstdOutputStream setChecksum(boolean z) {
        if (this.frameClosed) {
            this.useChecksum = z;
            return this;
        }
        throw new IOException("Change of parameter on initialized stream");
    }

    public ZstdOutputStream setDict(byte[] bArr) {
        if (this.frameClosed) {
            this.fastDict = null;
            this.dict = bArr;
            return this;
        }
        throw new IOException("Change of parameter on initialized stream");
    }

    public ZstdOutputStream setDict(ZstdDictCompress zstdDictCompress) {
        if (this.frameClosed) {
            this.dict = null;
            this.fastDict = zstdDictCompress;
            return this;
        }
        throw new IOException("Change of parameter on initialized stream");
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = 1;
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (this.frameClosed) {
            long j;
            if (this.fastDict != null) {
                j = this.stream;
                ZstdDictCompress zstdDictCompress = this.fastDict;
                if (!this.useChecksum) {
                    i3 = 0;
                }
                i3 = initCStreamWithFastDict(j, zstdDictCompress, i3);
            } else if (this.dict != null) {
                i3 = initCStreamWithDict(this.stream, this.dict, this.dict.length, this.level, this.useChecksum ? 1 : 0);
            } else {
                j = this.stream;
                int i4 = this.level;
                if (!this.useChecksum) {
                    i3 = 0;
                }
                i3 = initCStream(j, i4, i3);
            }
            if (Zstd.isError((long) i3)) {
                throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName((long) i3));
            }
            this.frameClosed = false;
        }
        int i5 = i + i2;
        this.srcPos = (long) i;
        while (this.srcPos < ((long) i5)) {
            i3 = compressStream(this.stream, this.dst, dstSize, bArr, i5);
            if (Zstd.isError((long) i3)) {
                throw new IOException("Compression error: " + Zstd.getErrorName((long) i3));
            } else if (this.dstPos > 0) {
                this.out.write(this.dst, 0, (int) this.dstPos);
            }
        }
    }

    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void flush() {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        } else if (!this.frameClosed) {
            int endStream;
            if (this.closeFrameOnFlush) {
                endStream = endStream(this.stream, this.dst, dstSize);
                if (Zstd.isError((long) endStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) endStream));
                }
                this.frameClosed = true;
            } else {
                endStream = flushStream(this.stream, this.dst, dstSize);
                if (Zstd.isError((long) endStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) endStream));
                }
            }
            this.out.write(this.dst, 0, (int) this.dstPos);
            this.out.flush();
        }
    }

    public void close() {
        if (!this.isClosed) {
            if (!this.frameClosed) {
                int endStream = endStream(this.stream, this.dst, dstSize);
                if (Zstd.isError((long) endStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) endStream));
                }
                this.out.write(this.dst, 0, (int) this.dstPos);
            }
            freeCStream(this.stream);
            this.out.close();
            this.isClosed = true;
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        close();
    }
}
