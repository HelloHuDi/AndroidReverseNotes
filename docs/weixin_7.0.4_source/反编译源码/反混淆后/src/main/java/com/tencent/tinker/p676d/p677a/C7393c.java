package com.tencent.tinker.p676d.p677a;

import java.nio.ByteOrder;

/* renamed from: com.tencent.tinker.d.a.c */
public final class C7393c extends C5928b {
    private final ByteOrder AFn;
    private final byte[] buffer;
    private final int byteCount;
    private final int offset = 0;
    private int position;

    private C7393c(byte[] bArr, int i, ByteOrder byteOrder) {
        this.buffer = bArr;
        this.byteCount = i;
        this.AFn = byteOrder;
    }

    /* renamed from: a */
    public static C5928b m12647a(byte[] bArr, int i, ByteOrder byteOrder) {
        return new C7393c(bArr, i, byteOrder);
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
