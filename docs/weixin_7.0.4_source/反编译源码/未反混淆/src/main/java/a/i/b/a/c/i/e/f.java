package a.i.b.a.c.i.e;

import a.a.v;
import a.f.a.b;
import a.f.b.j;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.i;
import a.i.b.a.c.i.e.d.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class f extends i {
    private final h BGb;

    public f(h hVar) {
        j.p(hVar, "workerScope");
        AppMethodBeat.i(122192);
        this.BGb = hVar;
        AppMethodBeat.o(122192);
    }

    public final /* synthetic */ Collection a(d dVar, b bVar) {
        d dVar2;
        List list;
        AppMethodBeat.i(122188);
        j.p(dVar, "kindFilter");
        j.p(bVar, "nameFilter");
        a aVar = d.BFX;
        int ejK = dVar.BFy & d.BFI;
        if (ejK == 0) {
            dVar2 = null;
        } else {
            dVar2 = new d(ejK, dVar.BFz);
        }
        if (dVar2 == null) {
            list = v.AUP;
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : this.BGb.a(dVar2, bVar)) {
                if (next instanceof i) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        }
        Collection collection = list;
        AppMethodBeat.o(122188);
        return collection;
    }

    public final h c(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122187);
        j.p(fVar, "name");
        j.p(aVar, FirebaseAnalytics.b.LOCATION);
        h c = this.BGb.c(fVar, aVar);
        if (c != null) {
            h hVar;
            if (c instanceof e) {
                hVar = c;
            } else {
                hVar = null;
            }
            e eVar = (e) hVar;
            if (eVar != null) {
                hVar = eVar;
                AppMethodBeat.o(122187);
                return hVar;
            }
            if (c instanceof aq) {
                hVar = c;
            } else {
                hVar = null;
            }
            hVar = (aq) hVar;
            AppMethodBeat.o(122187);
            return hVar;
        }
        AppMethodBeat.o(122187);
        return null;
    }

    public final Set<a.i.b.a.c.f.f> eau() {
        AppMethodBeat.i(122189);
        Set eau = this.BGb.eau();
        AppMethodBeat.o(122189);
        return eau;
    }

    public final Set<a.i.b.a.c.f.f> eav() {
        AppMethodBeat.i(122190);
        Set eav = this.BGb.eav();
        AppMethodBeat.o(122190);
        return eav;
    }

    public final String toString() {
        AppMethodBeat.i(122191);
        String str = "Classes from " + this.BGb;
        AppMethodBeat.o(122191);
        return str;
    }
}
