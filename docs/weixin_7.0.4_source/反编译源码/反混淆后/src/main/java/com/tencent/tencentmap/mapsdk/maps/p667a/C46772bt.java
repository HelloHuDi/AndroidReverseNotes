package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bt */
public final class C46772bt {
    /* renamed from: a */
    public static String f18092a = BuildConfig.COMMAND;
    /* renamed from: b */
    public static String f18093b = "";
    /* renamed from: c */
    public static String f18094c = "";
    /* renamed from: d */
    public static String f18095d = "";
    /* renamed from: e */
    public static volatile boolean f18096e = false;
    /* renamed from: f */
    public static boolean f18097f = true;
    /* renamed from: g */
    private static Context f18098g = null;
    /* renamed from: h */
    private static String f18099h = "DefaultSessionId";
    /* renamed from: i */
    private static long f18100i;
    /* renamed from: j */
    private static int f18101j = 0;
    /* renamed from: k */
    private static boolean f18102k = false;
    /* renamed from: l */
    private static String f18103l = "";
    /* renamed from: m */
    private static String f18104m = "3.5.1.18";
    /* renamed from: n */
    private static String f18105n = "";
    /* renamed from: o */
    private static boolean f18106o = false;
    /* renamed from: p */
    private static String f18107p = "";
    /* renamed from: q */
    private static Handler f18108q;
    /* renamed from: r */
    private static boolean f18109r = false;

    /* renamed from: a */
    public static Context m88735a() {
        return f18098g;
    }

    /* renamed from: b */
    public static boolean m88738b() {
        return f18109r;
    }

    /* renamed from: c */
    public static int m88739c() {
        return f18101j;
    }

    /* renamed from: d */
    public static String m88740d() {
        return f18099h;
    }

    /* renamed from: e */
    public static int m88741e() {
        AppMethodBeat.m2504i(98579);
        int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - f18100i);
        AppMethodBeat.m2505o(98579);
        return elapsedRealtime;
    }

    /* renamed from: f */
    public static String m88742f() {
        return f18103l;
    }

    /* renamed from: g */
    public static boolean m88743g() {
        return f18102k;
    }

    /* renamed from: h */
    public static String m88744h() {
        return f18104m;
    }

    /* renamed from: i */
    public static String m88745i() {
        AppMethodBeat.m2504i(98580);
        String str;
        if (!C24373eu.m37738a(f18107p)) {
            str = f18107p;
            AppMethodBeat.m2505o(98580);
            return str;
        } else if (C24373eu.m37738a(f18105n) || !f18105n.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            str = "";
            AppMethodBeat.m2505o(98580);
            return str;
        } else {
            str = f18105n.substring(f18105n.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1);
            AppMethodBeat.m2505o(98580);
            return str;
        }
    }

    /* renamed from: j */
    public static Handler m88746j() {
        return f18108q;
    }

    /* renamed from: a */
    public static void m88737a(boolean z, int i, C16209bh c16209bh, String str, int i2) {
        AppMethodBeat.m2504i(98578);
        f18109r = z;
        f18100i = SystemClock.elapsedRealtime();
        Process.myPid();
        Context a = c16209bh.mo29243a();
        f18098g = a.getApplicationContext();
        f18103l = a.getPackageName();
        f18101j = i;
        f18102k = c16209bh.mo29246d();
        String c = c16209bh.mo29245c();
        if (C24373eu.m37738a(c)) {
            c = "";
        }
        f18094c = c;
        c = c16209bh.mo29244b();
        if (C24373eu.m37738a(c)) {
            c = "";
        }
        f18095d = c;
        f18104m = "3.5.1.18";
        Handler handler = new Handler(f18098g.getMainLooper());
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            f18092a = packageInfo.versionName;
            int i3 = packageInfo.versionCode;
            f18093b = packageInfo.applicationInfo.loadLabel(a.getPackageManager()).toString();
        } catch (Throwable th) {
        }
        f18105n = str;
        f18106o = f18103l.equals(f18105n);
        HandlerThread handlerThread = new HandlerThread("halley_" + f18101j + "_" + "TempTask", 10);
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        f18108q = handler;
        handler.post(new C41038co());
        AppMethodBeat.m2505o(98578);
    }
}
