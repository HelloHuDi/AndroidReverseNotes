package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import java.util.HashMap;

public class a implements at {
    private c pgK = null;
    private d pgL = null;
    private com.tencent.mm.plugin.product.b.a pgM = new com.tencent.mm.plugin.product.b.a();

    public a() {
        AppMethodBeat.i(43940);
        AppMethodBeat.o(43940);
    }

    public static a bZC() {
        AppMethodBeat.i(43941);
        a aVar = (a) q.Y(a.class);
        AppMethodBeat.o(43941);
        return aVar;
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(43942);
        this.pgK = null;
        com.tencent.mm.sdk.b.a.xxA.c(this.pgM);
        AppMethodBeat.o(43942);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(43943);
        com.tencent.mm.sdk.b.a.xxA.d(this.pgM);
        AppMethodBeat.o(43943);
    }

    public static c bZD() {
        AppMethodBeat.i(43944);
        g.RN().QU();
        if (bZC().pgK == null) {
            bZC().pgK = new c();
        }
        c cVar = bZC().pgK;
        AppMethodBeat.o(43944);
        return cVar;
    }

    public final d bZE() {
        AppMethodBeat.i(43945);
        g.RN().QU();
        if (this.pgL == null) {
            this.pgL = new d();
        }
        d dVar = this.pgL;
        AppMethodBeat.o(43945);
        return dVar;
    }
}
