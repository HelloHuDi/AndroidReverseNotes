package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class bt {
    public static String a = BuildConfig.COMMAND;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static volatile boolean e = false;
    public static boolean f = true;
    private static Context g = null;
    private static String h = "DefaultSessionId";
    private static long i;
    private static int j = 0;
    private static boolean k = false;
    private static String l = "";
    private static String m = "3.5.1.18";
    private static String n = "";
    private static boolean o = false;
    private static String p = "";
    private static Handler q;
    private static boolean r = false;

    public static Context a() {
        return g;
    }

    public static boolean b() {
        return r;
    }

    public static int c() {
        return j;
    }

    public static String d() {
        return h;
    }

    public static int e() {
        AppMethodBeat.i(98579);
        int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - i);
        AppMethodBeat.o(98579);
        return elapsedRealtime;
    }

    public static String f() {
        return l;
    }

    public static boolean g() {
        return k;
    }

    public static String h() {
        return m;
    }

    public static String i() {
        AppMethodBeat.i(98580);
        String str;
        if (!eu.a(p)) {
            str = p;
            AppMethodBeat.o(98580);
            return str;
        } else if (eu.a(n) || !n.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            str = "";
            AppMethodBeat.o(98580);
            return str;
        } else {
            str = n.substring(n.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1);
            AppMethodBeat.o(98580);
            return str;
        }
    }

    public static Handler j() {
        return q;
    }

    public static void a(boolean z, int i, bh bhVar, String str, int i2) {
        AppMethodBeat.i(98578);
        r = z;
        i = SystemClock.elapsedRealtime();
        Process.myPid();
        Context a = bhVar.a();
        g = a.getApplicationContext();
        l = a.getPackageName();
        j = i;
        k = bhVar.d();
        String c = bhVar.c();
        if (eu.a(c)) {
            c = "";
        }
        c = c;
        c = bhVar.b();
        if (eu.a(c)) {
            c = "";
        }
        d = c;
        m = "3.5.1.18";
        Handler handler = new Handler(g.getMainLooper());
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            a = packageInfo.versionName;
            int i3 = packageInfo.versionCode;
            b = packageInfo.applicationInfo.loadLabel(a.getPackageManager()).toString();
        } catch (Throwable th) {
        }
        n = str;
        o = l.equals(n);
        HandlerThread handlerThread = new HandlerThread("halley_" + j + "_" + "TempTask", 10);
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        q = handler;
        handler.post(new co());
        AppMethodBeat.o(98578);
    }
}
