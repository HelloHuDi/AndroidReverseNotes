package com.google.a.a;

public final class g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final byte[] bxA = new byte[0];
    public static final int[] bxu = new int[0];
    public static final long[] bxv = new long[0];
    public static final float[] bxw = new float[0];
    public static final double[] bxx = new double[0];
    public static final boolean[] bxy = new boolean[0];
    public static final byte[][] bxz = new byte[0][];

    static int fy(int i) {
        return i & 7;
    }

    public static int fz(int i) {
        return i >>> 3;
    }

    static int bv(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(a aVar, int i) {
        return aVar.fn(i);
    }

    public static final int b(a aVar, int i) {
        int i2 = 1;
        int position = aVar.getPosition();
        aVar.fn(i);
        while (aVar.vc() == i) {
            aVar.fn(i);
            i2++;
        }
        aVar.fq(position);
        return i2;
    }
}
