package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C31630k;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C31631l;
import p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a.C41431c;
import p000a.p010i.p011b.p012a.p015c.p045l.p1148d.C41451b;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p048n.C0171c;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.l.au */
public class C25227au {
    static final /* synthetic */ boolean $assertionsDisabled = (!C25227au.class.desiredAssertionStatus());
    public static final C25227au BJW = C25227au.m39772d(C44922as.BJU);
    public final C44922as Bik;

    /* renamed from: a.i.b.a.c.l.au$1 */
    static class C01621 implements C17126b<C8174b, Boolean> {
        C01621() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(122660);
            if (((C8174b) obj).equals(C31619g.Bag.BaW)) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(122660);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.l.au$a */
    static final class C25228a extends Exception {
        public C25228a(String str) {
            super(str);
        }
    }

    /* renamed from: a.i.b.a.c.l.au$b */
    enum C25229b {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION;

        static {
            AppMethodBeat.m2505o(122664);
        }
    }

    static {
        AppMethodBeat.m2504i(122680);
        AppMethodBeat.m2505o(122680);
    }

    /* renamed from: d */
    public static C25227au m39772d(C44922as c44922as) {
        AppMethodBeat.m2504i(122665);
        C25227au c25227au = new C25227au(c44922as);
        AppMethodBeat.m2505o(122665);
        return c25227au;
    }

    /* renamed from: b */
    public static C25227au m39769b(C44922as c44922as, C44922as c44922as2) {
        AppMethodBeat.m2504i(122666);
        C25227au d = C25227au.m39772d(C41455l.m72330a(c44922as, c44922as2));
        AppMethodBeat.m2505o(122666);
        return d;
    }

    /* renamed from: aw */
    public static C25227au m39766aw(C46867w c46867w) {
        AppMethodBeat.m2504i(122667);
        C25227au d = C25227au.m39772d(C25225ao.m39757a(c46867w.ejw(), c46867w.ejt()));
        AppMethodBeat.m2505o(122667);
        return d;
    }

    private C25227au(C44922as c44922as) {
        this.Bik = c44922as;
    }

    /* renamed from: c */
    public final C46867w mo42080c(C46867w c46867w, C0163ba c0163ba) {
        AppMethodBeat.m2504i(122669);
        C41446ap c = m39771c(new C44836ar(c0163ba, this.Bik.mo31387a(c46867w, c0163ba)));
        if (c == null) {
            AppMethodBeat.m2505o(122669);
            return null;
        }
        C46867w dZS = c.dZS();
        AppMethodBeat.m2505o(122669);
        return dZS;
    }

    /* renamed from: c */
    private C41446ap m39771c(C41446ap c41446ap) {
        AppMethodBeat.m2504i(122670);
        C41446ap d = mo42081d(c41446ap);
        if (this.Bik.eki() || this.Bik.ejx()) {
            d = C41451b.m72322a(d, this.Bik.ejx());
            AppMethodBeat.m2505o(122670);
            return d;
        }
        AppMethodBeat.m2505o(122670);
        return d;
    }

    /* renamed from: a */
    private C41446ap m39762a(C41446ap c41446ap, int i) {
        AppMethodBeat.m2504i(122672);
        C25227au.m39765a(i, c41446ap, this.Bik);
        if (c41446ap.ekp()) {
            AppMethodBeat.m2505o(122672);
            return c41446ap;
        }
        C46867w dZS = c41446ap.dZS();
        if (dZS instanceof C25230aw) {
            C41447az ekk = ((C25230aw) dZS).ekk();
            dZS = ((C25230aw) dZS).ekl();
            C41446ap a = m39762a(new C44836ar(c41446ap.ekq(), ekk), i + 1);
            c41446ap = new C44836ar(a.ekq(), C25231ax.m39780b(a.dZS().ekn(), mo42080c(dZS, c41446ap.ekq())));
            AppMethodBeat.m2505o(122672);
            return c41446ap;
        } else if (C41457n.m72337ag(dZS) || (dZS.ekn() instanceof C31771ac)) {
            AppMethodBeat.m2505o(122672);
            return c41446ap;
        } else {
            C41446ap O = this.Bik.mo31386O(dZS);
            C0163ba ekq = c41446ap.ekq();
            if (O == null && C44924t.m82160ai(dZS) && !C17312am.m26801aq(dZS)) {
                C17325q aj = C44924t.m82161aj(dZS);
                C41446ap a2 = m39762a(new C44836ar(ekq, aj.BJx), i + 1);
                O = m39762a(new C44836ar(ekq, aj.BJy), i + 1);
                C0163ba ekq2 = a2.ekq();
                if (!$assertionsDisabled && ((ekq2 != O.ekq() || ekq != C0163ba.INVARIANT) && ekq != ekq2)) {
                    AssertionError assertionError = new AssertionError("Unexpected substituted projection kind: " + ekq2 + "; original: " + ekq);
                    AppMethodBeat.m2505o(122672);
                    throw assertionError;
                } else if (a2.dZS() == aj.BJx && O.dZS() == aj.BJy) {
                    AppMethodBeat.m2505o(122672);
                    return c41446ap;
                } else {
                    c41446ap = new C44836ar(ekq2, C17326x.m26839a(C17315at.m26809av(a2.dZS()), C17315at.m26809av(O.dZS())));
                    AppMethodBeat.m2505o(122672);
                    return c41446ap;
                }
            } else if (C31619g.m51134y(dZS) || C25239y.m39807an(dZS)) {
                AppMethodBeat.m2505o(122672);
                return c41446ap;
            } else if (O != null) {
                C25229b b = C25227au.m39768b(ekq, O.ekq());
                if (!C41431c.m72269ae(dZS)) {
                    switch (b) {
                        case OUT_IN_IN_POSITION:
                            C25228a c25228a = new C25228a("Out-projection in in-position");
                            AppMethodBeat.m2505o(122672);
                            throw c25228a;
                        case IN_IN_OUT_POSITION:
                            c41446ap = new C44836ar(C0163ba.OUT_VARIANCE, dZS.ejw().dZD().dXN());
                            AppMethodBeat.m2505o(122672);
                            return c41446ap;
                    }
                }
                C17321f ar = C17312am.m26802ar(dZS);
                if (O.ekp()) {
                    AppMethodBeat.m2505o(122672);
                    return O;
                }
                C46867w R;
                if (ar != null) {
                    R = ar.mo31384R(O.dZS());
                } else {
                    R = C17316av.m26821b(O.dZS(), dZS.eci());
                }
                if (!dZS.dYn().isEmpty()) {
                    C0026g j = C25227au.m39774j(this.Bik.mo31389h(dZS.dYn()));
                    R = C41448a.m72311a(R, new C31630k(R.dYn(), j));
                }
                c41446ap = new C44836ar(b == C25229b.NO_CONFLICT ? C25227au.m39764a(ekq, O.ekq()) : ekq, R);
                AppMethodBeat.m2505o(122672);
                return c41446ap;
            } else {
                c41446ap = m39767b(c41446ap, i);
                AppMethodBeat.m2505o(122672);
                return c41446ap;
            }
        }
    }

    /* renamed from: j */
    private static C0026g m39774j(C0026g c0026g) {
        AppMethodBeat.m2504i(122673);
        if (c0026g.mo55j(C31619g.Bag.BaW)) {
            C31631l c31631l = new C31631l(c0026g, new C01621());
            AppMethodBeat.m2505o(122673);
            return c31631l;
        }
        AppMethodBeat.m2505o(122673);
        return c0026g;
    }

    /* renamed from: b */
    private C41446ap m39767b(C41446ap c41446ap, int i) {
        AppMethodBeat.m2504i(122674);
        C46867w dZS = c41446ap.dZS();
        C0163ba ekq = c41446ap.ekq();
        if (dZS.ejw().dYs() instanceof C36955ar) {
            AppMethodBeat.m2505o(122674);
            return c41446ap;
        }
        C46867w c46867w = null;
        C8235ad ao = C41444ag.m72303ao(dZS);
        if (ao != null) {
            c46867w = mo42080c(ao, C0163ba.INVARIANT);
        }
        dZS = C17315at.m26808a(dZS, m39770b(dZS.ejw().getParameters(), dZS.ejt(), i), this.Bik.mo31389h(dZS.dYn()));
        if ((dZS instanceof C8235ad) && (c46867w instanceof C8235ad)) {
            dZS = C41444ag.m72305b((C8235ad) dZS, (C8235ad) c46867w);
        }
        c41446ap = new C44836ar(ekq, dZS);
        AppMethodBeat.m2505o(122674);
        return c41446ap;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private List<C41446ap> m39770b(List<C36955ar> list, List<C41446ap> list2, int i) {
        AppMethodBeat.m2504i(122675);
        ArrayList arrayList = new ArrayList(list.size());
        int i2 = 0;
        Object obj = null;
        while (i2 < list.size()) {
            C41446ap e;
            Object obj2;
            C36955ar c36955ar = (C36955ar) list.get(i2);
            C41446ap c41446ap = (C41446ap) list2.get(i2);
            C41446ap a = m39762a(c41446ap, i + 1);
            switch (C25227au.m39768b(c36955ar.dZh(), a.ekq())) {
                case OUT_IN_IN_POSITION:
                case IN_IN_OUT_POSITION:
                    e = C17316av.m26823e(c36955ar);
                    break;
                case NO_CONFLICT:
                    if (!(c36955ar.dZh() == C0163ba.INVARIANT || a.ekp())) {
                        e = new C44836ar(C0163ba.INVARIANT, a.dZS());
                        break;
                    }
                default:
                    e = a;
                    break;
            }
            if (e != c41446ap) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            arrayList.add(e);
            i2++;
            obj = obj2;
        }
        if (obj == null) {
            AppMethodBeat.m2505o(122675);
            return list2;
        }
        AppMethodBeat.m2505o(122675);
        return arrayList;
    }

    /* renamed from: a */
    public static C0163ba m39763a(C0163ba c0163ba, C41446ap c41446ap) {
        AppMethodBeat.m2504i(122676);
        C0163ba c0163ba2;
        if (c41446ap.ekp()) {
            c0163ba2 = C0163ba.OUT_VARIANCE;
            AppMethodBeat.m2505o(122676);
            return c0163ba2;
        }
        c0163ba2 = C25227au.m39764a(c0163ba, c41446ap.ekq());
        AppMethodBeat.m2505o(122676);
        return c0163ba2;
    }

    /* renamed from: a */
    private static C0163ba m39764a(C0163ba c0163ba, C0163ba c0163ba2) {
        AppMethodBeat.m2504i(122677);
        if (c0163ba == C0163ba.INVARIANT) {
            AppMethodBeat.m2505o(122677);
            return c0163ba2;
        } else if (c0163ba2 == C0163ba.INVARIANT) {
            AppMethodBeat.m2505o(122677);
            return c0163ba;
        } else if (c0163ba == c0163ba2) {
            AppMethodBeat.m2505o(122677);
            return c0163ba2;
        } else {
            AssertionError assertionError = new AssertionError("Variance conflict: type parameter variance '" + c0163ba + "' and projection kind '" + c0163ba2 + "' cannot be combined");
            AppMethodBeat.m2505o(122677);
            throw assertionError;
        }
    }

    /* renamed from: b */
    private static C25229b m39768b(C0163ba c0163ba, C0163ba c0163ba2) {
        if (c0163ba == C0163ba.IN_VARIANCE && c0163ba2 == C0163ba.OUT_VARIANCE) {
            return C25229b.OUT_IN_IN_POSITION;
        }
        if (c0163ba == C0163ba.OUT_VARIANCE && c0163ba2 == C0163ba.IN_VARIANCE) {
            return C25229b.IN_IN_OUT_POSITION;
        }
        return C25229b.NO_CONFLICT;
    }

    /* renamed from: a */
    private static void m39765a(int i, C41446ap c41446ap, C44922as c44922as) {
        AppMethodBeat.m2504i(122678);
        if (i > 100) {
            IllegalStateException illegalStateException = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + C25227au.m39773dU(c41446ap) + "; substitution: " + C25227au.m39773dU(c44922as));
            AppMethodBeat.m2505o(122678);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(122678);
    }

    /* renamed from: dU */
    private static String m39773dU(Object obj) {
        AppMethodBeat.m2504i(122679);
        String obj2;
        try {
            obj2 = obj.toString();
            AppMethodBeat.m2505o(122679);
            return obj2;
        } catch (Throwable th) {
            if (C0171c.m295r(th)) {
                RuntimeException runtimeException = (RuntimeException) th;
                AppMethodBeat.m2505o(122679);
            } else {
                obj2 = "[Exception while computing toString(): " + th + "]";
                AppMethodBeat.m2505o(122679);
                return obj2;
            }
        }
    }

    /* renamed from: b */
    public final C46867w mo42079b(C46867w c46867w, C0163ba c0163ba) {
        AppMethodBeat.m2504i(122668);
        if (this.Bik.isEmpty()) {
            AppMethodBeat.m2505o(122668);
            return c46867w;
        }
        try {
            c46867w = m39762a(new C44836ar(c0163ba, c46867w), 0).dZS();
            AppMethodBeat.m2505o(122668);
            return c46867w;
        } catch (C25228a e) {
            c46867w = C25235p.awn(e.getMessage());
            AppMethodBeat.m2505o(122668);
            return c46867w;
        }
    }

    /* renamed from: d */
    public final C41446ap mo42081d(C41446ap c41446ap) {
        AppMethodBeat.m2504i(122671);
        if (this.Bik.isEmpty()) {
            AppMethodBeat.m2505o(122671);
            return c41446ap;
        }
        try {
            c41446ap = m39762a(c41446ap, 0);
            AppMethodBeat.m2505o(122671);
            return c41446ap;
        } catch (C25228a e) {
            AppMethodBeat.m2505o(122671);
            return null;
        }
    }
}
