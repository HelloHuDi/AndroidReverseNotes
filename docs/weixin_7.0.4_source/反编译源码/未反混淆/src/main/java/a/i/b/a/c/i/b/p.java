package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p extends m<Long> {
    public p(long j) {
        super(Long.valueOf(j));
        AppMethodBeat.i(122106);
        AppMethodBeat.o(122106);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122104);
        j.p(yVar, "module");
        ad a = yVar.dZD().a(h.LONG);
        j.o(a, "module.builtIns.longType");
        w wVar = a;
        AppMethodBeat.o(122104);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122105);
        String str = ((Number) getValue()).longValue() + ".toLong()";
        AppMethodBeat.o(122105);
        return str;
    }
}
