package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C44871ac;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.c.i */
public final class C17167i implements C44871ac {
    private final List<C44871ac> BhB;

    public C17167i(List<? extends C44871ac> list) {
        C25052j.m39376p(list, "providers");
        AppMethodBeat.m2504i(119430);
        this.BhB = list;
        AppMethodBeat.m2505o(119430);
    }

    /* renamed from: h */
    public final List<C36953ab> mo17925h(C8174b c8174b) {
        AppMethodBeat.m2504i(119428);
        C25052j.m39376p(c8174b, "fqName");
        ArrayList arrayList = new ArrayList();
        for (C44871ac h : this.BhB) {
            arrayList.addAll(h.mo17925h(c8174b));
        }
        List m = C25035t.m39352m(arrayList);
        AppMethodBeat.m2505o(119428);
        return m;
    }

    /* renamed from: a */
    public final Collection<C8174b> mo17924a(C8174b c8174b, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(119429);
        C25052j.m39376p(c8174b, "fqName");
        C25052j.m39376p(c17126b, "nameFilter");
        HashSet hashSet = new HashSet();
        for (C44871ac a : this.BhB) {
            hashSet.addAll(a.mo17924a(c8174b, c17126b));
        }
        Collection collection = hashSet;
        AppMethodBeat.m2505o(119429);
        return collection;
    }
}
