package android.support.p057v4.p065f;

/* renamed from: android.support.v4.f.c */
public final class C0404c {
    /* renamed from: Lf */
    static final int[] f474Lf = new int[0];
    /* renamed from: Lg */
    static final long[] f475Lg = new long[0];
    /* renamed from: Lh */
    static final Object[] f476Lh = new Object[0];

    public static int idealIntArraySize(int i) {
        return C0404c.m691aF(i * 4) / 4;
    }

    /* renamed from: aE */
    public static int m690aE(int i) {
        return C0404c.m691aF(i * 8) / 8;
    }

    /* renamed from: aF */
    private static int m691aF(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m688a(int[] iArr, int i, int i2) {
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

    /* renamed from: a */
    public static int m689a(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else if (j2 <= j) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }
}
