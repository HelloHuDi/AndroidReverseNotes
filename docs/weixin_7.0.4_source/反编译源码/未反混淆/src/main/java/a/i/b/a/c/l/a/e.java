package a.i.b.a.c.l.a;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class e extends ad {
    private final boolean BEI;
    private final a BKv;
    final f BKw;
    final az BKx;
    private final g Bfn;

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122721);
        az k = k(gVar);
        AppMethodBeat.o(122721);
        return k;
    }

    public final /* synthetic */ ad d(g gVar) {
        AppMethodBeat.i(122722);
        ad k = k(gVar);
        AppMethodBeat.o(122722);
        return k;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122724);
        az sc = sc(z);
        AppMethodBeat.o(122724);
        return sc;
    }

    public final /* synthetic */ ad rL(boolean z) {
        AppMethodBeat.i(122725);
        ad sc = sc(z);
        AppMethodBeat.o(122725);
        return sc;
    }

    public final g dYn() {
        return this.Bfn;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public e(a aVar, f fVar, az azVar, g gVar, boolean z) {
        j.p(aVar, "captureStatus");
        j.p(fVar, "constructor");
        j.p(gVar, "annotations");
        AppMethodBeat.i(122726);
        this.BKv = aVar;
        this.BKw = fVar;
        this.BKx = azVar;
        this.Bfn = gVar;
        this.BEI = z;
        AppMethodBeat.o(122726);
    }

    public e(a aVar, az azVar, ap apVar) {
        j.p(aVar, "captureStatus");
        j.p(apVar, "projection");
        this(aVar, new f(apVar), azVar);
        AppMethodBeat.i(122728);
        AppMethodBeat.o(122728);
    }

    public final h dXR() {
        AppMethodBeat.i(122719);
        h cw = p.cw("No member resolution should be done on captured type!", true);
        j.o(cw, "ErrorUtils.createErrorSc…on captured type!\", true)");
        AppMethodBeat.o(122719);
        return cw;
    }

    private e k(g gVar) {
        AppMethodBeat.i(122720);
        j.p(gVar, "newAnnotations");
        e eVar = new e(this.BKv, this.BKw, this.BKx, gVar, this.BEI);
        AppMethodBeat.o(122720);
        return eVar;
    }

    private e sc(boolean z) {
        AppMethodBeat.i(122723);
        e eVar = new e(this.BKv, this.BKw, this.BKx, this.Bfn, z);
        AppMethodBeat.o(122723);
        return eVar;
    }

    public final List<ap> ejt() {
        return v.AUP;
    }

    public final /* bridge */ /* synthetic */ an ejw() {
        return this.BKw;
    }
}
