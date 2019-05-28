package p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C41445ak;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;

/* renamed from: a.i.b.a.c.i.a.a.a */
public final class C44636a extends C8235ad implements C41445ak {
    private final C41446ap BEG;
    private final C41430b BEH;
    private final boolean BEI;
    private final C0026g Bfn;

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122052);
        C41447az e = m81059e(c0026g);
        AppMethodBeat.m2505o(122052);
        return e;
    }

    /* renamed from: d */
    public final /* synthetic */ C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122053);
        C8235ad e = m81059e(c0026g);
        AppMethodBeat.m2505o(122053);
        return e;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122049);
        C41447az rY = m81060rY(z);
        AppMethodBeat.m2505o(122049);
        return rY;
    }

    /* renamed from: rL */
    public final /* synthetic */ C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(122050);
        C8235ad rY = m81060rY(z);
        AppMethodBeat.m2505o(122050);
        return rY;
    }

    public /* synthetic */ C44636a(C41446ap c41446ap) {
        C41430b c41430b = new C41430b(c41446ap);
        C0027a c0027a = C0026g.BfJ;
        this(c41446ap, c41430b, false, C0027a.eai());
        AppMethodBeat.m2504i(122055);
        AppMethodBeat.m2505o(122055);
    }

    public final boolean eci() {
        return this.BEI;
    }

    public final C0026g dYn() {
        return this.Bfn;
    }

    private C44636a(C41446ap c41446ap, C41430b c41430b, boolean z, C0026g c0026g) {
        C25052j.m39376p(c41446ap, "typeProjection");
        C25052j.m39376p(c41430b, "constructor");
        C25052j.m39376p(c0026g, "annotations");
        AppMethodBeat.m2504i(122054);
        this.BEG = c41446ap;
        this.BEH = c41430b;
        this.BEI = z;
        this.Bfn = c0026g;
        AppMethodBeat.m2505o(122054);
    }

    public final C31746h dXR() {
        AppMethodBeat.m2504i(122042);
        C31746h cw = C25235p.m39798cw("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        C25052j.m39375o(cw, "ErrorUtils.createErrorSc…system resolution\", true)");
        AppMethodBeat.m2505o(122042);
        return cw;
    }

    public final C46867w eju() {
        AppMethodBeat.m2504i(122043);
        C0163ba c0163ba = C0163ba.OUT_VARIANCE;
        C8235ad dXN = C41448a.m72314aL(this).dXN();
        C25052j.m39375o(dXN, "builtIns.nullableAnyType");
        C46867w b = m81058b(c0163ba, dXN);
        AppMethodBeat.m2505o(122043);
        return b;
    }

    public final C46867w ejv() {
        AppMethodBeat.m2504i(122044);
        C0163ba c0163ba = C0163ba.IN_VARIANCE;
        C8235ad dXL = C41448a.m72314aL(this).dXL();
        C25052j.m39375o(dXL, "builtIns.nothingType");
        C46867w b = m81058b(c0163ba, dXL);
        AppMethodBeat.m2505o(122044);
        return b;
    }

    /* renamed from: b */
    private final C46867w m81058b(C0163ba c0163ba, C46867w c46867w) {
        Object c46867w2;
        AppMethodBeat.m2504i(122045);
        if (this.BEG.ekq() == c0163ba) {
            c46867w2 = this.BEG.dZS();
        }
        C25052j.m39375o(c46867w2, "if (typeProjection.proje…jection.type else default");
        AppMethodBeat.m2505o(122045);
        return c46867w2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122047);
        String str = "Captured(" + this.BEG + ')' + (this.BEI ? "?" : "");
        AppMethodBeat.m2505o(122047);
        return str;
    }

    /* renamed from: e */
    private C44636a m81059e(C0026g c0026g) {
        AppMethodBeat.m2504i(122051);
        C25052j.m39376p(c0026g, "newAnnotations");
        C44636a c44636a = new C44636a(this.BEG, this.BEH, this.BEI, c0026g);
        AppMethodBeat.m2505o(122051);
        return c44636a;
    }

    public final List<C41446ap> ejt() {
        return C17115v.AUP;
    }

    /* renamed from: ad */
    public final boolean mo31391ad(C46867w c46867w) {
        AppMethodBeat.m2504i(122046);
        C25052j.m39376p(c46867w, "type");
        if (this.BEH == c46867w.ejw()) {
            AppMethodBeat.m2505o(122046);
            return true;
        }
        AppMethodBeat.m2505o(122046);
        return false;
    }

    /* renamed from: rY */
    private C44636a m81060rY(boolean z) {
        AppMethodBeat.m2504i(122048);
        if (z == this.BEI) {
            AppMethodBeat.m2505o(122048);
            return this;
        }
        C44636a c44636a = new C44636a(this.BEG, this.BEH, z, this.Bfn);
        AppMethodBeat.m2505o(122048);
        return c44636a;
    }

    public final /* bridge */ /* synthetic */ C17313an ejw() {
        return this.BEH;
    }
}
