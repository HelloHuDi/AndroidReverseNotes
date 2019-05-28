package com.tencent.p177mm.plugin.wepkg.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.wepkg.C40393b;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.p1076b.C44021f;
import com.tencent.p177mm.plugin.wepkg.p1076b.C46470d;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.model.b */
public class C30011b {
    private static C30011b uWJ = null;

    /* renamed from: com.tencent.mm.plugin.wepkg.model.b$a */
    static class C14806a implements C45413i<IPCString, Bundle> {
        private C14806a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(63504);
            IPCString iPCString = (IPCString) obj;
            if (iPCString == null) {
                AppMethodBeat.m2505o(63504);
                return null;
            }
            C4990ab.m7417i("MicroMsg.Wepkg.CleanWepkgMgr", "pkgid:%s used_version:%s", iPCString.value, C40393b.ahz(iPCString.value));
            Object bundle = new Bundle();
            bundle.putString("used_wepkg_version", r1);
            AppMethodBeat.m2505o(63504);
            return bundle;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.b$b */
    static class C30010b implements C45413i<Bundle, Bundle> {
        private C30010b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(63505);
            Bundle bundle = (Bundle) obj;
            if (bundle == null) {
                AppMethodBeat.m2505o(63505);
            } else {
                C30011b.m47502dS(bundle.getString("ipc_param_pkgid"), bundle.getInt("ipc_param_type", -1));
                AppMethodBeat.m2505o(63505);
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.b$1 */
    class C300121 implements Runnable {
        C300121() {
        }

        public final void run() {
            int i;
            AppMethodBeat.m2504i(63501);
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("we_pkg_sp", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("clean_wepkg_time", 0) > 86400000 ? 1 : 0) != 0) {
                C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg in one day");
                sharedPreferences.edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.f2968Cn = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
                if (C4996ah.bqo()) {
                    wepkgCrossProcessTask.asP();
                } else {
                    WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
                }
                List<WepkgVersion> list = wepkgCrossProcessTask.uWZ;
                if (C5046bo.m7548ek(list)) {
                    C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
                } else {
                    C4990ab.m7417i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", Integer.valueOf(list.size()));
                    for (WepkgVersion wepkgVersion : list) {
                        if (wepkgVersion != null) {
                            C30011b.m47500dQ(wepkgVersion.eBS, 2);
                        }
                    }
                }
            }
            if ((System.currentTimeMillis() - sharedPreferences.getLong("clean_dirty_wepkg_time", 0) > 172800000 ? 1 : 0) != 0) {
                C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "start clean dirty wepkg");
                sharedPreferences.edit().putLong("clean_dirty_wepkg_time", System.currentTimeMillis()).commit();
                C30011b.dgB();
            }
            if (System.currentTimeMillis() - sharedPreferences.getLong("clean_extra_wepkg_time", 0) > 3600000) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                sharedPreferences.edit().putLong("clean_extra_wepkg_time", System.currentTimeMillis()).commit();
                long currentTimeMillis = System.currentTimeMillis();
                C4990ab.m7417i("MicroMsg.Wepkg.CleanWepkgMgr", "local wepkg size: %d, cost time: %d", Long.valueOf(C30011b.m47499a(C30011b.this, new File(C14807c.uWL))), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                List dgr = C44021f.dgp().dgr();
                if (C5046bo.m7548ek(dgr)) {
                    AppMethodBeat.m2505o(63501);
                    return;
                }
                long j = r0;
                while (j > DownloadHelper.SAVE_LENGTH && dgr.size() > 0) {
                    String str = (String) dgr.remove(0);
                    if (!C5046bo.isNullOrNil(str)) {
                        C30011b.m47500dQ(str, 2);
                        j = C30011b.m47499a(C30011b.this, new File(C14807c.uWL));
                    }
                }
            }
            C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg finish!");
            AppMethodBeat.m2505o(63501);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.b$2 */
    public class C300132 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(63502);
            C30011b.m47500dQ(null, 0);
            AppMethodBeat.m2505o(63502);
        }
    }

    /* renamed from: a */
    static /* synthetic */ long m47499a(C30011b c30011b, File file) {
        AppMethodBeat.m2504i(63515);
        long U = c30011b.m47498U(file);
        AppMethodBeat.m2505o(63515);
        return U;
    }

    /* renamed from: dS */
    static /* synthetic */ void m47502dS(String str, int i) {
        AppMethodBeat.m2504i(63516);
        C30011b.m47501dR(str, i);
        AppMethodBeat.m2505o(63516);
    }

    public static synchronized C30011b dgz() {
        C30011b c30011b;
        synchronized (C30011b.class) {
            AppMethodBeat.m2504i(63506);
            if (uWJ == null) {
                synchronized (C30011b.class) {
                    try {
                        if (uWJ == null) {
                            uWJ = new C30011b();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(63506);
                        }
                    }
                }
            }
            c30011b = uWJ;
            AppMethodBeat.m2505o(63506);
        }
        return c30011b;
    }

    public final synchronized void dgA() {
        AppMethodBeat.m2504i(63507);
        C30022d.aNS().mo10302aa(new C300121());
        AppMethodBeat.m2505o(63507);
    }

    /* renamed from: dP */
    public final void mo48248dP(final String str, final int i) {
        AppMethodBeat.m2504i(63508);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C30022d.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(63503);
                    C30011b.m47500dQ(str, i);
                    AppMethodBeat.m2505o(63503);
                }
            });
            AppMethodBeat.m2505o(63508);
            return;
        }
        C30011b.m47500dQ(str, i);
        AppMethodBeat.m2505o(63508);
    }

    /* renamed from: dQ */
    public static void m47500dQ(String str, int i) {
        AppMethodBeat.m2504i(63509);
        if (C4996ah.bqo()) {
            C30011b.m47501dR(str, i);
            AppMethodBeat.m2505o(63509);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgSync fail. can not process on Main thread");
            AppMethodBeat.m2505o(63509);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("ipc_param_pkgid", str);
            bundle.putInt("ipc_param_type", i);
            C9549f.m17010a("com.tencent.mm", bundle, C30010b.class);
            AppMethodBeat.m2505o(63509);
        }
    }

    /* renamed from: dR */
    private static void m47501dR(String str, int i) {
        AppMethodBeat.m2504i(63510);
        if (!C4996ah.bqo()) {
            C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. only run on mm process");
            AppMethodBeat.m2505o(63510);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync fail. can not process on Main thread");
            AppMethodBeat.m2505o(63510);
        } else {
            C4990ab.m7417i("MicroMsg.Wepkg.CleanWepkgMgr", "removeWepkgInMMSync, pkgid:[%s], type:%d", str, Integer.valueOf(i));
            String ahQ;
            Bundle bundle;
            String string;
            ArrayList arrayList;
            switch (i) {
                case 0:
                    C44021f.dgp().dgt();
                    C30011b.ahP(C14807c.uWL);
                    AppMethodBeat.m2505o(63510);
                    return;
                case 1:
                    if (C5046bo.isNullOrNil(str)) {
                        AppMethodBeat.m2505o(63510);
                        return;
                    }
                    C30011b.ahP(C14807c.ahQ(str));
                    C44021f.dgp().ahE(str);
                    C46470d.dgo().ahE(str);
                    AppMethodBeat.m2505o(63510);
                    return;
                case 2:
                    if (C5046bo.isNullOrNil(str)) {
                        AppMethodBeat.m2505o(63510);
                        return;
                    }
                    ahQ = C14807c.ahQ(str);
                    bundle = (Bundle) C9549f.m17010a("com.tencent.mm:tools", new IPCString(str), C14806a.class);
                    if (bundle == null) {
                        AppMethodBeat.m2505o(63510);
                        return;
                    }
                    string = bundle.getString("used_wepkg_version");
                    arrayList = new ArrayList();
                    if (!C5046bo.isNullOrNil(string)) {
                        arrayList.add(string);
                    }
                    C30011b.m47503t(ahQ, arrayList);
                    C44021f.dgp().ahE(str);
                    C46470d.dgo().ahE(str);
                    AppMethodBeat.m2505o(63510);
                    return;
                case 3:
                    if (!C5046bo.isNullOrNil(str)) {
                        ahQ = C14807c.ahQ(str);
                        bundle = (Bundle) C9549f.m17010a("com.tencent.mm:tools", new IPCString(str), C14806a.class);
                        if (bundle != null) {
                            string = bundle.getString("used_wepkg_version");
                            arrayList = new ArrayList();
                            if (!C5046bo.isNullOrNil(string)) {
                                arrayList.add(string);
                            }
                            WepkgVersion ahW = C40404h.ahW(str);
                            if (ahW != null) {
                                arrayList.add(ahW.version);
                            }
                            C30011b.m47503t(ahQ, arrayList);
                            break;
                        }
                        AppMethodBeat.m2505o(63510);
                        return;
                    }
                    AppMethodBeat.m2505o(63510);
                    return;
            }
            AppMethodBeat.m2505o(63510);
        }
    }

    /* renamed from: U */
    private long m47498U(File file) {
        long j = 0;
        AppMethodBeat.m2504i(63511);
        if (file == null) {
            AppMethodBeat.m2505o(63511);
        } else {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2.isFile()) {
                            j += file2.length();
                        } else {
                            j += m47498U(file2);
                        }
                    }
                } else if (file.isFile()) {
                    j = 0 + file.length();
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(63511);
        }
        return j;
    }

    private static boolean ahP(String str) {
        AppMethodBeat.m2504i(63512);
        try {
            C4990ab.m7417i("MicroMsg.Wepkg.CleanWepkgMgr", "Safe delete dir: %s", str);
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName() + "_temp");
            if (file.renameTo(file2)) {
                C1173e.m2575t(file2);
                AppMethodBeat.m2505o(63512);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.Wepkg.CleanWepkgMgr", "safeDeleteDir err:" + e.getMessage());
        }
        AppMethodBeat.m2505o(63512);
        return false;
    }

    /* renamed from: t */
    private static boolean m47503t(String str, List list) {
        int i = 0;
        AppMethodBeat.m2504i(63513);
        if (C5046bo.m7548ek(list)) {
            C30011b.ahP(str);
            AppMethodBeat.m2505o(63513);
            return true;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(63513);
                return false;
            }
            int length = listFiles.length;
            while (i < length) {
                File file2 = listFiles[i];
                if (!(file2 == null || list.contains(file2.getName()))) {
                    C30011b.ahP(file2.getAbsolutePath());
                }
                i++;
            }
            AppMethodBeat.m2505o(63513);
            return true;
        }
        AppMethodBeat.m2505o(63513);
        return false;
    }

    static /* synthetic */ void dgB() {
        AppMethodBeat.m2504i(63514);
        File file = new File(C14807c.uWL);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.m2505o(63514);
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null) {
                    C30011b.m47500dQ(file2.getName(), 3);
                }
            }
            AppMethodBeat.m2505o(63514);
            return;
        }
        AppMethodBeat.m2505o(63514);
    }
}
