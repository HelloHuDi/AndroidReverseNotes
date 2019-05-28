package a.i.b.a.c.d.a;

import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.p;
import a.i.b.a.c.i.d;
import a.i.b.a.c.i.e.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n {
    public static final az Blg = new az("package") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119701);
            boolean c = n.c(pVar, lVar);
            AppMethodBeat.o(119701);
            return c;
        }

        public final Integer c(az azVar) {
            AppMethodBeat.i(119702);
            Integer valueOf;
            if (this == azVar) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.o(119702);
                return valueOf;
            } else if (ay.b(azVar)) {
                valueOf = Integer.valueOf(1);
                AppMethodBeat.o(119702);
                return valueOf;
            } else {
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.o(119702);
                return valueOf;
            }
        }

        public final String getDisplayName() {
            return "public/*package*/";
        }

        public final az eag() {
            return ay.BeY;
        }
    };
    public static final az Blh = new az("protected_static") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119703);
            boolean c = n.c(eVar, pVar, lVar);
            AppMethodBeat.o(119703);
            return c;
        }

        public final String getDisplayName() {
            return "protected/*protected static*/";
        }

        public final az eag() {
            return ay.BeY;
        }
    };
    public static final az Bli = new az("protected_and_package") {
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(119704);
            boolean c = n.c(eVar, pVar, lVar);
            AppMethodBeat.o(119704);
            return c;
        }

        public final Integer c(az azVar) {
            AppMethodBeat.i(119705);
            Integer valueOf;
            if (this == azVar) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.o(119705);
                return valueOf;
            } else if (azVar == ay.BeZ) {
                AppMethodBeat.o(119705);
                return null;
            } else if (ay.b(azVar)) {
                valueOf = Integer.valueOf(1);
                AppMethodBeat.o(119705);
                return valueOf;
            } else {
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.o(119705);
                return valueOf;
            }
        }

        public final String getDisplayName() {
            return "protected/*protected and package*/";
        }

        public final az eag() {
            return ay.BeY;
        }
    };

    static /* synthetic */ boolean c(l lVar, l lVar2) {
        AppMethodBeat.i(119707);
        boolean b = b(lVar, lVar2);
        AppMethodBeat.o(119707);
        return b;
    }

    static {
        AppMethodBeat.i(119709);
        AppMethodBeat.o(119709);
    }

    private static boolean b(l lVar, l lVar2) {
        AppMethodBeat.i(119706);
        ab abVar = (ab) d.a(lVar, ab.class, false);
        ab abVar2 = (ab) d.a(lVar2, ab.class, false);
        if (abVar2 == null || abVar == null || !abVar.dZF().equals(abVar2.dZF())) {
            AppMethodBeat.o(119706);
            return false;
        }
        AppMethodBeat.o(119706);
        return true;
    }

    static /* synthetic */ boolean c(e eVar, p pVar, l lVar) {
        AppMethodBeat.i(119708);
        if (b(d.a(pVar), lVar)) {
            AppMethodBeat.o(119708);
            return true;
        }
        boolean b = ay.BeY.b(eVar, pVar, lVar);
        AppMethodBeat.o(119708);
        return b;
    }
}
