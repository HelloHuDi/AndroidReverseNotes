package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p.C25233b;

/* renamed from: a.i.b.a.c.l.ae */
final class C25223ae extends C8235ad {
    private final boolean BEI;
    private final C17313an BJm;
    private final List<C41446ap> BeP;
    private final C31746h BiC;

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122619);
        C41447az d = mo18030d(c0026g);
        AppMethodBeat.m2505o(122619);
        return d;
    }

    /* renamed from: rK */
    public final /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122621);
        C41447az rL = mo18033rL(z);
        AppMethodBeat.m2505o(122621);
        return rL;
    }

    public final C17313an ejw() {
        return this.BJm;
    }

    public final List<C41446ap> ejt() {
        return this.BeP;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public final C31746h dXR() {
        return this.BiC;
    }

    public C25223ae(C17313an c17313an, List<? extends C41446ap> list, boolean z, C31746h c31746h) {
        C25052j.m39376p(c17313an, "constructor");
        C25052j.m39376p(list, "arguments");
        C25052j.m39376p(c31746h, "memberScope");
        AppMethodBeat.m2504i(122622);
        this.BJm = c17313an;
        this.BeP = list;
        this.BEI = z;
        this.BiC = c31746h;
        if (this.BiC instanceof C25233b) {
            Throwable illegalStateException = new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.BiC + 10 + this.BJm);
            AppMethodBeat.m2505o(122622);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(122622);
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(122617);
        C0027a c0027a = C0026g.BfJ;
        C0026g eai = C0027a.eai();
        AppMethodBeat.m2505o(122617);
        return eai;
    }

    /* renamed from: d */
    public final C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122618);
        C25052j.m39376p(c0026g, "newAnnotations");
        if (c0026g.isEmpty()) {
            C8235ad c8235ad = this;
            AppMethodBeat.m2505o(122618);
            return c8235ad;
        }
        C8235ad c41452d = new C41452d(this, c0026g);
        AppMethodBeat.m2505o(122618);
        return c41452d;
    }

    /* renamed from: rL */
    public final C8235ad mo18033rL(boolean z) {
        C24624j c24624j;
        AppMethodBeat.m2504i(122620);
        if (z == this.BEI) {
            c24624j = this;
        } else if (z) {
            c24624j = new C37051ab(this);
        } else {
            c24624j = new C31770aa(this);
        }
        C8235ad c8235ad = c24624j;
        AppMethodBeat.m2505o(122620);
        return c8235ad;
    }
}
