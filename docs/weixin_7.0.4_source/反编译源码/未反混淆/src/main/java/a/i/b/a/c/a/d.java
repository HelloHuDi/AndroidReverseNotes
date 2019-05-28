package a.i.b.a.c.a;

import a.a.m;
import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class d {
    private static final LinkedHashSet<a> AZP;
    public static final d AZQ = new d();

    static {
        AppMethodBeat.i(119074);
        Set set = h.BbY;
        j.o(set, "PrimitiveType.NUMBER_TYPES");
        Iterable<h> iterable = set;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (h c : iterable) {
            arrayList.add(g.c(c));
        }
        Iterable<b> a = t.a((Collection) t.a((Collection) t.a((Collection) (List) arrayList, (Object) g.Bag.Bas.ehI()), (Object) g.Bag.Bau.ehI()), (Object) g.Bag.BaD.ehI());
        arrayList = new LinkedHashSet();
        for (b n : a) {
            arrayList.add(a.n(n));
        }
        AZP = (LinkedHashSet) arrayList;
        AppMethodBeat.o(119074);
    }

    private d() {
    }

    public static Set<a> dXF() {
        AppMethodBeat.i(119072);
        Set unmodifiableSet = Collections.unmodifiableSet(AZP);
        j.o(unmodifiableSet, "Collections.unmodifiableSet(classIds)");
        AppMethodBeat.o(119072);
        return unmodifiableSet;
    }

    public static boolean b(e eVar) {
        AppMethodBeat.i(119073);
        j.p(eVar, "classDescriptor");
        if (a.i.b.a.c.i.d.u((l) eVar)) {
            Iterable iterable = AZP;
            a c = a.i.b.a.c.i.c.a.c(eVar);
            if (t.a(iterable, c != null ? c.ehC() : null)) {
                AppMethodBeat.o(119073);
                return true;
            }
        }
        AppMethodBeat.o(119073);
        return false;
    }
}
