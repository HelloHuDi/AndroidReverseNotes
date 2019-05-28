package a.i.b.a.c.l;

import a.f.b.j;
import a.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t {
    public static final boolean ai(w wVar) {
        AppMethodBeat.i(122591);
        j.p(wVar, "receiver$0");
        boolean z = wVar.ekn() instanceof q;
        AppMethodBeat.o(122591);
        return z;
    }

    public static final q aj(w wVar) {
        AppMethodBeat.i(122592);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (ekn == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
            AppMethodBeat.o(122592);
            throw vVar;
        }
        q qVar = (q) ekn;
        AppMethodBeat.o(122592);
        return qVar;
    }

    public static final ad ak(w wVar) {
        AppMethodBeat.i(122593);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        ad adVar;
        if (ekn instanceof q) {
            adVar = ((q) ekn).BJx;
            AppMethodBeat.o(122593);
            return adVar;
        } else if (ekn instanceof ad) {
            adVar = (ad) ekn;
            AppMethodBeat.o(122593);
            return adVar;
        } else {
            m mVar = new m();
            AppMethodBeat.o(122593);
            throw mVar;
        }
    }

    public static final ad al(w wVar) {
        AppMethodBeat.i(122594);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        ad adVar;
        if (ekn instanceof q) {
            adVar = ((q) ekn).BJy;
            AppMethodBeat.o(122594);
            return adVar;
        } else if (ekn instanceof ad) {
            adVar = (ad) ekn;
            AppMethodBeat.o(122594);
            return adVar;
        } else {
            m mVar = new m();
            AppMethodBeat.o(122594);
            throw mVar;
        }
    }
}
