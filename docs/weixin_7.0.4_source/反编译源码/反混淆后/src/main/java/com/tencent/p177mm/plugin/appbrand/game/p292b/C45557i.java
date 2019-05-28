package com.tencent.p177mm.plugin.appbrand.game.p292b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a.C19224b;
import com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a.C24694a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.i */
enum C45557i {
    ;
    
    private static C4931a hrj;
    private static C4931a hrk;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.i$1 */
    static class C192251 implements C4931a {
        C192251() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(130093);
            if (C42340f.auT() == null) {
                C4990ab.m7420w("MicroMsg.SearchMiniGameQueryLogic", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
                AppMethodBeat.m2505o(130093);
                return;
            }
            LinkedList linkedList;
            switch (c4935m.hsh) {
                case 2:
                case 3:
                    linkedList = new LinkedList();
                    if (!"batch".equals(str)) {
                        linkedList.addAll(C42340f.auT().mo73338yx(c4935m.obj.toString()));
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        for (String yx : (List) c4935m.obj) {
                            linkedList.addAll(C42340f.auT().mo73338yx(yx));
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        C42340f.auT().mo15641b("batch", 3, linkedList);
                        AppMethodBeat.m2505o(130093);
                        return;
                    }
                    break;
                case 5:
                    linkedList = new LinkedList();
                    if (!"batch".equals(str)) {
                        linkedList.addAll(C42340f.auT().mo73338yx(c4935m.obj.toString()));
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        for (String yx2 : (List) c4935m.obj) {
                            linkedList.addAll(C42340f.auT().mo73338yx(yx2));
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        C42340f.auT().mo15641b("batch", 5, linkedList);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(130093);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.i$2 */
    static class C192262 implements C4931a {
        C192262() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(130094);
            C4990ab.m7417i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandUsage storage change: event=%s | eventData=%s", str, c4935m);
            AppBrandRecentTaskInfo Au;
            List<String> list;
            ArrayList arrayList;
            switch (c4935m.hsh) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        Au = C45557i.m84027Au(c4935m.obj.toString());
                        if (Au == null) {
                            AppMethodBeat.m2505o(130094);
                            return;
                        }
                        C42340f.avb().mo73361a(C45557i.m84029b(Au), true);
                        AppMethodBeat.m2505o(130094);
                        return;
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        list = (List) c4935m.obj;
                        arrayList = new ArrayList();
                        for (String Au2 : list) {
                            Au = C45557i.m84027Au(Au2);
                            if (Au != null) {
                                arrayList.add(C45557i.m84029b(Au));
                            }
                        }
                        C42340f.avb().mo73365b(arrayList, true);
                        AppMethodBeat.m2505o(130094);
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        C42340f.avb().mo73364ae(c4935m.obj.toString(), true);
                        break;
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        list = (List) c4935m.obj;
                        arrayList = new ArrayList();
                        for (String Au22 : list) {
                            Au = C45557i.m84027Au(Au22);
                            if (Au != null) {
                                C24694a b = C45557i.m84029b(Au);
                                if (b != null) {
                                    arrayList.add(b.euD);
                                }
                            }
                        }
                        C42340f.avb().mo73363aH(arrayList);
                        AppMethodBeat.m2505o(130094);
                        return;
                    }
            }
            AppMethodBeat.m2505o(130094);
        }
    }

    static {
        hrj = new C192251();
        hrk = new C192262();
        AppMethodBeat.m2505o(130107);
    }

    public static void onCreate() {
        AppMethodBeat.m2504i(130097);
        C26842p.ayH().mo10114a(hrj, C42677e.aNS().oAl.getLooper());
        if (C42340f.auT() != null) {
            C42340f.auT().mo10116c(hrk);
        }
        AppMethodBeat.m2505o(130097);
    }

    public static void onDestroy() {
        AppMethodBeat.m2504i(130098);
        C26842p.ayH().mo10117d(hrj);
        if (C42340f.auT() != null) {
            C42340f.auT().mo10117d(hrk);
        }
        AppMethodBeat.m2505o(130098);
    }

    /* renamed from: e */
    public static void m84030e(C4931a c4931a) {
        AppMethodBeat.m2504i(130099);
        if (C42340f.avb() != null) {
            C42340f.avb().mo10116c(c4931a);
        }
        AppMethodBeat.m2505o(130099);
    }

    /* renamed from: f */
    public static void m84031f(C4931a c4931a) {
        AppMethodBeat.m2504i(130100);
        if (C42340f.avb() != null) {
            C42340f.avb().mo10117d(c4931a);
        }
        AppMethodBeat.m2505o(130100);
    }

    public static List<C19224b> aAG() {
        AppMethodBeat.m2504i(130101);
        if (C42340f.avb() == null) {
            AppMethodBeat.m2505o(130101);
            return null;
        }
        LinkedList<AppBrandRecentTaskInfo> linkedList = new LinkedList();
        if (C42340f.auT() != null) {
            ArrayList axJ = C42340f.auT().axJ();
            if (!C5046bo.m7548ek(axJ)) {
                linkedList.addAll(axJ);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (!((AppBrandRecentTaskInfo) it.next()).mo5856xy()) {
                it.remove();
            }
        }
        if (!C5046bo.m7548ek(linkedList)) {
            ArrayList arrayList = new ArrayList();
            for (AppBrandRecentTaskInfo a : linkedList) {
                arrayList.add(C45557i.m84028a(a));
            }
            C42340f.avb().mo73365b(arrayList, false);
            C4990ab.m7417i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandRecentTaskInfo convert to MiniGameStorage, size:%d", Integer.valueOf(arrayList.size()));
        }
        C4990ab.m7416i("MicroMsg.SearchMiniGameQueryLogic", "updateMiniGameList");
        List<C19224b> aAH = C42340f.avb().aAH();
        AppMethodBeat.m2505o(130101);
        return aAH;
    }

    /* renamed from: As */
    public static C19224b m84025As(String str) {
        AppMethodBeat.m2504i(130102);
        if (C42340f.avb() != null) {
            C19224b As = C42340f.avb().mo73360As(str);
            AppMethodBeat.m2505o(130102);
            return As;
        }
        AppMethodBeat.m2505o(130102);
        return null;
    }

    /* renamed from: At */
    public static AppBrandRecentTaskInfo m84026At(String str) {
        AppMethodBeat.m2504i(130103);
        if (C42340f.auT() == null) {
            AppMethodBeat.m2505o(130103);
            return null;
        }
        AppBrandRecentTaskInfo yw = C42340f.auT().mo73337yw(str);
        AppMethodBeat.m2505o(130103);
        return yw;
    }

    /* renamed from: a */
    private static C24694a m84028a(AppBrandRecentTaskInfo appBrandRecentTaskInfo) {
        AppMethodBeat.m2504i(130104);
        if (appBrandRecentTaskInfo == null) {
            AppMethodBeat.m2505o(130104);
            return null;
        }
        C24694a c24694a = new C24694a();
        c24694a.euD = appBrandRecentTaskInfo.euD;
        c24694a.fKh = appBrandRecentTaskInfo.appId;
        c24694a.ncH = appBrandRecentTaskInfo.appName;
        c24694a.IconUrl = appBrandRecentTaskInfo.hac;
        c24694a.jBB = appBrandRecentTaskInfo.csl;
        c24694a.gVs = appBrandRecentTaskInfo.gVs;
        AppMethodBeat.m2505o(130104);
        return c24694a;
    }
}
