package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q extends c<mp> {
    private static long ecD = 86400000;

    public q() {
        AppMethodBeat.i(78504);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(78504);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(78507);
        boolean aiv = aiv();
        AppMethodBeat.o(78507);
        return aiv;
    }

    private static boolean aiv() {
        AppMethodBeat.i(78505);
        ab.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + Iv());
        if (Iv()) {
            c.aiq().update();
        }
        AppMethodBeat.o(78505);
        return false;
    }

    private static boolean Iv() {
        AppMethodBeat.i(78506);
        if (bo.fp(bo.c((Long) g.RP().Ry().get(81938, null))) * 1000 > ecD) {
            AppMethodBeat.o(78506);
            return true;
        }
        AppMethodBeat.o(78506);
        return false;
    }
}
