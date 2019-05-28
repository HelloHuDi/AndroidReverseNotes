package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Log {
    /* renamed from: e */
    public static void m38227e(String str, String str2) {
        boolean z = Config.DEBUG;
    }

    /* renamed from: w */
    public static void m38228w(String str, String str2) {
        boolean z = Config.DEBUG;
    }

    /* renamed from: d */
    public static void m38225d(String str, Object obj) {
        AppMethodBeat.m2504i(19);
        if (Config.DEBUG) {
            String.valueOf(obj);
            AppMethodBeat.m2505o(19);
            return;
        }
        AppMethodBeat.m2505o(19);
    }

    /* renamed from: d */
    public static void m38226d(String str, String str2, Throwable th) {
        if (!Config.DEBUG) {
        }
    }
}
