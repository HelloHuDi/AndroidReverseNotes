package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r extends m<Short> {
    public r(short s) {
        super(Short.valueOf(s));
        AppMethodBeat.i(122110);
        AppMethodBeat.o(122110);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122108);
        j.p(yVar, "module");
        ad a = yVar.dZD().a(h.SHORT);
        j.o(a, "module.builtIns.shortType");
        w wVar = a;
        AppMethodBeat.o(122108);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122109);
        String str = ((Number) getValue()).shortValue() + ".toShort()";
        AppMethodBeat.o(122109);
        return str;
    }
}
