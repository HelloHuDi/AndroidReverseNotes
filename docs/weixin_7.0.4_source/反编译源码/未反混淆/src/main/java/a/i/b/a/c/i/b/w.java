package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.a;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w extends x<Short> {
    public w(short s) {
        super(Short.valueOf(s));
        AppMethodBeat.i(122125);
        AppMethodBeat.o(122125);
    }

    public final a.i.b.a.c.l.w b(y yVar) {
        ad dZf;
        a.i.b.a.c.l.w wVar;
        AppMethodBeat.i(122123);
        j.p(yVar, "module");
        a aVar = g.Bag.BbC;
        j.o(aVar, "KotlinBuiltIns.FQ_NAMES.uShort");
        e a = s.a(yVar, aVar);
        if (a != null) {
            dZf = a.dZf();
            if (dZf != null) {
                wVar = dZf;
                AppMethodBeat.o(122123);
                return wVar;
            }
        }
        dZf = p.awn("Unsigned type UShort not found");
        j.o(dZf, "ErrorUtils.createErrorTy…d type UShort not found\")");
        wVar = dZf;
        AppMethodBeat.o(122123);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122124);
        String str = ((Number) getValue()).shortValue() + ".toUShort()";
        AppMethodBeat.o(122124);
        return str;
    }
}
