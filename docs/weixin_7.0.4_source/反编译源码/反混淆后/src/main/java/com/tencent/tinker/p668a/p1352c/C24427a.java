package com.tencent.tinker.p668a.p1352c;

/* renamed from: com.tencent.tinker.a.c.a */
public final class C24427a implements Cloneable {
    private static final boolean[] Azh = new boolean[0];
    private static final int[] bxu = new int[0];
    private boolean[] Azi;
    /* renamed from: Ly */
    private int[] f4880Ly;
    private int mSize;

    public final /* synthetic */ Object clone() {
        return dSd();
    }

    public C24427a() {
        this((byte) 0);
    }

    private C24427a(byte b) {
        this.f4880Ly = new int[10];
        this.Azi = new boolean[10];
        this.mSize = 0;
    }

    /* renamed from: bl */
    private static int m38025bl(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private C24427a dSd() {
        try {
            C24427a c24427a = (C24427a) super.clone();
            try {
                c24427a.f4880Ly = (int[]) this.f4880Ly.clone();
                c24427a.Azi = (boolean[]) this.Azi.clone();
                return c24427a;
            } catch (CloneNotSupportedException e) {
                return c24427a;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: RI */
    public final void mo40758RI(int i) {
        int a = C24427a.m38024a(this.f4880Ly, this.mSize, i);
        if (a >= 0) {
            this.Azi[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.f4880Ly;
        int i3 = this.mSize;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            iArr[i2] = i;
        } else {
            int[] iArr2 = new int[C24427a.m38025bl(i3)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = i;
            System.arraycopy(iArr, i2, iArr2, i2 + 1, iArr.length - i2);
            iArr = iArr2;
        }
        this.f4880Ly = iArr;
        boolean[] zArr = this.Azi;
        i3 = this.mSize;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            boolean[] zArr2 = new boolean[C24427a.m38025bl(i3)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            zArr2[i2] = true;
            System.arraycopy(zArr, i2, zArr2, i2 + 1, zArr.length - i2);
            zArr = zArr2;
        }
        this.Azi = zArr;
        this.mSize++;
    }

    /* renamed from: a */
    private static int m38024a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    /* renamed from: RJ */
    public final boolean mo40759RJ(int i) {
        return C24427a.m38024a(this.f4880Ly, this.mSize, i) >= 0;
    }

    public final String toString() {
        if (this.mSize <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.f4880Ly[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.Azi[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
