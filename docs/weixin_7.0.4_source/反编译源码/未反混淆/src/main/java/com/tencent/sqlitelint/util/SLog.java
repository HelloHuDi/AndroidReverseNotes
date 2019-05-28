package com.tencent.sqlitelint.util;

import com.tencent.matrix.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SLog {
    private static final String TAG = "SQLiteLint.SLog";
    private static volatile SLog mInstance = null;

    public static native void nativeSetLogger(int i);

    public static SLog getInstance() {
        AppMethodBeat.i(94108);
        if (mInstance == null) {
            synchronized (SLog.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SLog();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(94108);
                    }
                }
            }
        }
        SLog sLog = mInstance;
        AppMethodBeat.o(94108);
        return sLog;
    }

    public void printLog(int i, String str, String str2) {
        AppMethodBeat.i(94109);
        switch (i) {
            case 2:
                c.v(str, str2, new Object[0]);
                AppMethodBeat.o(94109);
                return;
            case 3:
                c.d(str, str2, new Object[0]);
                AppMethodBeat.o(94109);
                return;
            case 4:
                c.i(str, str2, new Object[0]);
                AppMethodBeat.o(94109);
                return;
            case 5:
                c.w(str, str2, new Object[0]);
                AppMethodBeat.o(94109);
                return;
            case 6:
            case 7:
                c.e(str, str2, new Object[0]);
                AppMethodBeat.o(94109);
                return;
            default:
                try {
                    c.i(str, str2, new Object[0]);
                    AppMethodBeat.o(94109);
                    return;
                } catch (Throwable th) {
                    new StringBuilder("printLog ex ").append(th.getMessage());
                    AppMethodBeat.o(94109);
                }
        }
        new StringBuilder("printLog ex ").append(th.getMessage());
        AppMethodBeat.o(94109);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94110);
        getInstance().printLog(6, str, String.format(str2, objArr));
        AppMethodBeat.o(94110);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94111);
        getInstance().printLog(5, str, String.format(str2, objArr));
        AppMethodBeat.o(94111);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94112);
        getInstance().printLog(4, str, String.format(str2, objArr));
        AppMethodBeat.o(94112);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94113);
        getInstance().printLog(3, str, String.format(str2, objArr));
        AppMethodBeat.o(94113);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94114);
        getInstance().printLog(2, str, String.format(str2, objArr));
        AppMethodBeat.o(94114);
    }
}
