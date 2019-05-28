package a.i.b.a.c.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static final g a(g gVar, g gVar2) {
        AppMethodBeat.i(119342);
        j.p(gVar, "first");
        j.p(gVar2, "second");
        if (gVar.isEmpty()) {
            AppMethodBeat.o(119342);
            return gVar2;
        } else if (gVar2.isEmpty()) {
            AppMethodBeat.o(119342);
            return gVar;
        } else {
            g kVar = new k(gVar, gVar2);
            AppMethodBeat.o(119342);
            return kVar;
        }
    }
}
