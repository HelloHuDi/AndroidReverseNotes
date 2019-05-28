package a.i.b.a.c.i.a.a;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ak;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a extends ad implements ak {
    private final ap BEG;
    private final b BEH;
    private final boolean BEI;
    private final g Bfn;

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122052);
        az e = e(gVar);
        AppMethodBeat.o(122052);
        return e;
    }

    public final /* synthetic */ ad d(g gVar) {
        AppMethodBeat.i(122053);
        ad e = e(gVar);
        AppMethodBeat.o(122053);
        return e;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122049);
        az rY = rY(z);
        AppMethodBeat.o(122049);
        return rY;
    }

    public final /* synthetic */ ad rL(boolean z) {
        AppMethodBeat.i(122050);
        ad rY = rY(z);
        AppMethodBeat.o(122050);
        return rY;
    }

    public /* synthetic */ a(ap apVar) {
        b bVar = new b(apVar);
        a.i.b.a.c.b.a.g.a aVar = g.BfJ;
        this(apVar, bVar, false, a.i.b.a.c.b.a.g.a.eai());
        AppMethodBeat.i(122055);
        AppMethodBeat.o(122055);
    }

    public final boolean eci() {
        return this.BEI;
    }

    public final g dYn() {
        return this.Bfn;
    }

    private a(ap apVar, b bVar, boolean z, g gVar) {
        j.p(apVar, "typeProjection");
        j.p(bVar, "constructor");
        j.p(gVar, "annotations");
        AppMethodBeat.i(122054);
        this.BEG = apVar;
        this.BEH = bVar;
        this.BEI = z;
        this.Bfn = gVar;
        AppMethodBeat.o(122054);
    }

    public final h dXR() {
        AppMethodBeat.i(122042);
        h cw = p.cw("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        j.o(cw, "ErrorUtils.createErrorSc…system resolution\", true)");
        AppMethodBeat.o(122042);
        return cw;
    }

    public final w eju() {
        AppMethodBeat.i(122043);
        ba baVar = ba.OUT_VARIANCE;
        ad dXN = a.i.b.a.c.l.c.a.aL(this).dXN();
        j.o(dXN, "builtIns.nullableAnyType");
        w b = b(baVar, dXN);
        AppMethodBeat.o(122043);
        return b;
    }

    public final w ejv() {
        AppMethodBeat.i(122044);
        ba baVar = ba.IN_VARIANCE;
        ad dXL = a.i.b.a.c.l.c.a.aL(this).dXL();
        j.o(dXL, "builtIns.nothingType");
        w b = b(baVar, dXL);
        AppMethodBeat.o(122044);
        return b;
    }

    private final w b(ba baVar, w wVar) {
        Object wVar2;
        AppMethodBeat.i(122045);
        if (this.BEG.ekq() == baVar) {
            wVar2 = this.BEG.dZS();
        }
        j.o(wVar2, "if (typeProjection.proje…jection.type else default");
        AppMethodBeat.o(122045);
        return wVar2;
    }

    public final String toString() {
        AppMethodBeat.i(122047);
        String str = "Captured(" + this.BEG + ')' + (this.BEI ? "?" : "");
        AppMethodBeat.o(122047);
        return str;
    }

    private a e(g gVar) {
        AppMethodBeat.i(122051);
        j.p(gVar, "newAnnotations");
        a aVar = new a(this.BEG, this.BEH, this.BEI, gVar);
        AppMethodBeat.o(122051);
        return aVar;
    }

    public final List<ap> ejt() {
        return v.AUP;
    }

    public final boolean ad(w wVar) {
        AppMethodBeat.i(122046);
        j.p(wVar, "type");
        if (this.BEH == wVar.ejw()) {
            AppMethodBeat.o(122046);
            return true;
        }
        AppMethodBeat.o(122046);
        return false;
    }

    private a rY(boolean z) {
        AppMethodBeat.i(122048);
        if (z == this.BEI) {
            AppMethodBeat.o(122048);
            return this;
        }
        a aVar = new a(this.BEG, this.BEH, z, this.Bfn);
        AppMethodBeat.o(122048);
        return aVar;
    }

    public final /* bridge */ /* synthetic */ an ejw() {
        return this.BEH;
    }
}
