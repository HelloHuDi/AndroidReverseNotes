package com.tencent.p177mm.sdk.p599a;

import com.tencent.p177mm.sdk.platformtools.C5047bp;

/* renamed from: com.tencent.mm.sdk.a.b */
public final class C4872b {
    public static boolean foreground = false;
    public static String xxv = "unknow";
    private static C4873c xxw = null;
    private static boolean xxx = false;
    private static boolean xxy = false;

    /* renamed from: a */
    public static void m7235a(C4873c c4873c) {
        xxw = c4873c;
    }

    /* renamed from: A */
    public static void m7233A(String str, String str2) {
        if (xxw != null) {
            xxw.mo10037A(str, str2);
        }
    }

    /* renamed from: g */
    public static void m7237g(int i, String str) {
        if (xxw != null) {
            xxw.mo10040g(i, str);
        }
    }

    /* renamed from: cE */
    public static void m7236cE(boolean z) {
        foreground = z;
    }

    public static void ame(String str) {
        xxv = str;
    }

    public static void dnL() {
    }

    /* renamed from: a */
    public static void m7234a(C4871a c4871a) {
        if (xxw != null) {
            xxw.mo10038a(c4871a);
        }
    }

    @Deprecated
    public static boolean dnM() {
        return C5047bp.dnM();
    }

    @Deprecated
    public static void dnN() {
        C5047bp.dpK();
    }

    @Deprecated
    public static boolean dnO() {
        return C5047bp.dpL();
    }

    @Deprecated
    public static void amf(String str) {
        C5047bp.anC(str);
    }

    @Deprecated
    public static String dnP() {
        return C5047bp.dpM();
    }

    public static boolean dnQ() {
        return xxx;
    }

    /* renamed from: pf */
    public static void m7238pf(boolean z) {
        xxx = z;
    }

    /* renamed from: pg */
    public static void m7239pg(boolean z) {
        xxy = z;
    }

    public static boolean dnR() {
        return xxy;
    }
}
