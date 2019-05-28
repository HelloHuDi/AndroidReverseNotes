package com.tencent.p177mm.plugin.wepkg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.C14805a;
import com.tencent.p177mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.wepkg.utils.d */
public final class C30022d {
    private static volatile C5004al ftB;
    private static final Set<Object> hvE = new HashSet();
    private static final Object iRa = new Object();

    static {
        AppMethodBeat.m2504i(63665);
        AppMethodBeat.m2505o(63665);
    }

    public static long aNY() {
        AppMethodBeat.m2504i(63651);
        long anT = C5046bo.anT();
        AppMethodBeat.m2505o(63651);
        return anT;
    }

    /* renamed from: bB */
    public static <T> T m47517bB(T t) {
        AppMethodBeat.m2504i(63652);
        hvE.add(t);
        AppMethodBeat.m2505o(63652);
        return t;
    }

    /* renamed from: at */
    public static void m47515at(Object obj) {
        AppMethodBeat.m2504i(63653);
        hvE.remove(obj);
        AppMethodBeat.m2505o(63653);
    }

    public static void aNR() {
        AppMethodBeat.m2504i(63654);
        if (ftB == null) {
            AppMethodBeat.m2505o(63654);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(63654);
            }
        }
    }

    public static C5004al aNS() {
        AppMethodBeat.m2504i(63655);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new C5004al("WebviewCache#WorkerThread");
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63655);
                    }
                }
            }
        }
        C5004al c5004al = ftB;
        AppMethodBeat.m2505o(63655);
        return c5004al;
    }

    /* renamed from: b */
    public static void m47516b(String str, final C14805a c14805a) {
        AppMethodBeat.m2504i(63656);
        final long currentTimeMillis = System.currentTimeMillis();
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 1001;
        wepkgCrossProcessTask.uXd = str;
        if (C4996ah.bqo()) {
            C30022d.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(63649);
                    wepkgCrossProcessTask.asP();
                    if (c14805a != null) {
                        c14805a.mo9822a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.m2505o(63649);
                }
            });
            AppMethodBeat.m2505o(63656);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(63650);
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (c14805a != null) {
                    c14805a.mo9822a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.m2505o(63650);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63656);
    }

    public static String aid(String str) {
        AppMethodBeat.m2504i(63657);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(63657);
            return str2;
        }
        try {
            str2 = C5046bo.nullAsNil(Uri.parse(str).getQueryParameter("wechat_pkgid"));
            AppMethodBeat.m2505o(63657);
            return str2;
        } catch (UnsupportedOperationException e) {
            C4990ab.m7412e("MicroMsg.Wepkg.WepkgUtil", e.getMessage());
            str2 = "";
            AppMethodBeat.m2505o(63657);
            return str2;
        }
    }

    public static String aie(String str) {
        AppMethodBeat.m2504i(63658);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(63658);
            return str2;
        }
        str2 = Uri.parse(str).getHost();
        AppMethodBeat.m2505o(63658);
        return str2;
    }

    public static String aif(String str) {
        AppMethodBeat.m2504i(63659);
        String str2;
        if (C5046bo.isNullOrNil(str) || !URLUtil.isNetworkUrl(str)) {
            str2 = "";
            AppMethodBeat.m2505o(63659);
            return str2;
        }
        try {
            str2 = str.replaceFirst(Uri.parse(str).getScheme() + "://", "");
            try {
                if (str2.contains("?")) {
                    str2 = str2.substring(0, str2.indexOf("?"));
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            str2 = str;
        }
        AppMethodBeat.m2505o(63659);
        return str2;
    }

    public static boolean aig(String str) {
        AppMethodBeat.m2504i(63660);
        if (C5046bo.isNullOrNil(C30022d.aid(str))) {
            AppMethodBeat.m2505o(63660);
            return false;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
            C4990ab.m7416i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
            C35765a.m58633b("EnterWeb", str, C30022d.aid(str), null, 0, 0, C35765a.m58632Kl(11));
            AppMethodBeat.m2505o(63660);
            return false;
        } else if (C35766b.uXV) {
            C4990ab.m7416i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
            C35765a.m58633b("EnterWeb", str, C30022d.aid(str), null, 0, 0, C35765a.m58632Kl(12));
            AppMethodBeat.m2505o(63660);
            return false;
        } else {
            AppMethodBeat.m2505o(63660);
            return true;
        }
    }

    /* renamed from: hA */
    public static String m47519hA(String str, String str2) {
        AppMethodBeat.m2504i(63661);
        String x = C1178g.m2591x((str + "_" + str2).getBytes());
        AppMethodBeat.m2505o(63661);
        return x;
    }

    public static boolean aih(String str) {
        AppMethodBeat.m2504i(63662);
        try {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            AppMethodBeat.m2505o(63662);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(63662);
            return false;
        }
    }

    public static boolean dgH() {
        AppMethodBeat.m2504i(63663);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i = gregorianCalendar.get(11);
        int i2 = gregorianCalendar.get(12);
        if (i < 12 || i >= 14) {
            if (i == 14) {
                if (i2 <= 30) {
                    AppMethodBeat.m2505o(63663);
                    return true;
                }
            } else if (i >= 18 && i <= 24) {
                AppMethodBeat.m2505o(63663);
                return true;
            }
            AppMethodBeat.m2505o(63663);
            return false;
        }
        AppMethodBeat.m2505o(63663);
        return true;
    }

    /* renamed from: eA */
    public static boolean m47518eA(Context context) {
        AppMethodBeat.m2504i(63664);
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.m2505o(63664);
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools") || runningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))) {
                AppMethodBeat.m2505o(63664);
                return true;
            }
        }
        AppMethodBeat.m2505o(63664);
        return false;
    }
}
