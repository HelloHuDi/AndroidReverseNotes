package a.i.b.a.c.i;

import a.f.a.b;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.k;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.h.c;
import a.i.b.a.c.h.h;
import a.i.b.a.c.h.i;
import a.i.b.a.c.l.w;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.List;

public class g implements Comparator<l> {
    static final /* synthetic */ boolean $assertionsDisabled = (!g.class.desiredAssertionStatus());
    public static final g BEi = new g();
    private static final c BEj = a.i.b.a.c.h.c.a.e(new b<i, y>() {
        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(121986);
            i iVar = (i) obj;
            iVar.rV(false);
            iVar.rU(true);
            iVar.a(a.i.b.a.c.h.a.UNLESS_EMPTY);
            iVar.n(h.BCv);
            y yVar = y.AUy;
            AppMethodBeat.o(121986);
            return yVar;
        }
    });

    public static class a implements Comparator<l> {
        public static final a BEk = new a();

        static /* synthetic */ Integer g(l lVar, l lVar2) {
            AppMethodBeat.i(121990);
            Integer f = f(lVar, lVar2);
            AppMethodBeat.o(121990);
            return f;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(121989);
            Integer f = f((l) obj, (l) obj2);
            if (f != null) {
                int intValue = f.intValue();
                AppMethodBeat.o(121989);
                return intValue;
            }
            AppMethodBeat.o(121989);
            return 0;
        }

        static {
            AppMethodBeat.i(121991);
            AppMethodBeat.o(121991);
        }

        private a() {
        }

        private static int E(l lVar) {
            AppMethodBeat.i(121987);
            if (d.x(lVar)) {
                AppMethodBeat.o(121987);
                return 8;
            } else if (lVar instanceof k) {
                AppMethodBeat.o(121987);
                return 7;
            } else if (lVar instanceof ah) {
                if (((ah) lVar).dYQ() == null) {
                    AppMethodBeat.o(121987);
                    return 6;
                }
                AppMethodBeat.o(121987);
                return 5;
            } else if (lVar instanceof t) {
                if (((t) lVar).dYQ() == null) {
                    AppMethodBeat.o(121987);
                    return 4;
                }
                AppMethodBeat.o(121987);
                return 3;
            } else if (lVar instanceof e) {
                AppMethodBeat.o(121987);
                return 2;
            } else if (lVar instanceof aq) {
                AppMethodBeat.o(121987);
                return 1;
            } else {
                AppMethodBeat.o(121987);
                return 0;
            }
        }

        private static Integer f(l lVar, l lVar2) {
            AppMethodBeat.i(121988);
            int E = E(lVar2) - E(lVar);
            Integer valueOf;
            if (E != 0) {
                valueOf = Integer.valueOf(E);
                AppMethodBeat.o(121988);
                return valueOf;
            } else if (d.x(lVar) && d.x(lVar2)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.o(121988);
                return valueOf;
            } else {
                E = lVar.dZg().v(lVar2.dZg());
                if (E != 0) {
                    valueOf = Integer.valueOf(E);
                    AppMethodBeat.o(121988);
                    return valueOf;
                }
                AppMethodBeat.o(121988);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.i(121993);
        a.i.b.a.c.h.c.a aVar = c.BBP;
        AppMethodBeat.o(121993);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        int i = 1;
        AppMethodBeat.i(121992);
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        Integer g = a.g(lVar, lVar2);
        int intValue;
        if (g != null) {
            intValue = g.intValue();
            AppMethodBeat.o(121992);
            return intValue;
        }
        AssertionError assertionError;
        if ((lVar instanceof aq) && (lVar2 instanceof aq)) {
            intValue = BEj.b(((aq) lVar).dZP()).compareTo(BEj.b(((aq) lVar2).dZP()));
            if (intValue != 0) {
                AppMethodBeat.o(121992);
                return intValue;
            }
        } else if ((lVar instanceof a.i.b.a.c.b.a) && (lVar2 instanceof a.i.b.a.c.b.a)) {
            int i2;
            a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) lVar;
            a.i.b.a.c.b.a aVar2 = (a.i.b.a.c.b.a) lVar2;
            ak dYQ = aVar.dYQ();
            ak dYQ2 = aVar2.dYQ();
            if (!$assertionsDisabled) {
                i2 = dYQ != null ? 1 : 0;
                if (dYQ2 == null) {
                    i = 0;
                }
                if (i2 != i) {
                    assertionError = new AssertionError();
                    AppMethodBeat.o(121992);
                    throw assertionError;
                }
            }
            if (dYQ != null) {
                i = BEj.b(dYQ.dZS()).compareTo(BEj.b(dYQ2.dZS()));
                if (i != 0) {
                    AppMethodBeat.o(121992);
                    return i;
                }
            }
            List dYV = aVar.dYV();
            List dYV2 = aVar2.dYV();
            for (i2 = 0; i2 < Math.min(dYV.size(), dYV2.size()); i2++) {
                i = BEj.b(((au) dYV.get(i2)).dZS()).compareTo(BEj.b(((au) dYV2.get(i2)).dZS()));
                if (i != 0) {
                    AppMethodBeat.o(121992);
                    return i;
                }
            }
            i = dYV.size() - dYV2.size();
            if (i != 0) {
                AppMethodBeat.o(121992);
                return i;
            }
            dYV2 = aVar.dYS();
            List dYS = aVar2.dYS();
            for (i2 = 0; i2 < Math.min(dYV2.size(), dYS.size()); i2++) {
                List dWP = ((ar) dYV2.get(i2)).dWP();
                List dWP2 = ((ar) dYS.get(i2)).dWP();
                i = dWP.size() - dWP2.size();
                if (i != 0) {
                    AppMethodBeat.o(121992);
                    return i;
                }
                for (int i3 = 0; i3 < dWP.size(); i3++) {
                    i = BEj.b((w) dWP.get(i3)).compareTo(BEj.b((w) dWP2.get(i3)));
                    if (i != 0) {
                        AppMethodBeat.o(121992);
                        return i;
                    }
                }
            }
            i = dYV2.size() - dYS.size();
            if (i != 0) {
                AppMethodBeat.o(121992);
                return i;
            } else if ((aVar instanceof a.i.b.a.c.b.b) && (aVar2 instanceof a.i.b.a.c.b.b)) {
                intValue = ((a.i.b.a.c.b.b) aVar).dYZ().ordinal() - ((a.i.b.a.c.b.b) aVar2).dYZ().ordinal();
                if (intValue != 0) {
                    AppMethodBeat.o(121992);
                    return intValue;
                }
            }
        } else if ((lVar instanceof e) && (lVar2 instanceof e)) {
            e eVar = (e) lVar;
            e eVar2 = (e) lVar2;
            if (eVar.dYc().ordinal() != eVar2.dYc().ordinal()) {
                intValue = eVar.dYc().ordinal() - eVar2.dYc().ordinal();
                AppMethodBeat.o(121992);
                return intValue;
            } else if (eVar.dYg() != eVar2.dYg()) {
                if (eVar.dYg()) {
                    AppMethodBeat.o(121992);
                    return 1;
                }
                AppMethodBeat.o(121992);
                return -1;
            }
        } else {
            assertionError = new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{lVar, lVar.getClass(), lVar2, lVar2.getClass()}));
            AppMethodBeat.o(121992);
            throw assertionError;
        }
        intValue = BEj.k(lVar).compareTo(BEj.k(lVar2));
        if (intValue != 0) {
            AppMethodBeat.o(121992);
            return intValue;
        }
        intValue = d.s(lVar).dZg().v(d.s(lVar2).dZg());
        AppMethodBeat.o(121992);
        return intValue;
    }

    private g() {
    }
}
