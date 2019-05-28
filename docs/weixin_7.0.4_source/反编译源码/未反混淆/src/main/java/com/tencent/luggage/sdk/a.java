package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.customize.impl.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.ui.u;

public class a extends com.tencent.luggage.bridge.impl.a {
    public void a(c cVar) {
        AppMethodBeat.i(114299);
        super.a(cVar);
        cVar.a(u.class, new com.tencent.luggage.sdk.customize.impl.a());
        cVar.a(com.tencent.mm.plugin.appbrand.page.al.a.class, new com.tencent.mm.plugin.appbrand.widget.input.al.a());
        cVar.a(com.tencent.mm.plugin.appbrand.r.q.a.class, new b());
        cVar.a(com.tencent.luggage.c.a.a.class, new com.tencent.luggage.c.a.a.a());
        cVar.a(o.class, com.tencent.mm.plugin.appbrand.appcache.c.gSg);
        AppMethodBeat.o(114299);
    }

    public void a(com.tencent.luggage.bridge.a.a.a aVar) {
        AppMethodBeat.i(114300);
        super.a(aVar);
        AppMethodBeat.o(114300);
    }
}
