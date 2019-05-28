package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    private long Aiw = -1;
    private final byte[] eHH = new byte[1];

    public b() {
        AppMethodBeat.i(123364);
        AppMethodBeat.o(123364);
    }

    public final void dOV() {
        AppMethodBeat.i(123365);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] == (byte) 0) {
                    this.eHH[0] = (byte) 1;
                    this.Aiw = Thread.currentThread().getId();
                    j.i("MicroMsg.WxConsumedLock", "lock %s", this);
                } else if (this.Aiw != Thread.currentThread().getId()) {
                    j.i("MicroMsg.WxConsumedLock", "lock waiting %s", this);
                    this.eHH.wait();
                    j.d("MicroMsg.WxConsumedLock", "unlock waiting %s", this);
                } else {
                    j.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", this);
                }
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MicroMsg.WxConsumedLock", e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(123365);
            }
        }
        AppMethodBeat.o(123365);
    }

    public final void done() {
        AppMethodBeat.i(123366);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] != (byte) 0) {
                    this.eHH[0] = (byte) 0;
                    this.Aiw = -1;
                    this.eHH.notifyAll();
                    j.i("MicroMsg.WxConsumedLock", "notify done %s", this);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123366);
            }
        }
    }
}
