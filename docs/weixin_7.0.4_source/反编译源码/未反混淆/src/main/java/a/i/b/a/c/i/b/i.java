package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.d;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i extends f<o<? extends a, ? extends f>> {
    private final a BER;
    public final f BES;

    public i(a aVar, f fVar) {
        j.p(aVar, "enumClassId");
        j.p(fVar, "enumEntryName");
        super(u.I(aVar, fVar));
        AppMethodBeat.i(122089);
        this.BER = aVar;
        this.BES = fVar;
        AppMethodBeat.o(122089);
    }

    public final w b(y yVar) {
        ad dZf;
        w wVar;
        AppMethodBeat.i(122087);
        j.p(yVar, "module");
        e a = s.a(yVar, this.BER);
        if (a != null) {
            if (!d.y((l) a)) {
                a = null;
            }
            if (a != null) {
                dZf = a.dZf();
                if (dZf != null) {
                    wVar = dZf;
                    AppMethodBeat.o(122087);
                    return wVar;
                }
            }
        }
        dZf = p.awn("Containing class for error-class based enum entry " + this.BER + '.' + this.BES);
        j.o(dZf, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
        wVar = dZf;
        AppMethodBeat.o(122087);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122088);
        String str = this.BER.ehB() + '.' + this.BES;
        AppMethodBeat.o(122088);
        return str;
    }
}
