package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

public final class ab {
    private static final String SYS_INFO;
    private static int level = 6;
    private static a xyP;
    private static a xyQ;

    public interface a {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void moveLogsFromCacheDirToLogDir();
    }

    static {
        AnonymousClass1 anonymousClass1 = new a() {
            private Handler handler = new Handler(Looper.getMainLooper());

            public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                ab.level;
            }

            public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                ab.level;
            }

            public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                ab.level;
            }

            public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                ab.level;
            }

            public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                ab.level;
            }

            public final void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (ab.level > 5) {
                }
            }

            public final int getLogLevel() {
                return ab.level;
            }

            public final void appenderClose() {
            }

            public final void appenderFlush(boolean z) {
            }

            public final void moveLogsFromCacheDirToLogDir() {
            }
        };
        xyP = anonymousClass1;
        xyQ = anonymousClass1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            printErrStackTrace("MicroMsg.SDK.Log", th, "", new Object[0]);
        }
        SYS_INFO = stringBuilder.toString();
    }

    public static void a(a aVar) {
        xyQ = aVar;
    }

    public static a dos() {
        return xyQ;
    }

    public static void appenderClose() {
        if (xyQ != null) {
            xyQ.appenderClose();
        }
    }

    public static void dot() {
        if (xyQ != null) {
            xyQ.appenderFlush(false);
        }
    }

    public static void dou() {
        if (xyQ != null) {
            xyQ.appenderFlush(true);
        }
    }

    public static int getLogLevel() {
        if (xyQ != null) {
            return xyQ.getLogLevel();
        }
        return 6;
    }

    public static void LZ(int i) {
        level = i;
    }

    public static void moveLogsFromCacheDirToLogDir() {
        if (xyQ != null) {
            xyQ.moveLogsFromCacheDirToLogDir();
        }
    }

    public static void f(String str, String str2) {
        f(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 5) {
            xyQ.logF(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logW(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logI(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logD(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logV(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 1) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + bo.dpG();
            String str4 = str;
            xyQ.logI(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 2) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + bo.dpG();
            String str4 = str;
            xyQ.logI(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + Log.getStackTraceString(th);
            xyQ.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }
}
