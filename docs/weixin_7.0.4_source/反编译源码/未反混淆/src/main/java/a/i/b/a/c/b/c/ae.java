package a.i.b.a.c.b.c;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.c;
import a.i.b.a.c.i.e.d;
import a.i.b.a.c.i.e.d.a;
import a.i.b.a.c.i.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class ae extends i {
    private final y Bdv;
    private final b BfP;

    public ae(y yVar, b bVar) {
        j.p(yVar, "moduleDescriptor");
        j.p(bVar, "fqName");
        AppMethodBeat.i(119589);
        this.Bdv = yVar;
        this.BfP = bVar;
        AppMethodBeat.o(119589);
    }

    public final Collection<l> a(d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(119588);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        a aVar = d.BFX;
        Collection collection;
        if (!dVar.UI(d.BFE)) {
            collection = v.AUP;
            AppMethodBeat.o(119588);
            return collection;
        } else if (this.BfP.ByQ.ByV.isEmpty() && dVar.BFz.contains(c.b.BFx)) {
            Collection<l> collection2 = v.AUP;
            AppMethodBeat.o(119588);
            return collection2;
        } else {
            Collection<b> a = this.Bdv.a(this.BfP, bVar);
            ArrayList arrayList = new ArrayList(a.size());
            for (b bVar2 : a) {
                f ehK = bVar2.ByQ.ehK();
                j.o(ehK, "subFqName.shortName()");
                if (((Boolean) bVar.am(ehK)).booleanValue()) {
                    Object obj;
                    collection = arrayList;
                    j.p(ehK, "name");
                    if (ehK.ByZ) {
                        obj = null;
                    } else {
                        y yVar = this.Bdv;
                        b q = this.BfP.q(ehK);
                        j.o(q, "fqName.child(name)");
                        obj = yVar.g(q);
                        if (obj.isEmpty()) {
                            obj = null;
                        }
                    }
                    a.i.b.a.c.n.a.b(collection, obj);
                }
            }
            Collection<l> collection3 = arrayList;
            AppMethodBeat.o(119588);
            return collection3;
        }
    }
}
