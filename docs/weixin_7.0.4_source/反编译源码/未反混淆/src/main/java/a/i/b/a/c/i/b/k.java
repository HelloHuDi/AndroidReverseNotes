package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k extends f<Float> {
    public k(float f) {
        super(Float.valueOf(f));
        AppMethodBeat.i(122095);
        AppMethodBeat.o(122095);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122093);
        j.p(yVar, "module");
        ad a = yVar.dZD().a(h.FLOAT);
        j.o(a, "module.builtIns.floatType");
        w wVar = a;
        AppMethodBeat.o(122093);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122094);
        String str = ((Number) getValue()).floatValue() + ".toFloat()";
        AppMethodBeat.o(122094);
        return str;
    }
}
