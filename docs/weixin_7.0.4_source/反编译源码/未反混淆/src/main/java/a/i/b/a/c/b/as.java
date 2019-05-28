package a.i.b.a.c.b;

import a.a.m;
import a.a.t;
import a.a.v;
import a.aa;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.i.d;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.j.h;
import a.j.n;
import a.j.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class as {

    static final class b extends k implements a.f.a.b<l, h<? extends ar>> {
        public static final b BeV = new b();

        static {
            AppMethodBeat.i(119298);
            AppMethodBeat.o(119298);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119297);
            l lVar = (l) obj;
            j.p(lVar, "it");
            List dYS = ((a) lVar).dYS();
            j.o(dYS, "(it as CallableDescriptor).typeParameters");
            h t = t.t(dYS);
            AppMethodBeat.o(119297);
            return t;
        }
    }

    static final class a extends k implements a.f.a.b<l, Boolean> {
        public static final a BeU = new a();

        static {
            AppMethodBeat.i(119296);
            AppMethodBeat.o(119296);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119295);
            l lVar = (l) obj;
            j.p(lVar, "it");
            Boolean valueOf = Boolean.valueOf(lVar instanceof a);
            AppMethodBeat.o(119295);
            return valueOf;
        }
    }

    public static final List<ar> a(i iVar) {
        List list = null;
        AppMethodBeat.i(119299);
        j.p(iVar, "receiver$0");
        List dYq = iVar.dYq();
        j.o(dYq, "declaredTypeParameters");
        if (iVar.dYh() || (iVar.dXW() instanceof a)) {
            h H = a.i.b.a.c.i.c.a.H(iVar);
            a.f.a.b bVar = a.BeU;
            j.p(H, "receiver$0");
            j.p(bVar, "predicate");
            List c = n.c(n.c(new o(H, bVar), b.BeV));
            for (Object next : a.i.b.a.c.i.c.a.H(iVar)) {
                if (next instanceof e) {
                    break;
                }
            }
            Object next2 = null;
            e eVar = (e) next2;
            if (eVar != null) {
                an dXY = eVar.dXY();
                if (dXY != null) {
                    list = dXY.getParameters();
                }
            }
            if (list == null) {
                list = v.AUP;
            }
            List<ar> dYq2;
            if (c.isEmpty() && list.isEmpty()) {
                dYq2 = iVar.dYq();
                j.o(dYq2, "declaredTypeParameters");
                AppMethodBeat.o(119299);
                return dYq2;
            }
            Iterable<ar> b = t.b((Collection) c, (Iterable) list);
            Collection arrayList = new ArrayList(m.d(b));
            for (ar arVar : b) {
                j.o(arVar, "it");
                arrayList.add(new c(arVar, iVar, dYq.size()));
            }
            dYq2 = t.b((Collection) dYq, (Iterable) (List) arrayList);
            AppMethodBeat.o(119299);
            return dYq2;
        }
        AppMethodBeat.o(119299);
        return dYq;
    }

    public static final af a(w wVar, i iVar, int i) {
        AppMethodBeat.i(119300);
        if (iVar == null || p.L(iVar)) {
            AppMethodBeat.o(119300);
            return null;
        }
        int size = iVar.dYq().size() + i;
        if (iVar.dYh()) {
            List subList = wVar.ejt().subList(i, size);
            l dXW = iVar.dXW();
            if (!(dXW instanceof i)) {
                dXW = null;
            }
            af afVar = new af(iVar, subList, a(wVar, (i) dXW, size));
            AppMethodBeat.o(119300);
            return afVar;
        }
        Object obj = (size == wVar.ejt().size() || d.m(iVar)) ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError((wVar.ejt().size() - size) + " trailing arguments were found in " + wVar + " type");
            AppMethodBeat.o(119300);
            throw assertionError;
        }
        af afVar2 = new af(iVar, wVar.ejt().subList(i, wVar.ejt().size()), null);
        AppMethodBeat.o(119300);
        return afVar2;
    }
}
