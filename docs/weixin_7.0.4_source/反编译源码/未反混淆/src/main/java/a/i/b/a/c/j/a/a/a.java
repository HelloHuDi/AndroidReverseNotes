package a.i.b.a.c.j.a.a;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.f.b;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.h;
import a.i.b.a.c.k.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class a implements g {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final f BHN;

    static {
        AppMethodBeat.i(122333);
        AppMethodBeat.o(122333);
    }

    private final List<c> ejT() {
        AppMethodBeat.i(122334);
        List list = (List) h.a(this.BHN, eQB[0]);
        AppMethodBeat.o(122334);
        return list;
    }

    public a(i iVar, a.f.a.a<? extends List<? extends c>> aVar) {
        j.p(iVar, "storageManager");
        j.p(aVar, "compute");
        AppMethodBeat.i(122337);
        this.BHN = iVar.i(aVar);
        AppMethodBeat.o(122337);
    }

    public final c i(b bVar) {
        AppMethodBeat.i(122338);
        j.p(bVar, "fqName");
        c a = g.b.a(this, bVar);
        AppMethodBeat.o(122338);
        return a;
    }

    public final boolean j(b bVar) {
        AppMethodBeat.i(122339);
        j.p(bVar, "fqName");
        boolean b = g.b.b(this, bVar);
        AppMethodBeat.o(122339);
        return b;
    }

    public boolean isEmpty() {
        AppMethodBeat.i(122335);
        boolean isEmpty = ejT().isEmpty();
        AppMethodBeat.o(122335);
        return isEmpty;
    }

    public Iterator<c> iterator() {
        AppMethodBeat.i(122336);
        Iterator it = ejT().iterator();
        AppMethodBeat.o(122336);
        return it;
    }
}
