package com.tencent.liteav.basic.log;

import android.os.Environment;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCLog {
    public static final int LOG_ASYNC = 0;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 4;
    public static final int LOG_FATAL = 5;
    public static final int LOG_INFO = 2;
    public static final int LOG_NONE = 6;
    public static final int LOG_SYNC = 1;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARNING = 3;
    private static boolean mHasInit = false;
    private static C8804a mListener = null;
    private static final Object mLogLock = new Object();

    /* renamed from: com.tencent.liteav.basic.log.TXCLog$a */
    public interface C8804a {
        /* renamed from: a */
        void mo19901a(int i, String str, String str2);
    }

    private static native void nativeLog(int i, String str, String str2, int i2, String str3, String str4);

    private static native void nativeLogClose();

    private static native void nativeLogInit();

    private static native void nativeLogOpen(int i, String str, String str2);

    private static native void nativeLogSetConsole(boolean z);

    private static native void nativeLogSetLevel(int i);

    static {
        AppMethodBeat.m2504i(66092);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66092);
    }

    public static void init() {
        AppMethodBeat.m2504i(66082);
        synchronized (mLogLock) {
            try {
                if (!mHasInit) {
                    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/liteav";
                    nativeLogInit();
                    nativeLogSetLevel(0);
                    nativeLogSetConsole(true);
                    nativeLogOpen(0, str, "LiteAV");
                    mHasInit = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66082);
            }
        }
    }

    public static void log(int i, String str, String str2) {
        AppMethodBeat.m2504i(66083);
        init();
        nativeLog(i, str, "", 0, "", str2);
        log_callback(i, str, str2);
        AppMethodBeat.m2505o(66083);
    }

    public static void setLevel(int i) {
        AppMethodBeat.m2504i(66084);
        init();
        nativeLogSetLevel(i);
        AppMethodBeat.m2505o(66084);
    }

    public static void setConsoleEnabled(boolean z) {
        AppMethodBeat.m2504i(66085);
        init();
        nativeLogSetConsole(z);
        AppMethodBeat.m2505o(66085);
    }

    public static void setListener(C8804a c8804a) {
        mListener = c8804a;
    }

    /* renamed from: v */
    public static void m15678v(String str, String str2) {
        AppMethodBeat.m2504i(66086);
        log(0, str, str2);
        AppMethodBeat.m2505o(66086);
    }

    /* renamed from: d */
    public static void m15675d(String str, String str2) {
        AppMethodBeat.m2504i(66087);
        log(1, str, str2);
        AppMethodBeat.m2505o(66087);
    }

    /* renamed from: i */
    public static void m15677i(String str, String str2) {
        AppMethodBeat.m2504i(66088);
        log(2, str, str2);
        AppMethodBeat.m2505o(66088);
    }

    /* renamed from: w */
    public static void m15679w(String str, String str2) {
        AppMethodBeat.m2504i(66089);
        log(3, str, str2);
        AppMethodBeat.m2505o(66089);
    }

    /* renamed from: e */
    public static void m15676e(String str, String str2) {
        AppMethodBeat.m2504i(66090);
        log(4, str, str2);
        AppMethodBeat.m2505o(66090);
    }

    private static void log_callback(int i, String str, String str2) {
        AppMethodBeat.m2504i(66091);
        if (mListener != null) {
            mListener.mo19901a(i, str, str2);
        }
        AppMethodBeat.m2505o(66091);
    }
}
