package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger {
    private static ILog mILog = new C170781();

    /* renamed from: com.tencent.qqmusic.mediaplayer.util.Logger$1 */
    static class C170781 implements ILog {
        C170781() {
        }

        /* renamed from: d */
        public final void mo24629d(String str, String str2) {
        }

        /* renamed from: w */
        public final void mo24636w(String str, String str2) {
        }

        /* renamed from: e */
        public final void mo24630e(String str, String str2) {
        }

        /* renamed from: i */
        public final void mo24634i(String str, String str2) {
        }

        /* renamed from: i */
        public final void mo24635i(String str, String str2, Throwable th) {
        }

        /* renamed from: e */
        public final void mo24633e(String str, Throwable th) {
        }

        /* renamed from: e */
        public final void mo24631e(String str, String str2, Throwable th) {
        }

        /* renamed from: e */
        public final void mo24632e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(105542);
            String.format(str2, objArr);
            AppMethodBeat.m2505o(105542);
        }
    }

    static {
        AppMethodBeat.m2504i(105521);
        AppMethodBeat.m2505o(105521);
    }

    public static void setLog(ILog iLog) {
        mILog = iLog;
    }

    /* renamed from: d */
    public static void m71020d(String str, String str2) {
        AppMethodBeat.m2504i(105513);
        if (mILog != null) {
            mILog.mo24629d(str, str2);
        }
        AppMethodBeat.m2505o(105513);
    }

    /* renamed from: w */
    public static void m71027w(String str, String str2) {
        AppMethodBeat.m2504i(105514);
        if (mILog != null) {
            mILog.mo24636w(str, str2);
        }
        AppMethodBeat.m2505o(105514);
    }

    /* renamed from: e */
    public static void m71021e(String str, String str2) {
        AppMethodBeat.m2504i(105515);
        if (mILog != null) {
            mILog.mo24630e(str, str2);
        }
        AppMethodBeat.m2505o(105515);
    }

    /* renamed from: i */
    public static void m71025i(String str, String str2) {
        AppMethodBeat.m2504i(105516);
        if (mILog != null) {
            mILog.mo24634i(str, str2);
        }
        AppMethodBeat.m2505o(105516);
    }

    /* renamed from: e */
    public static void m71024e(String str, Throwable th) {
        AppMethodBeat.m2504i(105517);
        if (mILog != null) {
            mILog.mo24633e(str, th);
        }
        AppMethodBeat.m2505o(105517);
    }

    /* renamed from: e */
    public static void m71022e(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(105518);
        if (mILog != null) {
            mILog.mo24631e(str, str2, th);
        }
        AppMethodBeat.m2505o(105518);
    }

    /* renamed from: e */
    public static void m71023e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(105519);
        if (mILog != null) {
            mILog.mo24632e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(105519);
    }

    /* renamed from: i */
    public static void m71026i(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(105520);
        if (mILog != null) {
            mILog.mo24635i(str, str2, th);
        }
        AppMethodBeat.m2505o(105520);
    }
}
