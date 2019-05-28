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
        AppMethodBeat.m2504i(12709);
        mCallback = null;
        nativeSetLogger(i, null);
        AppMethodBeat.m2505o(12709);
    }

    public static void setLogger(LogCallback logCallback) {
        AppMethodBeat.m2504i(12710);
        mCallback = logCallback;
        nativeSetLogger(-1, logCallback);
        AppMethodBeat.m2505o(12710);
    }

    public static void println(int i, String str, String str2) {
        AppMethodBeat.m2504i(12711);
        if (mCallback != null) {
            mCallback.println(i, str, str2);
            AppMethodBeat.m2505o(12711);
            return;
        }
        nativePrintLn(i, str, str2);
        AppMethodBeat.m2505o(12711);
    }

    /* renamed from: f */
    public static void m9446f(String str, String str2) {
        AppMethodBeat.m2504i(12712);
        println(7, str, str2);
        AppMethodBeat.m2505o(12712);
    }

    /* renamed from: e */
    public static void m9444e(String str, String str2) {
        AppMethodBeat.m2504i(12713);
        println(6, str, str2);
        AppMethodBeat.m2505o(12713);
    }

    /* renamed from: w */
    public static void m9452w(String str, String str2) {
        AppMethodBeat.m2504i(12714);
        println(5, str, str2);
        AppMethodBeat.m2505o(12714);
    }

    /* renamed from: i */
    public static void m9448i(String str, String str2) {
        AppMethodBeat.m2504i(12715);
        println(4, str, str2);
        AppMethodBeat.m2505o(12715);
    }

    /* renamed from: d */
    public static void m9442d(String str, String str2) {
        AppMethodBeat.m2504i(12716);
        println(3, str, str2);
        AppMethodBeat.m2505o(12716);
    }

    /* renamed from: v */
    public static void m9450v(String str, String str2) {
        AppMethodBeat.m2504i(12717);
        println(2, str, str2);
        AppMethodBeat.m2505o(12717);
    }

    /* renamed from: f */
    public static void m9447f(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(12718);
        println(7, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(12718);
    }

    /* renamed from: e */
    public static void m9445e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(12719);
        println(6, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(12719);
    }

    /* renamed from: w */
    public static void m9453w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(12720);
        println(5, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(12720);
    }

    /* renamed from: i */
    public static void m9449i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(12721);
        println(4, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(12721);
    }

    /* renamed from: d */
    public static void m9443d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(12722);
        println(3, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(12722);
    }

    /* renamed from: v */
    public static void m9451v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(12723);
        println(2, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(12723);
    }
}
