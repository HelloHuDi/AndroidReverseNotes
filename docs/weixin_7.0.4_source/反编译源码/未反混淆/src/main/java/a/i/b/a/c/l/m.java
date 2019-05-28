package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.h.c;
import a.i.b.a.c.h.i;
import a.i.b.a.c.l.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m extends q {
    private final g Bfn;

    private m(a.i.b.a.c.a.g gVar, g gVar2) {
        j.p(gVar, "builtIns");
        j.p(gVar2, "annotations");
        ad dXL = gVar.dXL();
        j.o(dXL, "builtIns.nothingType");
        ad dXN = gVar.dXN();
        j.o(dXN, "builtIns.nullableAnyType");
        super(dXL, dXN);
        AppMethodBeat.i(122528);
        this.Bfn = gVar2;
        AppMethodBeat.o(122528);
    }

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122526);
        j.p(gVar, "newAnnotations");
        az mVar = new m(a.aL(this.BJy), gVar);
        AppMethodBeat.o(122526);
        return mVar;
    }

    public final g dYn() {
        return this.Bfn;
    }

    public final /* bridge */ /* synthetic */ az rK(boolean z) {
        return this;
    }

    public final boolean eci() {
        return false;
    }

    public final String a(c cVar, i iVar) {
        AppMethodBeat.i(122527);
        j.p(cVar, "renderer");
        j.p(iVar, "options");
        String str = "dynamic";
        AppMethodBeat.o(122527);
        return str;
    }

    public final ad eby() {
        return this.BJy;
    }
}
