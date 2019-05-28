package com.tencent.p177mm.vending.p640f;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.f.a */
public final class C5687a {
    private static C5686a zXJ = null;

    /* renamed from: com.tencent.mm.vending.f.a$a */
    public interface C5686a {
        /* renamed from: d */
        void mo11576d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo11577e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo11578i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: w */
        void mo11580w(String str, String str2, Object... objArr);
    }

    /* renamed from: a */
    public static void m8539a(C5686a c5686a) {
        zXJ = c5686a;
    }

    /* renamed from: e */
    public static void m8541e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(126138);
        if (zXJ != null) {
            zXJ.mo11577e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(126138);
    }

    /* renamed from: w */
    public static void m8543w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(126139);
        if (zXJ != null) {
            zXJ.mo11580w(str, str2, objArr);
        }
        AppMethodBeat.m2505o(126139);
    }

    /* renamed from: i */
    public static void m8542i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(126140);
        if (zXJ != null) {
            zXJ.mo11578i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(126140);
    }

    /* renamed from: d */
    public static void m8540d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(126141);
        if (zXJ != null) {
            zXJ.mo11576d(str, str2, objArr);
        }
        AppMethodBeat.m2505o(126141);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(126142);
        if (zXJ != null) {
            zXJ.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.m2505o(126142);
    }
}
