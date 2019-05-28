package com.tencent.mars.zstd;

import java.io.Closeable;

public class ZstdDictDecompress implements Closeable {
    private long nativePtr;

    private native void free();

    private native void init(byte[] bArr, int i, int i2);

    public ZstdDictDecompress(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ZstdDictDecompress(byte[] bArr, int i, int i2) {
        this.nativePtr = 0;
        if (bArr.length < 0) {
            throw new IllegalArgumentException("Dictionary buffer is to short");
        }
        init(bArr, i, i2);
        if (this.nativePtr == 0) {
            throw new IllegalStateException("ZSTD_createDDict failed");
        }
    }

    public void close() {
        free();
        this.nativePtr = 0;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        close();
    }
}
