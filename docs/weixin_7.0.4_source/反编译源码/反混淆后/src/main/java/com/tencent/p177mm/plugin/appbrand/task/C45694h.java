package com.tencent.p177mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.appusage.C19104i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C38435f;
import com.tencent.p177mm.plugin.appbrand.p329s.C10725a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI1;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI2;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI3;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI4;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.model.C33517f;
import com.tencent.p177mm.plugin.appbrand.report.model.C33517f.C33518a;
import com.tencent.p177mm.plugin.appbrand.task.AppBrandRemoteTaskController.C27306a;
import com.tencent.p177mm.plugin.appbrand.task.p1139a.C27308a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.task.h */
public class C45694h {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final LinkedList<C45695j> iFk;
    private static final LinkedList<C45695j> iFl;
    private static final C45695j iFm = new C10743d();
    private static final C45695j iFn = new C27309c();
    private static final C45695j iFo = new C2466k();

    /* renamed from: com.tencent.mm.plugin.appbrand.task.h$a */
    interface C10744a {
        /* renamed from: a */
        boolean mo22300a(C45695j c45695j);
    }

    static {
        boolean z;
        AppMethodBeat.m2504i(132872);
        if (C45694h.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
        LinkedList linkedList = new LinkedList();
        iFk = linkedList;
        linkedList.add(new C45695j(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class));
        iFk.add(new C45695j(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class));
        iFk.add(new C45695j(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class));
        iFk.add(new C45695j(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class));
        iFk.add(new C45695j(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class));
        linkedList = new LinkedList();
        iFl = linkedList;
        linkedList.addAll(iFk);
        iFl.add(iFm);
        iFl.add(iFn);
        iFl.add(iFo);
        AppMethodBeat.m2505o(132872);
    }

    /* renamed from: d */
    public static int m84427d(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(132849);
        if (C38435f.m65031c(context, appBrandInitConfigWC, appBrandStatObject)) {
            AppMethodBeat.m2505o(132849);
            return 1;
        }
        int i;
        int i2;
        C45695j c45695j;
        Context context2;
        C33517f c33517f = C33517f.iBe;
        String str = appBrandInitConfigWC.appId;
        int i3 = appBrandInitConfigWC.axy;
        boolean bu = C45694h.m84423bu(str, -1);
        C33518a c33518a = (C33518a) c33517f.iBf.get(str);
        if (c33518a == null) {
            c33518a = new C33518a();
            c33518a.iBi = 1;
            c33517f.iBf.put(str, c33518a);
        } else {
            c33518a.iBi++;
        }
        long anU = c33518a.iBh > 0 ? C5046bo.anU() - c33518a.iBh : 0;
        C7060h c7060h = C7060h.pYm;
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
        objArr[4] = Long.valueOf(c33518a.iBi);
        objArr[5] = Long.valueOf(anU);
        c7060h.mo8381e(16064, objArr);
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appBrandInitConfigWC.appId)) {
            i2 = 1;
            c45695j = iFo;
        } else if (appBrandInitConfigWC.hgJ) {
            i2 = 1;
            c45695j = iFm;
        } else {
            C45695j DQ = C45694h.m84414DQ(appBrandInitConfigWC.appId);
            if (DQ == null || DQ == iFm || (DQ instanceof C46897a)) {
                C45695j c45695j2;
                if (appBrandInitConfigWC.hgI) {
                    c45695j2 = iFn;
                } else {
                    DQ = C45694h.m84429e(appBrandInitConfigWC.mo32992xy() ? C38519g.WAGAME : C38519g.WASERVICE);
                    DQ.mo73491f(appBrandInitConfigWC.mo32992xy() ? C38519g.WAGAME : C38519g.WASERVICE);
                    c45695j2 = DQ;
                }
                C45694h.m84421b(c45695j2);
                i2 = 1;
                c45695j = c45695j2;
            } else {
                i2 = 2;
                c45695j = DQ;
            }
        }
        c45695j.mo73490a(appBrandInitConfigWC.appId, appBrandInitConfigWC.gVs, null);
        if (context == null) {
            context2 = C4996ah.getContext();
        } else {
            context2 = context;
        }
        Intent intent = new Intent(context2, c45695j.iFr);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        int i4 = (C10725a.m18398al(c45695j.iFr) || !(context2 instanceof Activity)) ? 268435456 : 0;
        intent.addFlags(i4);
        if (context2 instanceof Activity) {
            RunningTaskInfo av = C5046bo.m7523av(context2, ((Activity) context2).getTaskId());
            if (!(av == null || av.baseActivity == null || !C5046bo.nullAsNil(av.baseActivity.getClassName()).equals(c45695j.iFq))) {
                intent.putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
                intent.addFlags(603979776);
            }
        }
        appBrandInitConfigWC.hgK = C5046bo.anU();
        context2.startActivity(intent);
        if (i2 == 1) {
            C45694h.m84411DN(appBrandInitConfigWC.appId);
        }
        C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "startApp appId[%s] type[%d] scene[%d] strategy[%d]", appBrandInitConfigWC.appId, Integer.valueOf(appBrandInitConfigWC.gVs), Integer.valueOf(appBrandStatObject.scene), Integer.valueOf(i2));
        AppMethodBeat.m2505o(132849);
        return i2;
    }

    /* renamed from: bt */
    public static void m84422bt(String str, int i) {
        AppMethodBeat.m2504i(132850);
        C45695j DQ = C45694h.m84414DQ(str);
        if (DQ == null) {
            AppMethodBeat.m2505o(132850);
            return;
        }
        if (DQ.mo73487DT(str).intValue() == i && DQ.mo73488DU(str) != null) {
            DQ.mo73488DU(str).mo73482DM(str);
        }
        AppMethodBeat.m2505o(132850);
    }

    /* renamed from: pN */
    public static void m84430pN(int i) {
        AppMethodBeat.m2504i(132851);
        Iterator it;
        if (2 == i) {
            it = C45694h.aLX().iterator();
            while (it.hasNext()) {
                ((C45695j) it.next()).aLJ();
            }
            C4990ab.m7416i("MicroMsg.AppBrandTaskManager", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
            C45694h.m84419a(C38519g.WASERVICE, false);
            C45694h.m84419a(C38519g.WAGAME, false);
            AppMethodBeat.m2505o(132851);
            return;
        }
        it = C45694h.aLX().iterator();
        while (it.hasNext()) {
            C45695j c45695j = (C45695j) it.next();
            c45695j.aLJ();
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : c45695j.iFu.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.iEK = C27306a.KILL;
                    appBrandRemoteTaskController.iEL = i;
                    appBrandRemoteTaskController.aCb();
                }
            }
        }
        AppMethodBeat.m2505o(132851);
    }

    /* renamed from: DN */
    public static void m84411DN(String str) {
        AppMethodBeat.m2504i(132852);
        C45695j DQ = C45694h.m84414DQ(str);
        if (!(DQ == null || DQ.mo73488DU(str) == null)) {
            DQ.mo73488DU(str).mo73482DM(str);
        }
        AppMethodBeat.m2505o(132852);
    }

    /* renamed from: b */
    public static void m84420b(C38519g c38519g) {
        AppMethodBeat.m2504i(139126);
        C45694h.m84419a(c38519g, false);
        AppMethodBeat.m2505o(139126);
    }

    /* renamed from: a */
    static void m84419a(C38519g c38519g, boolean z) {
        AppMethodBeat.m2504i(132854);
        if (!C19104i.axb()) {
            AppMethodBeat.m2505o(132854);
        } else if (!z && C27308a.m43361g(c38519g)) {
            C4990ab.m7421w("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess %s, hit interval limit", c38519g);
            if (c38519g == C38519g.WASERVICE) {
                C7060h.pYm.mo15419k(915, 22, 1);
                AppMethodBeat.m2505o(132854);
                return;
            }
            if (c38519g == C38519g.WAGAME) {
                C7060h.pYm.mo15419k(915, 23, 1);
            }
            AppMethodBeat.m2505o(132854);
        } else if (c38519g == C38519g.NIL) {
            IllegalStateException illegalStateException = new IllegalStateException("serviceType == nil");
            AppMethodBeat.m2505o(132854);
            throw illegalStateException;
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s]", c38519g);
            C45695j d = C45694h.m84428d(c38519g);
            if (d != null) {
                d.mo73491f(c38519g);
                d.mo73489Dw();
            }
            AppMethodBeat.m2505o(132854);
        }
    }

    /* renamed from: DO */
    public static void m84412DO(String str) {
        AppMethodBeat.m2504i(132855);
        final C45695j DR = C45694h.m84415DR(str);
        if (DR == null) {
            AppMethodBeat.m2505o(132855);
            return;
        }
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132848);
                DR.mo73489Dw();
                AppMethodBeat.m2505o(132848);
            }
        }, 500);
        AppMethodBeat.m2505o(132855);
    }

    public static void onNetworkChange() {
        AppMethodBeat.m2504i(132856);
        Iterator it = C45694h.aLX().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((C45695j) it.next()).iFu.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.iEK = C27306a.NETWORK_CHANGE;
                    appBrandRemoteTaskController.aCb();
                }
            }
        }
        AppMethodBeat.m2505o(132856);
    }

    /* renamed from: DP */
    public static Class m84413DP(String str) {
        AppMethodBeat.m2504i(132857);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < iFl.size()) {
                C45695j c45695j = (C45695j) iFl.get(i2);
                if (c45695j.iFq.equals(str)) {
                    Class cls = c45695j.ifs;
                    AppMethodBeat.m2505o(132857);
                    return cls;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(132857);
                return null;
            }
        }
    }

    /* renamed from: a */
    private static C45695j m84418a(List<C45695j> list, C38519g c38519g) {
        AppMethodBeat.m2504i(132858);
        for (C45695j c45695j : list) {
            if (c45695j.iFv == c38519g) {
                AppMethodBeat.m2505o(132858);
                return c45695j;
            }
        }
        AppMethodBeat.m2505o(132858);
        return null;
    }

    /* renamed from: d */
    private static C45695j m84428d(C38519g c38519g) {
        C45695j c45695j;
        AppMethodBeat.m2504i(132860);
        synchronized (iFk) {
            try {
                if (C45694h.m84425c(c38519g)) {
                    C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", c38519g);
                    c45695j = null;
                } else {
                    String str;
                    Iterator it = iFk.iterator();
                    while (it.hasNext()) {
                        c45695j = (C45695j) it.next();
                        if (c45695j.iFt.isEmpty() && c45695j.iFv == c38519g) {
                            C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", c38519g);
                            AppMethodBeat.m2505o(132860);
                            break;
                        }
                    }
                    c45695j = C45694h.m84418a(iFk, C38519g.NIL);
                    String str2 = "MicroMsg.AppBrandTaskManager";
                    String str3 = "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = c38519g;
                    if (c45695j == null) {
                        str = BuildConfig.COMMAND;
                    } else {
                        str = c45695j.iFq;
                    }
                    objArr[1] = str;
                    C4990ab.m7417i(str2, str3, objArr);
                    AppMethodBeat.m2505o(132860);
                }
            } finally {
                AppMethodBeat.m2505o(132860);
            }
        }
        return c45695j;
    }

    /* renamed from: e */
    private static C45695j m84429e(C38519g c38519g) {
        C45695j c45695j;
        AppMethodBeat.m2504i(132861);
        synchronized (iFk) {
            try {
                Iterator it = iFk.iterator();
                while (it.hasNext()) {
                    c45695j = (C45695j) it.next();
                    if (c45695j.iFt.isEmpty() && c45695j.iFv == c38519g) {
                        C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found empty task, which can be used as [%s]", c38519g);
                        break;
                    }
                }
                if (C45694h.m84425c(c38519g)) {
                    C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup [%s] task reached maxLimit", c38519g);
                    c45695j = C45694h.m84418a(iFk, c38519g);
                    if (!$assertionsDisabled && c45695j == null) {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.m2505o(132861);
                        throw assertionError;
                    }
                } else {
                    c45695j = C45694h.m84418a(iFk, C38519g.NIL);
                    if (c45695j != null) {
                        C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup found not used task, which can be used as [%s]", c38519g);
                    } else {
                        C4990ab.m7417i("MicroMsg.AppBrandTaskManager", "getAvailableTaskToStartup all full for [%s]", c38519g);
                        c45695j = (C45695j) iFk.getFirst();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(132861);
            }
        }
        return c45695j;
    }

    /* renamed from: DQ */
    private static C45695j m84414DQ(String str) {
        AppMethodBeat.m2504i(132862);
        Iterator it = C45694h.aLX().iterator();
        while (it.hasNext()) {
            C45695j c45695j = (C45695j) it.next();
            if (c45695j.iFt.keySet().contains(str)) {
                AppMethodBeat.m2505o(132862);
                return c45695j;
            }
        }
        AppMethodBeat.m2505o(132862);
        return null;
    }

    /* renamed from: DR */
    static C45695j m84415DR(String str) {
        AppMethodBeat.m2504i(132863);
        Iterator it = C45694h.aLX().iterator();
        while (it.hasNext()) {
            C45695j c45695j = (C45695j) it.next();
            if (c45695j.iFq.equals(str)) {
                AppMethodBeat.m2505o(132863);
                return c45695j;
            }
        }
        Assert.assertTrue(true);
        AppMethodBeat.m2505o(132863);
        return null;
    }

    /* renamed from: a */
    static C45695j m84417a(C10744a c10744a) {
        AppMethodBeat.m2504i(132864);
        Iterator it = C45694h.aLX().iterator();
        while (it.hasNext()) {
            C45695j c45695j = (C45695j) it.next();
            if (c10744a.mo22300a(c45695j)) {
                AppMethodBeat.m2505o(132864);
                return c45695j;
            }
        }
        AppMethodBeat.m2505o(132864);
        return null;
    }

    /* renamed from: cN */
    static C45695j m84426cN(String str, String str2) {
        AppMethodBeat.m2504i(132865);
        Iterator it = C45694h.aLX().iterator();
        while (it.hasNext()) {
            C45695j c45695j = (C45695j) it.next();
            if (c45695j.iFt.keySet().contains(str) && c45695j.iFq.equals(str2)) {
                AppMethodBeat.m2505o(132865);
                return c45695j;
            }
        }
        AppMethodBeat.m2505o(132865);
        return null;
    }

    /* renamed from: bu */
    public static boolean m84423bu(String str, int i) {
        AppMethodBeat.m2504i(132866);
        C45695j DQ = C45694h.m84414DQ(str);
        if (DQ == null || ((i >= 0 && C5046bo.m7512a(DQ.mo73487DT(str), -1) != i) || DQ.mo73488DU(str) == null || !DQ.mo73488DU(str).aLU())) {
            AppMethodBeat.m2505o(132866);
            return false;
        }
        AppMethodBeat.m2505o(132866);
        return true;
    }

    /* renamed from: DS */
    public static boolean m84416DS(String str) {
        AppMethodBeat.m2504i(139127);
        boolean bu = C45694h.m84423bu(str, -1);
        AppMethodBeat.m2505o(139127);
        return bu;
    }

    /* renamed from: bv */
    public static String m84424bv(String str, int i) {
        AppMethodBeat.m2504i(132868);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(132868);
            return null;
        }
        try {
            synchronized (iFl) {
                if (C45694h.m84423bu(str, i)) {
                    String str2 = C45694h.m84414DQ(str).mo73488DU(str).iEO;
                    AppMethodBeat.m2505o(132868);
                    return str2;
                }
            }
        } catch (NullPointerException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandTaskManager", e, "[NOT CRASH]getAliveInstanceId", new Object[0]);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(132868);
            }
        }
        AppMethodBeat.m2505o(132868);
        return null;
    }

    private static LinkedList<C45695j> aLX() {
        LinkedList<C45695j> linkedList;
        AppMethodBeat.m2504i(132869);
        synchronized (iFl) {
            try {
                linkedList = new LinkedList(iFl);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(132869);
            }
        }
        return linkedList;
    }

    /* renamed from: DI */
    static void m84410DI(String str) {
        AppMethodBeat.m2504i(132870);
        C45695j DQ = C45694h.m84414DQ(str);
        if (DQ != null) {
            DQ.mo73486DI(str);
            if (DQ.iFt.keySet().isEmpty()) {
                if (DQ instanceof C46897a) {
                    synchronized (iFl) {
                        try {
                            iFl.remove(DQ);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(132870);
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
                        AppMethodBeat.m2505o(132870);
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
                            AppMethodBeat.m2505o(132870);
                        }
                    }
                }
                return;
            }
        }
        AppMethodBeat.m2505o(132870);
    }

    /* renamed from: b */
    static void m84421b(C45695j c45695j) {
        AppMethodBeat.m2504i(132871);
        synchronized (iFl) {
            try {
                iFl.remove(c45695j);
                iFl.addLast(c45695j);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(132871);
            }
        }
        synchronized (iFk) {
            try {
                if (iFk.contains(c45695j)) {
                    iFk.remove(c45695j);
                    iFk.addLast(c45695j);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(132871);
                }
            }
        }
    }

    /* renamed from: c */
    private static boolean m84425c(C38519g c38519g) {
        AppMethodBeat.m2504i(132859);
        Iterator it = iFk.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (((C45695j) it.next()).iFv == c38519g) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > c38519g.iFi) {
            IllegalStateException illegalStateException = new IllegalStateException(C5046bo.m7584t("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", c38519g.name(), Integer.valueOf(i), Integer.valueOf(c38519g.iFi)));
            AppMethodBeat.m2505o(132859);
            throw illegalStateException;
        } else if (i == c38519g.iFi) {
            AppMethodBeat.m2505o(132859);
            return true;
        } else {
            AppMethodBeat.m2505o(132859);
            return false;
        }
    }
}
