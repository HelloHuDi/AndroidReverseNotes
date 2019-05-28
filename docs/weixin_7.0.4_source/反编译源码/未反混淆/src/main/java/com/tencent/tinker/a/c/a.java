package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final boolean[] Azh = new boolean[0];
    private static final int[] bxu = new int[0];
    private boolean[] Azi;
    private int[] Ly;
    private int mSize;

    public final /* synthetic */ Object clone() {
        return dSd();
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.Ly = new int[10];
        this.Azi = new boolean[10];
        this.mSize = 0;
    }

    private static int bl(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a dSd() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.Ly = (int[]) this.Ly.clone();
                aVar.Azi = (boolean[]) this.Azi.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void RI(int i) {
        int a = a(this.Ly, this.mSize, i);
        if (a >= 0) {
            this.Azi[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.Ly;
        int i3 = this.mSize;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            iArr[i2] = i;
        } else {
            int[] iArr2 = new int[bl(i3)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = i;
            System.arraycopy(iArr, i2, iArr2, i2 + 1, iArr.length - i2);
            iArr = iArr2;
        }
        this.Ly = iArr;
        boolean[] zArr = this.Azi;
        i3 = this.mSize;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            boolean[] zArr2 = new boolean[bl(i3)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            zArr2[i2] = true;
            System.arraycopy(zArr, i2, zArr2, i2 + 1, zArr.length - i2);
            zArr = zArr2;
        }
        this.Azi = zArr;
        this.mSize++;
    }

    private static int a(int[] iArr, int i, int i2) {
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

    public final boolean RJ(int i) {
        return a(this.Ly, this.mSize, i) >= 0;
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
            stringBuilder.append(this.Ly[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.Azi[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
