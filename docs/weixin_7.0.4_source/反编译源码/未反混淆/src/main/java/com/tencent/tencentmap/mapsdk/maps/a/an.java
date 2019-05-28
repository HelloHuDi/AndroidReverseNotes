package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.a;
import com.tencent.tencentmap.mapsdk.a.c;
import com.tencent.tencentmap.mapsdk.a.e;
import com.tencent.tencentmap.mapsdk.a.f;
import java.util.Date;
import java.util.Map;

public class an {
    protected static Map<String, String> a = null;
    private static Context b = null;
    private static String c = "";
    private static String d = "10000";
    private static String e = "";
    private static Runnable f = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98474);
            ag.b(" db events to up on app call", new Object[0]);
            try {
                ax.a(false);
                AppMethodBeat.o(98474);
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(98474);
            }
        }
    };

    static {
        AppMethodBeat.i(98483);
        AppMethodBeat.o(98483);
    }

    public static void a(Context context) {
        AppMethodBeat.i(98475);
        a(context, null, true, 0);
        AppMethodBeat.o(98475);
    }

    @TargetApi(14)
    private static void a(Context context, ay ayVar, boolean z, long j) {
        AppMethodBeat.i(98476);
        if (context == null) {
            ag.c(" the context is null! init beacon sdk failed!", new Object[0]);
            AppMethodBeat.o(98476);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            b = applicationContext;
        } else {
            b = context;
        }
        if (j > 0) {
            if (j > 10000) {
                j = 10000;
            }
            u.a(j);
        }
        long time = new Date().getTime();
        if (Integer.valueOf(VERSION.SDK).intValue() >= 14) {
            ((Application) b).registerActivityLifecycleCallbacks(new f());
        }
        ag.a("initUserAction t1:" + (new Date().getTime() - time), new Object[0]);
        ax.a(b, ax.a(b, a(z)), ayVar);
        ag.a("initUserAction t1:" + (new Date().getTime() - time), new Object[0]);
        AppMethodBeat.o(98476);
    }

    private static boolean a(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(98477);
        if (z) {
            String b = a.b(b, "pid_stat", "");
            int myPid = Process.myPid();
            if ("".equals(b)) {
                a.c(b, String.valueOf(myPid));
            } else {
                int i = -1;
                try {
                    i = Integer.valueOf(b).intValue();
                } catch (Exception e) {
                }
                if (i == myPid) {
                    AppMethodBeat.o(98477);
                    return true;
                } else if (a.a(b, i)) {
                    z2 = false;
                } else {
                    a.c(b, b);
                    AppMethodBeat.o(98477);
                    return true;
                }
            }
            AppMethodBeat.o(98477);
            return z2;
        }
        AppMethodBeat.o(98477);
        return false;
    }

    public static void a(String str) {
        AppMethodBeat.i(98478);
        if (!(str == null || str.trim().equals(""))) {
            a.a(str);
        }
        AppMethodBeat.o(98478);
    }

    public static String a() {
        return d;
    }

    public static String b() {
        return c;
    }

    public static Map<String, String> c() {
        return a;
    }

    public static void b(String str) {
        AppMethodBeat.i(98479);
        if (!(str == null || str.equals(""))) {
            e = str;
        }
        AppMethodBeat.o(98479);
    }

    public static String d() {
        return e;
    }

    public static void c(String str) {
        AppMethodBeat.i(98480);
        c m = c.m();
        if (m == null) {
            c.a(b);
            m = c.m();
        }
        if (m == null) {
            ag.d("please set the channelID after call initUserAction!", new Object[0]);
            AppMethodBeat.o(98480);
            return;
        }
        m.c(e.b(str));
        AppMethodBeat.o(98480);
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        AppMethodBeat.i(98481);
        boolean a = a(str, z, j, j2, map, z2, false);
        AppMethodBeat.o(98481);
        return a;
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        AppMethodBeat.i(98482);
        if (str == null || "".equals(str.trim())) {
            ag.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
            AppMethodBeat.o(98482);
            return false;
        }
        String trim = str.replace('|', '_').trim();
        if (trim.length() == 0) {
            ag.c("eventName is invalid!! eventName length == 0!", new Object[0]);
            trim = null;
        } else if (!e.c(trim)) {
            ag.c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:".concat(String.valueOf(str)), new Object[0]);
            trim = null;
        } else if (trim.length() > 128) {
            ag.c("eventName is invalid!! eventName length should be less than 128! eventName:".concat(String.valueOf(str)), new Object[0]);
            trim = trim.substring(0, 128);
        }
        if (trim == null) {
            AppMethodBeat.o(98482);
            return false;
        }
        boolean a = ax.a(trim, z, j, j2, map, z2, z3);
        AppMethodBeat.o(98482);
        return a;
    }

    public static void a(boolean z, boolean z2) {
        ag.a = z;
        ag.b = z2;
    }
}
