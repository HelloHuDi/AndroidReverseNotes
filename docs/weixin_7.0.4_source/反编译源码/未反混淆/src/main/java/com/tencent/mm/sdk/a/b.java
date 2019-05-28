package com.tencent.mm.sdk.a;

import com.tencent.mm.sdk.platformtools.bp;

public final class b {
    public static boolean foreground = false;
    public static String xxv = "unknow";
    private static c xxw = null;
    private static boolean xxx = false;
    private static boolean xxy = false;

    public static void a(c cVar) {
        xxw = cVar;
    }

    public static void A(String str, String str2) {
        if (xxw != null) {
            xxw.A(str, str2);
        }
    }

    public static void g(int i, String str) {
        if (xxw != null) {
            xxw.g(i, str);
        }
    }

    public static void cE(boolean z) {
        foreground = z;
    }

    public static void ame(String str) {
        xxv = str;
    }

    public static void dnL() {
    }

    public static void a(a aVar) {
        if (xxw != null) {
            xxw.a(aVar);
        }
    }

    @Deprecated
    public static boolean dnM() {
        return bp.dnM();
    }

    @Deprecated
    public static void dnN() {
        bp.dpK();
    }

    @Deprecated
    public static boolean dnO() {
        return bp.dpL();
    }

    @Deprecated
    public static void amf(String str) {
        bp.anC(str);
    }

    @Deprecated
    public static String dnP() {
        return bp.dpM();
    }

    public static boolean dnQ() {
        return xxx;
    }

    public static void pf(boolean z) {
        xxx = z;
    }

    public static void pg(boolean z) {
        xxy = z;
    }

    public static boolean dnR() {
        return xxy;
    }
}
