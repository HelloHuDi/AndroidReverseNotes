package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;

/* renamed from: a.i.b.a.c.l.af */
public final class C8236af extends C17324i implements C25230aw {
    private final C46867w BJD;
    private final C8235ad BpK;

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122624);
        C41447az d = mo18030d(c0026g);
        AppMethodBeat.m2505o(122624);
        return d;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122626);
        C41447az rL = mo18033rL(z);
        AppMethodBeat.m2505o(122626);
        return rL;
    }

    /* Access modifiers changed, original: protected|final */
    public final C8235ad eby() {
        return this.BpK;
    }

    public final C46867w ekl() {
        return this.BJD;
    }

    public C8236af(C8235ad c8235ad, C46867w c46867w) {
        C25052j.m39376p(c8235ad, "delegate");
        C25052j.m39376p(c46867w, "enhancement");
        AppMethodBeat.m2504i(122627);
        this.BpK = c8235ad;
        this.BJD = c46867w;
        AppMethodBeat.m2505o(122627);
    }

    public final C41447az ekk() {
        return this.BpK;
    }

    /* renamed from: d */
    public final C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122623);
        C25052j.m39376p(c0026g, "newAnnotations");
        C41447az b = C25231ax.m39780b(this.BpK.mo18029b(c0026g), this.BJD);
        if (b == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.m2505o(122623);
            throw c44941v;
        }
        C8235ad c8235ad = (C8235ad) b;
        AppMethodBeat.m2505o(122623);
        return c8235ad;
    }

    /* renamed from: rL */
    public final C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(122625);
        C41447az b = C25231ax.m39780b(this.BpK.mo18032rK(z), this.BJD.ekn().mo18032rK(z));
        if (b == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.m2505o(122625);
            throw c44941v;
        }
        C8235ad c8235ad = (C8235ad) b;
        AppMethodBeat.m2505o(122625);
        return c8235ad;
    }
}
