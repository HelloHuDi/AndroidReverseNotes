package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C8231k;

/* renamed from: a.i.b.a.c.l.av */
public class C17316av {
    static final /* synthetic */ boolean $assertionsDisabled = (!C17316av.class.desiredAssertionStatus());
    public static final C8235ad BKc = C25235p.awo("DONT_CARE");
    public static final C8235ad BKd = C25235p.awn("Cannot be inferred");
    public static final C8235ad BKe = new C17317a("NO_EXPECTED_TYPE");
    public static final C8235ad BKf = new C17317a("UNIT_EXPECTED_TYPE");

    /* renamed from: a.i.b.a.c.l.av$a */
    public static class C17317a extends C17324i {
        private final String name;

        /* renamed from: b */
        public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
            AppMethodBeat.m2504i(122685);
            C8235ad d = mo18030d(c0026g);
            AppMethodBeat.m2505o(122685);
            return d;
        }

        /* renamed from: rK */
        public final /* synthetic */ C41447az mo18032rK(boolean z) {
            AppMethodBeat.m2504i(122684);
            C8235ad rL = mo18033rL(z);
            AppMethodBeat.m2505o(122684);
            return rL;
        }

        public C17317a(String str) {
            this.name = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final C8235ad eby() {
            AppMethodBeat.m2504i(122681);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.m2505o(122681);
            throw illegalStateException;
        }

        /* renamed from: d */
        public final C8235ad mo18030d(C0026g c0026g) {
            AppMethodBeat.m2504i(122682);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.m2505o(122682);
            throw illegalStateException;
        }

        /* renamed from: rL */
        public final C8235ad mo18033rL(boolean z) {
            AppMethodBeat.m2504i(122683);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.m2505o(122683);
            throw illegalStateException;
        }

        public final String toString() {
            return this.name;
        }
    }

    static {
        AppMethodBeat.m2504i(122700);
        AppMethodBeat.m2505o(122700);
    }

    /* renamed from: ax */
    public static boolean m26818ax(C46867w c46867w) {
        return c46867w == BKe || c46867w == BKf;
    }

    /* renamed from: ay */
    public static boolean m26819ay(C46867w c46867w) {
        AppMethodBeat.m2504i(122686);
        if (c46867w == null || c46867w.ejw() != BKc.ejw()) {
            AppMethodBeat.m2505o(122686);
            return false;
        }
        AppMethodBeat.m2505o(122686);
        return true;
    }

    /* renamed from: az */
    public static C46867w m26820az(C46867w c46867w) {
        AppMethodBeat.m2504i(122687);
        C46867w a = C17316av.m26811a(c46867w, true);
        AppMethodBeat.m2505o(122687);
        return a;
    }

    /* renamed from: aA */
    public static C46867w m26812aA(C46867w c46867w) {
        AppMethodBeat.m2504i(122688);
        C46867w a = C17316av.m26811a(c46867w, false);
        AppMethodBeat.m2505o(122688);
        return a;
    }

    /* renamed from: a */
    public static C46867w m26811a(C46867w c46867w, boolean z) {
        AppMethodBeat.m2504i(122689);
        C41447az rK = c46867w.ekn().mo18032rK(z);
        AppMethodBeat.m2505o(122689);
        return rK;
    }

    /* renamed from: b */
    public static C46867w m26821b(C46867w c46867w, boolean z) {
        AppMethodBeat.m2504i(122690);
        if (z) {
            c46867w = C17316av.m26811a(c46867w, true);
            AppMethodBeat.m2505o(122690);
            return c46867w;
        }
        AppMethodBeat.m2505o(122690);
        return c46867w;
    }

    /* renamed from: a */
    public static C8235ad m26810a(C0036h c0036h, C31746h c31746h) {
        AppMethodBeat.m2504i(122691);
        C8235ad awn;
        if (C25235p.m39792L(c0036h)) {
            awn = C25235p.awn("Unsubstituted type for ".concat(String.valueOf(c0036h)));
            AppMethodBeat.m2505o(122691);
            return awn;
        }
        C17313an dXY = c0036h.dXY();
        List ga = C17316av.m26824ga(dXY.getParameters());
        C0027a c0027a = C0026g.BfJ;
        awn = C17326x.m26838a(C0027a.eai(), dXY, ga, false, c31746h);
        AppMethodBeat.m2505o(122691);
        return awn;
    }

    /* renamed from: ga */
    public static List<C41446ap> m26824ga(List<C36955ar> list) {
        AppMethodBeat.m2504i(122692);
        ArrayList arrayList = new ArrayList(list.size());
        for (C36955ar dZf : list) {
            arrayList.add(new C44836ar(dZf.dZf()));
        }
        List m = C25035t.m39352m(arrayList);
        AppMethodBeat.m2505o(122692);
        return m;
    }

    /* renamed from: aB */
    public static boolean m26813aB(C46867w c46867w) {
        AppMethodBeat.m2504i(122693);
        C46867w c;
        if (c46867w.eci()) {
            AppMethodBeat.m2505o(122693);
            return true;
        } else if (C44924t.m82160ai(c46867w) && C17316av.m26813aB(C44924t.m82161aj(c46867w).BJy)) {
            AppMethodBeat.m2505o(122693);
            return true;
        } else if (C17316av.m26816aE(c46867w)) {
            if (!(c46867w.ejw().dYs() instanceof C46865e)) {
                C25227au aw = C25227au.m39766aw(c46867w);
                Collection<C46867w> eap = c46867w.ejw().eap();
                ArrayList<C46867w> arrayList = new ArrayList(eap.size());
                for (C46867w c2 : eap) {
                    Object b;
                    c2 = aw.mo42080c(c2, C0163ba.INVARIANT);
                    if (c2 != null) {
                        b = C17316av.m26821b(c2, c46867w.eci());
                    } else {
                        b = null;
                    }
                    if (b != null) {
                        arrayList.add(b);
                    }
                }
                for (C46867w c22 : arrayList) {
                    if (C17316av.m26813aB(c22)) {
                        AppMethodBeat.m2505o(122693);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(122693);
            return false;
        } else {
            C17313an ejw = c46867w.ejw();
            if (ejw instanceof C37059v) {
                for (C46867w c222 : ejw.eap()) {
                    if (C17316av.m26813aB(c222)) {
                        AppMethodBeat.m2505o(122693);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(122693);
            return false;
        }
    }

    /* renamed from: aC */
    public static boolean m26814aC(C46867w c46867w) {
        AppMethodBeat.m2504i(122694);
        if (c46867w.eci()) {
            AppMethodBeat.m2505o(122694);
            return true;
        } else if (C44924t.m82160ai(c46867w) && C17316av.m26814aC(C44924t.m82161aj(c46867w).BJy)) {
            AppMethodBeat.m2505o(122694);
            return true;
        } else {
            AppMethodBeat.m2505o(122694);
            return false;
        }
    }

    /* renamed from: aD */
    public static C46865e m26815aD(C46867w c46867w) {
        AppMethodBeat.m2504i(122695);
        C0036h dYs = c46867w.ejw().dYs();
        if (dYs instanceof C46865e) {
            C46865e c46865e = (C46865e) dYs;
            AppMethodBeat.m2505o(122695);
            return c46865e;
        }
        AppMethodBeat.m2505o(122695);
        return null;
    }

    /* renamed from: b */
    public static boolean m26822b(C46867w c46867w, C17126b<C41447az, Boolean> c17126b) {
        AppMethodBeat.m2504i(122696);
        if (c46867w == null) {
            AppMethodBeat.m2505o(122696);
            return false;
        }
        C41447az ekn = c46867w.ekn();
        if (((Boolean) c17126b.mo50am(ekn)).booleanValue()) {
            AppMethodBeat.m2505o(122696);
            return true;
        }
        C17325q c17325q = ekn instanceof C17325q ? (C17325q) ekn : null;
        if (c17325q != null && (C17316av.m26822b(c17325q.BJx, (C17126b) c17126b) || C17316av.m26822b(c17325q.BJy, (C17126b) c17126b))) {
            AppMethodBeat.m2505o(122696);
            return true;
        } else if ((ekn instanceof C24623g) && C17316av.m26822b(((C24623g) ekn).BJh, (C17126b) c17126b)) {
            AppMethodBeat.m2505o(122696);
            return true;
        } else {
            C17313an ejw = c46867w.ejw();
            if (ejw instanceof C37059v) {
                for (C46867w b : ((C37059v) ejw).BJH) {
                    if (C17316av.m26822b(b, (C17126b) c17126b)) {
                        AppMethodBeat.m2505o(122696);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(122696);
                return false;
            }
            for (C41446ap c41446ap : c46867w.ejt()) {
                if (!c41446ap.ekp() && C17316av.m26822b(c41446ap.dZS(), (C17126b) c17126b)) {
                    AppMethodBeat.m2505o(122696);
                    return true;
                }
            }
            AppMethodBeat.m2505o(122696);
            return false;
        }
    }

    /* renamed from: e */
    public static C41446ap m26823e(C36955ar c36955ar) {
        AppMethodBeat.m2504i(122697);
        C44920ah c44920ah = new C44920ah(c36955ar);
        AppMethodBeat.m2505o(122697);
        return c44920ah;
    }

    /* renamed from: aE */
    public static boolean m26816aE(C46867w c46867w) {
        AppMethodBeat.m2504i(122698);
        if (C17316av.m26817aF(c46867w) != null || (c46867w.ejw() instanceof C8231k)) {
            AppMethodBeat.m2505o(122698);
            return true;
        }
        AppMethodBeat.m2505o(122698);
        return false;
    }

    /* renamed from: aF */
    private static C36955ar m26817aF(C46867w c46867w) {
        AppMethodBeat.m2504i(122699);
        if (c46867w.ejw().dYs() instanceof C36955ar) {
            C36955ar c36955ar = (C36955ar) c46867w.ejw().dYs();
            AppMethodBeat.m2505o(122699);
            return c36955ar;
        }
        AppMethodBeat.m2505o(122699);
        return null;
    }
}
