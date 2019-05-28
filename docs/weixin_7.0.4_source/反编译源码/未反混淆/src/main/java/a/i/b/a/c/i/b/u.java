package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.a;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u extends x<Integer> {
    public u(int i) {
        super(Integer.valueOf(i));
        AppMethodBeat.i(122119);
        AppMethodBeat.o(122119);
    }

    public final w b(y yVar) {
        ad dZf;
        w wVar;
        AppMethodBeat.i(122117);
        j.p(yVar, "module");
        a aVar = g.Bag.BbD;
        j.o(aVar, "KotlinBuiltIns.FQ_NAMES.uInt");
        e a = s.a(yVar, aVar);
        if (a != null) {
            dZf = a.dZf();
            if (dZf != null) {
                wVar = dZf;
                AppMethodBeat.o(122117);
                return wVar;
            }
        }
        dZf = p.awn("Unsigned type UInt not found");
        j.o(dZf, "ErrorUtils.createErrorTy…ned type UInt not found\")");
        wVar = dZf;
        AppMethodBeat.o(122117);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122118);
        String str = ((Number) getValue()).intValue() + ".toUInt()";
        AppMethodBeat.o(122118);
        return str;
    }
}
