package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import p000a.C0219k;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.a.j */
public final class C46864j implements C44869c {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C46864j.class), "type", "getType()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    private final C44856f BfN = C17344i.m26853a(C0219k.PUBLICATION, new C8042a(this));
    private final C31619g BfO;
    final C8174b BfP;
    private final Map<C37022f, C41432f<?>> BfQ;

    /* renamed from: a.i.b.a.c.b.a.j$a */
    static final class C8042a extends C25053k implements C31214a<C8235ad> {
        final /* synthetic */ C46864j BfR;

        C8042a(C46864j c46864j) {
            this.BfR = c46864j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(119343);
            C46865e c = this.BfR.BfO.mo51611c(this.BfR.BfP);
            C25052j.m39375o(c, "builtIns.getBuiltInClassByFqName(fqName)");
            C8235ad dZf = c.dZf();
            AppMethodBeat.m2505o(119343);
            return dZf;
        }
    }

    static {
        AppMethodBeat.m2504i(119344);
        AppMethodBeat.m2505o(119344);
    }

    public final C46867w dZS() {
        AppMethodBeat.m2504i(119345);
        C46867w c46867w = (C46867w) this.BfN.getValue();
        AppMethodBeat.m2505o(119345);
        return c46867w;
    }

    public C46864j(C31619g c31619g, C8174b c8174b, Map<C37022f, ? extends C41432f<?>> map) {
        C25052j.m39376p(c31619g, "builtIns");
        C25052j.m39376p(c8174b, "fqName");
        C25052j.m39376p(map, "allValueArguments");
        AppMethodBeat.m2504i(119347);
        this.BfO = c31619g;
        this.BfP = c8174b;
        this.BfQ = map;
        AppMethodBeat.m2505o(119347);
    }

    public final C8174b dZF() {
        return this.BfP;
    }

    public final Map<C37022f, C41432f<?>> eah() {
        return this.BfQ;
    }

    public final C41398am dYo() {
        AppMethodBeat.m2504i(119346);
        C41398am c41398am = C41398am.BeR;
        C25052j.m39375o(c41398am, "SourceElement.NO_SOURCE");
        AppMethodBeat.m2505o(119346);
        return c41398am;
    }
}
