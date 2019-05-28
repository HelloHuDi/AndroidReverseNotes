package a.i.b.a.c.m.b;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;

public final class a {
    public static final <T> Collection<T> b(Collection<? extends T> collection, Collection<? extends T> collection2) {
        AppMethodBeat.i(122913);
        j.p(collection2, "collection");
        if (collection2.isEmpty()) {
            AppMethodBeat.o(122913);
            return collection;
        } else if (collection == null) {
            AppMethodBeat.o(122913);
            return collection2;
        } else if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            AppMethodBeat.o(122913);
            return collection;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
            linkedHashSet.addAll(collection2);
            Collection<? extends T> collection3 = linkedHashSet;
            AppMethodBeat.o(122913);
            return collection3;
        }
    }
}
