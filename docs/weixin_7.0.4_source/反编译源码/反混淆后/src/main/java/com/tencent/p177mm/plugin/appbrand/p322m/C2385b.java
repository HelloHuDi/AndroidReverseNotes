package com.tencent.p177mm.plugin.appbrand.p322m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19596a;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C10616e;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C10617f;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C10618h;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C31323g;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C33444d;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C38439a;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C38440c;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C45648b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.m.b */
public final class C2385b {
    private static final Map<Integer, C19596a> ipQ = new HashMap();

    static {
        AppMethodBeat.m2504i(102170);
        C2385b.m4645a(new C38439a());
        C2385b.m4645a(new C33444d());
        C2385b.m4645a(new C10617f());
        C2385b.m4645a(new C10618h());
        C2385b.m4645a(new C31323g());
        C2385b.m4645a(new C38440c());
        C2385b.m4645a(new C45648b());
        C2385b.m4645a(new C10616e());
        AppMethodBeat.m2505o(102170);
    }

    /* renamed from: pp */
    public static C19596a m4646pp(int i) {
        AppMethodBeat.m2504i(102168);
        C19596a c19596a = (C19596a) ipQ.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(102168);
        return c19596a;
    }

    /* renamed from: a */
    private static void m4645a(C19596a c19596a) {
        AppMethodBeat.m2504i(102169);
        ipQ.put(Integer.valueOf(c19596a.aIT()), c19596a);
        AppMethodBeat.m2505o(102169);
    }
}
