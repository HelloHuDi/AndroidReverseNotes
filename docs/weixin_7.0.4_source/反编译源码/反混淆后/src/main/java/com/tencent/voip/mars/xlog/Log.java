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

    /* renamed from: com.tencent.voip.mars.xlog.Log$1 */
    static class C163751 implements LogImp {
        private Handler handler = new Handler(Looper.getMainLooper());

        C163751() {
            AppMethodBeat.m2504i(92809);
            AppMethodBeat.m2505o(92809);
        }

        public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(92810);
            Log.level;
            AppMethodBeat.m2505o(92810);
        }

        public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(92811);
            Log.level;
            AppMethodBeat.m2505o(92811);
        }

        public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(92812);
            Log.level;
            AppMethodBeat.m2505o(92812);
        }

        public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(92813);
            Log.level;
            AppMethodBeat.m2505o(92813);
        }

        public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(92814);
            Log.level;
            AppMethodBeat.m2505o(92814);
        }

        public final void logF(String str, String str2, String str3, int i, int i2, long j, long j2, final String str4) {
            AppMethodBeat.m2504i(92815);
            if (Log.level > 5) {
                AppMethodBeat.m2505o(92815);
                return;
            }
            if (Log.toastSupportContext != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(92790);
                        Toast.makeText(Log.toastSupportContext, str4, 1).show();
                        AppMethodBeat.m2505o(92790);
                    }
                });
            }
            AppMethodBeat.m2505o(92815);
        }

        public final int getLogLevel() {
            AppMethodBeat.m2504i(92816);
            int access$000 = Log.level;
            AppMethodBeat.m2505o(92816);
            return access$000;
        }

        public final void appenderClose() {
        }

        public final void appenderFlush(boolean z) {
        }
    }

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
        AppMethodBeat.m2504i(92808);
        C163751 c163751 = new C163751();
        debugLog = c163751;
        logImp = c163751;
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
        AppMethodBeat.m2505o(92808);
    }

    public static void setLogImp(LogImp logImp) {
        logImp = logImp;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderClose() {
        AppMethodBeat.m2504i(92791);
        if (logImp != null) {
            logImp.appenderClose();
        }
        AppMethodBeat.m2505o(92791);
    }

    public static void appenderFlush(boolean z) {
        AppMethodBeat.m2504i(92792);
        if (logImp != null) {
            logImp.appenderFlush(z);
        }
        AppMethodBeat.m2505o(92792);
    }

    public static int getLogLevel() {
        AppMethodBeat.m2504i(92793);
        if (logImp != null) {
            int logLevel = logImp.getLogLevel();
            AppMethodBeat.m2505o(92793);
            return logLevel;
        }
        AppMethodBeat.m2505o(92793);
        return 6;
    }

    public static void setLevel(int i, boolean z) {
        AppMethodBeat.m2504i(92794);
        level = i;
        if (z) {
            Xlog.setLogLevel(i);
        }
        AppMethodBeat.m2505o(92794);
    }

    /* renamed from: f */
    public static void m25195f(String str, String str2) {
        AppMethodBeat.m2504i(92795);
        m25196f(str, str2, null);
        AppMethodBeat.m2505o(92795);
    }

    /* renamed from: e */
    public static void m25193e(String str, String str2) {
        AppMethodBeat.m2504i(92796);
        m25194e(str, str2, null);
        AppMethodBeat.m2505o(92796);
    }

    /* renamed from: w */
    public static void m25201w(String str, String str2) {
        AppMethodBeat.m2504i(92797);
        m25202w(str, str2, null);
        AppMethodBeat.m2505o(92797);
    }

    /* renamed from: i */
    public static void m25197i(String str, String str2) {
        AppMethodBeat.m2504i(92798);
        m25198i(str, str2, null);
        AppMethodBeat.m2505o(92798);
    }

    /* renamed from: d */
    public static void m25191d(String str, String str2) {
        AppMethodBeat.m2504i(92799);
        m25192d(str, str2, null);
        AppMethodBeat.m2505o(92799);
    }

    /* renamed from: v */
    public static void m25199v(String str, String str2) {
        AppMethodBeat.m2504i(92800);
        m25200v(str, str2, null);
        AppMethodBeat.m2505o(92800);
    }

    /* renamed from: f */
    public static void m25196f(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92801);
        if (logImp != null) {
            logImp.logF(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
        AppMethodBeat.m2505o(92801);
    }

    /* renamed from: e */
    public static void m25194e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92802);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logE(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(92802);
    }

    /* renamed from: w */
    public static void m25202w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92803);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logW(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(92803);
    }

    /* renamed from: i */
    public static void m25198i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92804);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logI(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(92804);
    }

    /* renamed from: d */
    public static void m25192d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92805);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logD(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(92805);
    }

    /* renamed from: v */
    public static void m25200v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92806);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logV(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(92806);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(92807);
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + android.util.Log.getStackTraceString(th);
            logImp.logE(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
        AppMethodBeat.m2505o(92807);
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }
}
