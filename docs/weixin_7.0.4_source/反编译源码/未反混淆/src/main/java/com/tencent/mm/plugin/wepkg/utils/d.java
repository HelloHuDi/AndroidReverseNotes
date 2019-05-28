package com.tencent.mm.plugin.wepkg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d {
    private static volatile al ftB;
    private static final Set<Object> hvE = new HashSet();
    private static final Object iRa = new Object();

    static {
        AppMethodBeat.i(63665);
        AppMethodBeat.o(63665);
    }

    public static long aNY() {
        AppMethodBeat.i(63651);
        long anT = bo.anT();
        AppMethodBeat.o(63651);
        return anT;
    }

    public static <T> T bB(T t) {
        AppMethodBeat.i(63652);
        hvE.add(t);
        AppMethodBeat.o(63652);
        return t;
    }

    public static void at(Object obj) {
        AppMethodBeat.i(63653);
        hvE.remove(obj);
        AppMethodBeat.o(63653);
    }

    public static void aNR() {
        AppMethodBeat.i(63654);
        if (ftB == null) {
            AppMethodBeat.o(63654);
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
                AppMethodBeat.o(63654);
            }
        }
    }

    public static al aNS() {
        AppMethodBeat.i(63655);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new al("WebviewCache#WorkerThread");
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63655);
                    }
                }
            }
        }
        al alVar = ftB;
        AppMethodBeat.o(63655);
        return alVar;
    }

    public static void b(String str, final a aVar) {
        AppMethodBeat.i(63656);
        final long currentTimeMillis = System.currentTimeMillis();
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 1001;
        wepkgCrossProcessTask.uXd = str;
        if (ah.bqo()) {
            aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63649);
                    wepkgCrossProcessTask.asP();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.o(63649);
                }
            });
            AppMethodBeat.o(63656);
            return;
        }
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(63650);
                ab.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.o(63650);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(63656);
    }

    public static String aid(String str) {
        AppMethodBeat.i(63657);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(63657);
            return str2;
        }
        try {
            str2 = bo.nullAsNil(Uri.parse(str).getQueryParameter("wechat_pkgid"));
            AppMethodBeat.o(63657);
            return str2;
        } catch (UnsupportedOperationException e) {
            ab.e("MicroMsg.Wepkg.WepkgUtil", e.getMessage());
            str2 = "";
            AppMethodBeat.o(63657);
            return str2;
        }
    }

    public static String aie(String str) {
        AppMethodBeat.i(63658);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(63658);
            return str2;
        }
        str2 = Uri.parse(str).getHost();
        AppMethodBeat.o(63658);
        return str2;
    }

    public static String aif(String str) {
        AppMethodBeat.i(63659);
        String str2;
        if (bo.isNullOrNil(str) || !URLUtil.isNetworkUrl(str)) {
            str2 = "";
            AppMethodBeat.o(63659);
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
        AppMethodBeat.o(63659);
        return str2;
    }

    public static boolean aig(String str) {
        AppMethodBeat.i(63660);
        if (bo.isNullOrNil(aid(str))) {
            AppMethodBeat.o(63660);
            return false;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
            ab.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
            a.b("EnterWeb", str, aid(str), null, 0, 0, a.Kl(11));
            AppMethodBeat.o(63660);
            return false;
        } else if (b.uXV) {
            ab.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
            a.b("EnterWeb", str, aid(str), null, 0, 0, a.Kl(12));
            AppMethodBeat.o(63660);
            return false;
        } else {
            AppMethodBeat.o(63660);
            return true;
        }
    }

    public static String hA(String str, String str2) {
        AppMethodBeat.i(63661);
        String x = g.x((str + "_" + str2).getBytes());
        AppMethodBeat.o(63661);
        return x;
    }

    public static boolean aih(String str) {
        AppMethodBeat.i(63662);
        try {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            AppMethodBeat.o(63662);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(63662);
            return false;
        }
    }

    public static boolean dgH() {
        AppMethodBeat.i(63663);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i = gregorianCalendar.get(11);
        int i2 = gregorianCalendar.get(12);
        if (i < 12 || i >= 14) {
            if (i == 14) {
                if (i2 <= 30) {
                    AppMethodBeat.o(63663);
                    return true;
                }
            } else if (i >= 18 && i <= 24) {
                AppMethodBeat.o(63663);
                return true;
            }
            AppMethodBeat.o(63663);
            return false;
        }
        AppMethodBeat.o(63663);
        return true;
    }

    public static boolean eA(Context context) {
        AppMethodBeat.i(63664);
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(63664);
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools") || runningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))) {
                AppMethodBeat.o(63664);
                return true;
            }
        }
        AppMethodBeat.o(63664);
        return false;
    }
}
