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

    /* renamed from: p */
    public static void m8769p(String str, String str2) {
    }

    public static String getStackTraceString(Throwable th) {
        AppMethodBeat.m2504i(65789);
        String stackTraceString = Log.getStackTraceString(th);
        AppMethodBeat.m2505o(65789);
        return stackTraceString;
    }

    /* renamed from: e */
    public static void m8765e(String str, int i, String str2) {
        AppMethodBeat.m2504i(65790);
        TXCLog.m15676e(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65790);
    }

    /* renamed from: e */
    public static void m8766e(String str, int i, String str2, Throwable th) {
        AppMethodBeat.m2504i(65791);
        m8765e(str, i, str2);
        AppMethodBeat.m2505o(65791);
    }

    /* renamed from: w */
    public static void m8770w(String str, int i, String str2) {
        AppMethodBeat.m2504i(65792);
        TXCLog.m15679w(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65792);
    }

    /* renamed from: w */
    public static void m8771w(String str, int i, String str2, Throwable th) {
        AppMethodBeat.m2504i(65793);
        TXCLog.m15679w(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65793);
    }

    /* renamed from: i */
    public static void m8767i(String str, int i, String str2) {
        AppMethodBeat.m2504i(65794);
        TXCLog.m15677i(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65794);
    }

    /* renamed from: i */
    public static void m8768i(String str, int i, String str2, Throwable th) {
        AppMethodBeat.m2504i(65795);
        TXCLog.m15677i(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65795);
    }

    /* renamed from: d */
    public static void m8763d(String str, int i, String str2) {
        AppMethodBeat.m2504i(65796);
        TXCLog.m15675d(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65796);
    }

    /* renamed from: d */
    public static void m8764d(String str, int i, String str2, Throwable th) {
        AppMethodBeat.m2504i(65797);
        TXCLog.m15675d(str, "[" + getReportLevel(i) + "]" + str2);
        AppMethodBeat.m2505o(65797);
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
