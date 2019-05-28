package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTLogger {
    private static IFaceLiveLogger iFaceLiveLogger;
    private static boolean sEnableLog = false;
    private static boolean sEnableNativeLog = false;

    public interface IFaceLiveLogger {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
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

    public static void v(String str, String str2) {
        AppMethodBeat.i(118097);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.v(str, str2);
            }
            AppMethodBeat.o(118097);
            return;
        }
        AppMethodBeat.o(118097);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(118098);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.d(str, str2);
            }
            AppMethodBeat.o(118098);
            return;
        }
        AppMethodBeat.o(118098);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(118099);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.i(str, str2);
            }
            AppMethodBeat.o(118099);
            return;
        }
        AppMethodBeat.o(118099);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(118100);
        if (sEnableLog) {
            if (iFaceLiveLogger != null) {
                iFaceLiveLogger.w(str, str2);
            }
            AppMethodBeat.o(118100);
            return;
        }
        AppMethodBeat.o(118100);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(118101);
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.e(str, str2);
        }
        AppMethodBeat.o(118101);
    }
}
