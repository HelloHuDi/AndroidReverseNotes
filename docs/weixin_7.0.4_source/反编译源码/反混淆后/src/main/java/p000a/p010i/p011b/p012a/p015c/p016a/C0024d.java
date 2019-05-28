package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.a.d */
public final class C0024d {
    private static final LinkedHashSet<C8173a> AZP;
    public static final C0024d AZQ = new C0024d();

    static {
        AppMethodBeat.m2504i(119074);
        Set set = C31622h.BbY;
        C25052j.m39375o(set, "PrimitiveType.NUMBER_TYPES");
        Iterable<C31622h> iterable = set;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C31622h c : iterable) {
            arrayList.add(C31619g.m51112c(c));
        }
        Iterable<C8174b> a = C25035t.m39326a((Collection) C25035t.m39326a((Collection) C25035t.m39326a((Collection) (List) arrayList, (Object) C31619g.Bag.Bas.ehI()), (Object) C31619g.Bag.Bau.ehI()), (Object) C31619g.Bag.BaD.ehI());
        arrayList = new LinkedHashSet();
        for (C8174b n : a) {
            arrayList.add(C8173a.m14427n(n));
        }
        AZP = (LinkedHashSet) arrayList;
        AppMethodBeat.m2505o(119074);
    }

    private C0024d() {
    }

    public static Set<C8173a> dXF() {
        AppMethodBeat.m2504i(119072);
        Set unmodifiableSet = Collections.unmodifiableSet(AZP);
        C25052j.m39375o(unmodifiableSet, "Collections.unmodifiableSet(classIds)");
        AppMethodBeat.m2505o(119072);
        return unmodifiableSet;
    }

    /* renamed from: b */
    public static boolean m24b(C46865e c46865e) {
        AppMethodBeat.m2504i(119073);
        C25052j.m39376p(c46865e, "classDescriptor");
        if (C8203d.m14494u((C31642l) c46865e)) {
            Iterable iterable = AZP;
            C8173a c = C41434a.m72281c(c46865e);
            if (C25035t.m39327a(iterable, c != null ? c.ehC() : null)) {
                AppMethodBeat.m2505o(119073);
                return true;
            }
        }
        AppMethodBeat.m2505o(119073);
        return false;
    }
}
