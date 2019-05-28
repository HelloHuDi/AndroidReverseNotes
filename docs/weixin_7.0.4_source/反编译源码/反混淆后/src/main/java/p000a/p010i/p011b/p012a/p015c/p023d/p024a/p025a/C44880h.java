package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import p000a.C8312u;
import p000a.p001a.C16480af;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.a.h */
public final class C44880h extends C0040b {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C44880h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final C41441f Bmk;

    /* renamed from: a.i.b.a.c.d.a.a.h$a */
    static final class C0044a extends C25053k implements C31214a<Map<C37022f, ? extends C41432f<?>>> {
        final /* synthetic */ C44880h Bmo;

        C0044a(C44880h c44880h) {
            this.Bmo = c44880h;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object a;
            AppMethodBeat.m2504i(119771);
            C8088d c8088d = C8088d.Bmi;
            C41432f a2 = C8088d.m14277a(this.Bmo.BlS);
            if (a2 != null) {
                C0042c c0042c = C0042c.Bmf;
                a = C16480af.m25284a(C8312u.m14628I(C0042c.ebk(), a2));
            } else {
                a = null;
            }
            if (a == null) {
                a = C31586ag.emptyMap();
            }
            AppMethodBeat.m2505o(119771);
            return a;
        }
    }

    static {
        AppMethodBeat.m2504i(119772);
        AppMethodBeat.m2505o(119772);
    }

    public final Map<C37022f, C41432f<?>> eah() {
        AppMethodBeat.m2504i(119773);
        Map map = (Map) C17310h.m26799a(this.Bmk, eQB[0]);
        AppMethodBeat.m2505o(119773);
        return map;
    }

    public C44880h(C41408a c41408a, C0057h c0057h) {
        C25052j.m39376p(c41408a, "annotation");
        C25052j.m39376p(c0057h, "c");
        C8174b c8174b = C31619g.Bag.BaT;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.retention");
        super(c0057h, c41408a, c8174b);
        AppMethodBeat.m2504i(119774);
        this.Bmk = c0057h.Bnv.Baf.mo31373i(new C0044a(this));
        AppMethodBeat.m2505o(119774);
    }
}
