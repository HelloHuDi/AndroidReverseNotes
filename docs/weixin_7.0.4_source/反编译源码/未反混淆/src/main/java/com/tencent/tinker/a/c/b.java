package com.tencent.tinker.a.c;

public final class b implements Cloneable {
    private static final int[] bxu = new int[0];
    public int[] Azj;
    public int[] Ly;
    public int mSize;

    public final /* synthetic */ Object clone() {
        return dSe();
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.Ly = new int[10];
        this.Azj = new int[this.Ly.length];
        this.mSize = 0;
    }

    private static int bl(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private b dSe() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.Ly = (int[]) this.Ly.clone();
                bVar.Azj = (int[]) this.Azj.clone();
                return bVar;
            } catch (CloneNotSupportedException e) {
                return bVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void put(int i, int i2) {
        int a = a(this.Ly, this.mSize, i);
        if (a >= 0) {
            this.Azj[a] = i2;
            return;
        }
        a ^= -1;
        this.Ly = c(this.Ly, this.mSize, a, i);
        this.Azj = c(this.Azj, this.mSize, a, i2);
        this.mSize++;
    }

    public final int indexOfKey(int i) {
        return a(this.Ly, this.mSize, i);
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

    public static int[] h(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[bl(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static int[] c(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            int[] iArr2 = new int[bl(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = i3;
            System.arraycopy(iArr, i2, iArr2, i2 + 1, iArr.length - i2);
            return iArr2;
        }
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
            stringBuilder.append(this.Azj[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
