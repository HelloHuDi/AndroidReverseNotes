package com.tencent.mm.plugin.appbrand.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static final a hpZ = null;

    static {
        hpZ = new a();
        AppMethodBeat.o(129991);
    }

    static void onCreate() {
        AppMethodBeat.i(129985);
        p.ayH().a(hpZ, e.aNS().oAl.getLooper());
        AppMethodBeat.o(129985);
    }

    static void onDestroy() {
        AppMethodBeat.i(129986);
        p.ayH().d(hpZ);
        AppMethodBeat.o(129986);
    }

    static List<AppBrandRecentTaskInfo> aAr() {
        AppMethodBeat.i(129987);
        LinkedList linkedList = new LinkedList();
        if (f.auT() != null) {
            ArrayList axJ = f.auT().axJ();
            if (!bo.ek(axJ)) {
                linkedList.addAll(axJ);
            }
        }
        if (a.abu()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((AppBrandRecentTaskInfo) it.next()).xy()) {
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(129987);
        return linkedList;
    }

    static AppBrandRecentTaskInfo An(String str) {
        AppMethodBeat.i(129988);
        if (f.auT() == null) {
            AppMethodBeat.o(129988);
            return null;
        }
        AppBrandRecentTaskInfo yw = f.auT().yw(str);
        if (yw == null) {
            AppMethodBeat.o(129988);
            return null;
        } else if (yw.xy() && a.abu()) {
            AppMethodBeat.o(129988);
            return null;
        } else {
            AppMethodBeat.o(129988);
            return yw;
        }
    }

    static void e(k.a aVar) {
        AppMethodBeat.i(129989);
        if (f.auT() != null) {
            f.auT().c(aVar);
        }
        AppMethodBeat.o(129989);
    }

    static void f(k.a aVar) {
        AppMethodBeat.i(129990);
        if (f.auT() != null) {
            f.auT().d(aVar);
        }
        AppMethodBeat.o(129990);
    }
}
