package a.i.b.a.c.i.e;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.aw;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.c.a.a;
import a.i.b.a.c.f.f;
import a.i.b.a.c.n.d;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class i implements h {
    public h c(f fVar, a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        return null;
    }

    public Set<f> eau() {
        Collection arrayList = new ArrayList();
        for (Object next : a(d.BFS, d.eku())) {
            if (next instanceof al) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (al dZg : (List) arrayList) {
            linkedHashSet.add(dZg.dZg());
        }
        return (Set) linkedHashSet;
    }

    public Set<f> eav() {
        Collection arrayList = new ArrayList();
        for (Object next : a(d.BFT, d.eku())) {
            if (next instanceof aw) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (aw dZg : (List) arrayList) {
            linkedHashSet.add(dZg.dZg());
        }
        return (Set) linkedHashSet;
    }

    public Collection<ah> a(f fVar, a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        return v.AUP;
    }

    public Collection<al> b(f fVar, a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        return v.AUP;
    }

    public Collection<l> a(d dVar, a.f.a.b<? super f, Boolean> bVar) {
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        return v.AUP;
    }

    public void d(f fVar, a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        j jVar = this;
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        jVar.b(fVar, aVar);
    }
}
