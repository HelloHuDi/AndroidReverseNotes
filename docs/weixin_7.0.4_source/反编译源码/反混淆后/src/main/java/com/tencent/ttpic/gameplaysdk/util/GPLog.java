package com.tencent.ttpic.gameplaysdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GPLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static final boolean isLoggable(int i) {
        return false;
    }

    /* renamed from: v */
    public static final void m9440v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(83223);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.m2505o(83223);
            return;
        }
        AppMethodBeat.m2505o(83223);
    }

    /* renamed from: d */
    public static final void m9437d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(83224);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.m2505o(83224);
            return;
        }
        AppMethodBeat.m2505o(83224);
    }

    public static final void debug(int i, String str, String str2) {
        AppMethodBeat.m2504i(83225);
        if (!isLoggable(3)) {
            AppMethodBeat.m2505o(83225);
        } else if (str2 == null) {
            AppMethodBeat.m2505o(83225);
        } else {
            AppMethodBeat.m2505o(83225);
        }
    }

    /* renamed from: i */
    public static final void m9439i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(83226);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.m2505o(83226);
            return;
        }
        AppMethodBeat.m2505o(83226);
    }

    /* renamed from: w */
    public static final void m9441w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(83227);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.m2505o(83227);
            return;
        }
        AppMethodBeat.m2505o(83227);
    }

    /* renamed from: e */
    public static final void m9438e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(83228);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.m2505o(83228);
            return;
        }
        AppMethodBeat.m2505o(83228);
    }
}
