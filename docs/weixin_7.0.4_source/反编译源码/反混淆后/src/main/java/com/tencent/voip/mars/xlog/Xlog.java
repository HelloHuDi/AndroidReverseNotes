package com.tencent.voip.mars.xlog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.voip.mars.xlog.Log.LogImp;

public class Xlog implements LogImp {
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;

    static class XLoggerInfo {
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public long maintid;
        public long pid;
        public String tag;
        public long tid;

        XLoggerInfo() {
        }
    }

    public static native void appenderOpen(int i, int i2, String str, String str2, String str3, int i3, String str4);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(int i, String str, String str2, String str3, int i2, int i3, long j, long j2, String str4);

    public static native void setAppenderMode(int i);

    public static native void setConsoleLogOpen(boolean z);

    public static native void setErrLogOpen(boolean z);

    public static native void setLogLevel(int i);

    public static native void setMaxAliveTime(long j);

    public static native void setMaxFileSize(long j);

    public native void appenderClose();

    public native void appenderFlush(boolean z);

    public native int getLogLevel();

    public static void open(boolean z, int i, int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(92817);
        if (z) {
            System.loadLibrary("stlport_shared");
            System.loadLibrary("wechatxlog");
        }
        appenderOpen(i, i2, str, str2, str3, 0, str4);
        AppMethodBeat.m2505o(92817);
    }

    private static String decryptTag(String str) {
        return str;
    }

    public void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        AppMethodBeat.m2504i(92818);
        logWrite2(0, decryptTag(str), str2, str3, i, i2, j, j2, str4);
        AppMethodBeat.m2505o(92818);
    }

    public void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        AppMethodBeat.m2504i(92819);
        logWrite2(1, decryptTag(str), str2, str3, i, i2, j, j2, str4);
        AppMethodBeat.m2505o(92819);
    }

    public void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        AppMethodBeat.m2504i(92820);
        logWrite2(2, decryptTag(str), str2, str3, i, i2, j, j2, str4);
        AppMethodBeat.m2505o(92820);
    }

    public void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        AppMethodBeat.m2504i(92821);
        logWrite2(3, decryptTag(str), str2, str3, i, i2, j, j2, str4);
        AppMethodBeat.m2505o(92821);
    }

    public void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        AppMethodBeat.m2504i(92822);
        logWrite2(4, decryptTag(str), str2, str3, i, i2, j, j2, str4);
        AppMethodBeat.m2505o(92822);
    }

    public void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        AppMethodBeat.m2504i(92823);
        logWrite2(5, decryptTag(str), str2, str3, i, i2, j, j2, str4);
        AppMethodBeat.m2505o(92823);
    }
}
