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

public final class t extends x<Byte> {
    public t(byte b) {
        super(Byte.valueOf(b));
        AppMethodBeat.i(122116);
        AppMethodBeat.o(122116);
    }

    public final w b(y yVar) {
        ad dZf;
        w wVar;
        AppMethodBeat.i(122114);
        j.p(yVar, "module");
        a aVar = g.Bag.BbB;
        j.o(aVar, "KotlinBuiltIns.FQ_NAMES.uByte");
        e a = s.a(yVar, aVar);
        if (a != null) {
            dZf = a.dZf();
            if (dZf != null) {
                wVar = dZf;
                AppMethodBeat.o(122114);
                return wVar;
            }
        }
        dZf = p.awn("Unsigned type UByte not found");
        j.o(dZf, "ErrorUtils.createErrorTy…ed type UByte not found\")");
        wVar = dZf;
        AppMethodBeat.o(122114);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122115);
        String str = ((Number) getValue()).byteValue() + ".toUByte()";
        AppMethodBeat.o(122115);
        return str;
    }
}
