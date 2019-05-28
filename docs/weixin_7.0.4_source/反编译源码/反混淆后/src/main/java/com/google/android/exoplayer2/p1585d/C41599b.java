package com.google.android.exoplayer2.p1585d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.d.b */
public final class C41599b {
    public static boolean DEBUG = true;
    private static C45028a bdW = null;

    /* renamed from: a */
    public static void m72862a(C45028a c45028a) {
        bdW = c45028a;
    }

    /* renamed from: i */
    public static void m72864i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(95227);
        if (bdW != null) {
            bdW.mo8023i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(95227);
    }

    /* renamed from: w */
    public static void m72865w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(95228);
        if (bdW != null) {
            bdW.mo8024w(str, str2, objArr);
        }
        AppMethodBeat.m2505o(95228);
    }

    /* renamed from: e */
    public static void m72863e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(95229);
        if (bdW != null) {
            bdW.mo8022e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(95229);
    }
}
