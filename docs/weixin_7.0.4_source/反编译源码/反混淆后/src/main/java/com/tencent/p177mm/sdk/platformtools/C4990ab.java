package com.tencent.p177mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

/* renamed from: com.tencent.mm.sdk.platformtools.ab */
public final class C4990ab {
    private static final String SYS_INFO;
    private static int level = 6;
    private static C4989a xyP;
    private static C4989a xyQ;

    /* renamed from: com.tencent.mm.sdk.platformtools.ab$a */
    public interface C4989a {
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

    /* renamed from: com.tencent.mm.sdk.platformtools.ab$1 */
    static class C49911 implements C4989a {
        private Handler handler = new Handler(Looper.getMainLooper());

        C49911() {
        }

        public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            C4990ab.level;
        }

        public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            C4990ab.level;
        }

        public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            C4990ab.level;
        }

        public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            C4990ab.level;
        }

        public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            C4990ab.level;
        }

        public final void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            if (C4990ab.level > 5) {
            }
        }

        public final int getLogLevel() {
            return C4990ab.level;
        }

        public final void appenderClose() {
        }

        public final void appenderFlush(boolean z) {
        }

        public final void moveLogsFromCacheDirToLogDir() {
        }
    }

    static {
        C49911 c49911 = new C49911();
        xyP = c49911;
        xyQ = c49911;
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
            C4990ab.printErrStackTrace("MicroMsg.SDK.Log", th, "", new Object[0]);
        }
        SYS_INFO = stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m7407a(C4989a c4989a) {
        xyQ = c4989a;
    }

    public static C4989a dos() {
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

    /* renamed from: LZ */
    public static void m7406LZ(int i) {
        level = i;
    }

    public static void moveLogsFromCacheDirToLogDir() {
        if (xyQ != null) {
            xyQ.moveLogsFromCacheDirToLogDir();
        }
    }

    /* renamed from: f */
    public static void m7414f(String str, String str2) {
        C4990ab.m7415f(str, str2, null);
    }

    /* renamed from: e */
    public static void m7412e(String str, String str2) {
        C4990ab.m7413e(str, str2, null);
    }

    /* renamed from: w */
    public static void m7420w(String str, String str2) {
        C4990ab.m7421w(str, str2, null);
    }

    /* renamed from: i */
    public static void m7416i(String str, String str2) {
        C4990ab.m7417i(str, str2, null);
    }

    /* renamed from: d */
    public static void m7410d(String str, String str2) {
        C4990ab.m7411d(str, str2, null);
    }

    /* renamed from: v */
    public static void m7418v(String str, String str2) {
        C4990ab.m7419v(str, str2, null);
    }

    /* renamed from: f */
    public static void m7415f(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 5) {
            xyQ.logF(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m7413e(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    /* renamed from: w */
    public static void m7421w(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logW(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    /* renamed from: i */
    public static void m7417i(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logI(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    /* renamed from: d */
    public static void m7411d(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logD(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    /* renamed from: v */
    public static void m7419v(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            xyQ.logV(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    /* renamed from: b */
    public static void m7408b(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 1) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + C5046bo.dpG();
            String str4 = str;
            xyQ.logI(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    /* renamed from: c */
    public static void m7409c(String str, String str2, Object... objArr) {
        if (xyQ != null && xyQ.getLogLevel() <= 2) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + C5046bo.dpG();
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
