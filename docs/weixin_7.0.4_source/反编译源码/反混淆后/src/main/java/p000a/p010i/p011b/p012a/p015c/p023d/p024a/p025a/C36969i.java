package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import p000a.C8312u;
import p000a.p001a.C16480af;
import p000a.p001a.C25033k;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C17188e;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36983b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8116m;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C41432f;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.a.i */
public final class C36969i extends C0040b {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C36969i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final C41441f Bmk;

    /* renamed from: a.i.b.a.c.d.a.a.i$a */
    static final class C8090a extends C25053k implements C31214a<Map<C37022f, ? extends C41432f<?>>> {
        final /* synthetic */ C36969i Bmp;

        C8090a(C36969i c36969i) {
            this.Bmp = c36969i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object fW;
            AppMethodBeat.m2504i(119775);
            C36983b c36983b = this.Bmp.BlS;
            C8088d c8088d;
            if (c36983b instanceof C17188e) {
                c8088d = C8088d.Bmi;
                fW = C8088d.m14278fW(((C17188e) this.Bmp.BlS).ebD());
            } else if (c36983b instanceof C8116m) {
                c8088d = C8088d.Bmi;
                fW = C8088d.m14278fW(C25033k.listOf(this.Bmp.BlS));
            } else {
                fW = null;
            }
            if (fW != null) {
                C0042c c0042c = C0042c.Bmf;
                fW = C16480af.m25284a(C8312u.m14628I(C0042c.ebj(), fW));
            } else {
                fW = null;
            }
            if (fW == null) {
                fW = C31586ag.emptyMap();
            }
            AppMethodBeat.m2505o(119775);
            return fW;
        }
    }

    static {
        AppMethodBeat.m2504i(119776);
        AppMethodBeat.m2505o(119776);
    }

    public final Map<C37022f, C41432f<?>> eah() {
        AppMethodBeat.m2504i(119777);
        Map map = (Map) C17310h.m26799a(this.Bmk, eQB[0]);
        AppMethodBeat.m2505o(119777);
        return map;
    }

    public C36969i(C41408a c41408a, C0057h c0057h) {
        C25052j.m39376p(c41408a, "annotation");
        C25052j.m39376p(c0057h, "c");
        C8174b c8174b = C31619g.Bag.BaQ;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.target");
        super(c0057h, c41408a, c8174b);
        AppMethodBeat.m2504i(119778);
        this.Bmk = c0057h.Bnv.Baf.mo31373i(new C8090a(this));
        AppMethodBeat.m2505o(119778);
    }
}
