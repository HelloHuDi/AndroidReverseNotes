package com.tencent.p177mm.sdk.platformtools;

/* renamed from: com.tencent.mm.sdk.platformtools.bp */
public final class C5047bp {
    private static boolean xCj = false;
    private static String xCk = null;
    private static boolean xCl = false;
    private static boolean xCm = false;

    /* renamed from: pm */
    public static void m7592pm(boolean z) {
        xCl = z;
    }

    /* renamed from: pn */
    public static void m7593pn(boolean z) {
        xCm = z;
    }

    public static boolean dnM() {
        return xCl;
    }

    public static boolean dpJ() {
        return xCm;
    }

    public static void dpK() {
        xCj = true;
    }

    public static boolean dpL() {
        return xCj;
    }

    public static void anC(String str) {
        xCk = str;
    }

    public static String dpM() {
        return xCk;
    }
}
