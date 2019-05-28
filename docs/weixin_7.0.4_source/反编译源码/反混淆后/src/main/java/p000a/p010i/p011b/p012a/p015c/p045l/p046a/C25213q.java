package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17312am;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C44924t;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.l.a.q */
public class C25213q {
    static final /* synthetic */ boolean $assertionsDisabled = (!C25213q.class.desiredAssertionStatus());
    private final C8233r BKW;

    /* renamed from: a.i.b.a.c.l.a.q$a */
    public enum C0161a {
        IN,
        OUT,
        INV,
        STAR;

        static {
            AppMethodBeat.m2505o(122790);
        }

        /* renamed from: a */
        public static C0161a m285a(C0163ba c0163ba) {
            AppMethodBeat.m2504i(122789);
            C0161a c0161a;
            switch (C252141.BKX[c0163ba.ordinal()]) {
                case 1:
                    c0161a = INV;
                    AppMethodBeat.m2505o(122789);
                    return c0161a;
                case 2:
                    c0161a = IN;
                    AppMethodBeat.m2505o(122789);
                    return c0161a;
                case 3:
                    c0161a = OUT;
                    AppMethodBeat.m2505o(122789);
                    return c0161a;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unknown variance");
                    AppMethodBeat.m2505o(122789);
                    throw illegalStateException;
            }
        }
    }

    /* renamed from: a.i.b.a.c.l.a.q$1 */
    static /* synthetic */ class C252141 {
        static final /* synthetic */ int[] BKX = new int[C0163ba.values().length];

        static {
            AppMethodBeat.m2504i(122786);
            try {
                BKX[C0163ba.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                BKX[C0163ba.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                BKX[C0163ba.OUT_VARIANCE.ordinal()] = 3;
                AppMethodBeat.m2505o(122786);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(122786);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(122801);
        AppMethodBeat.m2505o(122801);
    }

    /* renamed from: e */
    public static C46867w m39735e(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122791);
        C46867w a = C25221t.m39749a(c46867w, c46867w2, new C37050p());
        AppMethodBeat.m2505o(122791);
        return a;
    }

    /* renamed from: a */
    private static C46867w m39731a(C36955ar c36955ar, C41446ap c41446ap) {
        AppMethodBeat.m2504i(122792);
        Object obj = (c41446ap.ekq() == C0163ba.IN_VARIANCE || c36955ar.dZh() == C0163ba.IN_VARIANCE) ? 1 : null;
        if (obj != null) {
            C8235ad dXN = C41434a.m72275G(c36955ar).dXN();
            AppMethodBeat.m2505o(122792);
            return dXN;
        }
        C46867w dZS = c41446ap.dZS();
        AppMethodBeat.m2505o(122792);
        return dZS;
    }

    /* renamed from: b */
    private static C46867w m39733b(C36955ar c36955ar, C41446ap c41446ap) {
        AppMethodBeat.m2504i(122793);
        Object obj = (c41446ap.ekq() == C0163ba.OUT_VARIANCE || c36955ar.dZh() == C0163ba.OUT_VARIANCE) ? 1 : null;
        if (obj != null) {
            C8235ad dXL = C41434a.m72275G(c36955ar).dXL();
            AppMethodBeat.m2505o(122793);
            return dXL;
        }
        C46867w dZS = c41446ap.dZS();
        AppMethodBeat.m2505o(122793);
        return dZS;
    }

    public C25213q(C8233r c8233r) {
        this.BKW = c8233r;
    }

    /* renamed from: d */
    public final boolean mo42072d(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122794);
        boolean f;
        if (c46867w == c46867w2) {
            AppMethodBeat.m2505o(122794);
            return true;
        } else if (C44924t.m82160ai(c46867w)) {
            if (!C44924t.m82160ai(c46867w2)) {
                f = m39736f(c46867w2, c46867w);
                AppMethodBeat.m2505o(122794);
                return f;
            } else if (C25239y.m39807an(c46867w) || C25239y.m39807an(c46867w2) || !mo42071c(c46867w, c46867w2) || !mo42071c(c46867w2, c46867w)) {
                AppMethodBeat.m2505o(122794);
                return false;
            } else {
                AppMethodBeat.m2505o(122794);
                return true;
            }
        } else if (C44924t.m82160ai(c46867w2)) {
            f = m39736f(c46867w, c46867w2);
            AppMethodBeat.m2505o(122794);
            return f;
        } else if (c46867w.eci() != c46867w2.eci()) {
            AppMethodBeat.m2505o(122794);
            return false;
        } else if (c46867w.eci()) {
            f = this.BKW.mo18026a(C17316av.m26812aA(c46867w), C17316av.m26812aA(c46867w2), this);
            AppMethodBeat.m2505o(122794);
            return f;
        } else {
            C17313an ejw = c46867w.ejw();
            C17313an ejw2 = c46867w2.ejw();
            if (this.BKW.mo18027b(ejw, ejw2)) {
                List ejt = c46867w.ejt();
                List ejt2 = c46867w2.ejt();
                if (ejt.size() != ejt2.size()) {
                    AppMethodBeat.m2505o(122794);
                    return false;
                }
                for (int i = 0; i < ejt.size(); i++) {
                    C41446ap c41446ap = (C41446ap) ejt.get(i);
                    C41446ap c41446ap2 = (C41446ap) ejt2.get(i);
                    if (!c41446ap.ekp() || !c41446ap2.ekp()) {
                        C36955ar c36955ar = (C36955ar) ejw.getParameters().get(i);
                        C36955ar c36955ar2 = (C36955ar) ejw2.getParameters().get(i);
                        C25213q.m39732a(c41446ap, c41446ap2, c36955ar);
                        if (C25213q.m39734c(c36955ar, c41446ap) != C25213q.m39734c(c36955ar2, c41446ap2)) {
                            AppMethodBeat.m2505o(122794);
                            return false;
                        } else if (!this.BKW.mo18026a(c41446ap.dZS(), c41446ap2.dZS(), this)) {
                            AppMethodBeat.m2505o(122794);
                            return false;
                        }
                    }
                }
                AppMethodBeat.m2505o(122794);
                return true;
            }
            AppMethodBeat.m2505o(122794);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m39736f(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122795);
        if (!$assertionsDisabled && C44924t.m82160ai(c46867w)) {
            AssertionError assertionError = new AssertionError("Only inflexible types are allowed here: ".concat(String.valueOf(c46867w)));
            AppMethodBeat.m2505o(122795);
            throw assertionError;
        } else if (mo42071c(C44924t.m82161aj(c46867w2).BJx, c46867w) && mo42071c(c46867w, C44924t.m82161aj(c46867w2).BJy)) {
            AppMethodBeat.m2505o(122795);
            return true;
        } else {
            AppMethodBeat.m2505o(122795);
            return false;
        }
    }

    /* renamed from: c */
    private static C0161a m39734c(C36955ar c36955ar, C41446ap c41446ap) {
        C0163ba c0163ba;
        C0163ba c0163ba2;
        AppMethodBeat.m2504i(122796);
        C0163ba dZh = c36955ar.dZh();
        C0163ba ekq = c41446ap.ekq();
        if (ekq == C0163ba.INVARIANT) {
            c0163ba = dZh;
            c0163ba2 = ekq;
        } else {
            c0163ba = ekq;
            c0163ba2 = dZh;
        }
        C0161a c0161a;
        if (c0163ba2 == C0163ba.IN_VARIANCE && c0163ba == C0163ba.OUT_VARIANCE) {
            c0161a = C0161a.STAR;
            AppMethodBeat.m2505o(122796);
            return c0161a;
        } else if (c0163ba2 == C0163ba.OUT_VARIANCE && c0163ba == C0163ba.IN_VARIANCE) {
            c0161a = C0161a.STAR;
            AppMethodBeat.m2505o(122796);
            return c0161a;
        } else {
            c0161a = C0161a.m285a(c0163ba);
            AppMethodBeat.m2505o(122796);
            return c0161a;
        }
    }

    /* renamed from: c */
    public final boolean mo42071c(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122797);
        while (!C17312am.m26805b(c46867w, c46867w2)) {
            C46867w as = C17312am.m26803as(c46867w);
            C46867w at = C17312am.m26804at(c46867w2);
            if (as == c46867w && at == c46867w2) {
                boolean g = m39737g(c46867w, c46867w2);
                AppMethodBeat.m2505o(122797);
                return g;
            }
            c46867w2 = at;
            c46867w = as;
        }
        if (!c46867w.eci() || c46867w2.eci()) {
            AppMethodBeat.m2505o(122797);
            return true;
        }
        AppMethodBeat.m2505o(122797);
        return false;
    }

    /* renamed from: g */
    private boolean m39737g(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122798);
        if (C25239y.m39807an(c46867w) || C25239y.m39807an(c46867w2)) {
            AppMethodBeat.m2505o(122798);
            return true;
        } else if (!c46867w2.eci() && c46867w.eci()) {
            AppMethodBeat.m2505o(122798);
            return false;
        } else if (C31619g.m51135z(c46867w)) {
            AppMethodBeat.m2505o(122798);
            return true;
        } else {
            C46867w a = C25221t.m39749a(c46867w, c46867w2, this.BKW);
            if (a == null) {
                AppMethodBeat.m2505o(122798);
                return false;
            } else if (c46867w2.eci() || !a.eci()) {
                boolean h = m39738h(a, c46867w2);
                AppMethodBeat.m2505o(122798);
                return h;
            } else {
                AppMethodBeat.m2505o(122798);
                return false;
            }
        }
    }

    /* renamed from: h */
    private boolean m39738h(C46867w c46867w, C46867w c46867w2) {
        AppMethodBeat.m2504i(122799);
        C17313an ejw = c46867w.ejw();
        List ejt = c46867w.ejt();
        List ejt2 = c46867w2.ejt();
        if (ejt.size() != ejt2.size()) {
            AppMethodBeat.m2505o(122799);
            return false;
        }
        List parameters = ejw.getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            C36955ar c36955ar = (C36955ar) parameters.get(i);
            C41446ap c41446ap = (C41446ap) ejt2.get(i);
            C41446ap c41446ap2 = (C41446ap) ejt.get(i);
            if (!c41446ap.ekp()) {
                boolean z;
                C25213q.m39732a(c41446ap2, c41446ap, c36955ar);
                if (C25239y.m39807an(c41446ap2.dZS()) || C25239y.m39807an(c41446ap.dZS())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || c36955ar.dZh() != C0163ba.INVARIANT || c41446ap2.ekq() != C0163ba.INVARIANT || c41446ap.ekq() != C0163ba.INVARIANT) {
                    C46867w a = C25213q.m39731a(c36955ar, c41446ap);
                    if (this.BKW.mo18028b(C25213q.m39731a(c36955ar, c41446ap2), a, this)) {
                        a = C25213q.m39733b(c36955ar, c41446ap);
                        C46867w b = C25213q.m39733b(c36955ar, c41446ap2);
                        if (c41446ap.ekq() != C0163ba.OUT_VARIANCE) {
                            if (!this.BKW.mo18028b(a, b, this)) {
                                AppMethodBeat.m2505o(122799);
                                return false;
                            }
                        } else if (!($assertionsDisabled || C31619g.m51134y(a))) {
                            AssertionError assertionError = new AssertionError("In component must be Nothing for out-projection");
                            AppMethodBeat.m2505o(122799);
                            throw assertionError;
                        }
                    }
                    AppMethodBeat.m2505o(122799);
                    return false;
                } else if (!this.BKW.mo18026a(c41446ap2.dZS(), c41446ap.dZS(), this)) {
                    AppMethodBeat.m2505o(122799);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(122799);
        return true;
    }

    /* renamed from: a */
    private static boolean m39732a(C41446ap c41446ap, C41446ap c41446ap2, C36955ar c36955ar) {
        AppMethodBeat.m2504i(122800);
        if (c36955ar.dZh() != C0163ba.INVARIANT) {
            AppMethodBeat.m2505o(122800);
        } else if (c41446ap.ekq() == C0163ba.INVARIANT || c41446ap2.ekq() != C0163ba.INVARIANT) {
            AppMethodBeat.m2505o(122800);
        } else {
            c41446ap2.dZS();
            AppMethodBeat.m2505o(122800);
        }
        return false;
    }
}
