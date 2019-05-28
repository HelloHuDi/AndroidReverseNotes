package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.impl.C31255a;
import com.tencent.luggage.bridge.p814a.C8852a.C8851a;
import com.tencent.luggage.bridge.p814a.C8852a.C8855c;
import com.tencent.luggage.p1433c.p1434a.C31256a;
import com.tencent.luggage.p1433c.p1434a.p1455a.C32182a;
import com.tencent.luggage.sdk.customize.impl.C17827a;
import com.tencent.luggage.sdk.customize.impl.C25698b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C33093c;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.plugin.appbrand.p336ui.C38565u;
import com.tencent.p177mm.plugin.appbrand.page.C33467al.C31329a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C36739al.C31565a;

/* renamed from: com.tencent.luggage.sdk.a */
public class C17825a extends C31255a {
    /* renamed from: a */
    public void mo20026a(C8855c c8855c) {
        AppMethodBeat.m2504i(114299);
        super.mo20026a(c8855c);
        c8855c.mo20023a(C38565u.class, new C17827a());
        c8855c.mo20023a(C31329a.class, new C31565a());
        c8855c.mo20023a(C10708a.class, new C25698b());
        c8855c.mo20023a(C31256a.class, new C32182a());
        c8855c.mo20023a(C31282o.class, C33093c.gSg);
        AppMethodBeat.m2505o(114299);
    }

    /* renamed from: a */
    public void mo20025a(C8851a c8851a) {
        AppMethodBeat.m2504i(114300);
        super.mo20025a(c8851a);
        AppMethodBeat.m2505o(114300);
    }
}
