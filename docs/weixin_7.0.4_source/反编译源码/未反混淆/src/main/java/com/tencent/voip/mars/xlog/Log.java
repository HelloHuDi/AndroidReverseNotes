package com.tencent.voip.mars.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String SYS_INFO;
    private static final String TAG = "mars.xlog.log";
    private static LogImp debugLog;
    private static int level = 6;
    private static LogImp logImp;
    public static Context toastSupportContext = null;

    public interface LogImp {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    static {
        AppMethodBeat.i(92808);
        AnonymousClass1 anonymousClass1 = new LogImp() {
            private Handler handler = new Handler(Looper.getMainLooper());

            {
                AppMethodBeat.i(92809);
                AppMethodBeat.o(92809);
            }

            public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(92810);
                Log.level;
                AppMethodBeat.o(92810);
            }

            public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(92811);
                Log.level;
                AppMethodBeat.o(92811);
            }

            public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(92812);
                Log.level;
                AppMethodBeat.o(92812);
            }

            public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(92813);
                Log.level;
                AppMethodBeat.o(92813);
            }

            public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                AppMethodBeat.i(92814);
                Log.level;
                AppMethodBeat.o(92814);
            }

            public final void logF(String str, String str2, String str3, int i, int i2, long j, long j2, final String str4) {
                AppMethodBeat.i(92815);
                if (Log.level > 5) {
                    AppMethodBeat.o(92815);
                    return;
                }
                if (Log.toastSupportContext != null) {
                    this.handler.post(new Runnable() {
                        public void run() {
                            AppMethodBeat.i(92790);
                            Toast.makeText(Log.toastSupportContext, str4, 1).show();
                            AppMethodBeat.o(92790);
                        }
                    });
                }
                AppMethodBeat.o(92815);
            }

            public final int getLogLevel() {
                AppMethodBeat.i(92816);
                int access$000 = Log.level;
                AppMethodBeat.o(92816);
                return access$000;
            }

            public final void appenderClose() {
            }

            public final void appenderFlush(boolean z) {
            }
        };
        debugLog = anonymousClass1;
        logImp = anonymousClass1;
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
        }
        SYS_INFO = stringBuilder.toString();
        AppMethodBeat.o(92808);
    }

    public static void setLogImp(LogImp logImp) {
        logImp = logImp;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderClose() {
        AppMethodBeat.i(92791);
        if (logImp != null) {
            logImp.appenderClose();
        }
        AppMethodBeat.o(92791);
    }

    public static void appenderFlush(boolean z) {
        AppMethodBeat.i(92792);
        if (logImp != null) {
            logImp.appenderFlush(z);
        }
        AppMethodBeat.o(92792);
    }

    public static int getLogLevel() {
        AppMethodBeat.i(92793);
        if (logImp != null) {
            int logLevel = logImp.getLogLevel();
            AppMethodBeat.o(92793);
            return logLevel;
        }
        AppMethodBeat.o(92793);
        return 6;
    }

    public static void setLevel(int i, boolean z) {
        AppMethodBeat.i(92794);
        level = i;
        if (z) {
            Xlog.setLogLevel(i);
        }
        AppMethodBeat.o(92794);
    }

    public static void f(String str, String str2) {
        AppMethodBeat.i(92795);
        f(str, str2, null);
        AppMethodBeat.o(92795);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(92796);
        e(str, str2, null);
        AppMethodBeat.o(92796);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(92797);
        w(str, str2, null);
        AppMethodBeat.o(92797);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(92798);
        i(str, str2, null);
        AppMethodBeat.o(92798);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(92799);
        d(str, str2, null);
        AppMethodBeat.o(92799);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(92800);
        v(str, str2, null);
        AppMethodBeat.o(92800);
    }

    public static void f(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92801);
        if (logImp != null) {
            logImp.logF(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
        AppMethodBeat.o(92801);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92802);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logE(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(92802);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92803);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logW(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(92803);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92804);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logI(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(92804);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92805);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logD(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(92805);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92806);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logV(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.o(92806);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(92807);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + android.util.Log.getStackTraceString(th);
            logImp.logE(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
        AppMethodBeat.o(92807);
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }
}
