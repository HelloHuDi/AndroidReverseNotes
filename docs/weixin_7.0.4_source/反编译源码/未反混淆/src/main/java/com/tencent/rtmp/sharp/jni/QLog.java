package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final String ERR_KEY = "qq_error|";
    public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
    public static final String TAG_REPORTLEVEL_COLORUSER = "W";
    public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
    public static final String TAG_REPORTLEVEL_USER = "E";
    public static final int USR = 1;
    public static String sBuildNumber = "";

    public static void init(Context context) {
    }

    public static boolean isColorLevel() {
        return true;
    }

    public static boolean isDevelopLevel() {
        return true;
    }

    public static void p(String str, String str2) {
    }

    public static String getStackTraceString(Throwable th) {
        AppMethodBeat.i(65789);
        String stackTraceString = Log.getStackTraceString(th);
        AppMethodBeat.o(65789);
        return stackTraceString;
    }

    public static void e(String str, int i, String str2) {
        AppMethodBeat.i(65790);
        TXCLog.e(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65790);
    }

    public static void e(String str, int i, String str2, Throwable th) {
        AppMethodBeat.i(65791);
        e(str, i, str2);
        AppMethodBeat.o(65791);
    }

    public static void w(String str, int i, String str2) {
        AppMethodBeat.i(65792);
        TXCLog.w(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65792);
    }

    public static void w(String str, int i, String str2, Throwable th) {
        AppMethodBeat.i(65793);
        TXCLog.w(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65793);
    }

    public static void i(String str, int i, String str2) {
        AppMethodBeat.i(65794);
        TXCLog.i(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65794);
    }

    public static void i(String str, int i, String str2, Throwable th) {
        AppMethodBeat.i(65795);
        TXCLog.i(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65795);
    }

    public static void d(String str, int i, String str2) {
        AppMethodBeat.i(65796);
        TXCLog.d(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65796);
    }

    public static void d(String str, int i, String str2, Throwable th) {
        AppMethodBeat.i(65797);
        TXCLog.d(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.o(65797);
    }

    public static String getReportLevel(int i) {
        switch (i) {
            case 1:
                return TAG_REPORTLEVEL_USER;
            case 2:
                return TAG_REPORTLEVEL_COLORUSER;
            case 4:
                return TAG_REPORTLEVEL_DEVELOPER;
            default:
                return TAG_REPORTLEVEL_USER;
        }
    }

    public static void dumpCacheToFile() {
    }
}
