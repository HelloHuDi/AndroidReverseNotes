package a.i.b.a.c.d.a.c;

import a.a.l;
import a.a.v;
import a.d;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ac;
import a.i.b.a.c.d.a.c.a.h;
import a.i.b.a.c.d.a.e.t;
import a.i.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class g implements ac {
    final h Bnn;
    private final a.i.b.a.c.k.a<b, h> Bnq = this.Bnn.Bnv.Baf.eke();

    static final class a extends k implements a.f.a.a<h> {
        final /* synthetic */ g Bnr;
        final /* synthetic */ t Bns;

        a(g gVar, t tVar) {
            this.Bnr = gVar;
            this.Bns = tVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119835);
            h hVar = new h(this.Bnr.Bnn, this.Bns);
            AppMethodBeat.o(119835);
            return hVar;
        }
    }

    public g(b bVar) {
        j.p(bVar, "components");
        AppMethodBeat.i(119839);
        this.Bnn = new h(bVar, a.i.b.a.c.d.a.c.m.a.BnF, new d(null));
        AppMethodBeat.o(119839);
    }

    public final /* synthetic */ Collection a(b bVar, a.f.a.b bVar2) {
        AppMethodBeat.i(119838);
        j.p(bVar, "fqName");
        j.p(bVar2, "nameFilter");
        h l = l(bVar);
        List list = l != null ? (List) l.Bor.invoke() : null;
        if (list == null) {
            list = v.AUP;
        }
        Collection collection = list;
        AppMethodBeat.o(119838);
        return collection;
    }

    private final h l(b bVar) {
        AppMethodBeat.i(119836);
        t a = this.Bnn.Bnv.BmR.a(bVar);
        j.o(a, "c.components.finder.find…ge(fqName) ?: return null");
        h hVar = (h) this.Bnq.b(bVar, new a(this, a));
        AppMethodBeat.o(119836);
        return hVar;
    }

    public final List<h> h(b bVar) {
        AppMethodBeat.i(119837);
        j.p(bVar, "fqName");
        List dm = l.dm(l(bVar));
        AppMethodBeat.o(119837);
        return dm;
    }
}
