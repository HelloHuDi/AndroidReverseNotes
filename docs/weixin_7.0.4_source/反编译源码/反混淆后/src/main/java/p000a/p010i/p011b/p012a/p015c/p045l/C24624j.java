package p000a.p010i.p011b.p012a.p015c.p045l;

import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;

/* renamed from: a.i.b.a.c.l.j */
public abstract class C24624j extends C17324i {
    private final C8235ad BpK;

    public C24624j(C8235ad c8235ad) {
        C25052j.m39376p(c8235ad, "delegate");
        this.BpK = c8235ad;
    }

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        return m38308i(c0026g);
    }

    /* renamed from: d */
    public final /* synthetic */ C8235ad mo18030d(C0026g c0026g) {
        return m38308i(c0026g);
    }

    /* Access modifiers changed, original: protected|final */
    public final C8235ad eby() {
        return this.BpK;
    }

    /* renamed from: i */
    private C24624j m38308i(C0026g c0026g) {
        C25052j.m39376p(c0026g, "newAnnotations");
        if (c0026g != dYn()) {
            return new C41452d(this, c0026g);
        }
        return this;
    }

    /* renamed from: rL */
    public final C8235ad mo18032rK(boolean z) {
        if (z == eci()) {
            return this;
        }
        return this.BpK.mo18033rL(z).mo18030d(dYn());
    }
}
