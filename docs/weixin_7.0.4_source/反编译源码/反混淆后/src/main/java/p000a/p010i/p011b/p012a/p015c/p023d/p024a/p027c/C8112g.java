package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import p000a.C36929d;
import p000a.p001a.C17115v;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C44871ac;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C31669m.C31670a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a.C36974h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0060t;
import p000a.p010i.p011b.p012a.p015c.p044k.C17297a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.c.g */
public final class C8112g implements C44871ac {
    final C0057h Bnn;
    private final C17297a<C8174b, C36974h> Bnq = this.Bnn.Bnv.Baf.eke();

    /* renamed from: a.i.b.a.c.d.a.c.g$a */
    static final class C8113a extends C25053k implements C31214a<C36974h> {
        final /* synthetic */ C8112g Bnr;
        final /* synthetic */ C0060t Bns;

        C8113a(C8112g c8112g, C0060t c0060t) {
            this.Bnr = c8112g;
            this.Bns = c0060t;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119835);
            C36974h c36974h = new C36974h(this.Bnr.Bnn, this.Bns);
            AppMethodBeat.m2505o(119835);
            return c36974h;
        }
    }

    public C8112g(C36979b c36979b) {
        C25052j.m39376p(c36979b, "components");
        AppMethodBeat.m2504i(119839);
        this.Bnn = new C0057h(c36979b, C31670a.BnF, new C36929d(null));
        AppMethodBeat.m2505o(119839);
    }

    /* renamed from: a */
    public final /* synthetic */ Collection mo17924a(C8174b c8174b, C17126b c17126b) {
        AppMethodBeat.m2504i(119838);
        C25052j.m39376p(c8174b, "fqName");
        C25052j.m39376p(c17126b, "nameFilter");
        C36974h l = m14300l(c8174b);
        List list = l != null ? (List) l.Bor.invoke() : null;
        if (list == null) {
            list = C17115v.AUP;
        }
        Collection collection = list;
        AppMethodBeat.m2505o(119838);
        return collection;
    }

    /* renamed from: l */
    private final C36974h m14300l(C8174b c8174b) {
        AppMethodBeat.m2504i(119836);
        C0060t a = this.Bnn.Bnv.BmR.mo17928a(c8174b);
        C25052j.m39375o(a, "c.components.finder.find…ge(fqName) ?: return null");
        C36974h c36974h = (C36974h) this.Bnq.mo31366b(c8174b, new C8113a(this, a));
        AppMethodBeat.m2505o(119836);
        return c36974h;
    }

    /* renamed from: h */
    public final List<C36974h> mo17925h(C8174b c8174b) {
        AppMethodBeat.m2504i(119837);
        C25052j.m39376p(c8174b, "fqName");
        List dm = C7987l.m14171dm(m14300l(c8174b));
        AppMethodBeat.m2505o(119837);
        return dm;
    }
}
