package com.tencent.mm.compatible.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class g {

    public static class a {
        public long evE = SystemClock.elapsedRealtime();

        public a() {
            AppMethodBeat.i(93073);
            AppMethodBeat.o(93073);
        }

        public final void reset() {
            AppMethodBeat.i(139048);
            this.evE = SystemClock.elapsedRealtime();
            AppMethodBeat.o(139048);
        }

        public final long Mr() {
            AppMethodBeat.i(93075);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.evE;
            AppMethodBeat.o(93075);
            return elapsedRealtime;
        }
    }

    public static int getLine() {
        AppMethodBeat.i(93076);
        int lineNumber = new Throwable().getStackTrace()[1].getLineNumber();
        AppMethodBeat.o(93076);
        return lineNumber;
    }

    public static String Mp() {
        AppMethodBeat.i(93077);
        String stackTraceElement = new Throwable().getStackTrace()[1].toString();
        AppMethodBeat.o(93077);
        return stackTraceElement;
    }

    public static String Mq() {
        AppMethodBeat.i(93078);
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stackTraceElement.getLineNumber() + ")";
        AppMethodBeat.o(93078);
        return str;
    }
}
