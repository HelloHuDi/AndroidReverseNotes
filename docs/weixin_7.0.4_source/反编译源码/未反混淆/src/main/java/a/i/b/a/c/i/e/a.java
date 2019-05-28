package a.i.b.a.c.i.e;

import a.f.b.j;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.Collection;
import java.util.Set;

public abstract class a implements h {
    public abstract h ejA();

    public Collection<al> b(f fVar, a.i.b.a.c.c.a.a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        return ejA().b(fVar, aVar);
    }

    public final h c(f fVar, a.i.b.a.c.c.a.a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        return ejA().c(fVar, aVar);
    }

    public Collection<ah> a(f fVar, a.i.b.a.c.c.a.a aVar) {
        j.p(fVar, "name");
        j.p(aVar, b.LOCATION);
        return ejA().a(fVar, aVar);
    }

    public Collection<l> a(d dVar, a.f.a.b<? super f, Boolean> bVar) {
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        return ejA().a(dVar, bVar);
    }

    public final Set<f> eau() {
        return ejA().eau();
    }

    public final Set<f> eav() {
        return ejA().eav();
    }
}
