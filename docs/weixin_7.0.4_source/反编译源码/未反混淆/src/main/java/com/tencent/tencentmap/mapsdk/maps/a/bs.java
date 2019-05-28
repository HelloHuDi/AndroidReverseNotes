package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bs extends br {
    public bs(bp bpVar) {
        super(bpVar);
    }

    public final cv a() {
        AppMethodBeat.i(98577);
        en.d().a(1);
        cv a = super.a();
        AppMethodBeat.o(98577);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final cv a(int i) {
        AppMethodBeat.i(98576);
        cs csVar = new cs(this.c, this.a.d, this.a.c, this.a.b, i, this.a.g, false, 0, this.a.l, en.d().f(), this.a.o);
        csVar.a = this.b;
        csVar.o = this.d;
        csVar.a("app");
        this.e = csVar;
        this.e.l = this.a.n;
        cv a = this.e.a();
        AppMethodBeat.o(98576);
        return a;
    }
}
