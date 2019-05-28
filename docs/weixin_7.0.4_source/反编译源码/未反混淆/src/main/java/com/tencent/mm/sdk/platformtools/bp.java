package com.tencent.mm.sdk.platformtools;

public final class bp {
    private static boolean xCj = false;
    private static String xCk = null;
    private static boolean xCl = false;
    private static boolean xCm = false;

    public static void pm(boolean z) {
        xCl = z;
    }

    public static void pn(boolean z) {
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
