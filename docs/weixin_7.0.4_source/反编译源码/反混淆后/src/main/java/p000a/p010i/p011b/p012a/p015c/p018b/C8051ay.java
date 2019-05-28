package p000a.p010i.p011b.p012a.p015c.p018b;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import p000a.p001a.C7986al;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C25086af;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C0131e;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C31744f;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C37036g;
import p000a.p010i.p011b.p012a.p015c.p045l.C41457n;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p047m.C25242g;
import p000a.p010i.p011b.p012a.p015c.p047m.C25242g.C17328a;
import p000a.p010i.p011b.p012a.p015c.p048n.C31780a;

/* renamed from: a.i.b.a.c.b.ay */
public final class C8051ay {
    public static final C25082az BeW = new C25082az("private") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119301);
            if (C8203d.m14490r(c36652p)) {
                Object obj;
                if (C8203d.m14468C(c31642l) != C17154an.BeS) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    boolean a = C8051ay.m14223a((C31642l) c36652p, c31642l);
                    AppMethodBeat.m2505o(119301);
                    return a;
                }
            }
            if (c36652p instanceof C0037k) {
                C31642l dZo = ((C0037k) c36652p).dZo();
                if (C8203d.m14496v(dZo) && C8203d.m14490r(dZo) && (c31642l instanceof C0037k) && C8203d.m14490r(c31642l.dXW()) && C8051ay.m14223a((C31642l) c36652p, c31642l)) {
                    AppMethodBeat.m2505o(119301);
                    return true;
                }
            }
            C31642l c31642l2 = c36652p;
            while (c31642l2 != null) {
                c31642l2 = c31642l2.dXW();
                if (!(c31642l2 instanceof C46865e) || C8203d.m14494u(c31642l2)) {
                    if (c31642l2 instanceof C36953ab) {
                        break;
                    }
                }
                break;
            }
            if (c31642l2 == null) {
                AppMethodBeat.m2505o(119301);
                return false;
            }
            C31642l c31642l3 = c31642l;
            while (c31642l3 != null) {
                if (c31642l2 == c31642l3) {
                    AppMethodBeat.m2505o(119301);
                    return true;
                } else if (!(c31642l3 instanceof C36953ab)) {
                    c31642l3 = c31642l3.dXW();
                } else if ((c31642l2 instanceof C36953ab) && ((C36953ab) c31642l2).dZF().equals(((C36953ab) c31642l3).dZF()) && C8203d.m14483e(c31642l3, c31642l2)) {
                    AppMethodBeat.m2505o(119301);
                    return true;
                } else {
                    AppMethodBeat.m2505o(119301);
                    return false;
                }
            }
            AppMethodBeat.m2505o(119301);
            return false;
        }
    };
    public static final C25082az BeX = new C25082az("private_to_this") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119305);
            if (C8051ay.BeW.mo17859b(c0131e, c36652p, c31642l)) {
                if (c0131e == C8051ay.Bfj) {
                    AppMethodBeat.m2505o(119305);
                    return true;
                } else if (c0131e == C8051ay.Bfi) {
                    AppMethodBeat.m2505o(119305);
                    return false;
                } else {
                    C31642l a = C8203d.m14471a((C31642l) c36652p, C46865e.class);
                    if (a != null && (c0131e instanceof C37036g)) {
                        boolean equals = ((C37036g) c0131e).dZR().dZm().equals(a.dZd());
                        AppMethodBeat.m2505o(119305);
                        return equals;
                    }
                }
            }
            AppMethodBeat.m2505o(119305);
            return false;
        }

        public final String getDisplayName() {
            return "private/*private to this*/";
        }
    };
    public static final C25082az BeY = new C25082az("protected") {
        /* JADX WARNING: Removed duplicated region for block: B:50:0x009c A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0061 A:{SYNTHETIC} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119306);
            C0131e c0131e2 = c0131e;
            while (true) {
                C31642l c31642l2 = (C46865e) C8203d.m14471a((C31642l) c36652p, C46865e.class);
                C31642l c31642l3 = (C46865e) C8203d.m14472a(c31642l, C46865e.class, false);
                if (c31642l3 == null) {
                    AppMethodBeat.m2505o(119306);
                    return false;
                }
                C46865e c46865e;
                if (c31642l2 != null && C8203d.m14494u(c31642l2)) {
                    c46865e = (C46865e) C8203d.m14471a(c31642l2, C46865e.class);
                    if (c46865e != null && C8203d.m14481c(c31642l3, c46865e)) {
                        AppMethodBeat.m2505o(119306);
                        return true;
                    }
                }
                C31642l a = C8203d.m14473a(c36652p);
                c46865e = (C46865e) C8203d.m14471a(a, C46865e.class);
                if (c46865e == null) {
                    AppMethodBeat.m2505o(119306);
                    return false;
                }
                if (C8203d.m14481c(c31642l3, c46865e)) {
                    boolean z;
                    if (c0131e2 != C8051ay.Bfk) {
                        if (!(a instanceof C25085b)) {
                            z = true;
                        } else if (a instanceof C0037k) {
                            z = true;
                        } else if (c0131e2 == C8051ay.Bfj) {
                            z = true;
                        } else if (c0131e2 == C8051ay.Bfi || c0131e2 == null) {
                            z = false;
                        } else {
                            C46867w ejP = c0131e2 instanceof C31744f ? ((C31744f) c0131e2).ejP() : c0131e2.dZS();
                            if (C8203d.m14480b(ejP, c31642l3) || C41457n.m72337ag(ejP)) {
                                z = true;
                            }
                        }
                        if (!z) {
                            AppMethodBeat.m2505o(119306);
                            return true;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                c31642l = c31642l3.dXW();
            }
        }
    };
    public static final C25082az BeZ = new C25082az("internal") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119307);
            if (C8203d.m14491s(c31642l).mo247a(C8203d.m14491s(c36652p))) {
                boolean h = C8051ay.Bfl.mo31398h(c36652p, c31642l);
                AppMethodBeat.m2505o(119307);
                return h;
            }
            AppMethodBeat.m2505o(119307);
            return false;
        }
    };
    public static final C25082az Bfa = new C25082az("public") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            return true;
        }
    };
    public static final C25082az Bfb = new C25082az(ImagesContract.LOCAL) {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119308);
            IllegalStateException illegalStateException = new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            AppMethodBeat.m2505o(119308);
            throw illegalStateException;
        }
    };
    public static final C25082az Bfc = new C25082az("inherited") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            AppMethodBeat.m2504i(119309);
            IllegalStateException illegalStateException = new IllegalStateException("Visibility is unknown yet");
            AppMethodBeat.m2505o(119309);
            throw illegalStateException;
        }
    };
    public static final C25082az Bfd = new C25082az("invisible_fake") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            return false;
        }
    };
    public static final C25082az Bfe = new C25082az("unknown") {
        /* renamed from: b */
        public final boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
            return false;
        }
    };
    public static final Set<C25082az> Bff = Collections.unmodifiableSet(C7986al.setOf(BeW, BeX, BeZ, Bfb));
    private static final Map<C25082az, Integer> Bfg;
    public static final C25082az Bfh = Bfa;
    private static final C0131e Bfi = new C80602();
    public static final C0131e Bfj = new C80593();
    @Deprecated
    public static final C0131e Bfk = new C80544();
    private static final C25242g Bfl;

    /* renamed from: a.i.b.a.c.b.ay$4 */
    static class C80544 implements C0131e {
        C80544() {
        }

        public final C46867w dZS() {
            AppMethodBeat.m2504i(119304);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.m2505o(119304);
            throw illegalStateException;
        }
    }

    /* renamed from: a.i.b.a.c.b.ay$3 */
    static class C80593 implements C0131e {
        C80593() {
        }

        public final C46867w dZS() {
            AppMethodBeat.m2504i(119303);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.m2505o(119303);
            throw illegalStateException;
        }
    }

    /* renamed from: a.i.b.a.c.b.ay$2 */
    static class C80602 implements C0131e {
        C80602() {
        }

        public final C46867w dZS() {
            AppMethodBeat.m2504i(119302);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.m2505o(119302);
            throw illegalStateException;
        }
    }

    static {
        AppMethodBeat.m2504i(119315);
        HashMap UP = C31780a.m51474UP(4);
        UP.put(BeX, Integer.valueOf(0));
        UP.put(BeW, Integer.valueOf(0));
        UP.put(BeZ, Integer.valueOf(1));
        UP.put(BeY, Integer.valueOf(1));
        UP.put(Bfa, Integer.valueOf(2));
        Bfg = Collections.unmodifiableMap(UP);
        Iterator it = ServiceLoader.load(C25242g.class, C25242g.class.getClassLoader()).iterator();
        Bfl = it.hasNext() ? (C25242g) it.next() : C17328a.BLF;
        AppMethodBeat.m2505o(119315);
    }

    /* renamed from: a */
    public static boolean m14224a(C36652p c36652p, C31642l c31642l) {
        AppMethodBeat.m2504i(119310);
        if (C8051ay.m14221a(Bfj, c36652p, c31642l) == null) {
            AppMethodBeat.m2505o(119310);
            return true;
        }
        AppMethodBeat.m2505o(119310);
        return false;
    }

    /* renamed from: a */
    public static boolean m14223a(C31642l c31642l, C31642l c31642l2) {
        AppMethodBeat.m2504i(119311);
        C17154an C = C8203d.m14468C(c31642l2);
        if (C != C17154an.BeS) {
            boolean equals = C.equals(C8203d.m14468C(c31642l));
            AppMethodBeat.m2505o(119311);
            return equals;
        }
        AppMethodBeat.m2505o(119311);
        return false;
    }

    /* renamed from: a */
    private static C36652p m14221a(C0131e c0131e, C36652p c36652p, C31642l c31642l) {
        C36652p c36652p2;
        AppMethodBeat.m2504i(119312);
        C31642l c36652p22 = (C36652p) c36652p.dZd();
        while (c36652p22 != null && c36652p22.dYf() != Bfb) {
            if (c36652p22.dYf().mo17859b(c0131e, c36652p22, c31642l)) {
                c36652p22 = (C36652p) C8203d.m14471a(c36652p22, C36652p.class);
            } else {
                AppMethodBeat.m2505o(119312);
                return c36652p22;
            }
        }
        if (c36652p instanceof C25086af) {
            c36652p22 = C8051ay.m14221a(c0131e, ((C25086af) c36652p).eaL(), c31642l);
            if (c36652p22 != null) {
                AppMethodBeat.m2505o(119312);
                return c36652p22;
            }
        }
        AppMethodBeat.m2505o(119312);
        return null;
    }

    /* renamed from: a */
    static Integer m14222a(C25082az c25082az, C25082az c25082az2) {
        AppMethodBeat.m2504i(119313);
        Integer valueOf;
        if (c25082az == c25082az2) {
            valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(119313);
            return valueOf;
        }
        valueOf = (Integer) Bfg.get(c25082az);
        Integer num = (Integer) Bfg.get(c25082az2);
        if (valueOf == null || num == null || valueOf.equals(num)) {
            AppMethodBeat.m2505o(119313);
            return null;
        }
        valueOf = Integer.valueOf(valueOf.intValue() - num.intValue());
        AppMethodBeat.m2505o(119313);
        return valueOf;
    }

    /* renamed from: b */
    public static Integer m14225b(C25082az c25082az, C25082az c25082az2) {
        AppMethodBeat.m2504i(119314);
        Integer c = c25082az.mo31293c(c25082az2);
        if (c != null) {
            AppMethodBeat.m2505o(119314);
            return c;
        }
        c = c25082az2.mo31293c(c25082az);
        if (c != null) {
            c = Integer.valueOf(-c.intValue());
            AppMethodBeat.m2505o(119314);
            return c;
        }
        AppMethodBeat.m2505o(119314);
        return null;
    }

    /* renamed from: b */
    public static boolean m14226b(C25082az c25082az) {
        return c25082az == BeW || c25082az == BeX;
    }
}
