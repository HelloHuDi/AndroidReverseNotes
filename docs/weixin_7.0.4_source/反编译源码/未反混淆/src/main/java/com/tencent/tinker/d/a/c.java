package com.tencent.tinker.d.a;

import java.nio.ByteOrder;

public final class c extends b {
    private final ByteOrder AFn;
    private final byte[] buffer;
    private final int byteCount;
    private final int offset = 0;
    private int position;

    private c(byte[] bArr, int i, ByteOrder byteOrder) {
        this.buffer = bArr;
        this.byteCount = i;
        this.AFn = byteOrder;
    }

    public static b a(byte[] bArr, int i, ByteOrder byteOrder) {
        return new c(bArr, i, byteOrder);
    }

    public final void seek(int i) {
        this.position = i;
    }

    public final void dSu() {
        this.position += 4;
    }

    public final int readInt() {
        int i;
        byte[] bArr = this.buffer;
        int i2 = this.offset + this.position;
        int i3;
        int i4;
        if (this.AFn == ByteOrder.BIG_ENDIAN) {
            i3 = i2 + 1;
            i4 = i3 + 1;
            i2 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
            i2 |= (bArr[i4] & 255) << 8;
            i = ((bArr[i4 + 1] & 255) << 0) | i2;
        } else {
            i3 = i2 + 1;
            i4 = i3 + 1;
            i2 = ((bArr[i2] & 255) << 0) | ((bArr[i3] & 255) << 8);
            i2 |= (bArr[i4] & 255) << 16;
            i = ((bArr[i4 + 1] & 255) << 24) | i2;
        }
        this.position += 4;
        return i;
    }

    public final short readShort() {
        short s;
        byte[] bArr = this.buffer;
        int i = this.offset + this.position;
        if (this.AFn == ByteOrder.BIG_ENDIAN) {
            s = (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
        } else {
            s = (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
        }
        this.position += 2;
        return s;
    }
}
