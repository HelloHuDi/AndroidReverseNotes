package a.i.b.a.c.i;

import a.i.b.a.c.a.g;
import a.i.b.a.c.a.m;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ad;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.aw;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.o;
import a.i.b.a.c.b.p;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.c;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class d {
    static final /* synthetic */ boolean $assertionsDisabled = (!d.class.desiredAssertionStatus());
    public static final f BDQ = f.avX("values");
    public static final f BDR = f.avX("valueOf");
    public static final b BDS;
    public static final b BDT;
    public static final b BDU;
    public static final b BDV = BDT.q(f.avX("Continuation"));
    public static final b BDW = BDS.q(f.avX("Continuation"));
    public static final b BDX = new b("kotlin.Result");
    public static final b BDY = new b("kotlin.jvm.JvmName");

    static {
        AppMethodBeat.i(121975);
        b bVar = new b("kotlin.coroutines");
        BDS = bVar;
        bVar = bVar.q(f.avX("experimental"));
        BDT = bVar;
        BDU = bVar.q(f.avX("intrinsics"));
        AppMethodBeat.o(121975);
    }

    private d() {
    }

    public static ak l(l lVar) {
        AppMethodBeat.i(121938);
        if (lVar instanceof e) {
            ak dZl = ((e) lVar).dZl();
            AppMethodBeat.o(121938);
            return dZl;
        }
        AppMethodBeat.o(121938);
        return null;
    }

    public static boolean m(l lVar) {
        AppMethodBeat.i(121939);
        l lVar2 = lVar;
        while (lVar2 != null) {
            if (!w(lVar2)) {
                Object obj;
                if ((lVar2 instanceof p) && ((p) lVar2).dYf() == ay.Bfb) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    lVar2 = lVar2.dXW();
                }
            }
            AppMethodBeat.o(121939);
            return true;
        }
        AppMethodBeat.o(121939);
        return false;
    }

    public static c n(l lVar) {
        AppMethodBeat.i(121940);
        b p = p(lVar);
        c cVar;
        if (p != null) {
            cVar = p.ByQ;
            AppMethodBeat.o(121940);
            return cVar;
        }
        cVar = q(lVar);
        AppMethodBeat.o(121940);
        return cVar;
    }

    public static b o(l lVar) {
        AppMethodBeat.i(121941);
        b p = p(lVar);
        if (p != null) {
            AppMethodBeat.o(121941);
            return p;
        }
        p = q(lVar).ehI();
        AppMethodBeat.o(121941);
        return p;
    }

    private static b p(l lVar) {
        AppMethodBeat.i(121942);
        b bVar;
        if ((lVar instanceof y) || a.i.b.a.c.l.p.L(lVar)) {
            bVar = b.ByP;
            AppMethodBeat.o(121942);
            return bVar;
        } else if (lVar instanceof ad) {
            bVar = ((ad) lVar).dZF();
            AppMethodBeat.o(121942);
            return bVar;
        } else if (lVar instanceof ab) {
            bVar = ((ab) lVar).dZF();
            AppMethodBeat.o(121942);
            return bVar;
        } else {
            AppMethodBeat.o(121942);
            return null;
        }
    }

    private static c q(l lVar) {
        AppMethodBeat.i(121943);
        l dXW = lVar.dXW();
        if ($assertionsDisabled || dXW != null) {
            c t = n(dXW).t(lVar.dZg());
            AppMethodBeat.o(121943);
            return t;
        }
        AssertionError assertionError = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(lVar)));
        AppMethodBeat.o(121943);
        throw assertionError;
    }

    public static boolean r(l lVar) {
        AppMethodBeat.i(121944);
        if (lVar == null || !(lVar.dXW() instanceof ab)) {
            AppMethodBeat.o(121944);
            return false;
        }
        AppMethodBeat.o(121944);
        return true;
    }

    public static boolean e(l lVar, l lVar2) {
        AppMethodBeat.i(121945);
        boolean equals = s(lVar).equals(s(lVar2));
        AppMethodBeat.o(121945);
        return equals;
    }

    public static <D extends l> D a(l lVar, Class<D> cls) {
        AppMethodBeat.i(121946);
        l a = a(lVar, cls, true);
        AppMethodBeat.o(121946);
        return a;
    }

    public static <D extends l> D a(l lVar, Class<D> cls, boolean z) {
        AppMethodBeat.i(121947);
        if (lVar == null) {
            AppMethodBeat.o(121947);
            return null;
        }
        D dXW;
        if (z) {
            dXW = lVar.dXW();
        } else {
            dXW = lVar;
        }
        while (dXW != null) {
            if (cls.isInstance(dXW)) {
                AppMethodBeat.o(121947);
                return dXW;
            }
            dXW = dXW.dXW();
        }
        AppMethodBeat.o(121947);
        return null;
    }

    public static y Y(w wVar) {
        AppMethodBeat.i(121948);
        h dYs = wVar.ejw().dYs();
        if (dYs == null) {
            AppMethodBeat.o(121948);
            return null;
        }
        y t = t(dYs);
        AppMethodBeat.o(121948);
        return t;
    }

    public static y s(l lVar) {
        AppMethodBeat.i(121949);
        y t = t(lVar);
        if ($assertionsDisabled || t != null) {
            AppMethodBeat.o(121949);
            return t;
        }
        AssertionError assertionError = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(lVar)));
        AppMethodBeat.o(121949);
        throw assertionError;
    }

    private static y t(l lVar) {
        AppMethodBeat.i(121950);
        l lVar2 = lVar;
        while (lVar2 != null) {
            y yVar;
            if (lVar2 instanceof y) {
                yVar = (y) lVar2;
                AppMethodBeat.o(121950);
                return yVar;
            } else if (lVar2 instanceof ad) {
                yVar = ((ad) lVar2).dZG();
                AppMethodBeat.o(121950);
                return yVar;
            } else {
                lVar2 = lVar2.dXW();
            }
        }
        AppMethodBeat.o(121950);
        return null;
    }

    public static boolean b(e eVar, e eVar2) {
        AppMethodBeat.i(121951);
        for (w a : eVar.dXY().eap()) {
            if (a(a, eVar2.dZm())) {
                AppMethodBeat.o(121951);
                return true;
            }
        }
        AppMethodBeat.o(121951);
        return false;
    }

    public static boolean c(e eVar, e eVar2) {
        AppMethodBeat.i(121952);
        boolean b = b(eVar.dZf(), eVar2.dZm());
        AppMethodBeat.o(121952);
        return b;
    }

    private static boolean a(w wVar, l lVar) {
        AppMethodBeat.i(121953);
        h dYs = wVar.ejw().dYs();
        if (dYs != null) {
            l dZd = dYs.dZd();
            if ((dZd instanceof h) && (lVar instanceof h) && ((h) lVar).dXY().equals(((h) dZd).dXY())) {
                AppMethodBeat.o(121953);
                return true;
            }
        }
        AppMethodBeat.o(121953);
        return false;
    }

    public static boolean b(w wVar, l lVar) {
        AppMethodBeat.i(121954);
        if (a(wVar, lVar)) {
            AppMethodBeat.o(121954);
            return true;
        }
        for (w b : wVar.ejw().eap()) {
            if (b(b, lVar)) {
                AppMethodBeat.o(121954);
                return true;
            }
        }
        AppMethodBeat.o(121954);
        return false;
    }

    public static boolean u(l lVar) {
        AppMethodBeat.i(121955);
        if (a(lVar, a.i.b.a.c.b.f.OBJECT) && ((e) lVar).dYg()) {
            AppMethodBeat.o(121955);
            return true;
        }
        AppMethodBeat.o(121955);
        return false;
    }

    public static boolean v(l lVar) {
        AppMethodBeat.i(121956);
        if (a(lVar, a.i.b.a.c.b.f.CLASS) && ((e) lVar).dYd() == a.i.b.a.c.b.w.SEALED) {
            AppMethodBeat.o(121956);
            return true;
        }
        AppMethodBeat.o(121956);
        return false;
    }

    public static boolean x(l lVar) {
        AppMethodBeat.i(121958);
        boolean a = a(lVar, a.i.b.a.c.b.f.ENUM_ENTRY);
        AppMethodBeat.o(121958);
        return a;
    }

    public static boolean y(l lVar) {
        AppMethodBeat.i(121959);
        boolean a = a(lVar, a.i.b.a.c.b.f.ENUM_CLASS);
        AppMethodBeat.o(121959);
        return a;
    }

    public static boolean z(l lVar) {
        AppMethodBeat.i(121960);
        boolean a = a(lVar, a.i.b.a.c.b.f.ANNOTATION_CLASS);
        AppMethodBeat.o(121960);
        return a;
    }

    public static boolean A(l lVar) {
        AppMethodBeat.i(121961);
        boolean a = a(lVar, a.i.b.a.c.b.f.INTERFACE);
        AppMethodBeat.o(121961);
        return a;
    }

    private static boolean a(l lVar, a.i.b.a.c.b.f fVar) {
        AppMethodBeat.i(121963);
        if ((lVar instanceof e) && ((e) lVar).dYc() == fVar) {
            AppMethodBeat.o(121963);
            return true;
        }
        AppMethodBeat.o(121963);
        return false;
    }

    public static e x(e eVar) {
        AppMethodBeat.i(121964);
        for (w ejw : eVar.dXY().eap()) {
            e b = b(ejw.ejw());
            if (b.dYc() != a.i.b.a.c.b.f.INTERFACE) {
                AppMethodBeat.o(121964);
                return b;
            }
        }
        AppMethodBeat.o(121964);
        return null;
    }

    public static e Z(w wVar) {
        AppMethodBeat.i(139065);
        e b = b(wVar.ejw());
        AppMethodBeat.o(139065);
        return b;
    }

    private static e b(an anVar) {
        AppMethodBeat.i(121966);
        h dYs = anVar.dYs();
        if ($assertionsDisabled || (dYs instanceof e)) {
            e eVar = (e) dYs;
            AppMethodBeat.o(121966);
            return eVar;
        }
        AssertionError assertionError = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(anVar)));
        AppMethodBeat.o(121966);
        throw assertionError;
    }

    public static az y(e eVar) {
        AppMethodBeat.i(121967);
        a.i.b.a.c.b.f dYc = eVar.dYc();
        az azVar;
        if (dYc == a.i.b.a.c.b.f.ENUM_CLASS || dYc.dZn() || v((l) eVar)) {
            azVar = ay.BeW;
            AppMethodBeat.o(121967);
            return azVar;
        } else if (w(eVar)) {
            azVar = ay.Bfh;
            AppMethodBeat.o(121967);
            return azVar;
        } else if ($assertionsDisabled || dYc == a.i.b.a.c.b.f.CLASS || dYc == a.i.b.a.c.b.f.INTERFACE || dYc == a.i.b.a.c.b.f.ANNOTATION_CLASS) {
            azVar = ay.Bfa;
            AppMethodBeat.o(121967);
            return azVar;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(121967);
            throw assertionError;
        }
    }

    public static <D extends a.i.b.a.c.b.b> D u(D d) {
        a.i.b.a.c.b.b d2;
        AppMethodBeat.i(121968);
        while (d2.dYZ() == a.FAKE_OVERRIDE) {
            Collection dYX = d2.dYX();
            if (dYX.isEmpty()) {
                IllegalStateException illegalStateException = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(d2)));
                AppMethodBeat.o(121968);
                throw illegalStateException;
            }
            d2 = (a.i.b.a.c.b.b) dYX.iterator().next();
        }
        AppMethodBeat.o(121968);
        return d2;
    }

    public static <D extends p> D a(D d) {
        AppMethodBeat.i(121969);
        if (d instanceof a.i.b.a.c.b.b) {
            a.i.b.a.c.b.b u = u((a.i.b.a.c.b.b) d);
            AppMethodBeat.o(121969);
            return u;
        }
        AppMethodBeat.o(121969);
        return d;
    }

    public static boolean a(aw awVar, w wVar) {
        AppMethodBeat.i(121970);
        if (awVar.dZZ() || a.i.b.a.c.l.y.an(wVar)) {
            AppMethodBeat.o(121970);
            return false;
        } else if (av.aC(wVar)) {
            AppMethodBeat.o(121970);
            return true;
        } else {
            g G = a.i.b.a.c.i.c.a.G(awVar);
            if (!(g.p(wVar) || a.i.b.a.c.l.a.c.BKs.d(G.dXP(), wVar) || a.i.b.a.c.l.a.c.BKs.d(G.avB("Number").dZf(), wVar) || a.i.b.a.c.l.a.c.BKs.d(G.dXM(), wVar))) {
                m mVar = m.BcG;
                if (!m.G(wVar)) {
                    AppMethodBeat.o(121970);
                    return false;
                }
            }
            AppMethodBeat.o(121970);
            return true;
        }
    }

    public static <D extends a.i.b.a.c.b.a> Set<D> d(D d) {
        AppMethodBeat.i(121971);
        Set linkedHashSet = new LinkedHashSet();
        a(d.dYU(), linkedHashSet);
        AppMethodBeat.o(121971);
        return linkedHashSet;
    }

    private static <D extends a.i.b.a.c.b.a> void a(D d, Set<D> set) {
        AppMethodBeat.i(121972);
        if (set.contains(d)) {
            AppMethodBeat.o(121972);
            return;
        }
        for (a.i.b.a.c.b.a dYU : d.dYU().dYX()) {
            a.i.b.a.c.b.a dYU2 = dYU2.dYU();
            a(dYU2, (Set) set);
            set.add(dYU2);
        }
        AppMethodBeat.o(121972);
    }

    public static a.i.b.a.c.b.an C(l lVar) {
        ah dZH;
        AppMethodBeat.i(121973);
        if (lVar instanceof aj) {
            dZH = ((aj) lVar).dZH();
        } else {
            l dZH2 = lVar;
        }
        a.i.b.a.c.b.an dXz;
        if (dZH2 instanceof o) {
            dXz = dZH2.dYo().dXz();
            AppMethodBeat.o(121973);
            return dXz;
        }
        dXz = a.i.b.a.c.b.an.BeS;
        AppMethodBeat.o(121973);
        return dXz;
    }

    public static a.i.b.a.c.b.b v(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(121974);
        if (bVar instanceof ag) {
            ah dZH = ((ag) bVar).dZH();
            AppMethodBeat.o(121974);
            return dZH;
        }
        AppMethodBeat.o(121974);
        return bVar;
    }

    private static boolean w(l lVar) {
        AppMethodBeat.i(121957);
        if (a(lVar, a.i.b.a.c.b.f.CLASS) && lVar.dZg().equals(a.i.b.a.c.f.h.Bzc)) {
            AppMethodBeat.o(121957);
            return true;
        }
        AppMethodBeat.o(121957);
        return false;
    }

    public static boolean B(l lVar) {
        AppMethodBeat.i(121962);
        if (a(lVar, a.i.b.a.c.b.f.CLASS) || a(lVar, a.i.b.a.c.b.f.ENUM_CLASS)) {
            AppMethodBeat.o(121962);
            return true;
        }
        AppMethodBeat.o(121962);
        return false;
    }
}
