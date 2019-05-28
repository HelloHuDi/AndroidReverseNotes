package com.tencent.p177mm.plugin.ipcall.p438a.p439b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C35992bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import com.tencent.p177mm.sdk.platformtools.SensorController.C4986a;

/* renamed from: com.tencent.mm.plugin.ipcall.a.b.d */
public final class C12244d implements C4986a {
    private boolean mfR = false;
    public C35992bf mfS = new C35992bf(C4996ah.getContext());
    long mfT = -1;
    public SensorController mfW = new SensorController(C4996ah.getContext());
    public C12243a nxu = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.d$a */
    public interface C12243a {
        /* renamed from: iq */
        void mo24077iq(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.d$1 */
    class C122451 implements Runnable {
        C122451() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21818);
            C12244d.this.mfT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(21818);
        }
    }

    public C12244d() {
        AppMethodBeat.m2504i(21820);
        AppMethodBeat.m2505o(21820);
    }

    /* renamed from: he */
    public final void mo10257he(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(21821);
        C4990ab.m7416i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.mfR + " tick:" + C5046bo.m7525az(this.mfT) + "  lt:" + this.mfT);
        if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.m2505o(21821);
        } else if (z || this.mfT == -1 || C5046bo.m7525az(this.mfT) <= 400) {
            this.mfR = false;
            C4990ab.m7417i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", Boolean.valueOf(z));
            new C7564ap(new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(21819);
                    if (z) {
                        C4990ab.m7416i("MicroMsg.IPCallSensorManager", "light screen");
                        if (C12244d.this.nxu != null) {
                            C12244d.this.nxu.mo24077iq(false);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.IPCallSensorManager", "off screen");
                        if (C12244d.this.nxu != null) {
                            C12244d.this.nxu.mo24077iq(true);
                        }
                    }
                    AppMethodBeat.m2505o(21819);
                    return false;
                }
            }, false).mo16770ae(50, 50);
            AppMethodBeat.m2505o(21821);
        } else {
            this.mfR = true;
            AppMethodBeat.m2505o(21821);
        }
    }
}
