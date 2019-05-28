package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.soter.core.a;

public final class b extends c<hs> {
    public b() {
        AppMethodBeat.i(59329);
        this.xxI = hs.class.getName().hashCode();
        AppMethodBeat.o(59329);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        int i = 1;
        AppMethodBeat.i(59330);
        hs hsVar = (hs) bVar;
        ab.i("MicroMsg.GetIsEnrolledListener", "hy: check mode: %d", Integer.valueOf(hsVar.cCD.cCF));
        if (hsVar.cCD.cCF == 1 && m.cvU()) {
            ab.i("MicroMsg.GetIsEnrolledListener", "hy: has enrolled fingerprint: %b", Boolean.valueOf(a.iR(ah.getContext())));
            com.tencent.mm.g.a.hs.b bVar2 = hsVar.cCE;
            if (!a.iR(ah.getContext())) {
                i = 0;
            }
            bVar2.cCG = i;
        } else {
            ab.w("MicroMsg.GetIsEnrolledListener", "hy: not support");
            hsVar.cCE.cCG = -1;
        }
        AppMethodBeat.o(59330);
        return false;
    }
}
