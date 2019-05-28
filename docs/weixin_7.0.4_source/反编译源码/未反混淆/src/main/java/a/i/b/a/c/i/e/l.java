package a.i.b.a.c.i.e;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.ao;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.m;
import a.i.b.a.c.i.a.a.c;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.au;
import a.i.k;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class l implements h {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(l.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;"))};
    private final h BGb;
    private final au BGk;
    private Map<a.i.b.a.c.b.l, a.i.b.a.c.b.l> BGl;
    private final f BGm = i.g(new a(this));

    static final class a extends a.f.b.k implements a.f.a.a<Collection<? extends a.i.b.a.c.b.l>> {
        final /* synthetic */ l BGn;

        a(l lVar) {
            this.BGn = lVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122207);
            Collection a = l.a(this.BGn, a.i.b.a.c.i.e.j.a.a(this.BGn.BGb, null, null, 3));
            AppMethodBeat.o(122207);
            return a;
        }
    }

    static {
        AppMethodBeat.i(122208);
        AppMethodBeat.o(122208);
    }

    public l(h hVar, au auVar) {
        j.p(hVar, "workerScope");
        j.p(auVar, "givenSubstitutor");
        AppMethodBeat.i(122217);
        this.BGb = hVar;
        as asVar = auVar.Bik;
        j.o(asVar, "givenSubstitutor.substitution");
        this.BGk = c.c(asVar).ekr();
        AppMethodBeat.o(122217);
    }

    private final <D extends a.i.b.a.c.b.l> D J(D d) {
        AppMethodBeat.i(122209);
        if (this.BGk.Bik.isEmpty()) {
            AppMethodBeat.o(122209);
            return d;
        }
        if (this.BGl == null) {
            this.BGl = new HashMap();
        }
        Map map = this.BGl;
        if (map == null) {
            j.dWJ();
        }
        Object obj = map.get(d);
        if (obj == null) {
            Throwable assertionError;
            if (d instanceof ao) {
                m f = ((ao) d).f(this.BGk);
                if (f == null) {
                    assertionError = new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
                    AppMethodBeat.o(122209);
                    throw assertionError;
                }
                obj = f;
                map.put(d, obj);
            } else {
                assertionError = new IllegalStateException("Unknown descriptor in scope: ".concat(String.valueOf(d)).toString());
                AppMethodBeat.o(122209);
                throw assertionError;
            }
        }
        D d2 = (a.i.b.a.c.b.l) obj;
        if (d2 == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type D");
            AppMethodBeat.o(122209);
            throw vVar;
        }
        AppMethodBeat.o(122209);
        return d2;
    }

    private final <D extends a.i.b.a.c.b.l> Collection<D> o(Collection<? extends D> collection) {
        AppMethodBeat.i(122210);
        if (this.BGk.Bik.isEmpty()) {
            AppMethodBeat.o(122210);
            return collection;
        } else if (collection.isEmpty()) {
            AppMethodBeat.o(122210);
            return collection;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet(a.i.b.a.c.n.a.UR(collection.size()));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(J((a.i.b.a.c.b.l) it.next()));
            }
            Collection<? extends D> collection2 = linkedHashSet;
            AppMethodBeat.o(122210);
            return collection2;
        }
    }

    public final Collection<ah> a(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122211);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        Collection o = o(this.BGb.a(fVar, aVar));
        AppMethodBeat.o(122211);
        return o;
    }

    public final h c(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122212);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        h c = this.BGb.c(fVar, aVar);
        if (c != null) {
            c = (h) J(c);
            AppMethodBeat.o(122212);
            return c;
        }
        AppMethodBeat.o(122212);
        return null;
    }

    public final Collection<al> b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122213);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        Collection o = o(this.BGb.b(fVar, aVar));
        AppMethodBeat.o(122213);
        return o;
    }

    public final Set<a.i.b.a.c.f.f> eau() {
        AppMethodBeat.i(122215);
        Set eau = this.BGb.eau();
        AppMethodBeat.o(122215);
        return eau;
    }

    public final Set<a.i.b.a.c.f.f> eav() {
        AppMethodBeat.i(122216);
        Set eav = this.BGb.eav();
        AppMethodBeat.o(122216);
        return eav;
    }

    public final Collection<a.i.b.a.c.b.l> a(d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar) {
        AppMethodBeat.i(122214);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        Collection collection = (Collection) this.BGm.getValue();
        AppMethodBeat.o(122214);
        return collection;
    }
}
