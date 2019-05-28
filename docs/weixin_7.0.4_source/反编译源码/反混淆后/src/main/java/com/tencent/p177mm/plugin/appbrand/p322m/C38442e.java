package com.tencent.p177mm.plugin.appbrand.p322m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e.C38438a;
import com.tencent.p177mm.plugin.appbrand.p322m.p324d.C2387c;
import com.tencent.p177mm.plugin.appbrand.p322m.p324d.C38441a;
import com.tencent.p177mm.plugin.appbrand.p322m.p324d.C45650b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.m.e */
public final class C38442e {
    private static final Map<Integer, C42627e> ipX = new HashMap();

    static {
        AppMethodBeat.m2504i(102184);
        AppMethodBeat.m2505o(102184);
    }

    /* renamed from: a */
    protected static void m65037a(C38438a c38438a, C38492q c38492q) {
        AppMethodBeat.m2504i(102181);
        C38442e.m65038a(new C38441a(c38438a, c38492q));
        C38442e.m65038a(new C2387c(c38438a, c38492q));
        C38442e.m65038a(new C45650b(c38438a, c38492q));
        AppMethodBeat.m2505o(102181);
    }

    /* renamed from: pq */
    public static C42627e m65039pq(int i) {
        AppMethodBeat.m2504i(102182);
        C42627e c42627e = (C42627e) ipX.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(102182);
        return c42627e;
    }

    /* renamed from: a */
    private static final void m65038a(C42627e c42627e) {
        AppMethodBeat.m2504i(102183);
        ipX.put(Integer.valueOf(c42627e.getType()), c42627e);
        AppMethodBeat.m2505o(102183);
    }
}
