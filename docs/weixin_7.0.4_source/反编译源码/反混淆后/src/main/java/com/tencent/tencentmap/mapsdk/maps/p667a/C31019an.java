package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41003a;
import com.tencent.tencentmap.mapsdk.p666a.C41014c;
import com.tencent.tencentmap.mapsdk.p666a.C5847f;
import java.util.Date;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.an */
public class C31019an {
    /* renamed from: a */
    protected static Map<String, String> f14042a = null;
    /* renamed from: b */
    private static Context f14043b = null;
    /* renamed from: c */
    private static String f14044c = "";
    /* renamed from: d */
    private static String f14045d = "10000";
    /* renamed from: e */
    private static String f14046e = "";
    /* renamed from: f */
    private static Runnable f14047f = new C243521();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.an$1 */
    static class C243521 implements Runnable {
        C243521() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98474);
            C16205ag.m24685b(" db events to up on app call", new Object[0]);
            try {
                C25011ax.m39273a(false);
                AppMethodBeat.m2505o(98474);
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(98474);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(98483);
        AppMethodBeat.m2505o(98483);
    }

    /* renamed from: a */
    public static void m49816a(Context context) {
        AppMethodBeat.m2504i(98475);
        C31019an.m49817a(context, null, true, 0);
        AppMethodBeat.m2505o(98475);
    }

    @TargetApi(14)
    /* renamed from: a */
    private static void m49817a(Context context, C44498ay c44498ay, boolean z, long j) {
        AppMethodBeat.m2504i(98476);
        if (context == null) {
            C16205ag.m24686c(" the context is null! init beacon sdk failed!", new Object[0]);
            AppMethodBeat.m2505o(98476);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            f14043b = applicationContext;
        } else {
            f14043b = context;
        }
        if (j > 0) {
            if (j > 10000) {
                j = 10000;
            }
            C16310u.m25137a(j);
        }
        long time = new Date().getTime();
        if (Integer.valueOf(VERSION.SDK).intValue() >= 14) {
            ((Application) f14043b).registerActivityLifecycleCallbacks(new C5847f());
        }
        C16205ag.m24683a("initUserAction t1:" + (new Date().getTime() - time), new Object[0]);
        C25011ax.m39269a(f14043b, C25011ax.m39270a(f14043b, C31019an.m49822a(z)), c44498ay);
        C16205ag.m24683a("initUserAction t1:" + (new Date().getTime() - time), new Object[0]);
        AppMethodBeat.m2505o(98476);
    }

    /* renamed from: a */
    private static boolean m49822a(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(98477);
        if (z) {
            String b = C41003a.m71119b(f14043b, "pid_stat", "");
            int myPid = Process.myPid();
            if ("".equals(b)) {
                C41003a.m71122c(f14043b, String.valueOf(myPid));
            } else {
                int i = -1;
                try {
                    i = Integer.valueOf(b).intValue();
                } catch (Exception e) {
                }
                if (i == myPid) {
                    AppMethodBeat.m2505o(98477);
                    return true;
                } else if (C41003a.m71117a(f14043b, i)) {
                    z2 = false;
                } else {
                    C41003a.m71122c(f14043b, b);
                    AppMethodBeat.m2505o(98477);
                    return true;
                }
            }
            AppMethodBeat.m2505o(98477);
            return z2;
        }
        AppMethodBeat.m2505o(98477);
        return false;
    }

    /* renamed from: a */
    public static void m49818a(String str) {
        AppMethodBeat.m2504i(98478);
        if (!(str == null || str.trim().equals(""))) {
            C41003a.m71116a(str);
        }
        AppMethodBeat.m2505o(98478);
    }

    /* renamed from: a */
    public static String m49815a() {
        return f14045d;
    }

    /* renamed from: b */
    public static String m49823b() {
        return f14044c;
    }

    /* renamed from: c */
    public static Map<String, String> m49825c() {
        return f14042a;
    }

    /* renamed from: b */
    public static void m49824b(String str) {
        AppMethodBeat.m2504i(98479);
        if (!(str == null || str.equals(""))) {
            f14046e = str;
        }
        AppMethodBeat.m2505o(98479);
    }

    /* renamed from: d */
    public static String m49827d() {
        return f14046e;
    }

    /* renamed from: c */
    public static void m49826c(String str) {
        AppMethodBeat.m2504i(98480);
        C41014c m = C41014c.m71224m();
        if (m == null) {
            C41014c.m71218a(f14043b);
            m = C41014c.m71224m();
        }
        if (m == null) {
            C16205ag.m24687d("please set the channelID after call initUserAction!", new Object[0]);
            AppMethodBeat.m2505o(98480);
            return;
        }
        m.mo65053c(C24349e.m37596b(str));
        AppMethodBeat.m2505o(98480);
    }

    /* renamed from: a */
    public static boolean m49820a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        AppMethodBeat.m2504i(98481);
        boolean a = C31019an.m49821a(str, z, j, j2, map, z2, false);
        AppMethodBeat.m2505o(98481);
        return a;
    }

    /* renamed from: a */
    public static boolean m49821a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(98482);
        if (str == null || "".equals(str.trim())) {
            C16205ag.m24686c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
            AppMethodBeat.m2505o(98482);
            return false;
        }
        String trim = str.replace('|', '_').trim();
        if (trim.length() == 0) {
            C16205ag.m24686c("eventName is invalid!! eventName length == 0!", new Object[0]);
            trim = null;
        } else if (!C24349e.m37603c(trim)) {
            C16205ag.m24686c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:".concat(String.valueOf(str)), new Object[0]);
            trim = null;
        } else if (trim.length() > 128) {
            C16205ag.m24686c("eventName is invalid!! eventName length should be less than 128! eventName:".concat(String.valueOf(str)), new Object[0]);
            trim = trim.substring(0, 128);
        }
        if (trim == null) {
            AppMethodBeat.m2505o(98482);
            return false;
        }
        boolean a = C25011ax.m39272a(trim, z, j, j2, map, z2, z3);
        AppMethodBeat.m2505o(98482);
        return a;
    }

    /* renamed from: a */
    public static void m49819a(boolean z, boolean z2) {
        C16205ag.f3125a = z;
        C16205ag.f3126b = z2;
    }
}
