package a.i.b.a.c.b.c;

import a.a.m;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ad;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.y;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class r extends j implements ad {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(r.class), "fragments", "getFragments()Ljava/util/List;"))};
    final a.i.b.a.c.f.b BfP;
    private final f BiB;
    private final h BiC;
    final v BiD;

    static final class b extends a.f.b.k implements a.f.a.a<h> {
        final /* synthetic */ r BiE;

        b(r rVar) {
            this.BiE = rVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119465);
            h hVar;
            if (this.BiE.getFragments().isEmpty()) {
                hVar = a.i.b.a.c.i.e.h.b.BGh;
                AppMethodBeat.o(119465);
                return hVar;
            }
            Iterable<ab> fragments = this.BiE.getFragments();
            Collection arrayList = new ArrayList(m.d(fragments));
            for (ab dXR : fragments) {
                arrayList.add(dXR.dXR());
            }
            hVar = new a.i.b.a.c.i.e.b("package view scope for " + this.BiE.BfP + " in " + this.BiE.BiD.BgZ, a.a.t.a((Collection) (List) arrayList, (Object) new ae(this.BiE.BiD, this.BiE.BfP)));
            AppMethodBeat.o(119465);
            return hVar;
        }
    }

    static final class a extends a.f.b.k implements a.f.a.a<List<? extends ab>> {
        final /* synthetic */ r BiE;

        a(r rVar) {
            this.BiE = rVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119464);
            List h = this.BiE.BiD.eaE().h(this.BiE.BfP);
            AppMethodBeat.o(119464);
            return h;
        }
    }

    static {
        AppMethodBeat.i(119466);
        AppMethodBeat.o(119466);
    }

    public final List<ab> getFragments() {
        AppMethodBeat.i(119467);
        List list = (List) a.i.b.a.c.k.h.a(this.BiB, eQB[0]);
        AppMethodBeat.o(119467);
        return list;
    }

    public final a.i.b.a.c.f.b dZF() {
        return this.BfP;
    }

    public r(v vVar, a.i.b.a.c.f.b bVar, i iVar) {
        j.p(vVar, "module");
        j.p(bVar, "fqName");
        j.p(iVar, "storageManager");
        a.i.b.a.c.b.a.g.a aVar = g.BfJ;
        super(a.i.b.a.c.b.a.g.a.eai(), bVar.ByQ.ehL());
        AppMethodBeat.i(119472);
        this.BiD = vVar;
        this.BfP = bVar;
        this.BiB = iVar.i(new a(this));
        this.BiC = new a.i.b.a.c.i.e.g(iVar.i(new b(this)));
        AppMethodBeat.o(119472);
    }

    public final h dXR() {
        return this.BiC;
    }

    public final boolean equals(Object obj) {
        Object obj2;
        AppMethodBeat.i(119469);
        if (obj instanceof ad) {
            obj2 = obj;
        } else {
            obj2 = null;
        }
        ad adVar = (ad) obj2;
        if (adVar == null) {
            AppMethodBeat.o(119469);
            return false;
        } else if (j.j(this.BfP, adVar.dZF()) && j.j(this.BiD, adVar.dZG())) {
            AppMethodBeat.o(119469);
            return true;
        } else {
            AppMethodBeat.o(119469);
            return false;
        }
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119471);
        j.p(nVar, "visitor");
        Object a = nVar.a((ad) this, (Object) d);
        AppMethodBeat.o(119471);
        return a;
    }

    public final /* synthetic */ l dXW() {
        ad adVar;
        AppMethodBeat.i(119468);
        if (this.BfP.ByQ.ByV.isEmpty()) {
            adVar = null;
        } else {
            v vVar = this.BiD;
            a.i.b.a.c.f.b ehG = this.BfP.ehG();
            j.o(ehG, "fqName.parent()");
            adVar = vVar.g(ehG);
        }
        l lVar = adVar;
        AppMethodBeat.o(119468);
        return lVar;
    }

    public final int hashCode() {
        AppMethodBeat.i(119470);
        int hashCode = (this.BiD.hashCode() * 31) + this.BfP.hashCode();
        AppMethodBeat.o(119470);
        return hashCode;
    }

    public final /* bridge */ /* synthetic */ y dZG() {
        return this.BiD;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(119473);
        boolean isEmpty = getFragments().isEmpty();
        AppMethodBeat.o(119473);
        return isEmpty;
    }
}
