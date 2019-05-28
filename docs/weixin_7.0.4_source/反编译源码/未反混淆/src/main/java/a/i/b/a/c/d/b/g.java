package a.i.b.a.c.d.b;

import a.f.b.j;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.b.b;
import a.i.b.a.c.j.a.n;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g implements n {
    public static final g Brt = new g();

    static {
        AppMethodBeat.i(120264);
        AppMethodBeat.o(120264);
    }

    private g() {
    }

    public final w a(aa aaVar, String str, ad adVar, ad adVar2) {
        AppMethodBeat.i(120263);
        j.p(aaVar, "proto");
        j.p(str, "flexibleId");
        j.p(adVar, "lowerBound");
        j.p(adVar2, "upperBound");
        w wVar;
        if ((j.j(str, "kotlin.jvm.PlatformType") ^ 1) != 0) {
            ad awn = p.awn("Error java flexible type with id: " + str + ". (" + adVar + ".." + adVar2 + ')');
            j.o(awn, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
            wVar = awn;
            AppMethodBeat.o(120263);
            return wVar;
        } else if (aaVar.c(b.BxF)) {
            wVar = new a.i.b.a.c.d.a.c.b.g(adVar, adVar2);
            AppMethodBeat.o(120263);
            return wVar;
        } else {
            wVar = x.a(adVar, adVar2);
            AppMethodBeat.o(120263);
            return wVar;
        }
    }
}
