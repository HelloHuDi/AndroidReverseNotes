package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends f<Double> {
    public h(double d) {
        super(Double.valueOf(d));
        AppMethodBeat.i(122086);
        AppMethodBeat.o(122086);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122084);
        j.p(yVar, "module");
        ad a = yVar.dZD().a(a.i.b.a.c.a.h.DOUBLE);
        j.o(a, "module.builtIns.doubleType");
        w wVar = a;
        AppMethodBeat.o(122084);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122085);
        String str = ((Number) getValue()).doubleValue() + ".toDouble()";
        AppMethodBeat.o(122085);
        return str;
    }
}
