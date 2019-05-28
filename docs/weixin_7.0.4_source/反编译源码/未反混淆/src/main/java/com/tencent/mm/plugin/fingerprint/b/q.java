package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class q {
    a msf;

    public interface a {
        void AR(String str);
    }

    public q(a aVar) {
        this.msf = aVar;
    }

    public final void aBU() {
        AppMethodBeat.i(41560);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41559);
                String str = "";
                if (e.bxs()) {
                    ab.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(e.dQ(ah.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.LM());
                } else {
                    ab.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (q.this.msf != null) {
                    q.this.msf.AR(str);
                }
                AppMethodBeat.o(41559);
            }
        }, getClass().getName());
        AppMethodBeat.o(41560);
    }
}
