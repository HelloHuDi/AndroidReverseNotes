package com.tencent.p177mm.p217ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ci.b */
public final class C1388b {
    private long Aiw = -1;
    private final byte[] eHH = new byte[1];

    public C1388b() {
        AppMethodBeat.m2504i(123364);
        AppMethodBeat.m2505o(123364);
    }

    public final void dOV() {
        AppMethodBeat.m2504i(123365);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] == (byte) 0) {
                    this.eHH[0] = (byte) 1;
                    this.Aiw = Thread.currentThread().getId();
                    C1736j.m3587i("MicroMsg.WxConsumedLock", "lock %s", this);
                } else if (this.Aiw != Thread.currentThread().getId()) {
                    C1736j.m3587i("MicroMsg.WxConsumedLock", "lock waiting %s", this);
                    this.eHH.wait();
                    C1736j.m3584d("MicroMsg.WxConsumedLock", "unlock waiting %s", this);
                } else {
                    C1736j.m3584d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", this);
                }
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.WxConsumedLock", e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(123365);
            }
        }
        AppMethodBeat.m2505o(123365);
    }

    public final void done() {
        AppMethodBeat.m2504i(123366);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] != (byte) 0) {
                    this.eHH[0] = (byte) 0;
                    this.Aiw = -1;
                    this.eHH.notifyAll();
                    C1736j.m3587i("MicroMsg.WxConsumedLock", "notify done %s", this);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123366);
            }
        }
    }
}
