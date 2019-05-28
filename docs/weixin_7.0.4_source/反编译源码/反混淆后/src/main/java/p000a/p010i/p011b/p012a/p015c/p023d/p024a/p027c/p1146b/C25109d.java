package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C25096l;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C37052ai;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C44836ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C44920ah;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.c.b.d */
public final class C25109d {
    private static final C8174b Bpm = new C8174b("java.lang.Class");

    /* renamed from: a.i.b.a.c.d.a.c.b.d$a */
    static final class C25110a extends C25053k implements C31214a<C8235ad> {
        final /* synthetic */ C36955ar Bpn;

        C25110a(C36955ar c36955ar) {
            this.Bpn = c36955ar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(120050);
            C8235ad awn = C25235p.awn("Can't compute erased upper bound of type parameter `" + this.Bpn + '`');
            C25052j.m39375o(awn, "ErrorUtils.createErrorTy… type parameter `$this`\")");
            AppMethodBeat.m2505o(120050);
            return awn;
        }
    }

    static {
        AppMethodBeat.m2504i(120055);
        AppMethodBeat.m2505o(120055);
    }

    /* renamed from: a */
    public static /* synthetic */ C17179a m39487a(C25096l c25096l, boolean z, C36955ar c36955ar, int i) {
        AppMethodBeat.m2504i(120052);
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            c36955ar = null;
        }
        C25052j.m39376p(c25096l, "receiver$0");
        C17179a c17179a = new C17179a(c25096l, z, c36955ar);
        AppMethodBeat.m2505o(120052);
        return c17179a;
    }

    /* renamed from: b */
    public static /* synthetic */ C46867w m39490b(C36955ar c36955ar) {
        AppMethodBeat.m2504i(120054);
        C46867w a = C25109d.m39489a(c36955ar, null, new C25110a(c36955ar));
        AppMethodBeat.m2505o(120054);
        return a;
    }

    /* renamed from: a */
    public static final C46867w m39489a(C36955ar c36955ar, C36955ar c36955ar2, C31214a<? extends C46867w> c31214a) {
        AppMethodBeat.m2504i(120053);
        C25052j.m39376p(c36955ar, "receiver$0");
        C25052j.m39376p(c31214a, "defaultValue");
        C46867w c46867w;
        if (c36955ar == c36955ar2) {
            c46867w = (C46867w) c31214a.invoke();
            AppMethodBeat.m2505o(120053);
            return c46867w;
        }
        List dWP = c36955ar.dWP();
        C25052j.m39375o(dWP, "upperBounds");
        c46867w = (C46867w) C25035t.m39337fJ(dWP);
        if (c46867w.ejw().dYs() instanceof C46865e) {
            C25052j.m39375o(c46867w, "firstUpperBound");
            c46867w = C41448a.m72316aN(c46867w);
            AppMethodBeat.m2505o(120053);
            return c46867w;
        }
        if (c36955ar2 != null) {
            c36955ar = c36955ar2;
        }
        C0036h dYs = c46867w.ejw().dYs();
        C44941v c44941v;
        if (dYs == null) {
            c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            AppMethodBeat.m2505o(120053);
            throw c44941v;
        }
        while (true) {
            C36955ar c36955ar3 = (C36955ar) dYs;
            if ((C25052j.m39373j(c36955ar3, c36955ar) ^ 1) != 0) {
                dWP = c36955ar3.dWP();
                C25052j.m39375o(dWP, "current.upperBounds");
                c46867w = (C46867w) C25035t.m39337fJ(dWP);
                if (c46867w.ejw().dYs() instanceof C46865e) {
                    C25052j.m39375o(c46867w, "nextUpperBound");
                    c46867w = C41448a.m72316aN(c46867w);
                    AppMethodBeat.m2505o(120053);
                    return c46867w;
                }
                dYs = c46867w.ejw().dYs();
                if (dYs == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    AppMethodBeat.m2505o(120053);
                    throw c44941v;
                }
            } else {
                c46867w = (C46867w) c31214a.invoke();
                AppMethodBeat.m2505o(120053);
                return c46867w;
            }
        }
    }

    /* renamed from: a */
    public static final C41446ap m39488a(C36955ar c36955ar, C17179a c17179a) {
        AppMethodBeat.m2504i(120051);
        C25052j.m39376p(c36955ar, "typeParameter");
        C25052j.m39376p(c17179a, "attr");
        C41446ap c44836ar;
        if (c17179a.BoW == C25096l.SUPERTYPE) {
            c44836ar = new C44836ar(C37052ai.m62005d(c36955ar));
            AppMethodBeat.m2505o(120051);
            return c44836ar;
        }
        c44836ar = new C44920ah(c36955ar);
        AppMethodBeat.m2505o(120051);
        return c44836ar;
    }
}
