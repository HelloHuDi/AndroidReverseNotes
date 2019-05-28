package a.i.b.a.c.l;

import a.f.b.j;
import a.m;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax {
    public static final w aG(w wVar) {
        AppMethodBeat.i(122701);
        j.p(wVar, "receiver$0");
        if (wVar instanceof aw) {
            w ekl = ((aw) wVar).ekl();
            AppMethodBeat.o(122701);
            return ekl;
        }
        AppMethodBeat.o(122701);
        return null;
    }

    public static final az a(az azVar, w wVar) {
        AppMethodBeat.i(122702);
        j.p(azVar, "receiver$0");
        j.p(wVar, b.ORIGIN);
        az b = b(azVar, aG(wVar));
        AppMethodBeat.o(122702);
        return b;
    }

    public static final az b(az azVar, w wVar) {
        AppMethodBeat.i(122703);
        j.p(azVar, "receiver$0");
        az afVar;
        if (wVar == null) {
            AppMethodBeat.o(122703);
            return azVar;
        } else if (azVar instanceof ad) {
            afVar = new af((ad) azVar, wVar);
            AppMethodBeat.o(122703);
            return afVar;
        } else if (azVar instanceof q) {
            afVar = new s((q) azVar, wVar);
            AppMethodBeat.o(122703);
            return afVar;
        } else {
            m mVar = new m();
            AppMethodBeat.o(122703);
            throw mVar;
        }
    }
}
