package a.i.b.a.c.d.a.f;

import a.a.l;
import a.a.t;
import a.aa;
import a.f.a.b;
import a.f.b.j;
import a.i.b.a.c.a.b.c;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.k;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ax;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.c.a;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.i.b.a.c.l.y;
import a.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class s {
    private static final b BqL;
    private static final b BqM;

    public static final w a(w wVar, b<? super Integer, d> bVar) {
        AppMethodBeat.i(120200);
        j.p(wVar, "receiver$0");
        j.p(bVar, "qualifiers");
        k a = a(wVar.ekn(), (b) bVar, 0);
        w dZS = a.dZS();
        if (a.Bqi) {
            AppMethodBeat.o(120200);
            return dZS;
        }
        AppMethodBeat.o(120200);
        return null;
    }

    public static final boolean U(w wVar) {
        AppMethodBeat.i(120201);
        j.p(wVar, "receiver$0");
        g dYn = wVar.dYn();
        a.i.b.a.c.f.b bVar = p.Blv;
        j.o(bVar, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        if (dYn.i(bVar) != null) {
            AppMethodBeat.o(120201);
            return true;
        }
        AppMethodBeat.o(120201);
        return false;
    }

    private static final k a(az azVar, b<? super Integer, d> bVar, int i) {
        boolean z = false;
        AppMethodBeat.i(120202);
        k kVar;
        if (y.an(azVar)) {
            kVar = new k(azVar, 1, false);
            AppMethodBeat.o(120202);
            return kVar;
        } else if (azVar instanceof q) {
            o a = a(((q) azVar).BJx, bVar, i, q.FLEXIBLE_LOWER);
            o a2 = a(((q) azVar).BJy, bVar, i, q.FLEXIBLE_UPPER);
            if (a.Bqh == a2.Bqh) {
                int i2 = 1;
            } else {
                boolean i22 = false;
            }
            if (aa.AUz && i22 == 0) {
                Throwable assertionError = new AssertionError("Different tree sizes of bounds: lower = (" + ((q) azVar).BJx + ", " + a.Bqh + "), upper = (" + ((q) azVar).BJy + ", " + a2.Bqh + ')');
                AppMethodBeat.o(120202);
                throw assertionError;
            }
            w aG;
            az gVar;
            if (a.Bqi || a2.Bqi) {
                z = true;
            }
            w aG2 = ax.aG(a.BqF);
            if (aG2 == null) {
                aG = ax.aG(a2.BqF);
            } else {
                aG = aG2;
            }
            if (z) {
                if (azVar instanceof a.i.b.a.c.d.a.c.b.g) {
                    gVar = new a.i.b.a.c.d.a.c.b.g(a.BqF, a2.BqF);
                } else {
                    gVar = x.a(a.BqF, a2.BqF);
                }
                gVar = ax.b(gVar, aG);
            } else {
                gVar = azVar;
            }
            k kVar2 = new k(gVar, a.Bqh, z);
            AppMethodBeat.o(120202);
            return kVar2;
        } else if (azVar instanceof ad) {
            kVar = a((ad) azVar, bVar, i, q.INFLEXIBLE);
            AppMethodBeat.o(120202);
            return kVar;
        } else {
            m mVar = new m();
            AppMethodBeat.o(120202);
            throw mVar;
        }
    }

    private static final o a(ad adVar, b<? super Integer, d> bVar, int i, q qVar) {
        AppMethodBeat.i(120203);
        o oVar;
        if (a(qVar) || !adVar.ejt().isEmpty()) {
            h dYs = adVar.ejw().dYs();
            if (dYs == null) {
                oVar = new o(adVar, 1, false);
                AppMethodBeat.o(120203);
                return oVar;
            }
            j.o(dYs, "constructor.declarationD…pleResult(this, 1, false)");
            d dVar = (d) bVar.am(Integer.valueOf(i));
            c a = a(dYs, dVar, qVar);
            dYs = (h) a.result;
            g gVar = a.BpA;
            an dXY = dYs.dXY();
            j.o(dXY, "enhancedClassifier.typeConstructor");
            int i2 = i + 1;
            Object obj = gVar != null ? 1 : null;
            Iterable ejt = adVar.ejt();
            Collection arrayList = new ArrayList(a.a.m.d(ejt));
            int i3 = 0;
            int i4 = i2;
            for (Object next : ejt) {
                Object next2;
                int i5;
                i2 = i3 + 1;
                if (i3 < 0) {
                    l.dWs();
                }
                ap apVar = (ap) next2;
                if (apVar.ekp()) {
                    i5 = i4 + 1;
                    an dXY2 = dYs.dXY();
                    j.o(dXY2, "enhancedClassifier.typeConstructor");
                    next2 = av.e((ar) dXY2.getParameters().get(i3));
                } else {
                    k a2 = a(apVar.dZS().ekn(), (b) bVar, i4);
                    if (obj != null || a2.Bqi) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    i5 = a2.Bqh + i4;
                    w dZS = a2.dZS();
                    ba ekq = apVar.ekq();
                    j.o(ekq, "arg.projectionKind");
                    next2 = a.a(dZS, ekq, (ar) dXY.getParameters().get(i3));
                }
                arrayList.add(next2);
                i3 = i2;
                i4 = i5;
            }
            List list = (List) arrayList;
            a = a((w) adVar, dVar, qVar);
            boolean booleanValue = ((Boolean) a.result).booleanValue();
            g gVar2 = a.BpA;
            Object obj2 = (obj == null && gVar2 == null) ? null : 1;
            int i6 = i4 - i;
            if (obj2 == null) {
                oVar = new o(adVar, i6, false);
                AppMethodBeat.o(120203);
                return oVar;
            }
            ad fVar;
            ad c = x.c(fX(t.k(l.listOf(adVar.dYn(), gVar, gVar2))), dXY, list, booleanValue);
            if (dVar.BpD) {
                fVar = new f(c);
            } else {
                fVar = c;
            }
            Object obj3 = (gVar2 == null || !dVar.BpE) ? null : 1;
            az b = obj3 != null ? ax.b(adVar, fVar) : fVar;
            if (b == null) {
                v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
                AppMethodBeat.o(120203);
                throw vVar;
            }
            o oVar2 = new o((ad) b, i6, true);
            AppMethodBeat.o(120203);
            return oVar2;
        }
        oVar = new o(adVar, 1, false);
        AppMethodBeat.o(120203);
        return oVar;
    }

    private static final g fX(List<? extends g> list) {
        AppMethodBeat.i(120204);
        g gVar;
        switch (list.size()) {
            case 0:
                Throwable illegalStateException = new IllegalStateException("At least one Annotations object expected".toString());
                AppMethodBeat.o(120204);
                throw illegalStateException;
            case 1:
                gVar = (g) t.fN(list);
                AppMethodBeat.o(120204);
                return gVar;
            default:
                gVar = new k(t.m(list));
                AppMethodBeat.o(120204);
                return gVar;
        }
    }

    private static final boolean a(q qVar) {
        return qVar != q.INFLEXIBLE;
    }

    private static final <T> c<T> dC(T t) {
        AppMethodBeat.i(120205);
        c cVar = new c(t, null);
        AppMethodBeat.o(120205);
        return cVar;
    }

    private static final <T> c<T> dD(T t) {
        AppMethodBeat.i(120206);
        c cVar = new c(t, BqL);
        AppMethodBeat.o(120206);
        return cVar;
    }

    private static final <T> c<T> dE(T t) {
        AppMethodBeat.i(120207);
        c cVar = new c(t, BqM);
        AppMethodBeat.o(120207);
        return cVar;
    }

    private static final c<h> a(h hVar, d dVar, q qVar) {
        AppMethodBeat.i(120208);
        c<h> dE;
        if (!a(qVar)) {
            c dC = dC(hVar);
            AppMethodBeat.o(120208);
            return dC;
        } else if (hVar instanceof e) {
            c cVar = c.Bdq;
            e eVar = dVar.BpC;
            if (eVar != null) {
                switch (t.eQZ[eVar.ordinal()]) {
                    case 1:
                        if (qVar == q.FLEXIBLE_LOWER && c.h((e) hVar)) {
                            dE = dE(c.j((e) hVar));
                            AppMethodBeat.o(120208);
                            return dE;
                        }
                    case 2:
                        if (qVar == q.FLEXIBLE_UPPER && c.i((e) hVar)) {
                            dE = dE(c.k((e) hVar));
                            AppMethodBeat.o(120208);
                            return dE;
                        }
                }
            }
            dE = dC(hVar);
            AppMethodBeat.o(120208);
            return dE;
        } else {
            dE = dC(hVar);
            AppMethodBeat.o(120208);
            return dE;
        }
    }

    private static final c<Boolean> a(w wVar, d dVar, q qVar) {
        AppMethodBeat.i(120209);
        if (a(qVar)) {
            c<Boolean> dD;
            g gVar = dVar.BpB;
            if (gVar != null) {
                switch (t.pCY[gVar.ordinal()]) {
                    case 1:
                        dD = dD(Boolean.TRUE);
                        AppMethodBeat.o(120209);
                        return dD;
                    case 2:
                        dD = dD(Boolean.FALSE);
                        AppMethodBeat.o(120209);
                        return dD;
                }
            }
            dD = dC(Boolean.valueOf(wVar.eci()));
            AppMethodBeat.o(120209);
            return dD;
        }
        c dC = dC(Boolean.valueOf(wVar.eci()));
        AppMethodBeat.o(120209);
        return dC;
    }

    static {
        AppMethodBeat.i(120210);
        a.i.b.a.c.f.b bVar = p.Blv;
        j.o(bVar, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        BqL = new b(bVar);
        bVar = p.Blw;
        j.o(bVar, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        BqM = new b(bVar);
        AppMethodBeat.o(120210);
    }
}
