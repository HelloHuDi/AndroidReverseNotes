package a.i.b.a.c.d.b;

import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.a;
import a.i.b.a.c.b.ai;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.k;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.d.a.d;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.d.c;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class r {
    private static String a(t tVar, boolean z, boolean z2) {
        String str;
        w dZS;
        AppMethodBeat.i(120300);
        j.p(tVar, "receiver$0");
        StringBuilder stringBuilder = new StringBuilder();
        if (z2) {
            if (tVar instanceof k) {
                str = "<init>";
            } else {
                str = tVar.dZg().name;
                j.o(str, "name.asString()");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append("(");
        for (au auVar : tVar.dYV()) {
            j.o(auVar, "parameter");
            dZS = auVar.dZS();
            j.o(dZS, "parameter.type");
            a(stringBuilder, dZS);
        }
        stringBuilder.append(")");
        if (z) {
            Object obj;
            a aVar = tVar;
            j.p(aVar, "descriptor");
            if (aVar instanceof k) {
                obj = 1;
            } else {
                w dYT = aVar.dYT();
                if (dYT == null) {
                    j.dWJ();
                }
                if (g.D(dYT)) {
                    dYT = aVar.dYT();
                    if (dYT == null) {
                        j.dWJ();
                    }
                    if (!(av.aB(dYT) || (aVar instanceof ai))) {
                        int obj2 = 1;
                    }
                }
                obj2 = null;
            }
            if (obj2 != null) {
                stringBuilder.append("V");
            } else {
                dZS = tVar.dYT();
                if (dZS == null) {
                    j.dWJ();
                }
                j.o(dZS, "returnType!!");
                a(stringBuilder, dZS);
            }
        }
        str = stringBuilder.toString();
        j.o(str, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(120300);
        return str;
    }

    public static /* synthetic */ String a(t tVar, boolean z, boolean z2, int i) {
        AppMethodBeat.i(120301);
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        String a = a(tVar, z, z2);
        AppMethodBeat.o(120301);
        return a;
    }

    public static final boolean b(a aVar) {
        c cVar = null;
        AppMethodBeat.i(120302);
        j.p(aVar, "f");
        if (!(aVar instanceof t)) {
            AppMethodBeat.o(120302);
            return false;
        } else if (((t) aVar).dYV().size() == 1 && !a.i.b.a.c.d.a.t.s((b) aVar) && (j.j(((t) aVar).dZg().name, "remove") ^ 1) == 0) {
            t dZp = ((t) aVar).dZp();
            j.o(dZp, "f.original");
            List dYV = dZp.dYV();
            j.o(dYV, "f.original.valueParameters");
            Object fN = a.a.t.fN(dYV);
            j.o(fN, "f.original.valueParameters.single()");
            w dZS = ((au) fN).dZS();
            j.o(dZS, "f.original.valueParameters.single().type");
            j V = V(dZS);
            if (!(V instanceof j.c)) {
                V = null;
            }
            j.c cVar2 = (j.c) V;
            if (cVar2 != null) {
                cVar = cVar2.BrE;
            }
            if (cVar != c.INT) {
                AppMethodBeat.o(120302);
                return false;
            }
            t e = d.e((t) aVar);
            if (e == null) {
                AppMethodBeat.o(120302);
                return false;
            }
            dZp = e.dZp();
            j.o(dZp, "overridden.original");
            dYV = dZp.dYV();
            j.o(dYV, "overridden.original.valueParameters");
            fN = a.a.t.fN(dYV);
            j.o(fN, "overridden.original.valueParameters.single()");
            dZS = ((au) fN).dZS();
            j.o(dZS, "overridden.original.valueParameters.single().type");
            V = V(dZS);
            l dXW = e.dXW();
            j.o(dXW, "overridden.containingDeclaration");
            if (j.j(a.i.b.a.c.i.c.a.q(dXW), g.Bag.Bbi.ByQ) && (V instanceof j.b) && j.j(((j.b) V).BrD, "java/lang/Object")) {
                AppMethodBeat.o(120302);
                return true;
            }
            AppMethodBeat.o(120302);
            return false;
        } else {
            AppMethodBeat.o(120302);
            return false;
        }
    }

    private static final void a(StringBuilder stringBuilder, w wVar) {
        AppMethodBeat.i(120304);
        stringBuilder.append(V(wVar));
        AppMethodBeat.o(120304);
    }

    public static final j V(w wVar) {
        AppMethodBeat.i(120305);
        j.p(wVar, "receiver$0");
        j jVar = (j) y.a(wVar, l.BrF, w.BrW, v.BrL);
        AppMethodBeat.o(120305);
        return jVar;
    }

    public static final String c(a aVar) {
        AppMethodBeat.i(120303);
        j.p(aVar, "receiver$0");
        t tVar = t.BrJ;
        if (a.i.b.a.c.i.d.m(aVar)) {
            AppMethodBeat.o(120303);
            return null;
        }
        l dXW = aVar.dXW();
        if (!(dXW instanceof e)) {
            dXW = null;
        }
        e eVar = (e) dXW;
        if (eVar == null) {
            AppMethodBeat.o(120303);
            return null;
        }
        f dZg = eVar.dZg();
        j.o(dZg, "classDescriptor.name");
        if (dZg.ByZ) {
            AppMethodBeat.o(120303);
            return null;
        }
        a dYU = aVar.dYU();
        if (!(dYU instanceof al)) {
            dYU = null;
        }
        al alVar = (al) dYU;
        if (alVar == null) {
            AppMethodBeat.o(120303);
            return null;
        }
        String a = t.a(eVar, a(alVar, false, false, 3));
        AppMethodBeat.o(120303);
        return a;
    }
}
