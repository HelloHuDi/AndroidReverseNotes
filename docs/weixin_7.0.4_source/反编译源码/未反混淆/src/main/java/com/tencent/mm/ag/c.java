package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.music.b.a;

public final class c {
    public static boolean pN(String str) {
        AppMethodBeat.i(137230);
        t tVar = new t();
        tVar.csI.action = 7;
        tVar.csI.ckD = str;
        a.a(tVar);
        boolean z = tVar.csJ.csN;
        AppMethodBeat.o(137230);
        return z;
    }

    public static b pO(String str) {
        AppMethodBeat.i(137231);
        t tVar = new t();
        tVar.csI.action = 16;
        tVar.csI.ckD = str;
        a.a(tVar);
        b bVar = tVar.csI.csL;
        AppMethodBeat.o(137231);
        return bVar;
    }
}
