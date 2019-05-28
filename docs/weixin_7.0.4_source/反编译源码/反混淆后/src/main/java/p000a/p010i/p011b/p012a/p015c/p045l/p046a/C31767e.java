package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C41447az;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.l.a.e */
public final class C31767e extends C8235ad {
    private final boolean BEI;
    private final C0158a BKv;
    final C31768f BKw;
    final C41447az BKx;
    private final C0026g Bfn;

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122721);
        C41447az k = m51447k(c0026g);
        AppMethodBeat.m2505o(122721);
        return k;
    }

    /* renamed from: d */
    public final /* synthetic */ C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122722);
        C8235ad k = m51447k(c0026g);
        AppMethodBeat.m2505o(122722);
        return k;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122724);
        C41447az sc = m51448sc(z);
        AppMethodBeat.m2505o(122724);
        return sc;
    }

    /* renamed from: rL */
    public final /* synthetic */ C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(122725);
        C8235ad sc = m51448sc(z);
        AppMethodBeat.m2505o(122725);
        return sc;
    }

    public final C0026g dYn() {
        return this.Bfn;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public C31767e(C0158a c0158a, C31768f c31768f, C41447az c41447az, C0026g c0026g, boolean z) {
        C25052j.m39376p(c0158a, "captureStatus");
        C25052j.m39376p(c31768f, "constructor");
        C25052j.m39376p(c0026g, "annotations");
        AppMethodBeat.m2504i(122726);
        this.BKv = c0158a;
        this.BKw = c31768f;
        this.BKx = c41447az;
        this.Bfn = c0026g;
        this.BEI = z;
        AppMethodBeat.m2505o(122726);
    }

    public C31767e(C0158a c0158a, C41447az c41447az, C41446ap c41446ap) {
        C25052j.m39376p(c0158a, "captureStatus");
        C25052j.m39376p(c41446ap, "projection");
        this(c0158a, new C31768f(c41446ap), c41447az);
        AppMethodBeat.m2504i(122728);
        AppMethodBeat.m2505o(122728);
    }

    public final C31746h dXR() {
        AppMethodBeat.m2504i(122719);
        C31746h cw = C25235p.m39798cw("No member resolution should be done on captured type!", true);
        C25052j.m39375o(cw, "ErrorUtils.createErrorSc…on captured type!\", true)");
        AppMethodBeat.m2505o(122719);
        return cw;
    }

    /* renamed from: k */
    private C31767e m51447k(C0026g c0026g) {
        AppMethodBeat.m2504i(122720);
        C25052j.m39376p(c0026g, "newAnnotations");
        C31767e c31767e = new C31767e(this.BKv, this.BKw, this.BKx, c0026g, this.BEI);
        AppMethodBeat.m2505o(122720);
        return c31767e;
    }

    /* renamed from: sc */
    private C31767e m51448sc(boolean z) {
        AppMethodBeat.m2504i(122723);
        C31767e c31767e = new C31767e(this.BKv, this.BKw, this.BKx, this.Bfn, z);
        AppMethodBeat.m2505o(122723);
        return c31767e;
    }

    public final List<C41446ap> ejt() {
        return C17115v.AUP;
    }

    public final /* bridge */ /* synthetic */ C17313an ejw() {
        return this.BKw;
    }
}
