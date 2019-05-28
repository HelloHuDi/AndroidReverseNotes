package com.tencent.p177mm.svg.p611b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.svg.b.c */
public final class C5159c {
    private static C5158a ydv = null;

    /* renamed from: com.tencent.mm.svg.b.c$a */
    public interface C5158a {
        /* renamed from: d */
        void mo4555d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo4556e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo4557i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    /* renamed from: b */
    public static void m7866b(C5158a c5158a) {
        ydv = c5158a;
    }

    /* renamed from: e */
    public static void m7868e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70128);
        if (ydv != null) {
            ydv.mo4556e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(70128);
    }

    /* renamed from: i */
    public static void m7869i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70129);
        if (ydv != null) {
            ydv.mo4557i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(70129);
    }

    /* renamed from: d */
    public static void m7867d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70130);
        if (ydv != null) {
            ydv.mo4555d(str, str2, objArr);
        }
        AppMethodBeat.m2505o(70130);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(70131);
        if (ydv != null) {
            ydv.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.m2505o(70131);
    }
}
