package p000a.p010i.p011b.p012a.p015c.p045l;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p036h.C0125i;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;

/* renamed from: a.i.b.a.c.l.s */
public final class C37058s extends C17325q implements C25230aw {
    private final C17325q BJC;
    private final C46867w BJD;

    public final C46867w ekl() {
        return this.BJD;
    }

    /* renamed from: a */
    public final String mo31390a(C31724c c31724c, C0125i c0125i) {
        AppMethodBeat.m2504i(122588);
        C25052j.m39376p(c31724c, "renderer");
        C25052j.m39376p(c0125i, "options");
        String b;
        if (c0125i.eiT()) {
            b = c31724c.mo13665b(this.BJD);
            AppMethodBeat.m2505o(122588);
            return b;
        }
        b = this.BJC.mo31390a(c31724c, c0125i);
        AppMethodBeat.m2505o(122588);
        return b;
    }

    /* renamed from: b */
    public final C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122586);
        C25052j.m39376p(c0026g, "newAnnotations");
        C41447az b = C25231ax.m39780b(this.BJC.mo18029b(c0026g), this.BJD);
        AppMethodBeat.m2505o(122586);
        return b;
    }

    /* renamed from: rK */
    public final C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122587);
        C41447az b = C25231ax.m39780b(this.BJC.mo18032rK(z), this.BJD.ekn().mo18032rK(z));
        AppMethodBeat.m2505o(122587);
        return b;
    }

    public final C8235ad eby() {
        AppMethodBeat.m2504i(122589);
        C8235ad eby = this.BJC.eby();
        AppMethodBeat.m2505o(122589);
        return eby;
    }

    public final /* bridge */ /* synthetic */ C41447az ekk() {
        return this.BJC;
    }

    public C37058s(C17325q c17325q, C46867w c46867w) {
        C25052j.m39376p(c17325q, C8741b.ORIGIN);
        C25052j.m39376p(c46867w, "enhancement");
        super(c17325q.BJx, c17325q.BJy);
        AppMethodBeat.m2504i(122590);
        this.BJC = c17325q;
        this.BJD = c46867w;
        AppMethodBeat.m2505o(122590);
    }
}
