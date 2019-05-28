package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends com.tencent.mm.sdk.b.c<hu> {
    public c() {
        AppMethodBeat.i(59331);
        this.xxI = hu.class.getName().hashCode();
        AppMethodBeat.o(59331);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(59332);
        hu huVar = (hu) bVar;
        if (huVar instanceof hu) {
            ab.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            ab.i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", Boolean.valueOf(m.cvU()));
            if (m.cvU()) {
                huVar.cCM.cCN = 1;
            } else {
                huVar.cCM.cCN = 0;
            }
        }
        AppMethodBeat.o(59332);
        return true;
    }
}
