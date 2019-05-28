package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;

/* renamed from: a.i.b.a.c.l.aj */
public final class C44921aj extends C8235ad {
    private final boolean BEI;
    private final C17313an BJO;
    private final C17313an BJm;
    private final C31746h BiC;

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122639);
        C41447az d = mo18030d(c0026g);
        AppMethodBeat.m2505o(122639);
        return d;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122641);
        C41447az rL = mo18033rL(z);
        AppMethodBeat.m2505o(122641);
        return rL;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public final C17313an ejw() {
        return this.BJm;
    }

    public final C31746h dXR() {
        return this.BiC;
    }

    private C44921aj(C17313an c17313an, boolean z, C17313an c17313an2, C31746h c31746h) {
        C25052j.m39376p(c17313an, "originalTypeVariable");
        C25052j.m39376p(c17313an2, "constructor");
        C25052j.m39376p(c31746h, "memberScope");
        AppMethodBeat.m2504i(122643);
        this.BJO = c17313an;
        this.BEI = z;
        this.BJm = c17313an2;
        this.BiC = c31746h;
        AppMethodBeat.m2505o(122643);
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(122637);
        C0027a c0027a = C0026g.BfJ;
        C0026g eai = C0027a.eai();
        AppMethodBeat.m2505o(122637);
        return eai;
    }

    /* renamed from: d */
    public final C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122638);
        C25052j.m39376p(c0026g, "newAnnotations");
        Throwable illegalStateException = new IllegalStateException("Shouldn't be called on non-fixed type".toString());
        AppMethodBeat.m2505o(122638);
        throw illegalStateException;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122642);
        String str = "NonFixed: " + this.BJO;
        AppMethodBeat.m2505o(122642);
        return str;
    }

    public final List<C41446ap> ejt() {
        return C17115v.AUP;
    }

    /* renamed from: rL */
    public final C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(122640);
        if (z == this.BEI) {
            C8235ad c8235ad = this;
            AppMethodBeat.m2505o(122640);
            return c8235ad;
        }
        C8235ad c44921aj = new C44921aj(this.BJO, z, this.BJm, this.BiC);
        AppMethodBeat.m2505o(122640);
        return c44921aj;
    }
}
