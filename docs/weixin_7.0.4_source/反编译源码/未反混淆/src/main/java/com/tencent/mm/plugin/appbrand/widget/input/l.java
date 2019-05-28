package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

public final class l implements b, c {
    final WeakReference<u> jdm;

    public l(u uVar) {
        AppMethodBeat.i(123674);
        this.jdm = new WeakReference(uVar);
        uVar.a((b) this);
        uVar.a((c) this);
        AppMethodBeat.o(123674);
    }

    public final void wW() {
        AppMethodBeat.i(123675);
        u uVar = (u) this.jdm.get();
        if (uVar != null) {
            o.v(uVar);
        }
        AppMethodBeat.o(123675);
    }

    public final void onDestroy() {
        AppMethodBeat.i(123676);
        u uVar = (u) this.jdm.get();
        if (uVar != null) {
            if (uVar.mContext instanceof ad) {
                ((ad) uVar.mContext).aqX();
            }
            o.v(uVar);
            o.w(uVar);
            e.t(uVar);
            uVar.b((b) this);
            uVar.b((c) this);
            if (uVar.aJz() != null) {
                h.aQx().b(uVar.aJz());
            }
        }
        AppMethodBeat.o(123676);
    }
}
