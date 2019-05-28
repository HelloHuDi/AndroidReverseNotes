package a.i.b.a.c.i.e;

import a.a.l;
import a.aa;
import a.f.a.b;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.e;
import a.i.b.a.c.i.c;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.h;
import a.i.b.a.c.k.i;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class k extends i {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(k.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final e BFZ;
    private final f BGi;

    static final class a extends a.f.b.k implements a.f.a.a<List<? extends al>> {
        final /* synthetic */ k BGj;

        a(k kVar) {
            this.BGj = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122200);
            List listOf = l.listOf(c.w(this.BGj.BFZ), c.v(this.BGj.BFZ));
            AppMethodBeat.o(122200);
            return listOf;
        }
    }

    static {
        AppMethodBeat.i(122201);
        AppMethodBeat.o(122201);
    }

    private final List<al> ejO() {
        AppMethodBeat.i(122203);
        List list = (List) h.a(this.BGi, eQB[0]);
        AppMethodBeat.o(122203);
        return list;
    }

    public final /* synthetic */ Collection a(d dVar, b bVar) {
        AppMethodBeat.i(122204);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        Collection ejO = ejO();
        AppMethodBeat.o(122204);
        return ejO;
    }

    public final /* synthetic */ Collection b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122205);
        j.p(fVar, "name");
        j.p(aVar, FirebaseAnalytics.b.LOCATION);
        Collection arrayList = new ArrayList(1);
        for (Object next : ejO()) {
            if (j.j(((al) next).dZg(), fVar)) {
                arrayList.add(next);
            }
        }
        arrayList = (ArrayList) arrayList;
        AppMethodBeat.o(122205);
        return arrayList;
    }

    public final /* synthetic */ a.i.b.a.c.b.h c(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122202);
        j.p(fVar, "name");
        j.p(aVar, FirebaseAnalytics.b.LOCATION);
        AppMethodBeat.o(122202);
        return null;
    }

    public k(i iVar, e eVar) {
        j.p(iVar, "storageManager");
        j.p(eVar, "containingClass");
        AppMethodBeat.i(122206);
        this.BFZ = eVar;
        Object obj = this.BFZ.dYc() == a.i.b.a.c.b.f.ENUM_CLASS ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Class should be an enum: " + this.BFZ);
            AppMethodBeat.o(122206);
            throw assertionError;
        }
        this.BGi = iVar.i(new a(this));
        AppMethodBeat.o(122206);
    }
}
