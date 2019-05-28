package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class kp implements ko {
    public final <T, S extends kt> kj<T, S> a(kt ktVar, List<? extends kj<T, S>> list) {
        AppMethodBeat.i(100261);
        kj kjVar = (kj) Collections.min(list, ke.a(ke.a(ktVar.a()), ke.b(ktVar.a())));
        AppMethodBeat.o(100261);
        return kjVar;
    }
}
