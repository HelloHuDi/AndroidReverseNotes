package a.i.b.a.c.b.a;

import a.f.b.j;
import a.i.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class h implements g {
    private final List<c> BfM;

    public h(List<? extends c> list) {
        j.p(list, "annotations");
        AppMethodBeat.i(119339);
        this.BfM = list;
        AppMethodBeat.o(119339);
    }

    public final c i(b bVar) {
        AppMethodBeat.i(119340);
        j.p(bVar, "fqName");
        c a = g.b.a(this, bVar);
        AppMethodBeat.o(119340);
        return a;
    }

    public final boolean j(b bVar) {
        AppMethodBeat.i(119341);
        j.p(bVar, "fqName");
        boolean b = g.b.b(this, bVar);
        AppMethodBeat.o(119341);
        return b;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(119336);
        boolean isEmpty = this.BfM.isEmpty();
        AppMethodBeat.o(119336);
        return isEmpty;
    }

    public final Iterator<c> iterator() {
        AppMethodBeat.i(119337);
        Iterator it = this.BfM.iterator();
        AppMethodBeat.o(119337);
        return it;
    }

    public final String toString() {
        AppMethodBeat.i(119338);
        String obj = this.BfM.toString();
        AppMethodBeat.o(119338);
        return obj;
    }
}
