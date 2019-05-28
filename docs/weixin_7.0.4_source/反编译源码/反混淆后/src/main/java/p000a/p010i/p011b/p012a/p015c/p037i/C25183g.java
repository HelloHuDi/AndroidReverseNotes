package p000a.p010i.p011b.p012a.p015c.p037i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.List;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p018b.C0037k;
import p000a.p010i.p011b.p012a.p015c.p018b.C17159aq;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p036h.C0123h;
import p000a.p010i.p011b.p012a.p015c.p036h.C0125i;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c.C31725a;
import p000a.p010i.p011b.p012a.p015c.p036h.C37031a;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.i.g */
public class C25183g implements Comparator<C31642l> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C25183g.class.desiredAssertionStatus());
    public static final C25183g BEi = new C25183g();
    private static final C31724c BEj = C31725a.m51359e(new C01421());

    /* renamed from: a.i.b.a.c.i.g$1 */
    static class C01421 implements C17126b<C0125i, C37091y> {
        C01421() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(121986);
            C0125i c0125i = (C0125i) obj;
            c0125i.mo209rV(false);
            c0125i.mo208rU(true);
            c0125i.mo194a(C37031a.UNLESS_EMPTY);
            c0125i.mo204n(C0123h.BCv);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(121986);
            return c37091y;
        }
    }

    /* renamed from: a.i.b.a.c.i.g$a */
    public static class C25184a implements Comparator<C31642l> {
        public static final C25184a BEk = new C25184a();

        /* renamed from: g */
        static /* synthetic */ Integer m39676g(C31642l c31642l, C31642l c31642l2) {
            AppMethodBeat.m2504i(121990);
            Integer f = C25184a.m39675f(c31642l, c31642l2);
            AppMethodBeat.m2505o(121990);
            return f;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(121989);
            Integer f = C25184a.m39675f((C31642l) obj, (C31642l) obj2);
            if (f != null) {
                int intValue = f.intValue();
                AppMethodBeat.m2505o(121989);
                return intValue;
            }
            AppMethodBeat.m2505o(121989);
            return 0;
        }

        static {
            AppMethodBeat.m2504i(121991);
            AppMethodBeat.m2505o(121991);
        }

        private C25184a() {
        }

        /* renamed from: E */
        private static int m39674E(C31642l c31642l) {
            AppMethodBeat.m2504i(121987);
            if (C8203d.m14499x(c31642l)) {
                AppMethodBeat.m2505o(121987);
                return 8;
            } else if (c31642l instanceof C0037k) {
                AppMethodBeat.m2505o(121987);
                return 7;
            } else if (c31642l instanceof C31220ah) {
                if (((C31220ah) c31642l).dYQ() == null) {
                    AppMethodBeat.m2505o(121987);
                    return 6;
                }
                AppMethodBeat.m2505o(121987);
                return 5;
            } else if (c31642l instanceof C8083t) {
                if (((C8083t) c31642l).dYQ() == null) {
                    AppMethodBeat.m2505o(121987);
                    return 4;
                }
                AppMethodBeat.m2505o(121987);
                return 3;
            } else if (c31642l instanceof C46865e) {
                AppMethodBeat.m2505o(121987);
                return 2;
            } else if (c31642l instanceof C17159aq) {
                AppMethodBeat.m2505o(121987);
                return 1;
            } else {
                AppMethodBeat.m2505o(121987);
                return 0;
            }
        }

        /* renamed from: f */
        private static Integer m39675f(C31642l c31642l, C31642l c31642l2) {
            AppMethodBeat.m2504i(121988);
            int E = C25184a.m39674E(c31642l2) - C25184a.m39674E(c31642l);
            Integer valueOf;
            if (E != 0) {
                valueOf = Integer.valueOf(E);
                AppMethodBeat.m2505o(121988);
                return valueOf;
            } else if (C8203d.m14499x(c31642l) && C8203d.m14499x(c31642l2)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(121988);
                return valueOf;
            } else {
                E = c31642l.dZg().mo59040v(c31642l2.dZg());
                if (E != 0) {
                    valueOf = Integer.valueOf(E);
                    AppMethodBeat.m2505o(121988);
                    return valueOf;
                }
                AppMethodBeat.m2505o(121988);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(121993);
        C31725a c31725a = C31724c.BBP;
        AppMethodBeat.m2505o(121993);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        int i = 1;
        AppMethodBeat.m2504i(121992);
        C31642l c31642l = (C31642l) obj;
        C31642l c31642l2 = (C31642l) obj2;
        Integer g = C25184a.m39676g(c31642l, c31642l2);
        int intValue;
        if (g != null) {
            intValue = g.intValue();
            AppMethodBeat.m2505o(121992);
            return intValue;
        }
        AssertionError assertionError;
        if ((c31642l instanceof C17159aq) && (c31642l2 instanceof C17159aq)) {
            intValue = BEj.mo13665b(((C17159aq) c31642l).dZP()).compareTo(BEj.mo13665b(((C17159aq) c31642l2).dZP()));
            if (intValue != 0) {
                AppMethodBeat.m2505o(121992);
                return intValue;
            }
        } else if ((c31642l instanceof C8045a) && (c31642l2 instanceof C8045a)) {
            int i2;
            C8045a c8045a = (C8045a) c31642l;
            C8045a c8045a2 = (C8045a) c31642l2;
            C41396ak dYQ = c8045a.dYQ();
            C41396ak dYQ2 = c8045a2.dYQ();
            if (!$assertionsDisabled) {
                i2 = dYQ != null ? 1 : 0;
                if (dYQ2 == null) {
                    i = 0;
                }
                if (i2 != i) {
                    assertionError = new AssertionError();
                    AppMethodBeat.m2505o(121992);
                    throw assertionError;
                }
            }
            if (dYQ != null) {
                i = BEj.mo13665b(dYQ.dZS()).compareTo(BEj.mo13665b(dYQ2.dZS()));
                if (i != 0) {
                    AppMethodBeat.m2505o(121992);
                    return i;
                }
            }
            List dYV = c8045a.dYV();
            List dYV2 = c8045a2.dYV();
            for (i2 = 0; i2 < Math.min(dYV.size(), dYV2.size()); i2++) {
                i = BEj.mo13665b(((C41399au) dYV.get(i2)).dZS()).compareTo(BEj.mo13665b(((C41399au) dYV2.get(i2)).dZS()));
                if (i != 0) {
                    AppMethodBeat.m2505o(121992);
                    return i;
                }
            }
            i = dYV.size() - dYV2.size();
            if (i != 0) {
                AppMethodBeat.m2505o(121992);
                return i;
            }
            dYV2 = c8045a.dYS();
            List dYS = c8045a2.dYS();
            for (i2 = 0; i2 < Math.min(dYV2.size(), dYS.size()); i2++) {
                List dWP = ((C36955ar) dYV2.get(i2)).dWP();
                List dWP2 = ((C36955ar) dYS.get(i2)).dWP();
                i = dWP.size() - dWP2.size();
                if (i != 0) {
                    AppMethodBeat.m2505o(121992);
                    return i;
                }
                for (int i3 = 0; i3 < dWP.size(); i3++) {
                    i = BEj.mo13665b((C46867w) dWP.get(i3)).compareTo(BEj.mo13665b((C46867w) dWP2.get(i3)));
                    if (i != 0) {
                        AppMethodBeat.m2505o(121992);
                        return i;
                    }
                }
            }
            i = dYV2.size() - dYS.size();
            if (i != 0) {
                AppMethodBeat.m2505o(121992);
                return i;
            } else if ((c8045a instanceof C25085b) && (c8045a2 instanceof C25085b)) {
                intValue = ((C25085b) c8045a).dYZ().ordinal() - ((C25085b) c8045a2).dYZ().ordinal();
                if (intValue != 0) {
                    AppMethodBeat.m2505o(121992);
                    return intValue;
                }
            }
        } else if ((c31642l instanceof C46865e) && (c31642l2 instanceof C46865e)) {
            C46865e c46865e = (C46865e) c31642l;
            C46865e c46865e2 = (C46865e) c31642l2;
            if (c46865e.dYc().ordinal() != c46865e2.dYc().ordinal()) {
                intValue = c46865e.dYc().ordinal() - c46865e2.dYc().ordinal();
                AppMethodBeat.m2505o(121992);
                return intValue;
            } else if (c46865e.dYg() != c46865e2.dYg()) {
                if (c46865e.dYg()) {
                    AppMethodBeat.m2505o(121992);
                    return 1;
                }
                AppMethodBeat.m2505o(121992);
                return -1;
            }
        } else {
            assertionError = new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{c31642l, c31642l.getClass(), c31642l2, c31642l2.getClass()}));
            AppMethodBeat.m2505o(121992);
            throw assertionError;
        }
        intValue = BEj.mo13667k(c31642l).compareTo(BEj.mo13667k(c31642l2));
        if (intValue != 0) {
            AppMethodBeat.m2505o(121992);
            return intValue;
        }
        intValue = C8203d.m14491s(c31642l).dZg().mo59040v(C8203d.m14491s(c31642l2).dZg());
        AppMethodBeat.m2505o(121992);
        return intValue;
    }

    private C25183g() {
    }
}
