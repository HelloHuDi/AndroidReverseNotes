package com.google.p1368a.p1369a;

/* renamed from: com.google.a.a.g */
public final class C45015g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final byte[] bxA = new byte[0];
    public static final int[] bxu = new int[0];
    public static final long[] bxv = new long[0];
    public static final float[] bxw = new float[0];
    public static final double[] bxx = new double[0];
    public static final boolean[] bxy = new boolean[0];
    public static final byte[][] bxz = new byte[0][];

    /* renamed from: fy */
    static int m82451fy(int i) {
        return i & 7;
    }

    /* renamed from: fz */
    public static int m82452fz(int i) {
        return i >>> 3;
    }

    /* renamed from: bv */
    static int m82450bv(int i, int i2) {
        return (i << 3) | i2;
    }

    /* renamed from: a */
    public static boolean m82448a(C37224a c37224a, int i) {
        return c37224a.mo59446fn(i);
    }

    /* renamed from: b */
    public static final int m82449b(C37224a c37224a, int i) {
        int i2 = 1;
        int position = c37224a.getPosition();
        c37224a.mo59446fn(i);
        while (c37224a.mo59453vc() == i) {
            c37224a.mo59446fn(i);
            i2++;
        }
        c37224a.mo59449fq(position);
        return i2;
    }
}
