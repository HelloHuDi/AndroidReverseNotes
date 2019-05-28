package a.i.b.a.c.b;

import a.a.al;
import a.i.b.a.c.b.c.af;
import a.i.b.a.c.i.d;
import a.i.b.a.c.i.e.a.e;
import a.i.b.a.c.i.e.a.f;
import a.i.b.a.c.i.e.a.g;
import a.i.b.a.c.l.n;
import a.i.b.a.c.l.w;
import a.i.b.a.c.n.a;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

public final class ay {
    public static final az BeW = new az("private") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119301);
            if (d.r(pVar)) {
                Object obj;
                if (d.C(lVar) != an.BeS) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    boolean a = ay.a((l) pVar, lVar);
                    AppMethodBeat.o(119301);
                    return a;
                }
            }
            if (pVar instanceof k) {
                l dZo = ((k) pVar).dZo();
                if (d.v(dZo) && d.r(dZo) && (lVar instanceof k) && d.r(lVar.dXW()) && ay.a((l) pVar, lVar)) {
                    AppMethodBeat.o(119301);
                    return true;
                }
            }
            l lVar2 = pVar;
            while (lVar2 != null) {
                lVar2 = lVar2.dXW();
                if (!(lVar2 instanceof e) || d.u(lVar2)) {
                    if (lVar2 instanceof ab) {
                        break;
                    }
                }
                break;
            }
            if (lVar2 == null) {
                AppMethodBeat.o(119301);
                return false;
            }
            l lVar3 = lVar;
            while (lVar3 != null) {
                if (lVar2 == lVar3) {
                    AppMethodBeat.o(119301);
                    return true;
                } else if (!(lVar3 instanceof ab)) {
                    lVar3 = lVar3.dXW();
                } else if ((lVar2 instanceof ab) && ((ab) lVar2).dZF().equals(((ab) lVar3).dZF()) && d.e(lVar3, lVar2)) {
                    AppMethodBeat.o(119301);
                    return true;
                } else {
                    AppMethodBeat.o(119301);
                    return false;
                }
            }
            AppMethodBeat.o(119301);
            return false;
        }
    };
    public static final az BeX = new az("private_to_this") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119305);
            if (ay.BeW.b(eVar, pVar, lVar)) {
                if (eVar == ay.Bfj) {
                    AppMethodBeat.o(119305);
                    return true;
                } else if (eVar == ay.Bfi) {
                    AppMethodBeat.o(119305);
                    return false;
                } else {
                    l a = d.a((l) pVar, e.class);
                    if (a != null && (eVar instanceof g)) {
                        boolean equals = ((g) eVar).dZR().dZm().equals(a.dZd());
                        AppMethodBeat.o(119305);
                        return equals;
                    }
                }
            }
            AppMethodBeat.o(119305);
            return false;
        }

        public final String getDisplayName() {
            return "private/*private to this*/";
        }
    };
    public static final az BeY = new az("protected") {
        /* JADX WARNING: Removed duplicated region for block: B:50:0x009c A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0061 A:{SYNTHETIC} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119306);
            e eVar2 = eVar;
            while (true) {
                l lVar2 = (e) d.a((l) pVar, e.class);
                l lVar3 = (e) d.a(lVar, e.class, false);
                if (lVar3 == null) {
                    AppMethodBeat.o(119306);
                    return false;
                }
                e eVar3;
                if (lVar2 != null && d.u(lVar2)) {
                    eVar3 = (e) d.a(lVar2, e.class);
                    if (eVar3 != null && d.c(lVar3, eVar3)) {
                        AppMethodBeat.o(119306);
                        return true;
                    }
                }
                l a = d.a(pVar);
                eVar3 = (e) d.a(a, e.class);
                if (eVar3 == null) {
                    AppMethodBeat.o(119306);
                    return false;
                }
                if (d.c(lVar3, eVar3)) {
                    boolean z;
                    if (eVar2 != ay.Bfk) {
                        if (!(a instanceof b)) {
                            z = true;
                        } else if (a instanceof k) {
                            z = true;
                        } else if (eVar2 == ay.Bfj) {
                            z = true;
                        } else if (eVar2 == ay.Bfi || eVar2 == null) {
                            z = false;
                        } else {
                            w ejP = eVar2 instanceof f ? ((f) eVar2).ejP() : eVar2.dZS();
                            if (d.b(ejP, lVar3) || n.ag(ejP)) {
                                z = true;
                            }
                        }
                        if (!z) {
                            AppMethodBeat.o(119306);
                            return true;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                lVar = lVar3.dXW();
            }
        }
    };
    public static final az BeZ = new az("internal") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119307);
            if (d.s(lVar).a(d.s(pVar))) {
                boolean h = ay.Bfl.h(pVar, lVar);
                AppMethodBeat.o(119307);
                return h;
            }
            AppMethodBeat.o(119307);
            return false;
        }
    };
    public static final az Bfa = new az("public") {
        public final boolean b(e eVar, p pVar, l lVar) {
            return true;
        }
    };
    public static final az Bfb = new az(ImagesContract.LOCAL) {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119308);
            IllegalStateException illegalStateException = new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            AppMethodBeat.o(119308);
            throw illegalStateException;
        }
    };
    public static final az Bfc = new az("inherited") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119309);
            IllegalStateException illegalStateException = new IllegalStateException("Visibility is unknown yet");
            AppMethodBeat.o(119309);
            throw illegalStateException;
        }
    };
    public static final az Bfd = new az("invisible_fake") {
        public final boolean b(e eVar, p pVar, l lVar) {
            return false;
        }
    };
    public static final az Bfe = new az("unknown") {
        public final boolean b(e eVar, p pVar, l lVar) {
            return false;
        }
    };
    public static final Set<az> Bff = Collections.unmodifiableSet(al.setOf(BeW, BeX, BeZ, Bfb));
    private static final Map<az, Integer> Bfg;
    public static final az Bfh = Bfa;
    private static final e Bfi = new e() {
        public final w dZS() {
            AppMethodBeat.i(119302);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.o(119302);
            throw illegalStateException;
        }
    };
    public static final e Bfj = new e() {
        public final w dZS() {
            AppMethodBeat.i(119303);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.o(119303);
            throw illegalStateException;
        }
    };
    @Deprecated
    public static final e Bfk = new e() {
        public final w dZS() {
            AppMethodBeat.i(119304);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.o(119304);
            throw illegalStateException;
        }
    };
    private static final a.i.b.a.c.m.g Bfl;

    static {
        AppMethodBeat.i(119315);
        HashMap UP = a.UP(4);
        UP.put(BeX, Integer.valueOf(0));
        UP.put(BeW, Integer.valueOf(0));
        UP.put(BeZ, Integer.valueOf(1));
        UP.put(BeY, Integer.valueOf(1));
        UP.put(Bfa, Integer.valueOf(2));
        Bfg = Collections.unmodifiableMap(UP);
        Iterator it = ServiceLoader.load(a.i.b.a.c.m.g.class, a.i.b.a.c.m.g.class.getClassLoader()).iterator();
        Bfl = it.hasNext() ? (a.i.b.a.c.m.g) it.next() : a.i.b.a.c.m.g.a.BLF;
        AppMethodBeat.o(119315);
    }

    public static boolean a(p pVar, l lVar) {
        AppMethodBeat.i(119310);
        if (a(Bfj, pVar, lVar) == null) {
            AppMethodBeat.o(119310);
            return true;
        }
        AppMethodBeat.o(119310);
        return false;
    }

    public static boolean a(l lVar, l lVar2) {
        AppMethodBeat.i(119311);
        an C = d.C(lVar2);
        if (C != an.BeS) {
            boolean equals = C.equals(d.C(lVar));
            AppMethodBeat.o(119311);
            return equals;
        }
        AppMethodBeat.o(119311);
        return false;
    }

    private static p a(e eVar, p pVar, l lVar) {
        p pVar2;
        AppMethodBeat.i(119312);
        l pVar22 = (p) pVar.dZd();
        while (pVar22 != null && pVar22.dYf() != Bfb) {
            if (pVar22.dYf().b(eVar, pVar22, lVar)) {
                pVar22 = (p) d.a(pVar22, p.class);
            } else {
                AppMethodBeat.o(119312);
                return pVar22;
            }
        }
        if (pVar instanceof af) {
            pVar22 = a(eVar, ((af) pVar).eaL(), lVar);
            if (pVar22 != null) {
                AppMethodBeat.o(119312);
                return pVar22;
            }
        }
        AppMethodBeat.o(119312);
        return null;
    }

    static Integer a(az azVar, az azVar2) {
        AppMethodBeat.i(119313);
        Integer valueOf;
        if (azVar == azVar2) {
            valueOf = Integer.valueOf(0);
            AppMethodBeat.o(119313);
            return valueOf;
        }
        valueOf = (Integer) Bfg.get(azVar);
        Integer num = (Integer) Bfg.get(azVar2);
        if (valueOf == null || num == null || valueOf.equals(num)) {
            AppMethodBeat.o(119313);
            return null;
        }
        valueOf = Integer.valueOf(valueOf.intValue() - num.intValue());
        AppMethodBeat.o(119313);
        return valueOf;
    }

    public static Integer b(az azVar, az azVar2) {
        AppMethodBeat.i(119314);
        Integer c = azVar.c(azVar2);
        if (c != null) {
            AppMethodBeat.o(119314);
            return c;
        }
        c = azVar2.c(azVar);
        if (c != null) {
            c = Integer.valueOf(-c.intValue());
            AppMethodBeat.o(119314);
            return c;
        }
        AppMethodBeat.o(119314);
        return null;
    }

    public static boolean b(az azVar) {
        return azVar == BeW || azVar == BeX;
    }
}
