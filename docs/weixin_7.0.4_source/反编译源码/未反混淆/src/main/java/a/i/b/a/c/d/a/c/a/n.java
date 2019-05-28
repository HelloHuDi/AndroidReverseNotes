package a.i.b.a.c.d.a.c.a;

import a.a.k;
import a.a.m;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.c.b;
import a.i.b.a.c.d.a.a.l;
import a.i.b.a.c.d.a.c.b.d;
import a.i.b.a.c.d.a.c.e;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.c.d.a.e.w;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class n extends b {
    private final h Bnn;
    private final e BoU = new e(this.Bnn, this.BoV);
    private final w BoV;

    public final List<a.i.b.a.c.l.w> eaq() {
        AppMethodBeat.i(120019);
        Collection ecb = this.BoV.ecb();
        if (ecb.isEmpty()) {
            ad dXM = this.Bnn.Bnv.BcH.dZD().dXM();
            j.o(dXM, "c.module.builtIns.anyType");
            ad dXN = this.Bnn.Bnv.BcH.dZD().dXN();
            j.o(dXN, "c.module.builtIns.nullableAnyType");
            List listOf = k.listOf(x.a(dXM, dXN));
            AppMethodBeat.o(120019);
            return listOf;
        }
        Iterable<a.i.b.a.c.d.a.e.j> iterable = ecb;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (a.i.b.a.c.d.a.e.j a : iterable) {
            arrayList.add(this.Bnn.Bnu.a((v) a, d.a(l.COMMON, false, this, 1)));
        }
        List<a.i.b.a.c.l.w> list = (List) arrayList;
        AppMethodBeat.o(120019);
        return list;
    }

    public final void J(a.i.b.a.c.l.w wVar) {
        AppMethodBeat.i(120020);
        j.p(wVar, "type");
        AppMethodBeat.o(120020);
    }

    public final /* bridge */ /* synthetic */ g dYn() {
        return this.BoU;
    }

    public n(h hVar, w wVar, int i, a.i.b.a.c.b.l lVar) {
        j.p(hVar, "c");
        j.p(wVar, "javaTypeParameter");
        j.p(lVar, "containingDeclaration");
        super(hVar.Bnv.Baf, lVar, wVar.dZg(), ba.INVARIANT, false, i, am.BeR, hVar.Bnv.Bhr);
        AppMethodBeat.i(120021);
        this.Bnn = hVar;
        this.BoV = wVar;
        AppMethodBeat.o(120021);
    }
}
