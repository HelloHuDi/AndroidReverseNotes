package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import p000a.p001a.C17115v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0133c.C0134b;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d.C0137a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C37037i;
import p000a.p010i.p011b.p012a.p015c.p048n.C31780a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.c.ae */
public final class C41178ae extends C37037i {
    private final C25093y Bdv;
    private final C8174b BfP;

    public C41178ae(C25093y c25093y, C8174b c8174b) {
        C25052j.m39376p(c25093y, "moduleDescriptor");
        C25052j.m39376p(c8174b, "fqName");
        AppMethodBeat.m2504i(119589);
        this.Bdv = c25093y;
        this.BfP = c8174b;
        AppMethodBeat.m2505o(119589);
    }

    /* renamed from: a */
    public final Collection<C31642l> mo220a(C0136d c0136d, C17126b<? super C37022f, Boolean> c17126b) {
        AppMethodBeat.m2504i(119588);
        C25052j.m39376p(c0136d, "kindFilter");
        C25052j.m39376p(c17126b, "nameFilter");
        C0137a c0137a = C0136d.BFX;
        Collection collection;
        if (!c0136d.mo228UI(C0136d.BFE)) {
            collection = C17115v.AUP;
            AppMethodBeat.m2505o(119588);
            return collection;
        } else if (this.BfP.ByQ.ByV.isEmpty() && c0136d.BFz.contains(C0134b.BFx)) {
            Collection<C31642l> collection2 = C17115v.AUP;
            AppMethodBeat.m2505o(119588);
            return collection2;
        } else {
            Collection<C8174b> a = this.Bdv.mo246a(this.BfP, c17126b);
            ArrayList arrayList = new ArrayList(a.size());
            for (C8174b c8174b : a) {
                C37022f ehK = c8174b.ByQ.ehK();
                C25052j.m39375o(ehK, "subFqName.shortName()");
                if (((Boolean) c17126b.mo50am(ehK)).booleanValue()) {
                    Object obj;
                    collection = arrayList;
                    C25052j.m39376p(ehK, "name");
                    if (ehK.ByZ) {
                        obj = null;
                    } else {
                        C25093y c25093y = this.Bdv;
                        C8174b q = this.BfP.mo17976q(ehK);
                        C25052j.m39375o(q, "fqName.child(name)");
                        obj = c25093y.mo252g(q);
                        if (obj.isEmpty()) {
                            obj = null;
                        }
                    }
                    C31780a.m51478b(collection, obj);
                }
            }
            Collection<C31642l> collection3 = arrayList;
            AppMethodBeat.m2505o(119588);
            return collection3;
        }
    }
}
