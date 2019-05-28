package com.tencent.luggage.g;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static final String SYS_INFO;
    private static a bRA;
    private static a bRB;
    private static int level = 6;

    public interface a {
        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    static {
        AppMethodBeat.i(90895);
        AnonymousClass1 anonymousClass1 = new a() {
            private Handler handler = new Handler(Looper.getMainLooper());

            {
                AppMethodBeat.i(90875);
                AppMethodBeat.o(90875);
            }

            public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(90876);
                d.level;
                AppMethodBeat.o(90876);
            }

            public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(90877);
                d.level;
                AppMethodBeat.o(90877);
            }

            public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(90878);
                d.level;
                AppMethodBeat.o(90878);
            }

            public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(90879);
                d.level;
                AppMethodBeat.o(90879);
            }

            public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(90880);
                d.level;
                AppMethodBeat.o(90880);
            }

            public final int getLogLevel() {
                AppMethodBeat.i(90881);
                int access$000 = d.level;
                AppMethodBeat.o(90881);
                return access$000;
            }
        };
        bRA = anonymousClass1;
        bRB = anonymousClass1;
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
            printErrStackTrace("Luggage.Log", th, "", new Object[0]);
        }
        SYS_INFO = stringBuilder.toString();
        AppMethodBeat.o(90895);
    }

    public static void a(a aVar) {
        bRB = aVar;
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(90882);
        e(str, str2, null);
        AppMethodBeat.o(90882);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(90883);
        w(str, str2, null);
        AppMethodBeat.o(90883);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(90884);
        i(str, str2, null);
        AppMethodBeat.o(90884);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(90885);
        d(str, str2, null);
        AppMethodBeat.o(90885);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(90886);
        v(str, str2, null);
        AppMethodBeat.o(90886);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90887);
        if (bRB != null && bRB.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90887);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90888);
        if (bRB != null && bRB.getLogLevel() <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logW(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90888);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90889);
        if (bRB != null && bRB.getLogLevel() <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logI(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90889);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90890);
        if (bRB != null && bRB.getLogLevel() <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logD(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90890);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90891);
        if (bRB != null && bRB.getLogLevel() <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logV(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90891);
    }

    public static void b(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90892);
        if (bRB != null && bRB.getLogLevel() <= 1) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = str;
            bRB.logI(str3, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90892);
    }

    public static void c(String str, String str2, Object... objArr) {
        AppMethodBeat.i(90893);
        if (bRB != null && bRB.getLogLevel() <= 2) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = str;
            bRB.logI(str3, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(90893);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(90894);
        if (bRB != null && bRB.getLogLevel() <= 4) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + Log.getStackTraceString(th);
            String str4 = str;
            bRB.logE(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
        AppMethodBeat.o(90894);
    }
}
