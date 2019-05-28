package a.i.b.a.c.m;

import a.a.k;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.a.i;
import a.i.b.a.c.a.i.b;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.t;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ah;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.i.b.a.c.m.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class e implements b {
    public static final e BLC = new e();
    private static final String description = description;

    static {
        AppMethodBeat.i(122865);
        AppMethodBeat.o(122865);
    }

    private e() {
    }

    public final String i(t tVar) {
        AppMethodBeat.i(122866);
        j.p(tVar, "functionDescriptor");
        String a = a.a(this, tVar);
        AppMethodBeat.o(122866);
        return a;
    }

    public final String getDescription() {
        return description;
    }

    public final boolean h(t tVar) {
        w wVar;
        AppMethodBeat.i(122864);
        j.p(tVar, "functionDescriptor");
        au auVar = (au) tVar.dYV().get(1);
        b bVar = i.Bcn;
        j.o(auVar, "secondParameter");
        y F = a.i.b.a.c.i.c.a.F(auVar);
        j.p(F, "module");
        a.i.b.a.c.f.a aVar = g.Bag.Bbw;
        j.o(aVar, "KotlinBuiltIns.FQ_NAMES.kProperty");
        a.i.b.a.c.b.e a = s.a(F, aVar);
        if (a == null) {
            wVar = null;
        } else {
            a.i.b.a.c.b.a.g.a aVar2 = a.i.b.a.c.b.a.g.BfJ;
            a.i.b.a.c.b.a.g eai = a.i.b.a.c.b.a.g.a.eai();
            an dXY = a.dXY();
            j.o(dXY, "kPropertyClass.typeConstructor");
            List parameters = dXY.getParameters();
            j.o(parameters, "kPropertyClass.typeConstructor.parameters");
            Object fN = a.a.t.fN(parameters);
            j.o(fN, "kPropertyClass.typeConstructor.parameters.single()");
            wVar = x.a(eai, a, k.listOf(new ah((ar) fN)));
        }
        if (wVar != null) {
            w dZS = auVar.dZS();
            j.o(dZS, "secondParameter.type");
            boolean c = a.i.b.a.c.l.c.a.c(wVar, a.i.b.a.c.l.c.a.aA(dZS));
            AppMethodBeat.o(122864);
            return c;
        }
        AppMethodBeat.o(122864);
        return false;
    }
}
