package com.tencent.luggage.p147g;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.g.d */
public final class C45124d {
    private static final String SYS_INFO;
    private static C32191a bRA;
    private static C32191a bRB;
    private static int level = 6;

    /* renamed from: com.tencent.luggage.g.d$1 */
    static class C88691 implements C32191a {
        private Handler handler = new Handler(Looper.getMainLooper());

        C88691() {
            AppMethodBeat.m2504i(90875);
            AppMethodBeat.m2505o(90875);
        }

        public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(90876);
            C45124d.level;
            AppMethodBeat.m2505o(90876);
        }

        public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(90877);
            C45124d.level;
            AppMethodBeat.m2505o(90877);
        }

        public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(90878);
            C45124d.level;
            AppMethodBeat.m2505o(90878);
        }

        public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(90879);
            C45124d.level;
            AppMethodBeat.m2505o(90879);
        }

        public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(90880);
            C45124d.level;
            AppMethodBeat.m2505o(90880);
        }

        public final int getLogLevel() {
            AppMethodBeat.m2504i(90881);
            int access$000 = C45124d.level;
            AppMethodBeat.m2505o(90881);
            return access$000;
        }
    }

    /* renamed from: com.tencent.luggage.g.d$a */
    public interface C32191a {
        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    static {
        AppMethodBeat.m2504i(90895);
        C88691 c88691 = new C88691();
        bRA = c88691;
        bRB = c88691;
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
            C45124d.printErrStackTrace("Luggage.Log", th, "", new Object[0]);
        }
        SYS_INFO = stringBuilder.toString();
        AppMethodBeat.m2505o(90895);
    }

    /* renamed from: a */
    public static void m82922a(C32191a c32191a) {
        bRB = c32191a;
    }

    /* renamed from: e */
    public static void m82927e(String str, String str2) {
        AppMethodBeat.m2504i(90882);
        C45124d.m82928e(str, str2, null);
        AppMethodBeat.m2505o(90882);
    }

    /* renamed from: w */
    public static void m82933w(String str, String str2) {
        AppMethodBeat.m2504i(90883);
        C45124d.m82934w(str, str2, null);
        AppMethodBeat.m2505o(90883);
    }

    /* renamed from: i */
    public static void m82929i(String str, String str2) {
        AppMethodBeat.m2504i(90884);
        C45124d.m82930i(str, str2, null);
        AppMethodBeat.m2505o(90884);
    }

    /* renamed from: d */
    public static void m82925d(String str, String str2) {
        AppMethodBeat.m2504i(90885);
        C45124d.m82926d(str, str2, null);
        AppMethodBeat.m2505o(90885);
    }

    /* renamed from: v */
    public static void m82931v(String str, String str2) {
        AppMethodBeat.m2504i(90886);
        C45124d.m82932v(str, str2, null);
        AppMethodBeat.m2505o(90886);
    }

    /* renamed from: e */
    public static void m82928e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90887);
        if (bRB != null && bRB.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logE(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90887);
    }

    /* renamed from: w */
    public static void m82934w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90888);
        if (bRB != null && bRB.getLogLevel() <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logW(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90888);
    }

    /* renamed from: i */
    public static void m82930i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90889);
        if (bRB != null && bRB.getLogLevel() <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logI(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90889);
    }

    /* renamed from: d */
    public static void m82926d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90890);
        if (bRB != null && bRB.getLogLevel() <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logD(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90890);
    }

    /* renamed from: v */
    public static void m82932v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90891);
        if (bRB != null && bRB.getLogLevel() <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            bRB.logV(str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90891);
    }

    /* renamed from: b */
    public static void m82923b(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90892);
        if (bRB != null && bRB.getLogLevel() <= 1) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = str;
            bRB.logI(str3, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90892);
    }

    /* renamed from: c */
    public static void m82924c(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90893);
        if (bRB != null && bRB.getLogLevel() <= 2) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = str;
            bRB.logI(str3, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
        AppMethodBeat.m2505o(90893);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(90894);
        if (bRB != null && bRB.getLogLevel() <= 4) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            String str3 = format + "  " + Log.getStackTraceString(th);
            String str4 = str;
            bRB.logE(str4, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
        AppMethodBeat.m2505o(90894);
    }
}
