package com.tencent.p177mm.compatible.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.compatible.util.g */
public final class C1447g {

    /* renamed from: com.tencent.mm.compatible.util.g$a */
    public static class C1446a {
        public long evE = SystemClock.elapsedRealtime();

        public C1446a() {
            AppMethodBeat.m2504i(93073);
            AppMethodBeat.m2505o(93073);
        }

        public final void reset() {
            AppMethodBeat.m2504i(139048);
            this.evE = SystemClock.elapsedRealtime();
            AppMethodBeat.m2505o(139048);
        }

        /* renamed from: Mr */
        public final long mo4908Mr() {
            AppMethodBeat.m2504i(93075);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.evE;
            AppMethodBeat.m2505o(93075);
            return elapsedRealtime;
        }
    }

    public static int getLine() {
        AppMethodBeat.m2504i(93076);
        int lineNumber = new Throwable().getStackTrace()[1].getLineNumber();
        AppMethodBeat.m2505o(93076);
        return lineNumber;
    }

    /* renamed from: Mp */
    public static String m3074Mp() {
        AppMethodBeat.m2504i(93077);
        String stackTraceElement = new Throwable().getStackTrace()[1].toString();
        AppMethodBeat.m2505o(93077);
        return stackTraceElement;
    }

    /* renamed from: Mq */
    public static String m3075Mq() {
        AppMethodBeat.m2504i(93078);
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = stackTraceElement.getMethodName().substring(stackTraceElement.getMethodName().lastIndexOf(46) + 1) + "(" + stackTraceElement.getFileName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stackTraceElement.getLineNumber() + ")";
        AppMethodBeat.m2505o(93078);
        return str;
    }
}
