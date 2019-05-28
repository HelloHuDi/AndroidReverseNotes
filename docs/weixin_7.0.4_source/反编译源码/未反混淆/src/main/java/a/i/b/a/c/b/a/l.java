package a.i.b.a.c.b.a;

import a.f.a.b;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class l implements g {
    private final g BfV;
    private final b<a.i.b.a.c.f.b, Boolean> BfW;

    public l(g gVar, b<? super a.i.b.a.c.f.b, Boolean> bVar) {
        j.p(gVar, "delegate");
        j.p(bVar, "fqNameFilter");
        AppMethodBeat.i(119362);
        this.BfV = gVar;
        this.BfW = bVar;
        AppMethodBeat.o(119362);
    }

    public final boolean j(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119357);
        j.p(bVar, "fqName");
        if (((Boolean) this.BfW.am(bVar)).booleanValue()) {
            boolean j = this.BfV.j(bVar);
            AppMethodBeat.o(119357);
            return j;
        }
        AppMethodBeat.o(119357);
        return false;
    }

    public final c i(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119358);
        j.p(bVar, "fqName");
        if (((Boolean) this.BfW.am(bVar)).booleanValue()) {
            c i = this.BfV.i(bVar);
            AppMethodBeat.o(119358);
            return i;
        }
        AppMethodBeat.o(119358);
        return null;
    }

    public final Iterator<c> iterator() {
        AppMethodBeat.i(119359);
        Collection arrayList = new ArrayList();
        for (Object next : this.BfV) {
            if (c((c) next)) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        AppMethodBeat.o(119359);
        return it;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(119360);
        Iterable<c> iterable = this.BfV;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (c c : iterable) {
                if (c(c)) {
                    AppMethodBeat.o(119360);
                    return true;
                }
            }
        }
        AppMethodBeat.o(119360);
        return false;
    }

    private final boolean c(c cVar) {
        AppMethodBeat.i(119361);
        a.i.b.a.c.f.b dZF = cVar.dZF();
        if (dZF == null || !((Boolean) this.BfW.am(dZF)).booleanValue()) {
            AppMethodBeat.o(119361);
            return false;
        }
        AppMethodBeat.o(119361);
        return true;
    }
}
