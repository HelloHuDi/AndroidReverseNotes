package a.i.b.a.c.d.a.c;

import a.f.b.j;
import a.i.b.a.c.d.a.a.a;
import a.i.b.a.c.d.a.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;

public final class d {
    final EnumMap<a, h> Bnl;

    public d(EnumMap<a, h> enumMap) {
        j.p(enumMap, "nullabilityQualifiers");
        AppMethodBeat.i(119827);
        this.Bnl = enumMap;
        AppMethodBeat.o(119827);
    }

    public final a.i.b.a.c.d.a.f.d b(a aVar) {
        AppMethodBeat.i(119826);
        h hVar = (h) this.Bnl.get(aVar);
        if (hVar == null) {
            AppMethodBeat.o(119826);
            return null;
        }
        j.o(hVar, "nullabilityQualifiers[ap…ilityType] ?: return null");
        a.i.b.a.c.d.a.f.d dVar = new a.i.b.a.c.d.a.f.d(hVar.BpP, null, false, hVar.BpQ);
        AppMethodBeat.o(119826);
        return dVar;
    }
}
