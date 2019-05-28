package com.tencent.mars.xlog;

import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4990ab.C4989a;
import com.tencent.p177mm.sdk.platformtools.C4992ac;
import java.io.File;
import java.io.FileFilter;

public class Xlog implements C4989a {
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
    public static C4992ac logDecryptor;
    private static String mCacheDir = null;
    private static String mLogDir = null;

    /* renamed from: com.tencent.mars.xlog.Xlog$1 */
    class C10221 implements FileFilter {
        C10221() {
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return false;
            }
            return file.getName().toLowerCase().endsWith(".xlog");
        }
    }

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

    private static native void appenderOpen(int i, int i2, String str, String str2, String str3, int i3, String str4);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(int i, String str, String str2, String str3, int i2, int i3, long j, long j2, String str4);

    public static native void setAppenderMode(int i);

    public static native void setConsoleLogOpen(boolean z);

    public static native void setMaxAliveTime(long j);

    public static native void setMaxFileSize(long j);

    public native void appenderClose();

    public native void appenderFlush(boolean z);

    public native int getLogLevel();

    public static void open(boolean z, int i, int i2, String str, String str2, String str3, int i3) {
        if (z) {
            System.loadLibrary("tencentxlog");
        }
        AppenderOpen(i, i2, str, str2, str3, i3);
    }

    private static String decryptTag(String str) {
        if (logDecryptor == null) {
            return str;
        }
        C4992ac c4992ac = logDecryptor;
        if (str == null || str.length() == 0) {
            return str;
        }
        switch (str.charAt(0) ^ 56506) {
            case 9030:
                return c4992ac.mo10273ef(str, str.length());
            case 56475:
                return c4992ac.xyT.decryptTag(str);
            default:
                return str;
        }
    }

    public void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(0, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(1, decryptTag(str), str2, str3, i, i2, j, j2, LogLogic.appendMemLog(str4));
    }

    public void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(2, decryptTag(str), str2, str3, i, i2, j, j2, LogLogic.appendMemLog(str4));
    }

    public void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(3, decryptTag(str), str2, str3, i, i2, j, j2, LogLogic.appendMemLog(str4));
    }

    public void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(4, decryptTag(str), str2, str3, i, i2, j, j2, LogLogic.appendMemLog(str4));
    }

    public void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
        logWrite2(5, decryptTag(str), str2, str3, i, i2, j, j2, str4);
    }

    public static void AppenderOpen(int i, int i2, String str, String str2, String str3, int i3) {
        mCacheDir = str;
        mLogDir = str2;
        appenderOpen(i, i2, str, str2, str3, i3, "1dac3876bd566b60c7dcbffd219ca6af2d2c07f045711bf2a6d111a2b1fc27c4df31c1f568879708c5159e370ab141e6627ea028b47f8a5cf4d39ca30d501f81");
    }

    public void moveLogsFromCacheDirToLogDir() {
        if (mCacheDir != null && mLogDir != null && mCacheDir.length() != 0 && mLogDir.length() != 0) {
            File file = new File(mCacheDir);
            if (file.exists()) {
                File[] listFiles = file.listFiles(new C10221());
                if (listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        C1173e.m2567d(file2, new File(mLogDir + "/" + file2.getName()));
                    }
                }
            }
        }
    }
}
