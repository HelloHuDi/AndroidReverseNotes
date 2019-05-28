package com.tencent.p177mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.opensdk.utils.Log */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m4139d(String str, String str2) {
        AppMethodBeat.m2504i(128066);
        if (logImpl == null) {
            AppMethodBeat.m2505o(128066);
            return;
        }
        logImpl.mo20420d(str, str2);
        AppMethodBeat.m2505o(128066);
    }

    /* renamed from: e */
    public static void m4140e(String str, String str2) {
        AppMethodBeat.m2504i(128069);
        if (logImpl == null) {
            AppMethodBeat.m2505o(128069);
            return;
        }
        logImpl.mo20421e(str, str2);
        AppMethodBeat.m2505o(128069);
    }

    /* renamed from: i */
    public static void m4141i(String str, String str2) {
        AppMethodBeat.m2504i(128067);
        if (logImpl == null) {
            AppMethodBeat.m2505o(128067);
            return;
        }
        logImpl.mo20422i(str, str2);
        AppMethodBeat.m2505o(128067);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m4142v(String str, String str2) {
        AppMethodBeat.m2504i(128065);
        if (logImpl == null) {
            AppMethodBeat.m2505o(128065);
            return;
        }
        logImpl.mo20423v(str, str2);
        AppMethodBeat.m2505o(128065);
    }

    /* renamed from: w */
    public static void m4143w(String str, String str2) {
        AppMethodBeat.m2504i(128068);
        if (logImpl == null) {
            AppMethodBeat.m2505o(128068);
            return;
        }
        logImpl.mo20424w(str, str2);
        AppMethodBeat.m2505o(128068);
    }
}
