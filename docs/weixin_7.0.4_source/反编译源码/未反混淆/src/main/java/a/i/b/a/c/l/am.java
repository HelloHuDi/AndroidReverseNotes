package a.i.b.a.c.l;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am {
    public static final boolean aq(w wVar) {
        AppMethodBeat.i(122645);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (!(ekn instanceof f)) {
            ekn = null;
        }
        f fVar = (f) ekn;
        if (fVar != null) {
            boolean ech = fVar.ech();
            AppMethodBeat.o(122645);
            return ech;
        }
        AppMethodBeat.o(122645);
        return false;
    }

    public static final f ar(w wVar) {
        AppMethodBeat.i(122646);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (!(ekn instanceof f)) {
            ekn = null;
        }
        f fVar = (f) ekn;
        if (fVar == null) {
            AppMethodBeat.o(122646);
            return null;
        } else if (fVar.ech()) {
            AppMethodBeat.o(122646);
            return fVar;
        } else {
            AppMethodBeat.o(122646);
            return null;
        }
    }

    public static final w as(w wVar) {
        AppMethodBeat.i(122647);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (!(ekn instanceof ak)) {
            ekn = null;
        }
        ak akVar = (ak) ekn;
        if (akVar != null) {
            w eju = akVar.eju();
            if (eju != null) {
                wVar = eju;
            }
        }
        AppMethodBeat.o(122647);
        return wVar;
    }

    public static final w at(w wVar) {
        AppMethodBeat.i(122648);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        if (!(ekn instanceof ak)) {
            ekn = null;
        }
        ak akVar = (ak) ekn;
        if (akVar != null) {
            w ejv = akVar.ejv();
            if (ejv != null) {
                wVar = ejv;
            }
        }
        AppMethodBeat.o(122648);
        return wVar;
    }

    public static final boolean b(w wVar, w wVar2) {
        boolean ad;
        AppMethodBeat.i(122649);
        j.p(wVar, "first");
        j.p(wVar2, "second");
        az ekn = wVar.ekn();
        if (!(ekn instanceof ak)) {
            ekn = null;
        }
        ak akVar = (ak) ekn;
        if (akVar != null) {
            ad = akVar.ad(wVar2);
        } else {
            ad = false;
        }
        if (!ad) {
            ekn = wVar2.ekn();
            if (!(ekn instanceof ak)) {
                ekn = null;
            }
            akVar = (ak) ekn;
            if (akVar != null) {
                ad = akVar.ad(wVar);
            } else {
                ad = false;
            }
            if (!ad) {
                AppMethodBeat.o(122649);
                return false;
            }
        }
        AppMethodBeat.o(122649);
        return true;
    }
}
