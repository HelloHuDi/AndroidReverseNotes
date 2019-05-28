package com.tencent.mars.zstd;

import java.io.Closeable;

public class ZstdDictCompress implements Closeable {
    private long nativePtr;

    private native void free();

    private native void init(byte[] bArr, int i, int i2, int i3);

    public ZstdDictCompress(byte[] bArr, int i) {
        this(bArr, 0, bArr.length, i);
    }

    public ZstdDictCompress(byte[] bArr, int i, int i2, int i3) {
        this.nativePtr = 0;
        if (bArr.length - i < 0) {
            throw new IllegalArgumentException("Dictionary buffer is to short");
        }
        init(bArr, i, i2, i3);
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createCDict failed");
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
