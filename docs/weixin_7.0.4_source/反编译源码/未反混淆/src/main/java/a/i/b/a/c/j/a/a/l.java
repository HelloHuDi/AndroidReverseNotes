package a.i.b.a.c.j.a.a;

import a.a.m;
import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.c.b;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.a.ae;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.f.f;
import a.i.b.a.c.j.a.k;
import a.i.b.a.c.j.a.r;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class l extends b {
    final k BHj;
    private final a BID = new a(this.BHj.Brl.Baf, new a(this));
    final ae BIE;

    static final class a extends a.f.b.k implements a.f.a.a<List<? extends c>> {
        final /* synthetic */ l BIF;

        a(l lVar) {
            this.BIF = lVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122427);
            List m = t.m(this.BIF.BHj.Brl.BGR.a(this.BIF.BIE, this.BIF.BHj.AWq));
            AppMethodBeat.o(122427);
            return m;
        }
    }

    public final /* synthetic */ void J(w wVar) {
        AppMethodBeat.i(122429);
        j.p(wVar, "type");
        Throwable illegalStateException = new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: ".concat(String.valueOf(this)));
        AppMethodBeat.o(122429);
        throw illegalStateException;
    }

    public final List<w> eaq() {
        Object obj;
        List list;
        Collection arrayList;
        AppMethodBeat.i(122428);
        ae aeVar = this.BIE;
        h hVar = this.BHj.AWr;
        j.p(aeVar, "receiver$0");
        j.p(hVar, "typeTable");
        List list2 = aeVar.BvE;
        if (list2.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            list = list2;
        } else {
            list = null;
        }
        if (list == null) {
            list = aeVar.BvF;
            j.o(list, "upperBoundIdList");
            Iterable<Integer> iterable = list;
            arrayList = new ArrayList(m.d(iterable));
            for (Integer num : iterable) {
                j.o(num, "it");
                arrayList.add(hVar.Uk(num.intValue()));
            }
            list = (List) arrayList;
        }
        if (list.isEmpty()) {
            list2 = a.a.k.listOf(a.i.b.a.c.i.c.a.G(this).dXN());
            AppMethodBeat.o(122428);
            return list2;
        }
        Iterable<aa> iterable2 = list;
        a.i.b.a.c.j.a.w wVar = this.BHj.BHb;
        arrayList = new ArrayList(m.d(iterable2));
        for (aa r : iterable2) {
            arrayList.add(wVar.r(r));
        }
        List<w> list3 = (List) arrayList;
        AppMethodBeat.o(122428);
        return list3;
    }

    public final /* bridge */ /* synthetic */ g dYn() {
        return this.BID;
    }

    public l(k kVar, ae aeVar, int i) {
        j.p(kVar, "c");
        j.p(aeVar, "proto");
        i iVar = kVar.Brl.Baf;
        a.i.b.a.c.b.l lVar = kVar.Bht;
        f b = r.b(kVar.AWq, aeVar.Buf);
        a.i.b.a.c.j.a.t tVar = a.i.b.a.c.j.a.t.BHx;
        ae.b bVar = aeVar.BvD;
        j.o(bVar, "proto.variance");
        super(iVar, lVar, b, a.i.b.a.c.j.a.t.b(bVar), aeVar.BvC, i, am.BeR, a.i.b.a.c.b.ap.a.BeT);
        AppMethodBeat.i(122430);
        this.BHj = kVar;
        this.BIE = aeVar;
        AppMethodBeat.o(122430);
    }
}
