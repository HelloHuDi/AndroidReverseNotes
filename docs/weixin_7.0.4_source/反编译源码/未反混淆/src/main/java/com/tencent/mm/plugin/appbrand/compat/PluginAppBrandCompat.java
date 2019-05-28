package com.tencent.mm.plugin.appbrand.compat;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.t.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.d;

@Keep
@Deprecated
public final class PluginAppBrandCompat extends f implements c, com.tencent.mm.plugin.appbrand.compat.a.c {
    public final void installed() {
        AppMethodBeat.i(17021);
        super.installed();
        alias(com.tencent.mm.plugin.appbrand.compat.a.c.class);
        AppMethodBeat.o(17021);
    }

    public final void configure(g gVar) {
    }

    public final void execute(g gVar) {
        AppMethodBeat.i(17022);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(b.class, new e(new b()));
        } else {
            com.tencent.luggage.a.e.a(a.class, new d());
        }
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.a.class, new e(new a()));
        AppMethodBeat.o(17022);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
    }

    public final void onAccountRelease() {
    }
}
