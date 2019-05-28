package a.i.b.a.c.j.a.a;

import a.a.q;
import a.a.t;
import a.a.x;
import a.f.b.j;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.l;
import a.i.b.a.c.c.a.c;
import a.i.b.a.c.e.a.a;
import a.i.b.a.c.e.a.ag;
import a.i.b.a.c.e.a.am;
import a.i.b.a.c.e.a.s;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.d;
import a.i.b.a.c.j.a.i;
import a.i.b.a.c.j.a.k;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class h extends g {
    private final ab BIw;
    private final b BcW = this.BIw.dZF();

    public final /* synthetic */ Collection a(d dVar, a.f.a.b bVar) {
        AppMethodBeat.i(122405);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        Collection b = b(dVar, bVar, c.WHEN_GET_ALL_DESCRIPTORS);
        Collection arrayList = new ArrayList();
        for (a.i.b.a.c.b.b.b d : this.BHj.Brl.BGV) {
            q.a(arrayList, (Iterable) d.d(this.BcW));
        }
        arrayList = t.b(b, (Iterable) (List) arrayList);
        AppMethodBeat.o(122405);
        return arrayList;
    }

    public h(ab abVar, s sVar, a.i.b.a.c.e.a.c cVar, a aVar, e eVar, i iVar, a.f.a.a<? extends Collection<f>> aVar2) {
        j.p(abVar, "packageDescriptor");
        j.p(sVar, "proto");
        j.p(cVar, "nameResolver");
        j.p(aVar, "metadataVersion");
        j.p(iVar, "components");
        j.p(aVar2, "classNames");
        ag agVar = sVar.BtC;
        j.o(agVar, "proto.typeTable");
        a.i.b.a.c.e.a.h hVar = new a.i.b.a.c.e.a.h(agVar);
        a.i.b.a.c.e.a.i.a aVar3 = a.i.b.a.c.e.a.i.Bxj;
        am amVar = sVar.BtE;
        j.o(amVar, "proto.versionRequirementTable");
        k a = iVar.a(abVar, cVar, hVar, a.i.b.a.c.e.a.i.a.g(amVar), aVar, eVar);
        List list = sVar.Btw;
        j.o(list, "proto.functionList");
        Collection collection = list;
        List list2 = sVar.Btx;
        j.o(list2, "proto.propertyList");
        Collection collection2 = list2;
        List list3 = sVar.Bty;
        j.o(list3, "proto.typeAliasList");
        super(a, collection, collection2, list3, aVar2);
        AppMethodBeat.i(122411);
        this.BIw = abVar;
        AppMethodBeat.o(122411);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean D(f fVar) {
        AppMethodBeat.i(122406);
        j.p(fVar, "name");
        if (!super.D(fVar)) {
            Object obj;
            Iterable<a.i.b.a.c.b.b.b> iterable = this.BHj.Brl.BGV;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (a.i.b.a.c.b.b.b a : iterable) {
                    if (a.a(this.BcW, fVar)) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                AppMethodBeat.o(122406);
                return false;
            }
        }
        AppMethodBeat.o(122406);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final a.i.b.a.c.f.a A(f fVar) {
        AppMethodBeat.i(122407);
        j.p(fVar, "name");
        a.i.b.a.c.f.a aVar = new a.i.b.a.c.f.a(this.BcW, fVar);
        AppMethodBeat.o(122407);
        return aVar;
    }

    public final a.i.b.a.c.b.h c(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122408);
        j.p(fVar, "name");
        j.p(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        a.i.b.a.c.b.h c = super.c(fVar, aVar);
        AppMethodBeat.o(122408);
        return c;
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(Collection<l> collection, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(122410);
        j.p(collection, "result");
        j.p(bVar, "nameFilter");
        AppMethodBeat.o(122410);
    }

    public final void d(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122409);
        j.p(fVar, "name");
        j.p(aVar, FirebaseAnalytics.b.LOCATION);
        a.i.b.a.c.c.a.a(this.BHj.Brl.Bnc, aVar, this.BIw, fVar);
        AppMethodBeat.o(122409);
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> ejY() {
        return x.AUR;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> ejZ() {
        return x.AUR;
    }
}
