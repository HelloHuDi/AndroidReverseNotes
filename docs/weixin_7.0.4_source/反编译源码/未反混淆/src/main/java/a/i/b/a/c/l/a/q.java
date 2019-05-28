package a.i.b.a.c.l.a;

import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.am;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class q {
    static final /* synthetic */ boolean $assertionsDisabled = (!q.class.desiredAssertionStatus());
    private final r BKW;

    public enum a {
        IN,
        OUT,
        INV,
        STAR;

        static {
            AppMethodBeat.o(122790);
        }

        public static a a(ba baVar) {
            AppMethodBeat.i(122789);
            a aVar;
            switch (AnonymousClass1.BKX[baVar.ordinal()]) {
                case 1:
                    aVar = INV;
                    AppMethodBeat.o(122789);
                    return aVar;
                case 2:
                    aVar = IN;
                    AppMethodBeat.o(122789);
                    return aVar;
                case 3:
                    aVar = OUT;
                    AppMethodBeat.o(122789);
                    return aVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unknown variance");
                    AppMethodBeat.o(122789);
                    throw illegalStateException;
            }
        }
    }

    /* renamed from: a.i.b.a.c.l.a.q$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BKX = new int[ba.values().length];

        static {
            AppMethodBeat.i(122786);
            try {
                BKX[ba.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                BKX[ba.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                BKX[ba.OUT_VARIANCE.ordinal()] = 3;
                AppMethodBeat.o(122786);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(122786);
            }
        }
    }

    static {
        AppMethodBeat.i(122801);
        AppMethodBeat.o(122801);
    }

    public static w e(w wVar, w wVar2) {
        AppMethodBeat.i(122791);
        w a = t.a(wVar, wVar2, new p());
        AppMethodBeat.o(122791);
        return a;
    }

    private static w a(ar arVar, ap apVar) {
        AppMethodBeat.i(122792);
        Object obj = (apVar.ekq() == ba.IN_VARIANCE || arVar.dZh() == ba.IN_VARIANCE) ? 1 : null;
        if (obj != null) {
            ad dXN = a.i.b.a.c.i.c.a.G(arVar).dXN();
            AppMethodBeat.o(122792);
            return dXN;
        }
        w dZS = apVar.dZS();
        AppMethodBeat.o(122792);
        return dZS;
    }

    private static w b(ar arVar, ap apVar) {
        AppMethodBeat.i(122793);
        Object obj = (apVar.ekq() == ba.OUT_VARIANCE || arVar.dZh() == ba.OUT_VARIANCE) ? 1 : null;
        if (obj != null) {
            ad dXL = a.i.b.a.c.i.c.a.G(arVar).dXL();
            AppMethodBeat.o(122793);
            return dXL;
        }
        w dZS = apVar.dZS();
        AppMethodBeat.o(122793);
        return dZS;
    }

    public q(r rVar) {
        this.BKW = rVar;
    }

    public final boolean d(w wVar, w wVar2) {
        AppMethodBeat.i(122794);
        boolean f;
        if (wVar == wVar2) {
            AppMethodBeat.o(122794);
            return true;
        } else if (t.ai(wVar)) {
            if (!t.ai(wVar2)) {
                f = f(wVar2, wVar);
                AppMethodBeat.o(122794);
                return f;
            } else if (y.an(wVar) || y.an(wVar2) || !c(wVar, wVar2) || !c(wVar2, wVar)) {
                AppMethodBeat.o(122794);
                return false;
            } else {
                AppMethodBeat.o(122794);
                return true;
            }
        } else if (t.ai(wVar2)) {
            f = f(wVar, wVar2);
            AppMethodBeat.o(122794);
            return f;
        } else if (wVar.eci() != wVar2.eci()) {
            AppMethodBeat.o(122794);
            return false;
        } else if (wVar.eci()) {
            f = this.BKW.a(av.aA(wVar), av.aA(wVar2), this);
            AppMethodBeat.o(122794);
            return f;
        } else {
            an ejw = wVar.ejw();
            an ejw2 = wVar2.ejw();
            if (this.BKW.b(ejw, ejw2)) {
                List ejt = wVar.ejt();
                List ejt2 = wVar2.ejt();
                if (ejt.size() != ejt2.size()) {
                    AppMethodBeat.o(122794);
                    return false;
                }
                for (int i = 0; i < ejt.size(); i++) {
                    ap apVar = (ap) ejt.get(i);
                    ap apVar2 = (ap) ejt2.get(i);
                    if (!apVar.ekp() || !apVar2.ekp()) {
                        ar arVar = (ar) ejw.getParameters().get(i);
                        ar arVar2 = (ar) ejw2.getParameters().get(i);
                        a(apVar, apVar2, arVar);
                        if (c(arVar, apVar) != c(arVar2, apVar2)) {
                            AppMethodBeat.o(122794);
                            return false;
                        } else if (!this.BKW.a(apVar.dZS(), apVar2.dZS(), this)) {
                            AppMethodBeat.o(122794);
                            return false;
                        }
                    }
                }
                AppMethodBeat.o(122794);
                return true;
            }
            AppMethodBeat.o(122794);
            return false;
        }
    }

    private boolean f(w wVar, w wVar2) {
        AppMethodBeat.i(122795);
        if (!$assertionsDisabled && t.ai(wVar)) {
            AssertionError assertionError = new AssertionError("Only inflexible types are allowed here: ".concat(String.valueOf(wVar)));
            AppMethodBeat.o(122795);
            throw assertionError;
        } else if (c(t.aj(wVar2).BJx, wVar) && c(wVar, t.aj(wVar2).BJy)) {
            AppMethodBeat.o(122795);
            return true;
        } else {
            AppMethodBeat.o(122795);
            return false;
        }
    }

    private static a c(ar arVar, ap apVar) {
        ba baVar;
        ba baVar2;
        AppMethodBeat.i(122796);
        ba dZh = arVar.dZh();
        ba ekq = apVar.ekq();
        if (ekq == ba.INVARIANT) {
            baVar = dZh;
            baVar2 = ekq;
        } else {
            baVar = ekq;
            baVar2 = dZh;
        }
        a aVar;
        if (baVar2 == ba.IN_VARIANCE && baVar == ba.OUT_VARIANCE) {
            aVar = a.STAR;
            AppMethodBeat.o(122796);
            return aVar;
        } else if (baVar2 == ba.OUT_VARIANCE && baVar == ba.IN_VARIANCE) {
            aVar = a.STAR;
            AppMethodBeat.o(122796);
            return aVar;
        } else {
            aVar = a.a(baVar);
            AppMethodBeat.o(122796);
            return aVar;
        }
    }

    public final boolean c(w wVar, w wVar2) {
        AppMethodBeat.i(122797);
        while (!am.b(wVar, wVar2)) {
            w as = am.as(wVar);
            w at = am.at(wVar2);
            if (as == wVar && at == wVar2) {
                boolean g = g(wVar, wVar2);
                AppMethodBeat.o(122797);
                return g;
            }
            wVar2 = at;
            wVar = as;
        }
        if (!wVar.eci() || wVar2.eci()) {
            AppMethodBeat.o(122797);
            return true;
        }
        AppMethodBeat.o(122797);
        return false;
    }

    private boolean g(w wVar, w wVar2) {
        AppMethodBeat.i(122798);
        if (y.an(wVar) || y.an(wVar2)) {
            AppMethodBeat.o(122798);
            return true;
        } else if (!wVar2.eci() && wVar.eci()) {
            AppMethodBeat.o(122798);
            return false;
        } else if (g.z(wVar)) {
            AppMethodBeat.o(122798);
            return true;
        } else {
            w a = t.a(wVar, wVar2, this.BKW);
            if (a == null) {
                AppMethodBeat.o(122798);
                return false;
            } else if (wVar2.eci() || !a.eci()) {
                boolean h = h(a, wVar2);
                AppMethodBeat.o(122798);
                return h;
            } else {
                AppMethodBeat.o(122798);
                return false;
            }
        }
    }

    private boolean h(w wVar, w wVar2) {
        AppMethodBeat.i(122799);
        an ejw = wVar.ejw();
        List ejt = wVar.ejt();
        List ejt2 = wVar2.ejt();
        if (ejt.size() != ejt2.size()) {
            AppMethodBeat.o(122799);
            return false;
        }
        List parameters = ejw.getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            ar arVar = (ar) parameters.get(i);
            ap apVar = (ap) ejt2.get(i);
            ap apVar2 = (ap) ejt.get(i);
            if (!apVar.ekp()) {
                boolean z;
                a(apVar2, apVar, arVar);
                if (y.an(apVar2.dZS()) || y.an(apVar.dZS())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || arVar.dZh() != ba.INVARIANT || apVar2.ekq() != ba.INVARIANT || apVar.ekq() != ba.INVARIANT) {
                    w a = a(arVar, apVar);
                    if (this.BKW.b(a(arVar, apVar2), a, this)) {
                        a = b(arVar, apVar);
                        w b = b(arVar, apVar2);
                        if (apVar.ekq() != ba.OUT_VARIANCE) {
                            if (!this.BKW.b(a, b, this)) {
                                AppMethodBeat.o(122799);
                                return false;
                            }
                        } else if (!($assertionsDisabled || g.y(a))) {
                            AssertionError assertionError = new AssertionError("In component must be Nothing for out-projection");
                            AppMethodBeat.o(122799);
                            throw assertionError;
                        }
                    }
                    AppMethodBeat.o(122799);
                    return false;
                } else if (!this.BKW.a(apVar2.dZS(), apVar.dZS(), this)) {
                    AppMethodBeat.o(122799);
                    return false;
                }
            }
        }
        AppMethodBeat.o(122799);
        return true;
    }

    private static boolean a(ap apVar, ap apVar2, ar arVar) {
        AppMethodBeat.i(122800);
        if (arVar.dZh() != ba.INVARIANT) {
            AppMethodBeat.o(122800);
        } else if (apVar.ekq() == ba.INVARIANT || apVar2.ekq() != ba.INVARIANT) {
            AppMethodBeat.o(122800);
        } else {
            apVar2.dZS();
            AppMethodBeat.o(122800);
        }
        return false;
    }
}
