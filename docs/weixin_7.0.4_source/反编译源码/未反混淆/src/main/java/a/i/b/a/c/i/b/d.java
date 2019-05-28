package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends m<Byte> {
    public d(byte b) {
        super(Byte.valueOf(b));
        AppMethodBeat.i(122074);
        AppMethodBeat.o(122074);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122072);
        j.p(yVar, "module");
        ad a = yVar.dZD().a(h.BYTE);
        j.o(a, "module.builtIns.byteType");
        w wVar = a;
        AppMethodBeat.o(122072);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122073);
        String str = ((Number) getValue()).byteValue() + ".toByte()";
        AppMethodBeat.o(122073);
        return str;
    }
}
