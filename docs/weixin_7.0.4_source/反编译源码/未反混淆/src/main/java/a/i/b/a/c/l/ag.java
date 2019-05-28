package a.i.b.a.c.l;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag {
    public static final ad ao(w wVar) {
        AppMethodBeat.i(122628);
        j.p(wVar, "receiver$0");
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (!(ekn instanceof a)) {
            ekn = null;
        }
        a aVar = (a) ekn;
        if (aVar != null) {
            ad adVar = aVar.BJa;
            AppMethodBeat.o(122628);
            return adVar;
        }
        AppMethodBeat.o(122628);
        return null;
    }

    public static final ad b(ad adVar, ad adVar2) {
        AppMethodBeat.i(122629);
        j.p(adVar, "receiver$0");
        j.p(adVar2, "abbreviatedType");
        if (y.an(adVar)) {
            AppMethodBeat.o(122629);
            return adVar;
        }
        ad aVar = new a(adVar, adVar2);
        AppMethodBeat.o(122629);
        return aVar;
    }

    public static final boolean ap(w wVar) {
        AppMethodBeat.i(122630);
        j.p(wVar, "receiver$0");
        boolean z = wVar.ekn() instanceof g;
        AppMethodBeat.o(122630);
        return z;
    }
}
