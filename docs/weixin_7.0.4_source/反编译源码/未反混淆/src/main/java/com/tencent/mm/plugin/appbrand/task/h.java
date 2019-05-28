package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final LinkedList<j> iFk;
    private static final LinkedList<j> iFl;
    private static final j iFm = new d();
    private static final j iFn = new c();
    private static final j iFo = new k();

    interface a {
        boolean a(j jVar);
    }

    static {
        boolean z;
        AppMethodBeat.i(132872);
        if (h.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
        LinkedList linkedList = new LinkedList();
        iFk = linkedList;
        linkedList.add(new j(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class));
        iFk.add(new j(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class));
        iFk.add(new j(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class));
        iFk.add(new j(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class));
        iFk.add(new j(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class));
        linkedList = new LinkedList();
        iFl = linkedList;
        linkedList.addAll(iFk);
        iFl.add(iFm);
        iFl.add(iFn);
        iFl.add(iFo);
        AppMethodBeat.o(132872);
    }

    public static int d(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(132849);
        if (f.c(context, appBrandInitConfigWC, appBrandStatObject)) {
            AppMethodBeat.o(132849);
            return 1;
        }
        int i;
        int i2;
        j jVar;
        Context context2;
        com.tencent.mm.plugin.appbrand.report.model.f fVar = com.tencent.mm.plugin.appbrand.report.model.f.iBe;
        String str = appBrandInitConfigWC.appId;
        int i3 = appBrandInitConfigWC.axy;
        boolean bu = bu(str, -1);
        com.tencent.mm.plugin.appbrand.report.model.f.a aVar = (com.tencent.mm.plugin.appbrand.report.model.f.a) fVar.iBf.get(str);
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.appbrand.report.model.f.a();
            aVar.iBi = 1;
            fVar.iBf.put(str, aVar);
        } else {
            aVar.iBi++;
        }
        long anU = aVar.iBh > 0 ? bo.anU() - aVar.iBh : 0;
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i3);
        if (bu) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Long.valueOf(aVar.iBi);
        objArr[5] = Long.valueOf(anU);
        hVar.e(16064, objArr);
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appBrandInitConfigWC.appId)) {
            i2 = 1;
            jVar = iFo;
        } else if (appBrandInitConfigWC.hgJ) {
            i2 = 1;
            jVar = iFm;
        } else {
            j DQ = DQ(appBrandInitConfigWC.appId);
            if (DQ == null || DQ == iFm || (DQ instanceof a)) {
                j jVar2;
                if (appBrandInitConfigWC.hgI) {
                    jVar2 = iFn;
                } else {
                    DQ = e(appBrandInitConfigWC.xy() ? g.WAGAME : g.WASERVICE);
                    DQ.f(appBrandInitConfigWC.xy() ? g.WAGAME : g.WASERVICE);
                    jVar2 = DQ;
                }
                b(jVar2);
                i2 = 1;
                jVar = jVar2;
            } else {
                i2 = 2;
                jVar = DQ;
            }
        }
        jVar.a(appBrandInitConfigWC.appId, appBrandInitConfigWC.gVs, null);
        if (context == null) {
            context2 = ah.getContext();
        } else {
            context2 = context;
        }
        Intent intent = new Intent(context2, jVar.iFr);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        int i4 = (com.tencent.mm.plugin.appbrand.s.a.al(jVar.iFr) || !(context2 instanceof Activity)) ? 268435456 : 0;
        intent.addFlags(i4);
        if (context2 instanceof Activity) {
            RunningTaskInfo av = bo.av(context2, ((Activity) context2).getTaskId());
            if (!(av == null || av.baseActivity == null || !bo.nullAsNil(av.baseActivity.getClassName()).equals(jVar.iFq))) {
                intent.putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
                intent.addFlags(603979776);
            }
        }
        appBrandInitConfigWC.hgK = bo.anU();
        context2.startActivity(intent);
        if (i2 == 1) {
            DN(appBrandInitConfigWC.appId);
        }
        ab.i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d]", appBrandInitConfigWC.appId, Integer.valueOf(appBrandInitConfigWC.gVs), Integer.valueOf(appBrandStatObject.scene), Integer.valueOf(i2));
        AppMethodBeat.o(132849);
        return i2;
    }

    public static void bt(String str, int i) {
        AppMethodBeat.i(132850);
        j DQ = DQ(str);
        if (DQ == null) {
            AppMethodBeat.o(132850);
            return;
        }
        if (DQ.DT(str).intValue() == i && DQ.DU(str) != null) {
            DQ.DU(str).DM(str);
        }
        AppMethodBeat.o(132850);
    }

    public static void pN(int i) {
        AppMethodBeat.i(132851);
        Iterator it;
        if (2 == i) {
            it = aLX().iterator();
            while (it.hasNext()) {
                ((j) it.next()).aLJ();
            }
            ab.i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
            a(g.WASERVICE, false);
            a(g.WAGAME, false);
            AppMethodBeat.o(132851);
            return;
        }
        it = aLX().iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            jVar.aLJ();
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : jVar.iFu.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.iEK = com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a.KILL;
                    appBrandRemoteTaskController.iEL = i;
                    appBrandRemoteTaskController.aCb();
                }
            }
        }
        AppMethodBeat.o(132851);
    }

    public static void DN(String str) {
        AppMethodBeat.i(132852);
        j DQ = DQ(str);
        if (!(DQ == null || DQ.DU(str) == null)) {
            DQ.DU(str).DM(str);
        }
        AppMethodBeat.o(132852);
    }

    public static void b(g gVar) {
        AppMethodBeat.i(139126);
        a(gVar, false);
        AppMethodBeat.o(139126);
    }

    static void a(g gVar, boolean z) {
        AppMethodBeat.i(132854);
        if (!i.axb()) {
            AppMethodBeat.o(132854);
        } else if (!z && com.tencent.mm.plugin.appbrand.task.a.a.g(gVar)) {
            ab.w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", gVar);
            if (gVar == g.WASERVICE) {
                com.tencent.mm.plugin.report.service.h.pYm.k(915, 22, 1);
                AppMethodBeat.o(132854);
                return;
            }
            if (gVar == g.WAGAME) {
                com.tencent.mm.plugin.report.service.h.pYm.k(915, 23, 1);
            }
            AppMethodBeat.o(132854);
        } else if (gVar == g.NIL) {
            IllegalStateException illegalStateException = new IllegalStateException("serviceType == nil");
            AppMethodBeat.o(132854);
            throw illegalStateException;
        } else {
            ab.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s]", gVar);
            j d = d(gVar);
            if (d != null) {
                d.f(gVar);
                d.Dw();
            }
            AppMethodBeat.o(132854);
        }
    }

    public static void DO(String str) {
        AppMethodBeat.i(132855);
        final j DR = DR(str);
        if (DR == null) {
            AppMethodBeat.o(132855);
            return;
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132848);
                DR.Dw();
                AppMethodBeat.o(132848);
            }
        }, 500);
        AppMethodBeat.o(132855);
    }

    public static void onNetworkChange() {
        AppMethodBeat.i(132856);
        Iterator it = aLX().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((j) it.next()).iFu.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.iEK = com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a.NETWORK_CHANGE;
                    appBrandRemoteTaskController.aCb();
                }
            }
        }
        AppMethodBeat.o(132856);
    }

    public static Class DP(String str) {
        AppMethodBeat.i(132857);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < iFl.size()) {
                j jVar = (j) iFl.get(i2);
                if (jVar.iFq.equals(str)) {
                    Class cls = jVar.ifs;
                    AppMethodBeat.o(132857);
                    return cls;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(132857);
                return null;
            }
        }
    }

    private static j a(List<j> list, g gVar) {
        AppMethodBeat.i(132858);
        for (j jVar : list) {
            if (jVar.iFv == gVar) {
                AppMethodBeat.o(132858);
                return jVar;
            }
        }
        AppMethodBeat.o(132858);
        return null;
    }

    private static j d(g gVar) {
        j jVar;
        AppMethodBeat.i(132860);
        synchronized (iFk) {
            try {
                if (c(gVar)) {
                    ab.i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", gVar);
                    jVar = null;
                } else {
                    String str;
                    Iterator it = iFk.iterator();
                    while (it.hasNext()) {
                        jVar = (j) it.next();
                        if (jVar.iFt.isEmpty() && jVar.iFv == gVar) {
                            ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", gVar);
                            AppMethodBeat.o(132860);
                            break;
                        }
                    }
                    jVar = a(iFk, g.NIL);
                    String str2 = "MicroMsg.AppBrandTaskManager";
                    String str3 = "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = gVar;
                    if (jVar == null) {
                        str = BuildConfig.COMMAND;
                    } else {
                        str = jVar.iFq;
                    }
                    objArr[1] = str;
                    ab.i(str2, str3, objArr);
                    AppMethodBeat.o(132860);
                }
            } finally {
                AppMethodBeat.o(132860);
            }
        }
        return jVar;
    }

    private static j e(g gVar) {
        j jVar;
        AppMethodBeat.i(132861);
        synchronized (iFk) {
            try {
                Iterator it = iFk.iterator();
                while (it.hasNext()) {
                    jVar = (j) it.next();
                    if (jVar.iFt.isEmpty() && jVar.iFv == gVar) {
                        ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", gVar);
                        break;
                    }
                }
                if (c(gVar)) {
                    ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", gVar);
                    jVar = a(iFk, gVar);
                    if (!$assertionsDisabled && jVar == null) {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(132861);
                        throw assertionError;
                    }
                } else {
                    jVar = a(iFk, g.NIL);
                    if (jVar != null) {
                        ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", gVar);
                    } else {
                        ab.i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", gVar);
                        jVar = (j) iFk.getFirst();
                    }
                }
            } finally {
                AppMethodBeat.o(132861);
            }
        }
        return jVar;
    }

    private static j DQ(String str) {
        AppMethodBeat.i(132862);
        Iterator it = aLX().iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iFt.keySet().contains(str)) {
                AppMethodBeat.o(132862);
                return jVar;
            }
        }
        AppMethodBeat.o(132862);
        return null;
    }

    static j DR(String str) {
        AppMethodBeat.i(132863);
        Iterator it = aLX().iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iFq.equals(str)) {
                AppMethodBeat.o(132863);
                return jVar;
            }
        }
        Assert.assertTrue(true);
        AppMethodBeat.o(132863);
        return null;
    }

    static j a(a aVar) {
        AppMethodBeat.i(132864);
        Iterator it = aLX().iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (aVar.a(jVar)) {
                AppMethodBeat.o(132864);
                return jVar;
            }
        }
        AppMethodBeat.o(132864);
        return null;
    }

    static j cN(String str, String str2) {
        AppMethodBeat.i(132865);
        Iterator it = aLX().iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iFt.keySet().contains(str) && jVar.iFq.equals(str2)) {
                AppMethodBeat.o(132865);
                return jVar;
            }
        }
        AppMethodBeat.o(132865);
        return null;
    }

    public static boolean bu(String str, int i) {
        AppMethodBeat.i(132866);
        j DQ = DQ(str);
        if (DQ == null || ((i >= 0 && bo.a(DQ.DT(str), -1) != i) || DQ.DU(str) == null || !DQ.DU(str).aLU())) {
            AppMethodBeat.o(132866);
            return false;
        }
        AppMethodBeat.o(132866);
        return true;
    }

    public static boolean DS(String str) {
        AppMethodBeat.i(139127);
        boolean bu = bu(str, -1);
        AppMethodBeat.o(139127);
        return bu;
    }

    public static String bv(String str, int i) {
        AppMethodBeat.i(132868);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(132868);
            return null;
        }
        try {
            synchronized (iFl) {
                if (bu(str, i)) {
                    String str2 = DQ(str).DU(str).iEO;
                    AppMethodBeat.o(132868);
                    return str2;
                }
            }
        } catch (NullPointerException e) {
            ab.printErrStackTrace("MicroMsg.AppBrandTaskManager", e, "[NOT CRASH]getAliveInstanceId", new Object[0]);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(132868);
            }
        }
        AppMethodBeat.o(132868);
        return null;
    }

    private static LinkedList<j> aLX() {
        LinkedList<j> linkedList;
        AppMethodBeat.i(132869);
        synchronized (iFl) {
            try {
                linkedList = new LinkedList(iFl);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(132869);
            }
        }
        return linkedList;
    }

    static void DI(String str) {
        AppMethodBeat.i(132870);
        j DQ = DQ(str);
        if (DQ != null) {
            DQ.DI(str);
            if (DQ.iFt.keySet().isEmpty()) {
                if (DQ instanceof a) {
                    synchronized (iFl) {
                        try {
                            iFl.remove(DQ);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(132870);
                        }
                    }
                    return;
                }
                synchronized (iFl) {
                    try {
                        iFl.remove(DQ);
                        iFl.addFirst(DQ);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(132870);
                    }
                }
                synchronized (iFk) {
                    try {
                        if (iFk.contains(DQ)) {
                            iFk.remove(DQ);
                            iFk.addFirst(DQ);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(132870);
                        }
                    }
                }
                return;
            }
        }
        AppMethodBeat.o(132870);
    }

    static void b(j jVar) {
        AppMethodBeat.i(132871);
        synchronized (iFl) {
            try {
                iFl.remove(jVar);
                iFl.addLast(jVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(132871);
            }
        }
        synchronized (iFk) {
            try {
                if (iFk.contains(jVar)) {
                    iFk.remove(jVar);
                    iFk.addLast(jVar);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(132871);
                }
            }
        }
    }

    private static boolean c(g gVar) {
        AppMethodBeat.i(132859);
        Iterator it = iFk.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (((j) it.next()).iFv == gVar) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > gVar.iFi) {
            IllegalStateException illegalStateException = new IllegalStateException(bo.t("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", gVar.name(), Integer.valueOf(i), Integer.valueOf(gVar.iFi)));
            AppMethodBeat.o(132859);
            throw illegalStateException;
        } else if (i == gVar.iFi) {
            AppMethodBeat.o(132859);
            return true;
        } else {
            AppMethodBeat.o(132859);
            return false;
        }
    }
}
