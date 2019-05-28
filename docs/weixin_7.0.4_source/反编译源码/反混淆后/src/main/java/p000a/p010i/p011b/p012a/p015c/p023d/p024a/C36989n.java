package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36652p;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C0131e;

/* renamed from: a.i.b.a.c.d.a.n */
public final class C36989n {
    public static final C25082az Blg = new C25082az("package") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119701);
            boolean c = C36989n.m61774c(c36652p, c31642l);
            AppMethodBeat.m2505o(119701);
            return c;
        }

        /* renamed from: c */
        public final Integer mo31293c(C25082az c25082az) {
            AppMethodBeat.m2504i(119702);
            Integer valueOf;
            if (this == c25082az) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(119702);
                return valueOf;
            } else if (C8051ay.m14226b(c25082az)) {
                valueOf = Integer.valueOf(1);
                AppMethodBeat.m2505o(119702);
                return valueOf;
            } else {
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.m2505o(119702);
                return valueOf;
            }
        }

        public final String getDisplayName() {
            return "public/*package*/";
        }

        public final C25082az eag() {
            return C8051ay.BeY;
        }
    };
    public static final C25082az Blh = new C25082az("protected_static") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119703);
            boolean c = C36989n.m61775c(c0131e, c36652p, c31642l);
            AppMethodBeat.m2505o(119703);
            return c;
        }

        public final String getDisplayName() {
            return "protected/*protected static*/";
        }

        public final C25082az eag() {
            return C8051ay.BeY;
        }
    };
    public static final C25082az Bli = new C25082az("protected_and_package") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119704);
            boolean c = C36989n.m61775c(c0131e, c36652p, c31642l);
            AppMethodBeat.m2505o(119704);
            return c;
        }

        /* renamed from: c */
        public final Integer mo31293c(C25082az c25082az) {
            AppMethodBeat.m2504i(119705);
            Integer valueOf;
            if (this == c25082az) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(119705);
                return valueOf;
            } else if (c25082az == C8051ay.BeZ) {
                AppMethodBeat.m2505o(119705);
                return null;
            } else if (C8051ay.m14226b(c25082az)) {
                valueOf = Integer.valueOf(1);
                AppMethodBeat.m2505o(119705);
                return valueOf;
            } else {
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.m2505o(119705);
                return valueOf;
            }
        }

        public final String getDisplayName() {
            return "protected/*protected and package*/";
        }

        public final C25082az eag() {
            return C8051ay.BeY;
        }
    };

    /* renamed from: c */
    static /* synthetic */ boolean m61774c(C31642l c31642l, C31642l c31642l2) {
        AppMethodBeat.m2504i(119707);
        boolean b = C36989n.m61773b(c31642l, c31642l2);
        AppMethodBeat.m2505o(119707);
        return b;
    }

    static {
        AppMethodBeat.m2504i(119709);
        AppMethodBeat.m2505o(119709);
    }

    /* renamed from: b */
    private static boolean m61773b(C31642l c31642l, C31642l c31642l2) {
        AppMethodBeat.m2504i(119706);
        C36953ab c36953ab = (C36953ab) C8203d.m14472a(c31642l, C36953ab.class, false);
        C36953ab c36953ab2 = (C36953ab) C8203d.m14472a(c31642l2, C36953ab.class, false);
        if (c36953ab2 == null || c36953ab == null || !c36953ab.dZF().equals(c36953ab2.dZF())) {
            AppMethodBeat.m2505o(119706);
            return false;
        }
        AppMethodBeat.m2505o(119706);
        return true;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m61775c(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
        AppMethodBeat.m2504i(119708);
        if (C36989n.m61773b(C8203d.m14473a(c36652p), c31642l)) {
            AppMethodBeat.m2505o(119708);
            return true;
        }
        boolean b = C8051ay.BeY.mo17859b(c0131e, c36652p, c31642l);
        AppMethodBeat.m2505o(119708);
        return b;
    }
}
