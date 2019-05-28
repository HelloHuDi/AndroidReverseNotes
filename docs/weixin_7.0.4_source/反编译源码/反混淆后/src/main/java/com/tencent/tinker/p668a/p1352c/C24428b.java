package com.tencent.tinker.p668a.p1352c;

/* renamed from: com.tencent.tinker.a.c.b */
public final class C24428b implements Cloneable {
    private static final int[] bxu = new int[0];
    public int[] Azj;
    /* renamed from: Ly */
    public int[] f4881Ly;
    public int mSize;

    public final /* synthetic */ Object clone() {
        return dSe();
    }

    public C24428b() {
        this((byte) 0);
    }

    private C24428b(byte b) {
        this.f4881Ly = new int[10];
        this.Azj = new int[this.f4881Ly.length];
        this.mSize = 0;
    }

    /* renamed from: bl */
    private static int m38029bl(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private C24428b dSe() {
        try {
            C24428b c24428b = (C24428b) super.clone();
            try {
                c24428b.f4881Ly = (int[]) this.f4881Ly.clone();
                c24428b.Azj = (int[]) this.Azj.clone();
                return c24428b;
            } catch (CloneNotSupportedException e) {
                return c24428b;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void put(int i, int i2) {
        int a = C24428b.m38028a(this.f4881Ly, this.mSize, i);
        if (a >= 0) {
            this.Azj[a] = i2;
            return;
        }
        a ^= -1;
        this.f4881Ly = C24428b.m38030c(this.f4881Ly, this.mSize, a, i);
        this.Azj = C24428b.m38030c(this.Azj, this.mSize, a, i2);
        this.mSize++;
    }

    public final int indexOfKey(int i) {
        return C24428b.m38028a(this.f4881Ly, this.mSize, i);
    }

    /* renamed from: a */
    private static int m38028a(int[] iArr, int i, int i2) {
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

    /* renamed from: h */
    public static int[] m38031h(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[C24428b.m38029bl(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    /* renamed from: c */
    private static int[] m38030c(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            int[] iArr2 = new int[C24428b.m38029bl(i)];
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
            stringBuilder.append(this.f4881Ly[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.Azj[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
