package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends c<oa> {
    public k() {
        AppMethodBeat.i(41497);
        this.xxI = oa.class.getName().hashCode();
        AppMethodBeat.o(41497);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(41498);
        oa oaVar = (oa) bVar;
        if (!g.RK()) {
            ab.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (oaVar instanceof oa) {
            ab.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            a.bwM();
            if (a.bwN() != null) {
                a.bwM();
                a.bwN();
                c.bxk();
                ab.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            AppMethodBeat.o(41498);
            return true;
        }
        AppMethodBeat.o(41498);
        return false;
    }
}
