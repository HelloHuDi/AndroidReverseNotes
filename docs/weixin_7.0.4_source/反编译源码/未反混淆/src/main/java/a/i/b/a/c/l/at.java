package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class at {
    public static final w a(w wVar, List<? extends ap> list, g gVar) {
        AppMethodBeat.i(122656);
        j.p(wVar, "receiver$0");
        j.p(list, "newArguments");
        j.p(gVar, "newAnnotations");
        if ((list.isEmpty() || list == wVar.ejt()) && gVar == wVar.dYn()) {
            AppMethodBeat.o(122656);
            return wVar;
        }
        az ekn = wVar.ekn();
        w a;
        if (ekn instanceof q) {
            a = x.a(a(((q) ekn).BJx, (List) list, gVar), a(((q) ekn).BJy, (List) list, gVar));
            AppMethodBeat.o(122656);
            return a;
        } else if (ekn instanceof ad) {
            a = a((ad) ekn, (List) list, gVar);
            AppMethodBeat.o(122656);
            return a;
        } else {
            m mVar = new m();
            AppMethodBeat.o(122656);
            throw mVar;
        }
    }

    public static /* synthetic */ ad a(ad adVar, List list) {
        AppMethodBeat.i(122658);
        ad a = a(adVar, list, adVar.dYn());
        AppMethodBeat.o(122658);
        return a;
    }

    private static ad a(ad adVar, List<? extends ap> list, g gVar) {
        AppMethodBeat.i(122657);
        j.p(adVar, "receiver$0");
        j.p(list, "newArguments");
        j.p(gVar, "newAnnotations");
        if (list.isEmpty() && gVar == adVar.dYn()) {
            AppMethodBeat.o(122657);
            return adVar;
        } else if (list.isEmpty()) {
            adVar = adVar.d(gVar);
            AppMethodBeat.o(122657);
            return adVar;
        } else {
            adVar = x.c(gVar, adVar.ejw(), list, adVar.eci());
            AppMethodBeat.o(122657);
            return adVar;
        }
    }

    public static final ad av(w wVar) {
        AppMethodBeat.i(122659);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (!(ekn instanceof ad)) {
            ekn = null;
        }
        ad adVar = (ad) ekn;
        if (adVar == null) {
            Throwable illegalStateException = new IllegalStateException("This is should be simple type: ".concat(String.valueOf(wVar)).toString());
            AppMethodBeat.o(122659);
            throw illegalStateException;
        }
        AppMethodBeat.o(122659);
        return adVar;
    }
}
