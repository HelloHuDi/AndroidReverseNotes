package p000a.p010i.p011b.p012a.p015c.p047m.p1437b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.m.b.a */
public final class C31776a {
    /* renamed from: b */
    public static final <T> Collection<T> m51470b(Collection<? extends T> collection, Collection<? extends T> collection2) {
        AppMethodBeat.m2504i(122913);
        C25052j.m39376p(collection2, "collection");
        if (collection2.isEmpty()) {
            AppMethodBeat.m2505o(122913);
            return collection;
        } else if (collection == null) {
            AppMethodBeat.m2505o(122913);
            return collection2;
        } else if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            AppMethodBeat.m2505o(122913);
            return collection;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
            linkedHashSet.addAll(collection2);
            Collection<? extends T> collection3 = linkedHashSet;
            AppMethodBeat.m2505o(122913);
            return collection3;
        }
    }
}
