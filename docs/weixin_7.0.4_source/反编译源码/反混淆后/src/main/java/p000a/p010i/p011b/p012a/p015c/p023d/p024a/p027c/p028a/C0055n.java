package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25033k;
import p000a.p001a.C25034m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C17165b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C25096l;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C36981e;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b.C25109d;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0062w;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44886j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.d.a.c.a.n */
public final class C0055n extends C17165b {
    private final C0057h Bnn;
    private final C36981e BoU = new C36981e(this.Bnn, this.BoV);
    private final C0062w BoV;

    public final List<C46867w> eaq() {
        AppMethodBeat.m2504i(120019);
        Collection ecb = this.BoV.ecb();
        if (ecb.isEmpty()) {
            C8235ad dXM = this.Bnn.Bnv.BcH.dZD().dXM();
            C25052j.m39375o(dXM, "c.module.builtIns.anyType");
            C8235ad dXN = this.Bnn.Bnv.BcH.dZD().dXN();
            C25052j.m39375o(dXN, "c.module.builtIns.nullableAnyType");
            List listOf = C25033k.listOf(C17326x.m26839a(dXM, dXN));
            AppMethodBeat.m2505o(120019);
            return listOf;
        }
        Iterable<C44886j> iterable = ecb;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C44886j a : iterable) {
            arrayList.add(this.Bnn.Bnu.mo31276a((C8118v) a, C25109d.m39487a(C25096l.COMMON, false, this, 1)));
        }
        List<C46867w> list = (List) arrayList;
        AppMethodBeat.m2505o(120019);
        return list;
    }

    /* renamed from: J */
    public final void mo101J(C46867w c46867w) {
        AppMethodBeat.m2504i(120020);
        C25052j.m39376p(c46867w, "type");
        AppMethodBeat.m2505o(120020);
    }

    public final /* bridge */ /* synthetic */ C0026g dYn() {
        return this.BoU;
    }

    public C0055n(C0057h c0057h, C0062w c0062w, int i, C31642l c31642l) {
        C25052j.m39376p(c0057h, "c");
        C25052j.m39376p(c0062w, "javaTypeParameter");
        C25052j.m39376p(c31642l, "containingDeclaration");
        super(c0057h.Bnv.Baf, c31642l, c0062w.dZg(), C0163ba.INVARIANT, false, i, C41398am.BeR, c0057h.Bnv.Bhr);
        AppMethodBeat.m2504i(120021);
        this.Bnn = c0057h;
        this.BoV = c0062w;
        AppMethodBeat.m2505o(120021);
    }
}
