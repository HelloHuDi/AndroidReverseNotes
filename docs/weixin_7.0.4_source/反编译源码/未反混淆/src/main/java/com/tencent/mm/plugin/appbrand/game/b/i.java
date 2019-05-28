package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.game.b.a.b;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static a hrj;
    private static a hrk;

    static {
        hrj = new a() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(130093);
                if (f.auT() == null) {
                    ab.w("MicroMsg.SearchMiniGameQueryLogic", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
                    AppMethodBeat.o(130093);
                    return;
                }
                LinkedList linkedList;
                switch (mVar.hsh) {
                    case 2:
                    case 3:
                        linkedList = new LinkedList();
                        if (!"batch".equals(str)) {
                            linkedList.addAll(f.auT().yx(mVar.obj.toString()));
                        } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                            for (String yx : (List) mVar.obj) {
                                linkedList.addAll(f.auT().yx(yx));
                            }
                        }
                        if (!linkedList.isEmpty()) {
                            f.auT().b("batch", 3, linkedList);
                            AppMethodBeat.o(130093);
                            return;
                        }
                        break;
                    case 5:
                        linkedList = new LinkedList();
                        if (!"batch".equals(str)) {
                            linkedList.addAll(f.auT().yx(mVar.obj.toString()));
                        } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                            for (String yx2 : (List) mVar.obj) {
                                linkedList.addAll(f.auT().yx(yx2));
                            }
                        }
                        if (!linkedList.isEmpty()) {
                            f.auT().b("batch", 5, linkedList);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(130093);
            }
        };
        hrk = new a() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(130094);
                ab.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandUsage storage change: event=%s | eventData=%s", str, mVar);
                AppBrandRecentTaskInfo Au;
                List<String> list;
                ArrayList arrayList;
                switch (mVar.hsh) {
                    case 2:
                    case 3:
                        if (!"batch".equals(str)) {
                            Au = i.Au(mVar.obj.toString());
                            if (Au == null) {
                                AppMethodBeat.o(130094);
                                return;
                            }
                            f.avb().a(i.b(Au), true);
                            AppMethodBeat.o(130094);
                            return;
                        } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                            list = (List) mVar.obj;
                            arrayList = new ArrayList();
                            for (String Au2 : list) {
                                Au = i.Au(Au2);
                                if (Au != null) {
                                    arrayList.add(i.b(Au));
                                }
                            }
                            f.avb().b(arrayList, true);
                            AppMethodBeat.o(130094);
                            return;
                        }
                    case 5:
                        if (!"batch".equals(str)) {
                            f.avb().ae(mVar.obj.toString(), true);
                            break;
                        } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                            list = (List) mVar.obj;
                            arrayList = new ArrayList();
                            for (String Au22 : list) {
                                Au = i.Au(Au22);
                                if (Au != null) {
                                    com.tencent.mm.plugin.appbrand.game.b.a.a b = i.b(Au);
                                    if (b != null) {
                                        arrayList.add(b.euD);
                                    }
                                }
                            }
                            f.avb().aH(arrayList);
                            AppMethodBeat.o(130094);
                            return;
                        }
                }
                AppMethodBeat.o(130094);
            }
        };
        AppMethodBeat.o(130107);
    }

    public static void onCreate() {
        AppMethodBeat.i(130097);
        p.ayH().a(hrj, e.aNS().oAl.getLooper());
        if (f.auT() != null) {
            f.auT().c(hrk);
        }
        AppMethodBeat.o(130097);
    }

    public static void onDestroy() {
        AppMethodBeat.i(130098);
        p.ayH().d(hrj);
        if (f.auT() != null) {
            f.auT().d(hrk);
        }
        AppMethodBeat.o(130098);
    }

    public static void e(a aVar) {
        AppMethodBeat.i(130099);
        if (f.avb() != null) {
            f.avb().c(aVar);
        }
        AppMethodBeat.o(130099);
    }

    public static void f(a aVar) {
        AppMethodBeat.i(130100);
        if (f.avb() != null) {
            f.avb().d(aVar);
        }
        AppMethodBeat.o(130100);
    }

    public static List<b> aAG() {
        AppMethodBeat.i(130101);
        if (f.avb() == null) {
            AppMethodBeat.o(130101);
            return null;
        }
        LinkedList<AppBrandRecentTaskInfo> linkedList = new LinkedList();
        if (f.auT() != null) {
            ArrayList axJ = f.auT().axJ();
            if (!bo.ek(axJ)) {
                linkedList.addAll(axJ);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (!((AppBrandRecentTaskInfo) it.next()).xy()) {
                it.remove();
            }
        }
        if (!bo.ek(linkedList)) {
            ArrayList arrayList = new ArrayList();
            for (AppBrandRecentTaskInfo a : linkedList) {
                arrayList.add(a(a));
            }
            f.avb().b(arrayList, false);
            ab.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandRecentTaskInfo convert to MiniGameStorage, size:%d", Integer.valueOf(arrayList.size()));
        }
        ab.i("MicroMsg.SearchMiniGameQueryLogic", "updateMiniGameList");
        List<b> aAH = f.avb().aAH();
        AppMethodBeat.o(130101);
        return aAH;
    }

    public static b As(String str) {
        AppMethodBeat.i(130102);
        if (f.avb() != null) {
            b As = f.avb().As(str);
            AppMethodBeat.o(130102);
            return As;
        }
        AppMethodBeat.o(130102);
        return null;
    }

    public static AppBrandRecentTaskInfo At(String str) {
        AppMethodBeat.i(130103);
        if (f.auT() == null) {
            AppMethodBeat.o(130103);
            return null;
        }
        AppBrandRecentTaskInfo yw = f.auT().yw(str);
        AppMethodBeat.o(130103);
        return yw;
    }

    private static com.tencent.mm.plugin.appbrand.game.b.a.a a(AppBrandRecentTaskInfo appBrandRecentTaskInfo) {
        AppMethodBeat.i(130104);
        if (appBrandRecentTaskInfo == null) {
            AppMethodBeat.o(130104);
            return null;
        }
        com.tencent.mm.plugin.appbrand.game.b.a.a aVar = new com.tencent.mm.plugin.appbrand.game.b.a.a();
        aVar.euD = appBrandRecentTaskInfo.euD;
        aVar.fKh = appBrandRecentTaskInfo.appId;
        aVar.ncH = appBrandRecentTaskInfo.appName;
        aVar.IconUrl = appBrandRecentTaskInfo.hac;
        aVar.jBB = appBrandRecentTaskInfo.csl;
        aVar.gVs = appBrandRecentTaskInfo.gVs;
        AppMethodBeat.o(130104);
        return aVar;
    }
}
