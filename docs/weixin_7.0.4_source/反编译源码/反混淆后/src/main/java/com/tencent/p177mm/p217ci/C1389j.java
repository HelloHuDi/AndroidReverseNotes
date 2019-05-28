package com.tencent.p177mm.p217ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ci.j */
public final class C1389j {
    public final byte[] eHH = new byte[1];

    public C1389j() {
        AppMethodBeat.m2504i(115295);
        AppMethodBeat.m2505o(115295);
    }

    public final void dOX() {
        AppMethodBeat.m2504i(115296);
        synchronized (this.eHH) {
            try {
                if (this.eHH[0] != (byte) 0) {
                    C4990ab.m7417i("MicroMsg.WxTimeoutLock", "no need lock %s", this);
                } else {
                    this.eHH.wait(3000);
                }
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.WxTimeoutLock", e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(115296);
            }
        }
        AppMethodBeat.m2505o(115296);
    }
}
