package com.tencent.mm.plugin.wepkg.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class b {
    private static b uWJ = null;

    static class a implements i<IPCString, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(63504);
            IPCString iPCString = (IPCString) obj;
            if (iPCString == null) {
                AppMethodBeat.o(63504);
                return null;
            }
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "pkgid:%s used_version:%s", iPCString.value, com.tencent.mm.plugin.wepkg.b.ahz(iPCString.value));
            Object bundle = new Bundle();
            bundle.putString("used_wepkg_version", r1);
            AppMethodBeat.o(63504);
            return bundle;
        }
    }

    static class b implements i<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(63505);
            Bundle bundle = (Bundle) obj;
            if (bundle == null) {
                AppMethodBeat.o(63505);
            } else {
                b.dS(bundle.getString("ipc_param_pkgid"), bundle.getInt("ipc_param_type", -1));
                AppMethodBeat.o(63505);
            }
            return null;
        }
    }

    static /* synthetic */ long a(b bVar, File file) {
        AppMethodBeat.i(63515);
        long U = bVar.U(file);
        AppMethodBeat.o(63515);
        return U;
    }

    static /* synthetic */ void dS(String str, int i) {
        AppMethodBeat.i(63516);
        dR(str, i);
        AppMethodBeat.o(63516);
    }

    public static synchronized b dgz() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(63506);
            if (uWJ == null) {
                synchronized (b.class) {
                    try {
                        if (uWJ == null) {
                            uWJ = new b();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(63506);
                        }
                    }
                }
            }
            bVar = uWJ;
            AppMethodBeat.o(63506);
        }
        return bVar;
    }

    public final synchronized void dgA() {
        AppMethodBeat.i(63507);
        d.aNS().aa(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(63501);
                SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 0);
                if ((System.currentTimeMillis() - sharedPreferences.getLong("clean_wepkg_time", 0) > 86400000 ? 1 : 0) != 0) {
                    ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg in one day");
                    sharedPreferences.edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
                    WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.Cn = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
                    if (ah.bqo()) {
                        wepkgCrossProcessTask.asP();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask);
                    }
                    List<WepkgVersion> list = wepkgCrossProcessTask.uWZ;
                    if (bo.ek(list)) {
                        ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
                    } else {
                        ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", Integer.valueOf(list.size()));
                        for (WepkgVersion wepkgVersion : list) {
                            if (wepkgVersion != null) {
                                b.dQ(wepkgVersion.eBS, 2);
                            }
                        }
                    }
                }
                if ((System.currentTimeMillis() - sharedPreferences.getLong("clean_dirty_wepkg_time", 0) > 172800000 ? 1 : 0) != 0) {
                    ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "start clean dirty wepkg");
                    sharedPreferences.edit().putLong("clean_dirty_wepkg_time", System.currentTimeMillis()).commit();
                    b.dgB();
                }
                if (System.currentTimeMillis() - sharedPreferences.getLong("clean_extra_wepkg_time", 0) > 3600000) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    sharedPreferences.edit().putLong("clean_extra_wepkg_time", System.currentTimeMillis()).commit();
                    long currentTimeMillis = System.currentTimeMillis();
                    ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "local wepkg size: %d, cost time: %d", Long.valueOf(b.a(b.this, new File(c.uWL))), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    List dgr = f.dgp().dgr();
                    if (bo.ek(dgr)) {
                        AppMethodBeat.o(63501);
                        return;
                    }
                    long j = r0;
                    while (j > DownloadHelper.SAVE_LENGTH && dgr.size() > 0) {
                        String str = (String) dgr.remove(0);
                        if (!bo.isNullOrNil(str)) {
                            b.dQ(str, 2);
                            j = b.a(b.this, new File(c.uWL));
                        }
                    }
                }
                ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg finish!");
                AppMethodBeat.o(63501);
            }
        });
        AppMethodBeat.o(63507);
    }

    public final void dP(final String str, final int i) {
        AppMethodBeat.i(63508);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            d.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63503);
                    b.dQ(str, i);
                    AppMethodBeat.o(63503);
                }
            });
            AppMethodBeat.o(63508);
            return;
        }
        dQ(str, i);
        AppMethodBeat.o(63508);
    }

    public static void dQ(String str, int i) {
        AppMethodBeat.i(63509);
        if (ah.bqo()) {
            dR(str, i);
            AppMethodBeat.o(63509);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
            AppMethodBeat.o(63509);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("ipc_param_pkgid", str);
            bundle.putInt("ipc_param_type", i);
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, b.class);
            AppMethodBeat.o(63509);
        }
    }

    private static void dR(String str, int i) {
        AppMethodBeat.i(63510);
        if (!ah.bqo()) {
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
            AppMethodBeat.o(63510);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
            AppMethodBeat.o(63510);
        } else {
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", str, Integer.valueOf(i));
            String ahQ;
            Bundle bundle;
            String string;
            ArrayList arrayList;
            switch (i) {
                case 0:
                    f.dgp().dgt();
                    ahP(c.uWL);
                    AppMethodBeat.o(63510);
                    return;
                case 1:
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(63510);
                        return;
                    }
                    ahP(c.ahQ(str));
                    f.dgp().ahE(str);
                    com.tencent.mm.plugin.wepkg.b.d.dgo().ahE(str);
                    AppMethodBeat.o(63510);
                    return;
                case 2:
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(63510);
                        return;
                    }
                    ahQ = c.ahQ(str);
                    bundle = (Bundle) com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", new IPCString(str), a.class);
                    if (bundle == null) {
                        AppMethodBeat.o(63510);
                        return;
                    }
                    string = bundle.getString("used_wepkg_version");
                    arrayList = new ArrayList();
                    if (!bo.isNullOrNil(string)) {
                        arrayList.add(string);
                    }
                    t(ahQ, arrayList);
                    f.dgp().ahE(str);
                    com.tencent.mm.plugin.wepkg.b.d.dgo().ahE(str);
                    AppMethodBeat.o(63510);
                    return;
                case 3:
                    if (!bo.isNullOrNil(str)) {
                        ahQ = c.ahQ(str);
                        bundle = (Bundle) com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", new IPCString(str), a.class);
                        if (bundle != null) {
                            string = bundle.getString("used_wepkg_version");
                            arrayList = new ArrayList();
                            if (!bo.isNullOrNil(string)) {
                                arrayList.add(string);
                            }
                            WepkgVersion ahW = h.ahW(str);
                            if (ahW != null) {
                                arrayList.add(ahW.version);
                            }
                            t(ahQ, arrayList);
                            break;
                        }
                        AppMethodBeat.o(63510);
                        return;
                    }
                    AppMethodBeat.o(63510);
                    return;
            }
            AppMethodBeat.o(63510);
        }
    }

    private long U(File file) {
        long j = 0;
        AppMethodBeat.i(63511);
        if (file == null) {
            AppMethodBeat.o(63511);
        } else {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2.isFile()) {
                            j += file2.length();
                        } else {
                            j += U(file2);
                        }
                    }
                } else if (file.isFile()) {
                    j = 0 + file.length();
                }
            } catch (Exception e) {
            }
            AppMethodBeat.o(63511);
        }
        return j;
    }

    private static boolean ahP(String str) {
        AppMethodBeat.i(63512);
        try {
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s", str);
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName() + "_temp");
            if (file.renameTo(file2)) {
                e.t(file2);
                AppMethodBeat.o(63512);
                return true;
            }
        } catch (Exception e) {
            ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + e.getMessage());
        }
        AppMethodBeat.o(63512);
        return false;
    }

    private static boolean t(String str, List list) {
        int i = 0;
        AppMethodBeat.i(63513);
        if (bo.ek(list)) {
            ahP(str);
            AppMethodBeat.o(63513);
            return true;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(63513);
                return false;
            }
            int length = listFiles.length;
            while (i < length) {
                File file2 = listFiles[i];
                if (!(file2 == null || list.contains(file2.getName()))) {
                    ahP(file2.getAbsolutePath());
                }
                i++;
            }
            AppMethodBeat.o(63513);
            return true;
        }
        AppMethodBeat.o(63513);
        return false;
    }

    static /* synthetic */ void dgB() {
        AppMethodBeat.i(63514);
        File file = new File(c.uWL);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.o(63514);
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null) {
                    dQ(file2.getName(), 3);
                }
            }
            AppMethodBeat.o(63514);
            return;
        }
        AppMethodBeat.o(63514);
    }
}
