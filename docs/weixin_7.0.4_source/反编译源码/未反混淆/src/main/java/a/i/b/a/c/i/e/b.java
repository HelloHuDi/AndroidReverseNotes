package a.i.b.a.c.i.e;

import a.a.q;
import a.a.x;
import a.f.b.j;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.i;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class b implements h {
    public static final a BFu = new a();
    private final List<h> BFt;
    private final String ByG;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(122175);
        AppMethodBeat.o(122175);
    }

    public b(String str, List<? extends h> list) {
        j.p(str, "debugName");
        j.p(list, Constants.KEY_SCOPES);
        AppMethodBeat.i(122174);
        this.ByG = str;
        this.BFt = list;
        AppMethodBeat.o(122174);
    }

    public final h c(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122168);
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        h hVar = null;
        for (h c : this.BFt) {
            h c2 = c.c(fVar, aVar);
            if (c2 != null) {
                if (!(c2 instanceof i) || !((i) c2).dYk()) {
                    AppMethodBeat.o(122168);
                    return c2;
                } else if (hVar == null) {
                    hVar = c2;
                }
            }
        }
        AppMethodBeat.o(122168);
        return hVar;
    }

    public final Collection<ah> a(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122169);
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        List list = this.BFt;
        if (list.isEmpty()) {
            Collection collection = x.AUR;
            AppMethodBeat.o(122169);
            return collection;
        }
        Collection<ah> collection2;
        Collection<ah> collection3 = null;
        Iterator it = list.iterator();
        while (true) {
            collection2 = collection3;
            if (!it.hasNext()) {
                break;
            }
            collection3 = a.i.b.a.c.m.b.a.b(collection2, ((h) it.next()).a(fVar, aVar));
        }
        if (collection2 == null) {
            collection3 = x.AUR;
        } else {
            collection3 = collection2;
        }
        AppMethodBeat.o(122169);
        return collection3;
    }

    public final Collection<al> b(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122170);
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        List list = this.BFt;
        if (list.isEmpty()) {
            Collection collection = x.AUR;
            AppMethodBeat.o(122170);
            return collection;
        }
        Collection<al> collection2;
        Collection<al> collection3 = null;
        Iterator it = list.iterator();
        while (true) {
            collection2 = collection3;
            if (!it.hasNext()) {
                break;
            }
            collection3 = a.i.b.a.c.m.b.a.b(collection2, ((h) it.next()).b(fVar, aVar));
        }
        if (collection2 == null) {
            collection3 = x.AUR;
        } else {
            collection3 = collection2;
        }
        AppMethodBeat.o(122170);
        return collection3;
    }

    public final Collection<l> a(d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(122171);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        List list = this.BFt;
        if (list.isEmpty()) {
            Collection collection = x.AUR;
            AppMethodBeat.o(122171);
            return collection;
        }
        Collection<l> collection2;
        Collection<l> collection3 = null;
        Iterator it = list.iterator();
        while (true) {
            collection2 = collection3;
            if (!it.hasNext()) {
                break;
            }
            collection3 = a.i.b.a.c.m.b.a.b(collection2, ((h) it.next()).a(dVar, bVar));
        }
        if (collection2 == null) {
            collection3 = x.AUR;
        } else {
            collection3 = collection2;
        }
        AppMethodBeat.o(122171);
        return collection3;
    }

    public final Set<f> eau() {
        AppMethodBeat.i(122172);
        Collection linkedHashSet = new LinkedHashSet();
        for (h eau : this.BFt) {
            q.a(linkedHashSet, (Iterable) eau.eau());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(122172);
        return set;
    }

    public final Set<f> eav() {
        AppMethodBeat.i(122173);
        Collection linkedHashSet = new LinkedHashSet();
        for (h eav : this.BFt) {
            q.a(linkedHashSet, (Iterable) eav.eav());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(122173);
        return set;
    }

    public final String toString() {
        return this.ByG;
    }
}
