package com.tencent.p177mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.hardcoder.c */
public final class C1611c {
    private static C1610a eEg = null;

    /* renamed from: com.tencent.mm.hardcoder.c$a */
    public interface C1610a {
        /* renamed from: d */
        void mo5063d(String str, String str2);

        /* renamed from: e */
        void mo5064e(String str, String str2);

        /* renamed from: i */
        void mo5065i(String str, String str2);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    /* renamed from: a */
    public static void m3268a(C1610a c1610a) {
        eEg = c1610a;
    }

    /* renamed from: i */
    public static void m3271i(String str, String str2) {
        AppMethodBeat.m2504i(93919);
        if (eEg != null) {
            eEg.mo5065i(str, str2);
        }
        AppMethodBeat.m2505o(93919);
    }

    /* renamed from: d */
    public static void m3269d(String str, String str2) {
        AppMethodBeat.m2504i(93920);
        if (HardCoderJNI.isHcDebug() && eEg != null) {
            eEg.mo5063d(str, str2);
        }
        AppMethodBeat.m2505o(93920);
    }

    /* renamed from: e */
    public static void m3270e(String str, String str2) {
        AppMethodBeat.m2504i(93921);
        if (eEg != null) {
            eEg.mo5064e(str, str2);
        }
        AppMethodBeat.m2505o(93921);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(93922);
        if (eEg != null) {
            eEg.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.m2505o(93922);
    }
}
