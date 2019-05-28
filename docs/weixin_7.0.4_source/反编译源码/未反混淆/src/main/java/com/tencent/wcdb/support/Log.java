package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log {
    public static final int LOGGER_DEFAULT = 1;
    public static final int LOGGER_NONE = 0;
    private static LogCallback mCallback = null;

    public interface LogCallback {
        void println(int i, String str, String str2);
    }

    private static native void nativePrintLn(int i, String str, String str2);

    private static native void nativeSetLogger(int i, LogCallback logCallback);

    private Log() {
    }

    public static void setLogger(int i) {
        AppMethodBeat.i(12709);
        mCallback = null;
        nativeSetLogger(i, null);
        AppMethodBeat.o(12709);
    }

    public static void setLogger(LogCallback logCallback) {
        AppMethodBeat.i(12710);
        mCallback = logCallback;
        nativeSetLogger(-1, logCallback);
        AppMethodBeat.o(12710);
    }

    public static void println(int i, String str, String str2) {
        AppMethodBeat.i(12711);
        if (mCallback != null) {
            mCallback.println(i, str, str2);
            AppMethodBeat.o(12711);
            return;
        }
        nativePrintLn(i, str, str2);
        AppMethodBeat.o(12711);
    }

    public static void f(String str, String str2) {
        AppMethodBeat.i(12712);
        println(7, str, str2);
        AppMethodBeat.o(12712);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(12713);
        println(6, str, str2);
        AppMethodBeat.o(12713);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(12714);
        println(5, str, str2);
        AppMethodBeat.o(12714);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(12715);
        println(4, str, str2);
        AppMethodBeat.o(12715);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(12716);
        println(3, str, str2);
        AppMethodBeat.o(12716);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(12717);
        println(2, str, str2);
        AppMethodBeat.o(12717);
    }

    public static void f(String str, String str2, Object... objArr) {
        AppMethodBeat.i(12718);
        println(7, str, String.format(str2, objArr));
        AppMethodBeat.o(12718);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(12719);
        println(6, str, String.format(str2, objArr));
        AppMethodBeat.o(12719);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(12720);
        println(5, str, String.format(str2, objArr));
        AppMethodBeat.o(12720);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(12721);
        println(4, str, String.format(str2, objArr));
        AppMethodBeat.o(12721);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(12722);
        println(3, str, String.format(str2, objArr));
        AppMethodBeat.o(12722);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(12723);
        println(2, str, String.format(str2, objArr));
        AppMethodBeat.o(12723);
    }
}
