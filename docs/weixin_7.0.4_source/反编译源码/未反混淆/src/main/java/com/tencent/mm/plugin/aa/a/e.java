package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.f;

public final class e implements b<d> {
    protected d glE;
    public final a glF;

    public class a implements com.tencent.mm.vending.h.e<Void, Void> {
        public final String HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40602);
            d dVar = e.this.glE;
            m hVar = new h();
            g.RQ();
            g.RO().eJo.a(hVar, 0);
            dVar.glt = f.dMo();
            Void voidR = zXH;
            AppMethodBeat.o(40602);
            return voidR;
        }
    }

    public e() {
        this(new d());
        AppMethodBeat.i(40603);
        AppMethodBeat.o(40603);
    }

    private e(d dVar) {
        AppMethodBeat.i(40604);
        this.glF = new a();
        this.glE = dVar;
        AppMethodBeat.o(40604);
    }

    public final d aok() {
        return this.glE;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glE;
    }
}
