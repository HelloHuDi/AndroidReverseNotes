package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends i {
    public final ad BJa;
    public final ad BpK;

    public a(ad adVar, ad adVar2) {
        j.p(adVar, "delegate");
        j.p(adVar2, "abbreviation");
        AppMethodBeat.i(122486);
        this.BpK = adVar;
        this.BJa = adVar2;
        AppMethodBeat.o(122486);
    }

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122481);
        az f = f(gVar);
        AppMethodBeat.o(122481);
        return f;
    }

    public final /* synthetic */ ad d(g gVar) {
        AppMethodBeat.i(122482);
        ad f = f(gVar);
        AppMethodBeat.o(122482);
        return f;
    }

    /* Access modifiers changed, original: protected|final */
    public final ad eby() {
        return this.BpK;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122484);
        az sa = sa(z);
        AppMethodBeat.o(122484);
        return sa;
    }

    public final /* synthetic */ ad rL(boolean z) {
        AppMethodBeat.i(122485);
        ad sa = sa(z);
        AppMethodBeat.o(122485);
        return sa;
    }

    private a f(g gVar) {
        AppMethodBeat.i(122480);
        j.p(gVar, "newAnnotations");
        a aVar = new a(this.BpK.d(gVar), this.BJa);
        AppMethodBeat.o(122480);
        return aVar;
    }

    private a sa(boolean z) {
        AppMethodBeat.i(122483);
        a aVar = new a(this.BpK.rL(z), this.BJa.rL(z));
        AppMethodBeat.o(122483);
        return aVar;
    }
}
