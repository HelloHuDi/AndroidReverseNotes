package a.i.b.a.c.l;

import a.i.b.a.c.a.g;
import a.i.b.a.c.b.a.k;
import a.i.b.a.c.b.a.l;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.i.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class au {
    static final /* synthetic */ boolean $assertionsDisabled = (!au.class.desiredAssertionStatus());
    public static final au BJW = d(as.BJU);
    public final as Bik;

    static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    enum b {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION;

        static {
            AppMethodBeat.o(122664);
        }
    }

    static {
        AppMethodBeat.i(122680);
        AppMethodBeat.o(122680);
    }

    public static au d(as asVar) {
        AppMethodBeat.i(122665);
        au auVar = new au(asVar);
        AppMethodBeat.o(122665);
        return auVar;
    }

    public static au b(as asVar, as asVar2) {
        AppMethodBeat.i(122666);
        au d = d(l.a(asVar, asVar2));
        AppMethodBeat.o(122666);
        return d;
    }

    public static au aw(w wVar) {
        AppMethodBeat.i(122667);
        au d = d(ao.a(wVar.ejw(), wVar.ejt()));
        AppMethodBeat.o(122667);
        return d;
    }

    private au(as asVar) {
        this.Bik = asVar;
    }

    public final w c(w wVar, ba baVar) {
        AppMethodBeat.i(122669);
        ap c = c(new ar(baVar, this.Bik.a(wVar, baVar)));
        if (c == null) {
            AppMethodBeat.o(122669);
            return null;
        }
        w dZS = c.dZS();
        AppMethodBeat.o(122669);
        return dZS;
    }

    private ap c(ap apVar) {
        AppMethodBeat.i(122670);
        ap d = d(apVar);
        if (this.Bik.eki() || this.Bik.ejx()) {
            d = a.i.b.a.c.l.d.b.a(d, this.Bik.ejx());
            AppMethodBeat.o(122670);
            return d;
        }
        AppMethodBeat.o(122670);
        return d;
    }

    private ap a(ap apVar, int i) {
        AppMethodBeat.i(122672);
        a(i, apVar, this.Bik);
        if (apVar.ekp()) {
            AppMethodBeat.o(122672);
            return apVar;
        }
        w dZS = apVar.dZS();
        if (dZS instanceof aw) {
            az ekk = ((aw) dZS).ekk();
            dZS = ((aw) dZS).ekl();
            ap a = a(new ar(apVar.ekq(), ekk), i + 1);
            apVar = new ar(a.ekq(), ax.b(a.dZS().ekn(), c(dZS, apVar.ekq())));
            AppMethodBeat.o(122672);
            return apVar;
        } else if (n.ag(dZS) || (dZS.ekn() instanceof ac)) {
            AppMethodBeat.o(122672);
            return apVar;
        } else {
            ap O = this.Bik.O(dZS);
            ba ekq = apVar.ekq();
            if (O == null && t.ai(dZS) && !am.aq(dZS)) {
                q aj = t.aj(dZS);
                ap a2 = a(new ar(ekq, aj.BJx), i + 1);
                O = a(new ar(ekq, aj.BJy), i + 1);
                ba ekq2 = a2.ekq();
                if (!$assertionsDisabled && ((ekq2 != O.ekq() || ekq != ba.INVARIANT) && ekq != ekq2)) {
                    AssertionError assertionError = new AssertionError("Unexpected substituted projection kind: " + ekq2 + "; original: " + ekq);
                    AppMethodBeat.o(122672);
                    throw assertionError;
                } else if (a2.dZS() == aj.BJx && O.dZS() == aj.BJy) {
                    AppMethodBeat.o(122672);
                    return apVar;
                } else {
                    apVar = new ar(ekq2, x.a(at.av(a2.dZS()), at.av(O.dZS())));
                    AppMethodBeat.o(122672);
                    return apVar;
                }
            } else if (g.y(dZS) || y.an(dZS)) {
                AppMethodBeat.o(122672);
                return apVar;
            } else if (O != null) {
                b b = b(ekq, O.ekq());
                if (!c.ae(dZS)) {
                    switch (b) {
                        case OUT_IN_IN_POSITION:
                            a aVar = new a("Out-projection in in-position");
                            AppMethodBeat.o(122672);
                            throw aVar;
                        case IN_IN_OUT_POSITION:
                            apVar = new ar(ba.OUT_VARIANCE, dZS.ejw().dZD().dXN());
                            AppMethodBeat.o(122672);
                            return apVar;
                    }
                }
                f ar = am.ar(dZS);
                if (O.ekp()) {
                    AppMethodBeat.o(122672);
                    return O;
                }
                w R;
                if (ar != null) {
                    R = ar.R(O.dZS());
                } else {
                    R = av.b(O.dZS(), dZS.eci());
                }
                if (!dZS.dYn().isEmpty()) {
                    a.i.b.a.c.b.a.g j = j(this.Bik.h(dZS.dYn()));
                    R = a.i.b.a.c.l.c.a.a(R, new k(R.dYn(), j));
                }
                apVar = new ar(b == b.NO_CONFLICT ? a(ekq, O.ekq()) : ekq, R);
                AppMethodBeat.o(122672);
                return apVar;
            } else {
                apVar = b(apVar, i);
                AppMethodBeat.o(122672);
                return apVar;
            }
        }
    }

    private static a.i.b.a.c.b.a.g j(a.i.b.a.c.b.a.g gVar) {
        AppMethodBeat.i(122673);
        if (gVar.j(g.Bag.BaW)) {
            l lVar = new l(gVar, new a.f.a.b<a.i.b.a.c.f.b, Boolean>() {
                public final /* synthetic */ Object am(Object obj) {
                    boolean z;
                    AppMethodBeat.i(122660);
                    if (((a.i.b.a.c.f.b) obj).equals(g.Bag.BaW)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(122660);
                    return valueOf;
                }
            });
            AppMethodBeat.o(122673);
            return lVar;
        }
        AppMethodBeat.o(122673);
        return gVar;
    }

    private ap b(ap apVar, int i) {
        AppMethodBeat.i(122674);
        w dZS = apVar.dZS();
        ba ekq = apVar.ekq();
        if (dZS.ejw().dYs() instanceof ar) {
            AppMethodBeat.o(122674);
            return apVar;
        }
        w wVar = null;
        ad ao = ag.ao(dZS);
        if (ao != null) {
            wVar = c(ao, ba.INVARIANT);
        }
        dZS = at.a(dZS, b(dZS.ejw().getParameters(), dZS.ejt(), i), this.Bik.h(dZS.dYn()));
        if ((dZS instanceof ad) && (wVar instanceof ad)) {
            dZS = ag.b((ad) dZS, (ad) wVar);
        }
        apVar = new ar(ekq, dZS);
        AppMethodBeat.o(122674);
        return apVar;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private List<ap> b(List<ar> list, List<ap> list2, int i) {
        AppMethodBeat.i(122675);
        ArrayList arrayList = new ArrayList(list.size());
        int i2 = 0;
        Object obj = null;
        while (i2 < list.size()) {
            ap e;
            Object obj2;
            ar arVar = (ar) list.get(i2);
            ap apVar = (ap) list2.get(i2);
            ap a = a(apVar, i + 1);
            switch (b(arVar.dZh(), a.ekq())) {
                case OUT_IN_IN_POSITION:
                case IN_IN_OUT_POSITION:
                    e = av.e(arVar);
                    break;
                case NO_CONFLICT:
                    if (!(arVar.dZh() == ba.INVARIANT || a.ekp())) {
                        e = new ar(ba.INVARIANT, a.dZS());
                        break;
                    }
                default:
                    e = a;
                    break;
            }
            if (e != apVar) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            arrayList.add(e);
            i2++;
            obj = obj2;
        }
        if (obj == null) {
            AppMethodBeat.o(122675);
            return list2;
        }
        AppMethodBeat.o(122675);
        return arrayList;
    }

    public static ba a(ba baVar, ap apVar) {
        AppMethodBeat.i(122676);
        ba baVar2;
        if (apVar.ekp()) {
            baVar2 = ba.OUT_VARIANCE;
            AppMethodBeat.o(122676);
            return baVar2;
        }
        baVar2 = a(baVar, apVar.ekq());
        AppMethodBeat.o(122676);
        return baVar2;
    }

    private static ba a(ba baVar, ba baVar2) {
        AppMethodBeat.i(122677);
        if (baVar == ba.INVARIANT) {
            AppMethodBeat.o(122677);
            return baVar2;
        } else if (baVar2 == ba.INVARIANT) {
            AppMethodBeat.o(122677);
            return baVar;
        } else if (baVar == baVar2) {
            AppMethodBeat.o(122677);
            return baVar2;
        } else {
            AssertionError assertionError = new AssertionError("Variance conflict: type parameter variance '" + baVar + "' and projection kind '" + baVar2 + "' cannot be combined");
            AppMethodBeat.o(122677);
            throw assertionError;
        }
    }

    private static b b(ba baVar, ba baVar2) {
        if (baVar == ba.IN_VARIANCE && baVar2 == ba.OUT_VARIANCE) {
            return b.OUT_IN_IN_POSITION;
        }
        if (baVar == ba.OUT_VARIANCE && baVar2 == ba.IN_VARIANCE) {
            return b.IN_IN_OUT_POSITION;
        }
        return b.NO_CONFLICT;
    }

    private static void a(int i, ap apVar, as asVar) {
        AppMethodBeat.i(122678);
        if (i > 100) {
            IllegalStateException illegalStateException = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + dU(apVar) + "; substitution: " + dU(asVar));
            AppMethodBeat.o(122678);
            throw illegalStateException;
        }
        AppMethodBeat.o(122678);
    }

    private static String dU(Object obj) {
        AppMethodBeat.i(122679);
        String obj2;
        try {
            obj2 = obj.toString();
            AppMethodBeat.o(122679);
            return obj2;
        } catch (Throwable th) {
            if (a.i.b.a.c.n.c.r(th)) {
                RuntimeException runtimeException = (RuntimeException) th;
                AppMethodBeat.o(122679);
            } else {
                obj2 = "[Exception while computing toString(): " + th + "]";
                AppMethodBeat.o(122679);
                return obj2;
            }
        }
    }

    public final w b(w wVar, ba baVar) {
        AppMethodBeat.i(122668);
        if (this.Bik.isEmpty()) {
            AppMethodBeat.o(122668);
            return wVar;
        }
        try {
            wVar = a(new ar(baVar, wVar), 0).dZS();
            AppMethodBeat.o(122668);
            return wVar;
        } catch (a e) {
            wVar = p.awn(e.getMessage());
            AppMethodBeat.o(122668);
            return wVar;
        }
    }

    public final ap d(ap apVar) {
        AppMethodBeat.i(122671);
        if (this.Bik.isEmpty()) {
            AppMethodBeat.o(122671);
            return apVar;
        }
        try {
            apVar = a(apVar, 0);
            AppMethodBeat.o(122671);
            return apVar;
        } catch (a e) {
            AppMethodBeat.o(122671);
            return null;
        }
    }
}
