package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36983b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.a.b */
public class C0040b implements C44869c {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C0040b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    final C8174b BfP;
    private final C41398am Bfq;
    private final C41441f BlR;
    final C36983b BlS;

    /* renamed from: a.i.b.a.c.d.a.a.b$a */
    static final class C0041a extends C25053k implements C31214a<C8235ad> {
        final /* synthetic */ C0040b BlT;
        final /* synthetic */ C0057h BlU;

        C0041a(C0040b c0040b, C0057h c0057h) {
            this.BlT = c0040b;
            this.BlU = c0057h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119751);
            C46865e c = this.BlU.Bnv.BcH.dZD().mo51611c(this.BlT.BfP);
            C25052j.m39375o(c, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
            C8235ad dZf = c.dZf();
            AppMethodBeat.m2505o(119751);
            return dZf;
        }
    }

    static {
        AppMethodBeat.m2504i(119752);
        AppMethodBeat.m2505o(119752);
    }

    public C0040b(C0057h c0057h, C41408a c41408a, C8174b c8174b) {
        C41398am a;
        C0040b c0040b;
        C25052j.m39376p(c0057h, "c");
        C25052j.m39376p(c8174b, "fqName");
        AppMethodBeat.m2504i(119755);
        this.BfP = c8174b;
        if (c41408a != null) {
            a = c0057h.Bnv.BmZ.mo58984a(c41408a);
            c0040b = this;
        } else {
            a = C41398am.BeR;
            C25052j.m39375o(a, "SourceElement.NO_SOURCE");
            c0040b = this;
        }
        c0040b.Bfq = a;
        this.BlR = c0057h.Bnv.Baf.mo31373i(new C0041a(this, c0057h));
        this.BlS = c41408a != null ? (C36983b) C25035t.m39336f(c41408a.ebz()) : null;
        AppMethodBeat.m2505o(119755);
    }

    public final C8174b dZF() {
        return this.BfP;
    }

    public final C41398am dYo() {
        return this.Bfq;
    }

    public Map<C37022f, C41432f<?>> eah() {
        AppMethodBeat.m2504i(119754);
        Map emptyMap = C31586ag.emptyMap();
        AppMethodBeat.m2505o(119754);
        return emptyMap;
    }

    public final /* synthetic */ C46867w dZS() {
        AppMethodBeat.m2504i(119753);
        C46867w c46867w = (C8235ad) C17310h.m26799a(this.BlR, eQB[0]);
        AppMethodBeat.m2505o(119753);
        return c46867w;
    }
}
