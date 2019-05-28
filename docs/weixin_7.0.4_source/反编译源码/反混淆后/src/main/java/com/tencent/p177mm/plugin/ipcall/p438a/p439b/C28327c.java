package com.tencent.p177mm.plugin.ipcall.p438a.p439b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.b.c */
public final class C28327c {
    public boolean cFy;
    public boolean eif;
    C1293a kzo;
    public C1292c nxm;
    public final Object nxn;
    int nxo;
    boolean nxp;
    int nxq;
    boolean nxr;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.c$1 */
    class C33021 implements C1293a {
        C33021() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(21812);
            synchronized (C28327c.this.nxn) {
                try {
                    int cIq;
                    C28327c c28327c = C28327c.this;
                    if (c28327c.nxo <= 10) {
                        c28327c.nxo = 92;
                    }
                    C39254a c39254a = C21088i.bHt().nxf;
                    if (c39254a.kzq != null) {
                        cIq = c39254a.kzq.cIq();
                    } else {
                        cIq = 0;
                    }
                    c28327c.nxo = ((cIq + 24) + (c28327c.nxo * 3)) / 4;
                    if (c28327c.nxp) {
                        C4990ab.m7416i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                        c39254a = C21088i.bHt().nxf;
                        if (c39254a.kzq != null) {
                            i2 = c39254a.kzq.cIn();
                        }
                        c28327c.nxq = i2;
                        if (c28327c.nxq >= c28327c.nxo) {
                            c28327c.nxq -= c28327c.nxo;
                        }
                        c28327c.nxo = c28327c.nxq;
                        c28327c.nxp = false;
                    } else {
                        c28327c.nxo = 0;
                    }
                    if (C21088i.bHu().mCurrentState == 5) {
                        if (C28327c.this.nxr) {
                            C4990ab.m7416i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                            C28327c.this.nxr = false;
                        }
                        C21088i.bHr().nxx.recordCallback(bArr, i, C28327c.this.nxo);
                    }
                } finally {
                    AppMethodBeat.m2505o(21812);
                }
            }
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.c$2 */
    class C33032 implements Runnable {
        C33032() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21813);
            try {
                C28327c c28327c = C28327c.this;
                c28327c.nxm = new C1292c(v2protocal.VOICE_SAMPLERATE, 1, 6);
                c28327c.nxm.mo4598gG(20);
                c28327c.nxm.mo4596br(true);
                c28327c.nxm.mo4591EJ();
                c28327c.nxm.cpB = -19;
                c28327c.nxm.mo4599v(1, false);
                c28327c.nxm.mo4595bq(true);
                c28327c.nxm.cpM = c28327c.kzo;
                if (c28327c.nxm.mo4592EL()) {
                    c28327c.nxm.mo4597bs(c28327c.eif);
                } else {
                    C4990ab.m7412e("MicroMsg.IPCallRecorder", "start record failed");
                    if (c28327c.nxm.cpq != 13) {
                        C21088i.bHs().bHQ();
                        AppMethodBeat.m2505o(21813);
                        return;
                    }
                }
                AppMethodBeat.m2505o(21813);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallRecorder", "start record error: %s", e.getMessage());
                C21088i.bHs().bHQ();
                AppMethodBeat.m2505o(21813);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.c$a */
    public class C28328a implements Runnable {
        private C1292c nxt = null;

        public C28328a(C1292c c1292c) {
            this.nxt = c1292c;
        }

        public final void run() {
            AppMethodBeat.m2504i(21814);
            C4990ab.m7410d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.nxt != null) {
                this.nxt.mo4590EB();
                this.nxt = null;
                C28327c c28327c = C28327c.this;
                c28327c.nxo = 92;
                c28327c.nxp = true;
                c28327c.nxq = 0;
            }
            AppMethodBeat.m2505o(21814);
        }
    }

    public C28327c() {
        AppMethodBeat.m2504i(21815);
        this.nxm = null;
        this.nxn = new Object();
        this.cFy = false;
        this.eif = false;
        this.nxo = 92;
        this.nxp = true;
        this.nxq = 0;
        this.nxr = true;
        this.kzo = new C33021();
        this.cFy = false;
        AppMethodBeat.m2505o(21815);
    }

    public final void aDm() {
        AppMethodBeat.m2504i(21816);
        if (this.cFy) {
            C4990ab.m7410d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            AppMethodBeat.m2505o(21816);
            return;
        }
        C4990ab.m7416i("MicroMsg.IPCallRecorder", "start record");
        this.cFy = true;
        this.nxo = C21088i.bHt().nxf.nxb;
        if (this.nxo <= 10) {
            if (this.nxo <= 0) {
                C4990ab.m7412e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                C21088i.bHs().bHQ();
            }
            this.nxo = 92;
        }
        synchronized (this.nxn) {
            try {
                C7305d.post(new C33032(), "IPCallRecorder_startRecord");
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21816);
            }
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(21817);
        C4990ab.m7417i("MicroMsg.IPCallRecorder", "setMute: %b", Boolean.valueOf(z));
        if (this.cFy && this.nxm != null) {
            this.nxm.mo4597bs(z);
        }
        this.eif = z;
        AppMethodBeat.m2505o(21817);
    }
}
