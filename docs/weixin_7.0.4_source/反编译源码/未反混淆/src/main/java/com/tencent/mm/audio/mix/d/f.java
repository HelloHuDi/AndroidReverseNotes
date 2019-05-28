package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.d;
import com.tencent.mm.audio.mix.g.b;

public final class f {
    public static k a(d dVar, b bVar, boolean z) {
        k dVar2;
        AppMethodBeat.i(137073);
        if (bVar.Ev().ckA) {
            dVar2 = new d(dVar, bVar);
        } else {
            dVar2 = new e(dVar, bVar);
        }
        dVar2.init();
        if (z) {
            dVar2.Dw();
        }
        AppMethodBeat.o(137073);
        return dVar2;
    }
}
