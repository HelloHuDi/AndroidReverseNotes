package com.tencent.p177mm.p217ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1736j;

/* renamed from: com.tencent.mm.ci.k */
public final class C18167k {
    public final byte[] eHH = new byte[1];

    public C18167k() {
        AppMethodBeat.m2504i(123369);
        AppMethodBeat.m2505o(123369);
    }

    public final void done() {
        AppMethodBeat.m2504i(123370);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] == (byte) -1) {
                    this.eHH[0] = (byte) 1;
                    this.eHH.notifyAll();
                    C1736j.m3587i("MicroMsg.WxWaitingLock", "notify done %s", this);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123370);
            }
        }
    }
}
