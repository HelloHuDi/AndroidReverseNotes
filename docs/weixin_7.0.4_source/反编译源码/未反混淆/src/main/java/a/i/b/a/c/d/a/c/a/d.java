package a.i.b.a.c.d.a.c.a;

import a.a.q;
import a.a.x;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.i;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.b.n;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.k.f;
import a.i.k;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class d implements h {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    final j BnN;
    private final f BnO = this.Bnn.Bnv.Baf.i(new a(this));
    private final h BnP;
    private final a.i.b.a.c.d.a.c.h Bnn;

    static final class a extends a.f.b.k implements a.f.a.a<List<? extends h>> {
        final /* synthetic */ d BnQ;

        a(d dVar) {
            this.BnQ = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119863);
            Collection arrayList = new ArrayList();
            for (n a : this.BnQ.BnP.ebv().values()) {
                h a2 = this.BnQ.Bnn.Bnv.BmT.a((ab) this.BnQ.BnP, a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            List m = a.a.t.m((List) arrayList);
            AppMethodBeat.o(119863);
            return m;
        }
    }

    static {
        AppMethodBeat.i(119864);
        AppMethodBeat.o(119864);
    }

    private final List<h> ebp() {
        AppMethodBeat.i(119865);
        List list = (List) a.i.b.a.c.k.h.a(this.BnO, eQB[0]);
        AppMethodBeat.o(119865);
        return list;
    }

    public d(a.i.b.a.c.d.a.c.h hVar, a.i.b.a.c.d.a.e.t tVar, h hVar2) {
        j.p(hVar, "c");
        j.p(tVar, "jPackage");
        j.p(hVar2, "packageFragment");
        AppMethodBeat.i(119873);
        this.Bnn = hVar;
        this.BnP = hVar2;
        this.BnN = new j(this.Bnn, tVar, this.BnP);
        AppMethodBeat.o(119873);
    }

    public final a.i.b.a.c.b.h c(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119866);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        d(fVar, aVar);
        e e = this.BnN.e(fVar, aVar);
        if (e != null) {
            a.i.b.a.c.b.h hVar = e;
            AppMethodBeat.o(119866);
            return hVar;
        }
        a.i.b.a.c.b.h hVar2 = null;
        for (h c : ebp()) {
            a.i.b.a.c.b.h c2 = c.c(fVar, aVar);
            if (c2 != null) {
                if (!(c2 instanceof i) || !((i) c2).dYk()) {
                    AppMethodBeat.o(119866);
                    return c2;
                } else if (hVar2 == null) {
                    hVar2 = c2;
                }
            }
        }
        AppMethodBeat.o(119866);
        return hVar2;
    }

    public final Collection<ah> a(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        Collection<ah> collection;
        AppMethodBeat.i(119867);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        d(fVar, aVar);
        j jVar = this.BnN;
        List ebp = ebp();
        Collection<ah> a = jVar.a(fVar, aVar);
        Iterator it = ebp.iterator();
        while (true) {
            collection = a;
            if (!it.hasNext()) {
                break;
            }
            a = a.i.b.a.c.m.b.a.b(collection, ((h) it.next()).a(fVar, aVar));
        }
        a = collection == null ? x.AUR : collection;
        AppMethodBeat.o(119867);
        return a;
    }

    public final Collection<al> b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        Collection<al> collection;
        AppMethodBeat.i(119868);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        d(fVar, aVar);
        j jVar = this.BnN;
        List ebp = ebp();
        Collection<al> b = jVar.b(fVar, aVar);
        Iterator it = ebp.iterator();
        while (true) {
            collection = b;
            if (!it.hasNext()) {
                break;
            }
            b = a.i.b.a.c.m.b.a.b(collection, ((h) it.next()).b(fVar, aVar));
        }
        b = collection == null ? x.AUR : collection;
        AppMethodBeat.o(119868);
        return b;
    }

    public final Collection<l> a(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar) {
        Collection<l> collection;
        AppMethodBeat.i(119869);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        j jVar = this.BnN;
        List ebp = ebp();
        Collection<l> a = jVar.a(dVar, bVar);
        Iterator it = ebp.iterator();
        while (true) {
            collection = a;
            if (!it.hasNext()) {
                break;
            }
            a = a.i.b.a.c.m.b.a.b(collection, ((h) it.next()).a(dVar, bVar));
        }
        if (collection == null) {
            a = x.AUR;
        } else {
            a = collection;
        }
        AppMethodBeat.o(119869);
        return a;
    }

    public final Set<a.i.b.a.c.f.f> eau() {
        AppMethodBeat.i(119870);
        Collection linkedHashSet = new LinkedHashSet();
        for (h eau : ebp()) {
            q.a(linkedHashSet, (Iterable) eau.eau());
        }
        ((Set) linkedHashSet).addAll(this.BnN.eau());
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(119870);
        return set;
    }

    public final Set<a.i.b.a.c.f.f> eav() {
        AppMethodBeat.i(119871);
        Collection linkedHashSet = new LinkedHashSet();
        for (h eav : ebp()) {
            q.a(linkedHashSet, (Iterable) eav.eav());
        }
        ((Set) linkedHashSet).addAll(this.BnN.eav());
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(119871);
        return set;
    }

    private void d(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119872);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        a.i.b.a.c.c.a.a(this.Bnn.Bnv.Bnc, aVar, (ab) this.BnP, fVar);
        AppMethodBeat.o(119872);
    }
}
