package a.i.b.a.c.a;

import a.a.ag;
import a.a.t;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.a.a.b.b;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.c;
import a.i.b.a.c.i.b.s;
import a.i.b.a.c.i.c.a;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f {
    public static final boolean d(w wVar) {
        AppMethodBeat.i(119080);
        j.p(wVar, "receiver$0");
        h dYs = wVar.ejw().dYs();
        if ((dYs != null ? a((l) dYs) : null) == b.Function) {
            AppMethodBeat.o(119080);
            return true;
        }
        AppMethodBeat.o(119080);
        return false;
    }

    public static final boolean e(w wVar) {
        AppMethodBeat.i(119081);
        j.p(wVar, "receiver$0");
        h dYs = wVar.ejw().dYs();
        if ((dYs != null ? a((l) dYs) : null) == b.SuspendFunction) {
            AppMethodBeat.o(119081);
            return true;
        }
        AppMethodBeat.o(119081);
        return false;
    }

    public static final boolean f(w wVar) {
        AppMethodBeat.i(119082);
        j.p(wVar, "receiver$0");
        h dYs = wVar.ejw().dYs();
        b a = dYs != null ? a((l) dYs) : null;
        if (a == b.Function || a == b.SuspendFunction) {
            AppMethodBeat.o(119082);
            return true;
        }
        AppMethodBeat.o(119082);
        return false;
    }

    private static final boolean g(w wVar) {
        AppMethodBeat.i(119083);
        g dYn = wVar.dYn();
        a.i.b.a.c.f.b bVar = g.Bag.BaN;
        j.o(bVar, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (dYn.i(bVar) != null) {
            AppMethodBeat.o(119083);
            return true;
        }
        AppMethodBeat.o(119083);
        return false;
    }

    private static b a(l lVar) {
        AppMethodBeat.i(119084);
        j.p(lVar, "receiver$0");
        if (!(lVar instanceof e)) {
            AppMethodBeat.o(119084);
            return null;
        } else if (g.c(lVar)) {
            b a = a(a.q(lVar));
            AppMethodBeat.o(119084);
            return a;
        } else {
            AppMethodBeat.o(119084);
            return null;
        }
    }

    private static final b a(c cVar) {
        AppMethodBeat.i(119085);
        if (!cVar.ehH() || cVar.ByV.isEmpty()) {
            AppMethodBeat.o(119085);
            return null;
        }
        a.i.b.a.c.a.a.a.a aVar = a.i.b.a.c.a.a.a.BcI;
        String str = cVar.ehK().name;
        j.o(str, "shortName().asString()");
        a.i.b.a.c.f.b ehG = cVar.ehI().ehG();
        j.o(ehG, "toSafe().parent()");
        b b = a.i.b.a.c.a.a.a.a.b(str, ehG);
        AppMethodBeat.o(119085);
        return b;
    }

    public static final w h(w wVar) {
        AppMethodBeat.i(119086);
        j.p(wVar, "receiver$0");
        boolean f = f(wVar);
        if (aa.AUz && !f) {
            Throwable assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(wVar)));
            AppMethodBeat.o(119086);
            throw assertionError;
        } else if (g(wVar)) {
            w dZS = ((ap) t.fJ(wVar.ejt())).dZS();
            AppMethodBeat.o(119086);
            return dZS;
        } else {
            AppMethodBeat.o(119086);
            return null;
        }
    }

    public static final w i(w wVar) {
        AppMethodBeat.i(119087);
        j.p(wVar, "receiver$0");
        boolean f = f(wVar);
        if (!aa.AUz || f) {
            w dZS = ((ap) t.fL(wVar.ejt())).dZS();
            j.o(dZS, "arguments.last().type");
            AppMethodBeat.o(119087);
            return dZS;
        }
        Throwable assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(wVar)));
        AppMethodBeat.o(119087);
        throw assertionError;
    }

    public static final List<ap> j(w wVar) {
        Object obj = 1;
        AppMethodBeat.i(119088);
        j.p(wVar, "receiver$0");
        boolean f = f(wVar);
        Throwable assertionError;
        if (!aa.AUz || f) {
            Object obj2;
            List ejt = wVar.ejt();
            j.p(wVar, "receiver$0");
            if (f(wVar) && g(wVar)) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            int i = obj2 != null ? 1 : 0;
            int size = ejt.size() - 1;
            if (i > size) {
                obj = null;
            }
            if (aa.AUz && obj == null) {
                assertionError = new AssertionError("Not an exact function type: ".concat(String.valueOf(wVar)));
                AppMethodBeat.o(119088);
                throw assertionError;
            }
            List subList = ejt.subList(i, size);
            AppMethodBeat.o(119088);
            return subList;
        }
        assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(wVar)));
        AppMethodBeat.o(119088);
        throw assertionError;
    }

    public static final a.i.b.a.c.f.f k(w wVar) {
        AppMethodBeat.i(119089);
        j.p(wVar, "receiver$0");
        g dYn = wVar.dYn();
        a.i.b.a.c.f.b bVar = g.Bag.BaO;
        j.o(bVar, "KotlinBuiltIns.FQ_NAMES.parameterName");
        a.i.b.a.c.b.a.c i = dYn.i(bVar);
        if (i == null) {
            AppMethodBeat.o(119089);
            return null;
        }
        Object i2 = t.i((Iterable) i.eah().values());
        if (!(i2 instanceof s)) {
            i2 = null;
        }
        s sVar = (s) i2;
        if (sVar != null) {
            String str = (String) sVar.getValue();
            if (str != null) {
                if (!a.i.b.a.c.f.f.avY(str)) {
                    str = null;
                }
                if (str != null) {
                    a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(str);
                    AppMethodBeat.o(119089);
                    return avX;
                }
            }
        }
        AppMethodBeat.o(119089);
        return null;
    }

    public static /* synthetic */ ad a(g gVar, g gVar2, w wVar, List list, w wVar2) {
        AppMethodBeat.i(119091);
        ad a = a(gVar, gVar2, wVar, list, wVar2, false);
        AppMethodBeat.o(119091);
        return a;
    }

    public static final ad a(g gVar, g gVar2, w wVar, List<? extends w> list, w wVar2, boolean z) {
        Object SM;
        AppMethodBeat.i(119090);
        j.p(gVar, "builtIns");
        j.p(gVar2, "annotations");
        j.p(list, "parameterTypes");
        j.p(wVar2, "returnType");
        j.p(list, "parameterTypes");
        j.p(wVar2, "returnType");
        j.p(gVar, "builtIns");
        ArrayList arrayList = new ArrayList(((wVar != null ? 1 : 0) + list.size()) + 1);
        a.i.b.a.c.n.a.b(arrayList, wVar != null ? a.i.b.a.c.l.c.a.aM(wVar) : null);
        int i = 0;
        for (Object next : list) {
            Collection collection = arrayList;
            int i2 = i + 1;
            if (i < 0) {
                a.a.l.dWs();
            }
            collection.add(a.i.b.a.c.l.c.a.aM((w) next));
            i = i2;
        }
        arrayList.add(a.i.b.a.c.l.c.a.aM(wVar2));
        List list2 = arrayList;
        int size = list.size();
        if (wVar != null) {
            size++;
        }
        if (z) {
            SM = gVar.SM(size);
        } else {
            SM = gVar.avB(g.SK(size));
        }
        j.o(SM, "if (suspendFunction) bui…tFunction(parameterCount)");
        if (wVar != null) {
            a.i.b.a.c.f.b bVar = g.Bag.BaN;
            j.o(bVar, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (gVar2.i(bVar) == null) {
                g.a aVar = g.BfJ;
                Iterable iterable = gVar2;
                a.i.b.a.c.f.b bVar2 = g.Bag.BaN;
                j.o(bVar2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                gVar2 = g.a.fS(t.d(iterable, new a.i.b.a.c.b.a.j(gVar, bVar2, ag.emptyMap())));
            }
        }
        ad a = x.a(gVar2, SM, list2);
        AppMethodBeat.o(119090);
        return a;
    }
}
