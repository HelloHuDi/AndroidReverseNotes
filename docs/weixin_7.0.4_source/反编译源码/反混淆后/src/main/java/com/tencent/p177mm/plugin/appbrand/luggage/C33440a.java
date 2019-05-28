package com.tencent.p177mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.impl.C31255a;
import com.tencent.luggage.bridge.p814a.C8852a.C8851a;
import com.tencent.luggage.bridge.p814a.C8852a.C8855c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C45594m;
import com.tencent.p177mm.plugin.appbrand.luggage.p1227a.C19585c;
import com.tencent.p177mm.plugin.appbrand.luggage.p1538c.C45645c;
import com.tencent.p177mm.plugin.appbrand.p321l.C42602o;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.a */
public final class C33440a extends C31255a {
    private static C2103e hmp = new C19585c();

    static {
        AppMethodBeat.m2504i(132090);
        AppMethodBeat.m2505o(132090);
    }

    /* renamed from: a */
    public final void mo20026a(C8855c c8855c) {
        AppMethodBeat.m2504i(132088);
        super.mo20026a(c8855c);
        c8855c.mo20023a(C2103e.class, hmp);
        c8855c.mo20024a(C42602o.class, new C45645c());
        c8855c.mo20023a(C33523a.class, new C45594m());
        AppMethodBeat.m2505o(132088);
    }

    /* renamed from: a */
    public final void mo20025a(C8851a c8851a) {
        AppMethodBeat.m2504i(132089);
        super.mo20025a(c8851a);
        AppMethodBeat.m2505o(132089);
    }
}
