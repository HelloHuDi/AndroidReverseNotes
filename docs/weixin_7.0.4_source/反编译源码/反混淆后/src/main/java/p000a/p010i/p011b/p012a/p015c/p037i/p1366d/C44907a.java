package p000a.p010i.p011b.p012a.p015c.p037i.p1366d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C36968g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C8112g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a.C36974h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41409aa;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.i.d.a */
public final class C44907a {
    public final C8112g BFd;
    private final C36968g BmW;

    public C44907a(C8112g c8112g, C36968g c36968g) {
        C25052j.m39376p(c8112g, "packageFragmentProvider");
        C25052j.m39376p(c36968g, "javaResolverCache");
        AppMethodBeat.m2504i(122155);
        this.BFd = c8112g;
        this.BmW = c36968g;
        AppMethodBeat.m2505o(122155);
    }

    /* renamed from: b */
    public final C46865e mo72106b(C44635g c44635g) {
        AppMethodBeat.m2504i(122154);
        C25052j.m39376p(c44635g, "javaClass");
        C8174b dZF = c44635g.dZF();
        if (dZF == null || C41409aa.SOURCE != null) {
            C44635g ebG = c44635g.ebG();
            if (ebG != null) {
                C31746h dZk;
                C0036h c;
                C46865e b = mo72106b(ebG);
                if (b != null) {
                    dZk = b.dZk();
                } else {
                    dZk = null;
                }
                if (dZk != null) {
                    c = dZk.mo222c(c44635g.dZg(), C0039c.FROM_JAVA_LOADER);
                } else {
                    c = null;
                }
                if (!(c instanceof C46865e)) {
                    c = null;
                }
                b = (C46865e) c;
                AppMethodBeat.m2505o(122154);
                return b;
            } else if (dZF == null) {
                AppMethodBeat.m2505o(122154);
                return null;
            } else {
                C8112g c8112g = this.BFd;
                dZF = dZF.ehG();
                C25052j.m39375o(dZF, "fqName.parent()");
                C36974h c36974h = (C36974h) C25035t.m39338fK(c8112g.mo17925h(dZF));
                if (c36974h != null) {
                    C46865e c2 = c36974h.mo58979c(c44635g);
                    AppMethodBeat.m2505o(122154);
                    return c2;
                }
                AppMethodBeat.m2505o(122154);
                return null;
            }
        }
        AppMethodBeat.m2505o(122154);
        return null;
    }
}
