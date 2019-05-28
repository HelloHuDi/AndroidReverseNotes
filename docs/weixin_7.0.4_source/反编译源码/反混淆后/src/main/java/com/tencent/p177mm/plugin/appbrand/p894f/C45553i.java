package com.tencent.p177mm.plugin.appbrand.p894f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C42202a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.f.i */
enum C45553i {
    ;
    
    private static final C38210a hpZ = null;

    static {
        hpZ = new C38210a();
        AppMethodBeat.m2505o(129991);
    }

    static void onCreate() {
        AppMethodBeat.m2504i(129985);
        C26842p.ayH().mo10114a(hpZ, C42677e.aNS().oAl.getLooper());
        AppMethodBeat.m2505o(129985);
    }

    static void onDestroy() {
        AppMethodBeat.m2504i(129986);
        C26842p.ayH().mo10117d(hpZ);
        AppMethodBeat.m2505o(129986);
    }

    static List<AppBrandRecentTaskInfo> aAr() {
        AppMethodBeat.m2504i(129987);
        LinkedList linkedList = new LinkedList();
        if (C42340f.auT() != null) {
            ArrayList axJ = C42340f.auT().axJ();
            if (!C5046bo.m7548ek(axJ)) {
                linkedList.addAll(axJ);
            }
        }
        if (C42202a.abu()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((AppBrandRecentTaskInfo) it.next()).mo5856xy()) {
                    it.remove();
                }
            }
        }
        AppMethodBeat.m2505o(129987);
        return linkedList;
    }

    /* renamed from: An */
    static AppBrandRecentTaskInfo m84010An(String str) {
        AppMethodBeat.m2504i(129988);
        if (C42340f.auT() == null) {
            AppMethodBeat.m2505o(129988);
            return null;
        }
        AppBrandRecentTaskInfo yw = C42340f.auT().mo73337yw(str);
        if (yw == null) {
            AppMethodBeat.m2505o(129988);
            return null;
        } else if (yw.mo5856xy() && C42202a.abu()) {
            AppMethodBeat.m2505o(129988);
            return null;
        } else {
            AppMethodBeat.m2505o(129988);
            return yw;
        }
    }

    /* renamed from: e */
    static void m84011e(C4931a c4931a) {
        AppMethodBeat.m2504i(129989);
        if (C42340f.auT() != null) {
            C42340f.auT().mo10116c(c4931a);
        }
        AppMethodBeat.m2505o(129989);
    }

    /* renamed from: f */
    static void m84012f(C4931a c4931a) {
        AppMethodBeat.m2504i(129990);
        if (C42340f.auT() != null) {
            C42340f.auT().mo10117d(c4931a);
        }
        AppMethodBeat.m2505o(129990);
    }
}
