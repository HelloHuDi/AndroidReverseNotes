package a.i.b.a.c.d.a.b;

import a.a.m;
import a.a.t;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.a;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.c.ai;
import a.i.b.a.c.b.e;
import a.i.b.a.c.d.a.c.a.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.w;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class i {
    public static final List<au> a(Collection<j> collection, Collection<? extends au> collection2, a aVar) {
        AppMethodBeat.i(119813);
        j.p(collection, "newValueParametersTypes");
        j.p(collection2, "oldValueParameters");
        j.p(aVar, "newOwner");
        Object obj = collection.size() == collection2.size() ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Different value parameters sizes: Enhanced = " + collection.size() + ", Old = " + collection2.size());
            AppMethodBeat.o(119813);
            throw assertionError;
        }
        Iterable<o> a = t.a((Iterable) collection, (Iterable) collection2);
        Collection arrayList = new ArrayList(m.d(a));
        for (o oVar : a) {
            j jVar = (j) oVar.first;
            au auVar = (au) oVar.second;
            int index = auVar.getIndex();
            g dYn = auVar.dYn();
            f dZg = auVar.dZg();
            j.o(dZg, "oldParameter.name");
            w wVar = jVar.AYl;
            boolean z = jVar.BmM;
            boolean dZX = auVar.dZX();
            boolean dZY = auVar.dZY();
            w l = auVar.dZV() != null ? a.i.b.a.c.i.c.a.F(aVar).dZD().l(jVar.AYl) : null;
            am dYo = auVar.dYo();
            j.o(dYo, "oldParameter.source");
            arrayList.add(new ai(aVar, null, index, dYn, dZg, wVar, z, dZX, dZY, l, dYo));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(119813);
        return list;
    }

    public static final l s(e eVar) {
        h dXX;
        AppMethodBeat.i(119814);
        do {
            j.p(eVar, "receiver$0");
            Object eVar2 = a.i.b.a.c.i.c.a.z(eVar2);
            if (eVar2 == null) {
                AppMethodBeat.o(119814);
                return null;
            }
            dXX = eVar2.dXX();
            j.o(dXX, "superClassDescriptor.staticScope");
        } while (!(dXX instanceof l));
        l lVar = (l) dXX;
        AppMethodBeat.o(119814);
        return lVar;
    }
}
