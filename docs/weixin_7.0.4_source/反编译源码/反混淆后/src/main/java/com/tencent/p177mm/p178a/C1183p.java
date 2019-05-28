package com.tencent.p177mm.p178a;

/* renamed from: com.tencent.mm.a.p */
public final class C1183p extends Number {
    private int uin = 0;

    public C1183p(int i) {
        this.uin = i;
    }

    public C1183p(long j) {
        this.uin = (int) (-1 & j);
    }

    /* renamed from: cB */
    public static int m2611cB(String str) {
        try {
            return new C1183p(Long.valueOf(str).longValue()).intValue();
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
        return new C1183p(i).toString();
    }
}
