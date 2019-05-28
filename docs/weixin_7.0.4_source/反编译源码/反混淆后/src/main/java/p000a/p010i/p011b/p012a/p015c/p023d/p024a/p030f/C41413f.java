package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C17321f;
import p000a.p010i.p011b.p012a.p015c.p045l.C17324i;
import p000a.p010i.p011b.p012a.p015c.p045l.C17325q;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25231ax;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;

/* renamed from: a.i.b.a.c.d.a.f.f */
public final class C41413f extends C17324i implements C17321f {
    private final C8235ad BpK;

    public C41413f(C8235ad c8235ad) {
        C25052j.m39376p(c8235ad, "delegate");
        AppMethodBeat.m2504i(120105);
        this.BpK = c8235ad;
        AppMethodBeat.m2505o(120105);
    }

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(120101);
        C41447az c = m72225c(c0026g);
        AppMethodBeat.m2505o(120101);
        return c;
    }

    /* renamed from: d */
    public final /* synthetic */ C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(120102);
        C8235ad c = m72225c(c0026g);
        AppMethodBeat.m2505o(120102);
        return c;
    }

    public final C8235ad eby() {
        return this.BpK;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(120104);
        C41447az rL = mo18033rL(z);
        AppMethodBeat.m2505o(120104);
        return rL;
    }

    public final boolean ech() {
        return true;
    }

    /* renamed from: R */
    public final C46867w mo31384R(C46867w c46867w) {
        AppMethodBeat.m2504i(120098);
        C25052j.m39376p(c46867w, "replacement");
        C41447az ekn = c46867w.ekn();
        C46867w a;
        if (!C17316av.m26813aB(ekn) && !C41448a.m72313aE(ekn)) {
            C46867w c46867w2 = ekn;
            AppMethodBeat.m2505o(120098);
            return c46867w2;
        } else if (ekn instanceof C8235ad) {
            a = C41413f.m72224a((C8235ad) ekn);
            AppMethodBeat.m2505o(120098);
            return a;
        } else if (ekn instanceof C17325q) {
            a = C25231ax.m39780b(C17326x.m26839a(C41413f.m72224a(((C17325q) ekn).BJx), C41413f.m72224a(((C17325q) ekn).BJy)), C25231ax.m39779aG(ekn));
            AppMethodBeat.m2505o(120098);
            return a;
        } else {
            Throwable illegalStateException = new IllegalStateException("Incorrect type: ".concat(String.valueOf(ekn)).toString());
            AppMethodBeat.m2505o(120098);
            throw illegalStateException;
        }
    }

    public final boolean eci() {
        return false;
    }

    /* renamed from: a */
    private static C8235ad m72224a(C8235ad c8235ad) {
        AppMethodBeat.m2504i(120099);
        C8235ad rL = c8235ad.mo18033rL(false);
        if (C41448a.m72313aE(c8235ad)) {
            C8235ad c41413f = new C41413f(rL);
            AppMethodBeat.m2505o(120099);
            return c41413f;
        }
        AppMethodBeat.m2505o(120099);
        return rL;
    }

    /* renamed from: c */
    private C41413f m72225c(C0026g c0026g) {
        AppMethodBeat.m2504i(120100);
        C25052j.m39376p(c0026g, "newAnnotations");
        C41413f c41413f = new C41413f(this.BpK.mo18030d(c0026g));
        AppMethodBeat.m2505o(120100);
        return c41413f;
    }

    /* renamed from: rL */
    public final C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(120103);
        C8235ad rL;
        if (z) {
            rL = this.BpK.mo18033rL(true);
            AppMethodBeat.m2505o(120103);
            return rL;
        }
        rL = this;
        AppMethodBeat.m2505o(120103);
        return rL;
    }
}
