package a.i.b.a.c.a.b;

import a.a.ag;
import a.a.m;
import a.a.t;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ao;
import a.i.b.a.c.l.ao.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class h {
    public static final ao a(e eVar, e eVar2) {
        AppMethodBeat.i(119243);
        j.p(eVar, "from");
        j.p(eVar2, "to");
        Object obj = eVar.dYq().size() == eVar2.dYq().size() ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError(eVar + " and " + eVar2 + " should have same number of type parameters, but " + eVar.dYq().size() + " / " + eVar2.dYq().size() + " found");
            AppMethodBeat.o(119243);
            throw assertionError;
        }
        a aVar = ao.BJQ;
        List dYq = eVar.dYq();
        j.o(dYq, "from.declaredTypeParameters");
        Iterable<ar> iterable = dYq;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (ar dXY : iterable) {
            arrayList.add(dXY.dXY());
        }
        Iterable iterable2 = (List) arrayList;
        dYq = eVar2.dYq();
        j.o(dYq, "to.declaredTypeParameters");
        iterable = dYq;
        Collection arrayList2 = new ArrayList(m.d(iterable));
        for (ar dXY2 : iterable) {
            j.o(dXY2, "it");
            ad dZf = dXY2.dZf();
            j.o(dZf, "it.defaultType");
            arrayList2.add(a.i.b.a.c.l.c.a.aM(dZf));
        }
        ao bf = a.bf(ag.v(t.a(iterable2, (Iterable) (List) arrayList2)));
        AppMethodBeat.o(119243);
        return bf;
    }
}
