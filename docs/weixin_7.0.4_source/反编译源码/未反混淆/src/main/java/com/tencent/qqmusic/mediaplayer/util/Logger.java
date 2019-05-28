package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger {
    private static ILog mILog = new ILog() {
        public final void d(String str, String str2) {
        }

        public final void w(String str, String str2) {
        }

        public final void e(String str, String str2) {
        }

        public final void i(String str, String str2) {
        }

        public final void i(String str, String str2, Throwable th) {
        }

        public final void e(String str, Throwable th) {
        }

        public final void e(String str, String str2, Throwable th) {
        }

        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(105542);
            String.format(str2, objArr);
            AppMethodBeat.o(105542);
        }
    };

    static {
        AppMethodBeat.i(105521);
        AppMethodBeat.o(105521);
    }

    public static void setLog(ILog iLog) {
        mILog = iLog;
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(105513);
        if (mILog != null) {
            mILog.d(str, str2);
        }
        AppMethodBeat.o(105513);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(105514);
        if (mILog != null) {
            mILog.w(str, str2);
        }
        AppMethodBeat.o(105514);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(105515);
        if (mILog != null) {
            mILog.e(str, str2);
        }
        AppMethodBeat.o(105515);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(105516);
        if (mILog != null) {
            mILog.i(str, str2);
        }
        AppMethodBeat.o(105516);
    }

    public static void e(String str, Throwable th) {
        AppMethodBeat.i(105517);
        if (mILog != null) {
            mILog.e(str, th);
        }
        AppMethodBeat.o(105517);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(105518);
        if (mILog != null) {
            mILog.e(str, str2, th);
        }
        AppMethodBeat.o(105518);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(105519);
        if (mILog != null) {
            mILog.e(str, str2, objArr);
        }
        AppMethodBeat.o(105519);
    }

    public static void i(String str, String str2, Throwable th) {
        AppMethodBeat.i(105520);
        if (mILog != null) {
            mILog.i(str, str2, th);
        }
        AppMethodBeat.o(105520);
    }
}
