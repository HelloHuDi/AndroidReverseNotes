package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.h.c;
import a.i.b.a.c.h.i;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s extends q implements aw {
    private final q BJC;
    private final w BJD;

    public final w ekl() {
        return this.BJD;
    }

    public final String a(c cVar, i iVar) {
        AppMethodBeat.i(122588);
        j.p(cVar, "renderer");
        j.p(iVar, "options");
        String b;
        if (iVar.eiT()) {
            b = cVar.b(this.BJD);
            AppMethodBeat.o(122588);
            return b;
        }
        b = this.BJC.a(cVar, iVar);
        AppMethodBeat.o(122588);
        return b;
    }

    public final az b(g gVar) {
        AppMethodBeat.i(122586);
        j.p(gVar, "newAnnotations");
        az b = ax.b(this.BJC.b(gVar), this.BJD);
        AppMethodBeat.o(122586);
        return b;
    }

    public final az rK(boolean z) {
        AppMethodBeat.i(122587);
        az b = ax.b(this.BJC.rK(z), this.BJD.ekn().rK(z));
        AppMethodBeat.o(122587);
        return b;
    }

    public final ad eby() {
        AppMethodBeat.i(122589);
        ad eby = this.BJC.eby();
        AppMethodBeat.o(122589);
        return eby;
    }

    public final /* bridge */ /* synthetic */ az ekk() {
        return this.BJC;
    }

    public s(q qVar, w wVar) {
        j.p(qVar, b.ORIGIN);
        j.p(wVar, "enhancement");
        super(qVar.BJx, qVar.BJy);
        AppMethodBeat.i(122590);
        this.BJC = qVar;
        this.BJD = wVar;
        AppMethodBeat.o(122590);
    }
}
