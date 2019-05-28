package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j {
    public final byte[] eHH = new byte[1];

    public j() {
        AppMethodBeat.i(115295);
        AppMethodBeat.o(115295);
    }

    public final void dOX() {
        AppMethodBeat.i(115296);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] != (byte) 0) {
                    ab.i("MicroMsg.WxTimeoutLock", "no need lock %s", this);
                } else {
                    this.eHH.wait(3000);
                }
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MicroMsg.WxTimeoutLock", e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(115296);
            }
        }
        AppMethodBeat.o(115296);
    }
}
