package a.i.b.a.c.b.c;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ac;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class i implements ac {
    private final List<ac> BhB;

    public i(List<? extends ac> list) {
        j.p(list, "providers");
        AppMethodBeat.i(119430);
        this.BhB = list;
        AppMethodBeat.o(119430);
    }

    public final List<ab> h(b bVar) {
        AppMethodBeat.i(119428);
        j.p(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        for (ac h : this.BhB) {
            arrayList.addAll(h.h(bVar));
        }
        List m = t.m(arrayList);
        AppMethodBeat.o(119428);
        return m;
    }

    public final Collection<b> a(b bVar, a.f.a.b<? super f, Boolean> bVar2) {
        AppMethodBeat.i(119429);
        j.p(bVar, "fqName");
        j.p(bVar2, "nameFilter");
        HashSet hashSet = new HashSet();
        for (ac a : this.BhB) {
            hashSet.addAll(a.a(bVar, bVar2));
        }
        Collection collection = hashSet;
        AppMethodBeat.o(119429);
        return collection;
    }
}
