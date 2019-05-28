package com.tencent.mars.zstd;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZstdInputStream extends FilterInputStream {
    private static final int srcBuffSize = ((int) recommendedDInSize());
    private byte[] dict;
    private long dstPos;
    private ZstdDictDecompress fastDict;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private byte[] src;
    private long srcPos;
    private long srcSize;
    private long stream;

    private static native long createDStream();

    private native int decompressStream(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private static native int freeDStream(long j);

    private native int initDStream(long j);

    private native int initDStreamWithDict(long j, byte[] bArr, int i);

    private native int initDStreamWithFastDict(long j, ZstdDictDecompress zstdDictDecompress);

    private static native long recommendedDInSize();

    private static native long recommendedDOutSize();

    public ZstdInputStream(InputStream inputStream) {
        super(inputStream);
        this.dstPos = 0;
        this.srcPos = 0;
        this.srcSize = 0;
        this.src = null;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.dict = null;
        this.fastDict = null;
        this.src = new byte[srcBuffSize];
        if (this.src == null) {
            throw new IOException("Error allocating the input buffer of size " + srcBuffSize);
        }
        this.stream = createDStream();
    }

    public ZstdInputStream setContinuous(boolean z) {
        this.isContinuous = z;
        return this;
    }

    public boolean getContinuous() {
        return this.isContinuous;
    }

    public ZstdInputStream setDict(byte[] bArr) {
        if (this.frameFinished) {
            this.dict = bArr;
            this.fastDict = null;
            return this;
        }
        throw new IOException("Change of parameter on initialized stream");
    }

    public ZstdInputStream setDict(ZstdDictDecompress zstdDictDecompress) {
        if (this.frameFinished) {
            this.fastDict = zstdDictDecompress;
            this.dict = null;
            return this;
        }
        throw new IOException("Change of parameter on initialized stream");
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        int initDStreamWithFastDict;
        if (this.frameFinished) {
            if (this.fastDict != null) {
                initDStreamWithFastDict = initDStreamWithFastDict(this.stream, this.fastDict);
            } else if (this.dict != null) {
                initDStreamWithFastDict = initDStreamWithDict(this.stream, this.dict, this.dict.length);
            } else {
                initDStreamWithFastDict = initDStream(this.stream);
            }
            if (Zstd.isError((long) initDStreamWithFastDict)) {
                throw new IOException("Decompression error: " + Zstd.getErrorName((long) initDStreamWithFastDict));
            }
        }
        if (i < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Requested lenght " + i2 + " from offset " + i + " in buffer of size " + bArr.length);
        }
        int i3 = i + i2;
        this.dstPos = (long) i;
        while (this.dstPos < ((long) i3)) {
            if (this.srcSize - this.srcPos == 0) {
                this.srcSize = (long) this.in.read(this.src, 0, srcBuffSize);
                this.srcPos = 0;
                if (this.srcSize < 0) {
                    this.srcSize = 0;
                    if (this.frameFinished) {
                        return -1;
                    }
                    if (this.isContinuous) {
                        return (int) (this.dstPos - ((long) i));
                    }
                    throw new IOException("Read error or truncated source");
                }
                this.frameFinished = false;
            }
            initDStreamWithFastDict = decompressStream(this.stream, bArr, i3, this.src, (int) this.srcSize);
            if (Zstd.isError((long) initDStreamWithFastDict)) {
                throw new IOException("Decompression error: " + Zstd.getErrorName((long) initDStreamWithFastDict));
            } else if (initDStreamWithFastDict == 0) {
                this.frameFinished = true;
                return (int) (this.dstPos - ((long) i));
            }
        }
        return i2;
    }

    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read > 0) {
            return bArr[0] & 255;
        }
        return read;
    }

    public int available() {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        } else if (this.srcSize - this.srcPos > 0) {
            return (int) (this.srcSize - this.srcPos);
        } else {
            return this.in.available();
        }
    }

    public boolean markSupported() {
        return false;
    }

    public long skip(long j) {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        } else if (j <= 0) {
            return 0;
        } else {
            int min = (int) Math.min(recommendedDOutSize(), j);
            byte[] bArr = new byte[min];
            long j2 = j;
            while (j2 > 0) {
                int read = read(bArr, 0, (int) Math.min((long) min, j2));
                if (read < 0) {
                    break;
                }
                j2 -= (long) read;
            }
            return j - j2;
        }
    }

    public void close() {
        if (!this.isClosed) {
            freeDStream(this.stream);
            this.in.close();
            this.isClosed = true;
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        close();
    }
}
