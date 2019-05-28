package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af extends i implements aw {
    private final w BJD;
    private final ad BpK;

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122624);
        az d = d(gVar);
        AppMethodBeat.o(122624);
        return d;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122626);
        az rL = rL(z);
        AppMethodBeat.o(122626);
        return rL;
    }

    /* Access modifiers changed, original: protected|final */
    public final ad eby() {
        return this.BpK;
    }

    public final w ekl() {
        return this.BJD;
    }

    public af(ad adVar, w wVar) {
        j.p(adVar, "delegate");
        j.p(wVar, "enhancement");
        AppMethodBeat.i(122627);
        this.BpK = adVar;
        this.BJD = wVar;
        AppMethodBeat.o(122627);
    }

    public final az ekk() {
        return this.BpK;
    }

    public final ad d(g gVar) {
        AppMethodBeat.i(122623);
        j.p(gVar, "newAnnotations");
        az b = ax.b(this.BpK.b(gVar), this.BJD);
        if (b == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(122623);
            throw vVar;
        }
        ad adVar = (ad) b;
        AppMethodBeat.o(122623);
        return adVar;
    }

    public final ad rL(boolean z) {
        AppMethodBeat.i(122625);
        az b = ax.b(this.BpK.rK(z), this.BJD.ekn().rK(z));
        if (b == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(122625);
            throw vVar;
        }
        ad adVar = (ad) b;
        AppMethodBeat.o(122625);
        return adVar;
    }
}
