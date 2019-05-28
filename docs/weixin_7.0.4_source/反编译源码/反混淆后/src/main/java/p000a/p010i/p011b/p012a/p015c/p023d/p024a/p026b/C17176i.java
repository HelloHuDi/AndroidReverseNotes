package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31826o;
import p000a.C44847aa;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C8069ai;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a.C6137l;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.b.i */
public final class C17176i {
    /* renamed from: a */
    public static final List<C41399au> m26549a(Collection<C25098j> collection, Collection<? extends C41399au> collection2, C8045a c8045a) {
        AppMethodBeat.m2504i(119813);
        C25052j.m39376p(collection, "newValueParametersTypes");
        C25052j.m39376p(collection2, "oldValueParameters");
        C25052j.m39376p(c8045a, "newOwner");
        Object obj = collection.size() == collection2.size() ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Different value parameters sizes: Enhanced = " + collection.size() + ", Old = " + collection2.size());
            AppMethodBeat.m2505o(119813);
            throw assertionError;
        }
        Iterable<C31826o> a = C25035t.m39325a((Iterable) collection, (Iterable) collection2);
        Collection arrayList = new ArrayList(C25034m.m39318d(a));
        for (C31826o c31826o : a) {
            C25098j c25098j = (C25098j) c31826o.first;
            C41399au c41399au = (C41399au) c31826o.second;
            int index = c41399au.getIndex();
            C0026g dYn = c41399au.dYn();
            C37022f dZg = c41399au.dZg();
            C25052j.m39375o(dZg, "oldParameter.name");
            C46867w c46867w = c25098j.AYl;
            boolean z = c25098j.BmM;
            boolean dZX = c41399au.dZX();
            boolean dZY = c41399au.dZY();
            C46867w l = c41399au.dZV() != null ? C41434a.m72274F(c8045a).dZD().mo51618l(c25098j.AYl) : null;
            C41398am dYo = c41399au.dYo();
            C25052j.m39375o(dYo, "oldParameter.source");
            arrayList.add(new C8069ai(c8045a, null, index, dYn, dZg, c46867w, z, dZX, dZY, l, dYo));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(119813);
        return list;
    }

    /* renamed from: s */
    public static final C6137l m26550s(C46865e c46865e) {
        C31746h dXX;
        AppMethodBeat.m2504i(119814);
        do {
            C25052j.m39376p(c46865e, "receiver$0");
            Object c46865e2 = C41434a.m72287z(c46865e2);
            if (c46865e2 == null) {
                AppMethodBeat.m2505o(119814);
                return null;
            }
            dXX = c46865e2.dXX();
            C25052j.m39375o(dXX, "superClassDescriptor.staticScope");
        } while (!(dXX instanceof C6137l));
        C6137l c6137l = (C6137l) dXX;
        AppMethodBeat.m2505o(119814);
        return c6137l;
    }
}
