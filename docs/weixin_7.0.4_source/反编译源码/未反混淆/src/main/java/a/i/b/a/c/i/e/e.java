package a.i.b.a.c.i.e;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.l;
import a.i.b.a.c.i.h;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class e extends i {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final f BFY;
    protected final a.i.b.a.c.b.e BFZ;

    static final class a extends a.f.b.k implements a.f.a.a<List<? extends l>> {
        final /* synthetic */ e BGa;

        a(e eVar) {
            this.BGa = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122184);
            List dYw = this.BGa.dYw();
            List b = a.a.t.b((Collection) dYw, (Iterable) e.a(this.BGa, dYw));
            AppMethodBeat.o(122184);
            return b;
        }
    }

    public static final class b extends h {
        final /* synthetic */ e BGa;
        final /* synthetic */ ArrayList BcP;

        b(e eVar, ArrayList arrayList) {
            this.BGa = eVar;
            this.BcP = arrayList;
        }

        public final void g(a.i.b.a.c.b.b bVar) {
            AppMethodBeat.i(122185);
            j.p(bVar, "fakeOverride");
            a.i.b.a.c.i.j.a(bVar, null);
            this.BcP.add(bVar);
            AppMethodBeat.o(122185);
        }

        public final void a(a.i.b.a.c.b.b bVar, a.i.b.a.c.b.b bVar2) {
            AppMethodBeat.i(122186);
            j.p(bVar, "fromSuper");
            j.p(bVar2, "fromCurrent");
            Throwable illegalStateException = new IllegalStateException(("Conflict in scope of " + this.BGa.BFZ + ": " + bVar + " vs " + bVar2).toString());
            AppMethodBeat.o(122186);
            throw illegalStateException;
        }
    }

    private final List<l> ejM() {
        return (List) a.i.b.a.c.k.h.a(this.BFY, eQB[0]);
    }

    public abstract List<a.i.b.a.c.b.t> dYw();

    public e(i iVar, a.i.b.a.c.b.e eVar) {
        j.p(iVar, "storageManager");
        j.p(eVar, "containingClass");
        this.BFZ = eVar;
        this.BFY = iVar.i(new a(this));
    }

    public final Collection<l> a(d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar) {
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        if (dVar.UI(d.BFM.BFy)) {
            return ejM();
        }
        return a.a.v.AUP;
    }

    public final Collection<al> b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        Collection arrayList = new ArrayList();
        for (Object next : ejM()) {
            if (next instanceof al) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (j.j(((al) next2).dZg(), fVar)) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }

    public final Collection<ah> a(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        Collection arrayList = new ArrayList();
        for (Object next : ejM()) {
            if (next instanceof ah) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (j.j(((ah) next2).dZg(), fVar)) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }
}
