package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.o;
import a.i.b.a.c.b.t;
import a.i.b.a.c.b.w;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ab extends y implements aj {
    static final /* synthetic */ boolean $assertionsDisabled = (!ab.class.desiredAssertionStatus());
    private au Bjk;
    private final aj Bjl;

    static {
        AppMethodBeat.i(119572);
        AppMethodBeat.o(119572);
    }

    public ab(ah ahVar, g gVar, w wVar, az azVar, boolean z, boolean z2, boolean z3, a aVar, aj ajVar, am amVar) {
        f avZ = f.avZ("<set-" + ahVar.dZg() + ">");
        super(wVar, azVar, ahVar, gVar, avZ, z, z2, z3, aVar, amVar);
        AppMethodBeat.i(119565);
        if (ajVar == null) {
            Object ajVar2 = this;
        }
        this.Bjl = ajVar2;
        AppMethodBeat.o(119565);
    }

    public final void a(au auVar) {
        AppMethodBeat.i(119566);
        if ($assertionsDisabled || this.Bjk == null) {
            this.Bjk = auVar;
            AppMethodBeat.o(119566);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(119566);
        throw assertionError;
    }

    public static ai a(aj ajVar, a.i.b.a.c.l.w wVar, g gVar) {
        AppMethodBeat.i(119567);
        ai aiVar = new ai(ajVar, null, 0, gVar, f.avZ("<set-?>"), wVar, false, false, false, null, am.BeR);
        AppMethodBeat.o(119567);
        return aiVar;
    }

    public final Collection<? extends aj> dYX() {
        AppMethodBeat.i(119568);
        Collection rJ = super.rJ(false);
        AppMethodBeat.o(119568);
        return rJ;
    }

    public final List<au> dYV() {
        AppMethodBeat.i(119569);
        if (this.Bjk == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(119569);
            throw illegalStateException;
        }
        List singletonList = Collections.singletonList(this.Bjk);
        AppMethodBeat.o(119569);
        return singletonList;
    }

    public final a.i.b.a.c.l.w dYT() {
        AppMethodBeat.i(119570);
        ad dXO = a.i.b.a.c.i.c.a.G(this).dXO();
        AppMethodBeat.o(119570);
        return dXO;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119571);
        Object a = nVar.a((aj) this, (Object) d);
        AppMethodBeat.o(119571);
        return a;
    }

    public final /* bridge */ /* synthetic */ ag eaG() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ t dZp() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ b dYY() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.b.a dYU() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ l dZd() {
        return this.Bjl;
    }

    public final /* bridge */ /* synthetic */ o ean() {
        return this.Bjl;
    }
}
