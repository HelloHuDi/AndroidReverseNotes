package com.tencent.sqlitelint.util;

import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SLog {
    private static final String TAG = "SQLiteLint.SLog";
    private static volatile SLog mInstance = null;

    public static native void nativeSetLogger(int i);

    public static SLog getInstance() {
        AppMethodBeat.m2504i(94108);
        if (mInstance == null) {
            synchronized (SLog.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SLog();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(94108);
                    }
                }
            }
        }
        SLog sLog = mInstance;
        AppMethodBeat.m2505o(94108);
        return sLog;
    }

    public void printLog(int i, String str, String str2) {
        AppMethodBeat.m2504i(94109);
        switch (i) {
            case 2:
                C1070c.m2369v(str, str2, new Object[0]);
                AppMethodBeat.m2505o(94109);
                return;
            case 3:
                C1070c.m2366d(str, str2, new Object[0]);
                AppMethodBeat.m2505o(94109);
                return;
            case 4:
                C1070c.m2368i(str, str2, new Object[0]);
                AppMethodBeat.m2505o(94109);
                return;
            case 5:
                C1070c.m2370w(str, str2, new Object[0]);
                AppMethodBeat.m2505o(94109);
                return;
            case 6:
            case 7:
                C1070c.m2367e(str, str2, new Object[0]);
                AppMethodBeat.m2505o(94109);
                return;
            default:
                try {
                    C1070c.m2368i(str, str2, new Object[0]);
                    AppMethodBeat.m2505o(94109);
                    return;
                } catch (Throwable th) {
                    new StringBuilder("printLog ex ").append(th.getMessage());
                    AppMethodBeat.m2505o(94109);
                }
        }
        new StringBuilder("printLog ex ").append(th.getMessage());
        AppMethodBeat.m2505o(94109);
    }

    /* renamed from: e */
    public static void m8892e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94110);
        getInstance().printLog(6, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(94110);
    }

    /* renamed from: w */
    public static void m8895w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94111);
        getInstance().printLog(5, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(94111);
    }

    /* renamed from: i */
    public static void m8893i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94112);
        getInstance().printLog(4, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(94112);
    }

    /* renamed from: d */
    public static void m8891d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94113);
        getInstance().printLog(3, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(94113);
    }

    /* renamed from: v */
    public static void m8894v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94114);
        getInstance().printLog(2, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(94114);
    }
}
