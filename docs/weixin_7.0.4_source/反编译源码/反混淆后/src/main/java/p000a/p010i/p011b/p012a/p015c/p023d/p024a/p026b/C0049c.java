package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p026b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36961p;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C41404f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.b.c */
public class C0049c extends C41404f implements C17174b {
    static final /* synthetic */ boolean $assertionsDisabled = (!C0049c.class.desiredAssertionStatus());
    private Boolean Bmy = null;
    private Boolean Bmz = null;

    static {
        AppMethodBeat.m2504i(119794);
        AppMethodBeat.m2505o(119794);
    }

    /* renamed from: a */
    public final /* synthetic */ C36961p mo91a(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am) {
        AppMethodBeat.m2504i(119792);
        C0049c c = m51c(c31642l, c8083t, c8063a, c37022f, c0026g, c41398am);
        AppMethodBeat.m2505o(119792);
        return c;
    }

    /* renamed from: b */
    public final /* synthetic */ C41404f mo93b(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am) {
        AppMethodBeat.m2504i(119791);
        C0049c c = m51c(c31642l, c8083t, c8063a, c37022f, c0026g, c41398am);
        AppMethodBeat.m2505o(119791);
        return c;
    }

    private C0049c(C46865e c46865e, C0049c c0049c, C0026g c0026g, boolean z, C8063a c8063a, C41398am c41398am) {
        super(c46865e, c0049c, c0026g, z, c8063a, c41398am);
    }

    /* renamed from: a */
    public static C0049c m50a(C46865e c46865e, C0026g c0026g, boolean z, C41398am c41398am) {
        AppMethodBeat.m2504i(119785);
        C0049c c0049c = new C0049c(c46865e, null, c0026g, z, C8063a.DECLARATION, c41398am);
        AppMethodBeat.m2505o(119785);
        return c0049c;
    }

    public final boolean eaw() {
        AppMethodBeat.m2504i(119786);
        if ($assertionsDisabled || this.Bmy != null) {
            boolean booleanValue = this.Bmy.booleanValue();
            AppMethodBeat.m2505o(119786);
            return booleanValue;
        }
        AssertionError assertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(119786);
        throw assertionError;
    }

    /* renamed from: rH */
    public final void mo96rH(boolean z) {
        AppMethodBeat.m2504i(119787);
        this.Bmy = Boolean.valueOf(z);
        AppMethodBeat.m2505o(119787);
    }

    public final boolean dYW() {
        AppMethodBeat.m2504i(119788);
        if ($assertionsDisabled || this.Bmz != null) {
            boolean booleanValue = this.Bmz.booleanValue();
            AppMethodBeat.m2505o(119788);
            return booleanValue;
        }
        AssertionError assertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(119788);
        throw assertionError;
    }

    /* renamed from: rI */
    public final void mo97rI(boolean z) {
        AppMethodBeat.m2504i(119789);
        this.Bmz = Boolean.valueOf(z);
        AppMethodBeat.m2505o(119789);
    }

    /* renamed from: c */
    private C0049c m51c(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am) {
        AppMethodBeat.m2504i(119790);
        if (c8063a != C8063a.DECLARATION && c8063a != C8063a.SYNTHESIZED) {
            IllegalStateException illegalStateException = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + c31642l + "\nkind: " + c8063a);
            AppMethodBeat.m2505o(119790);
            throw illegalStateException;
        } else if ($assertionsDisabled || c37022f == null) {
            C0049c c0049c = new C0049c((C46865e) c31642l, (C0049c) c8083t, c0026g, this.hEK, c8063a, c41398am);
            c0049c.mo96rH(eaw());
            c0049c.mo97rI(dYW());
            AppMethodBeat.m2505o(119790);
            return c0049c;
        } else {
            AssertionError assertionError = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.m2505o(119790);
            throw assertionError;
        }
    }
}
