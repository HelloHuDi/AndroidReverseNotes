package a.i.b.a.c.d.a.f;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class b implements g {
    private final a.i.b.a.c.f.b Bpz;

    public b(a.i.b.a.c.f.b bVar) {
        j.p(bVar, "fqNameToMatch");
        AppMethodBeat.i(120089);
        this.Bpz = bVar;
        AppMethodBeat.o(120089);
    }

    public final /* synthetic */ c i(a.i.b.a.c.f.b bVar) {
        a aVar;
        AppMethodBeat.i(120087);
        j.p(bVar, "fqName");
        if (j.j(bVar, this.Bpz)) {
            aVar = a.Bpy;
        } else {
            aVar = null;
        }
        c cVar = aVar;
        AppMethodBeat.o(120087);
        return cVar;
    }

    public final boolean j(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(120090);
        j.p(bVar, "fqName");
        boolean b = a.i.b.a.c.b.a.g.b.b(this, bVar);
        AppMethodBeat.o(120090);
        return b;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final Iterator<c> iterator() {
        AppMethodBeat.i(120088);
        Iterator it = v.AUP.iterator();
        AppMethodBeat.o(120088);
        return it;
    }
}
