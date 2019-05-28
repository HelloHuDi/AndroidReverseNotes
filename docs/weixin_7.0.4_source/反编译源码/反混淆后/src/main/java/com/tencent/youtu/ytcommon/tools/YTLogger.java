package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTLogger {
    private static IFaceLiveLogger iFaceLiveLogger;
    private static boolean sEnableLog = false;
    private static boolean sEnableNativeLog = false;

    public interface IFaceLiveLogger {
        /* renamed from: d */
        void mo50927d(String str, String str2);

        /* renamed from: e */
        void mo50928e(String str, String str2);

        /* renamed from: i */
        void mo50929i(String str, String str2);

        /* renamed from: v */
        void mo50930v(String str, String str2);

        /* renamed from: w */
        void mo50931w(String str, String str2);
    }

    public static void setLog(IFaceLiveLogger iFaceLiveLogger) {
        iFaceLiveLogger = iFaceLiveLogger;
    }

    public static void setIsEnabledLog(boolean z) {
        sEnableLog = z;
    }

    public static void setIsEnabledNativeLog(boolean z) {
        sEnableNativeLog = z;
    }

    public static boolean isEnableLog() {
        return sEnableLog;
    }

    public static boolean isEnableNativeLog() {
        return sEnableNativeLog;
    }

    /* renamed from: v */
    public static void m50247v(String str, String str2) {
        AppMethodBeat.m2504i(118097);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.mo50930v(str, str2);
            }
            AppMethodBeat.m2505o(118097);
            return;
        }
        AppMethodBeat.m2505o(118097);
    }

    /* renamed from: d */
    public static void m50244d(String str, String str2) {
        AppMethodBeat.m2504i(118098);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.mo50927d(str, str2);
            }
            AppMethodBeat.m2505o(118098);
            return;
        }
        AppMethodBeat.m2505o(118098);
    }

    /* renamed from: i */
    public static void m50246i(String str, String str2) {
        AppMethodBeat.m2504i(118099);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.mo50929i(str, str2);
            }
            AppMethodBeat.m2505o(118099);
            return;
        }
        AppMethodBeat.m2505o(118099);
    }

    /* renamed from: w */
    public static void m50248w(String str, String str2) {
        AppMethodBeat.m2504i(118100);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.mo50931w(str, str2);
            }
            AppMethodBeat.m2505o(118100);
            return;
        }
        AppMethodBeat.m2505o(118100);
    }

    /* renamed from: e */
    public static void m50245e(String str, String str2) {
        AppMethodBeat.m2504i(118101);
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.mo50928e(str, str2);
        }
        AppMethodBeat.m2505o(118101);
    }
}
