package com.tencent.mm.a;

public final class p extends Number {
    private int uin = 0;

    public p(int i) {
        this.uin = i;
    }

    public p(long j) {
        this.uin = (int) (-1 & j);
    }

    public static int cB(String str) {
        try {
            return new p(Long.valueOf(str).longValue()).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public final double doubleValue() {
        return ((double) (((long) this.uin) | 0)) + 0.0d;
    }

    public final float floatValue() {
        return (float) (((double) (((long) this.uin) | 0)) + 0.0d);
    }

    public final int intValue() {
        return this.uin;
    }

    public final long longValue() {
        return ((long) this.uin) & 4294967295L;
    }

    public final String toString() {
        return String.valueOf(((long) this.uin) & 4294967295L);
    }

    public static String getString(int i) {
        return new p(i).toString();
    }
}
