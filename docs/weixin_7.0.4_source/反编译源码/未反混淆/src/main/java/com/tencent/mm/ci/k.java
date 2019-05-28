package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;

public final class k {
    public final byte[] eHH = new byte[1];

    public k() {
        AppMethodBeat.i(123369);
        AppMethodBeat.o(123369);
    }

    public final void done() {
        AppMethodBeat.i(123370);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] == (byte) -1) {
                    this.eHH[0] = (byte) 1;
                    this.eHH.notifyAll();
                    j.i("MicroMsg.WxWaitingLock", "notify done %s", this);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123370);
            }
        }
    }
}
