package com.tencent.p177mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.impl.C31255a;
import com.tencent.luggage.bridge.p814a.C8852a.C8851a;
import com.tencent.luggage.bridge.p814a.C8852a.C8855c;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e;
import com.tencent.p177mm.plugin.appbrand.dynamic.p284b.C2126b;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C27186p;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b */
public final class C33441b extends C31255a {
    private final C10333f ikb = new C27186p();

    public C33441b() {
        AppMethodBeat.m2504i(11122);
        AppMethodBeat.m2505o(11122);
    }

    /* renamed from: a */
    public final void mo20026a(C8855c c8855c) {
        AppMethodBeat.m2504i(11123);
        super.mo20026a(c8855c);
        c8855c.mo20023a(C10333f.class, this.ikb);
        c8855c.mo20023a(C2103e.class, C2126b.azO());
        AppMethodBeat.m2505o(11123);
    }

    /* renamed from: a */
    public final void mo20025a(C8851a c8851a) {
        AppMethodBeat.m2504i(11124);
        super.mo20025a(c8851a);
        c8851a.mo20023a(C10333f.class, (C25681b) this.ikb);
        AppMethodBeat.m2505o(11124);
    }
}
