package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public boolean cFy;
    public boolean eif;
    com.tencent.mm.audio.b.c.a kzo;
    public com.tencent.mm.audio.b.c nxm;
    public final Object nxn;
    int nxo;
    boolean nxp;
    int nxq;
    boolean nxr;

    public class a implements Runnable {
        private com.tencent.mm.audio.b.c nxt = null;

        public a(com.tencent.mm.audio.b.c cVar) {
            this.nxt = cVar;
        }

        public final void run() {
            AppMethodBeat.i(21814);
            ab.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.nxt != null) {
                this.nxt.EB();
                this.nxt = null;
                c cVar = c.this;
                cVar.nxo = 92;
                cVar.nxp = true;
                cVar.nxq = 0;
            }
            AppMethodBeat.o(21814);
        }
    }

    public c() {
        AppMethodBeat.i(21815);
        this.nxm = null;
        this.nxn = new Object();
        this.cFy = false;
        this.eif = false;
        this.nxo = 92;
        this.nxp = true;
        this.nxq = 0;
        this.nxr = true;
        this.kzo = new com.tencent.mm.audio.b.c.a() {
            public final void u(byte[] bArr, int i) {
                int i2 = 0;
                AppMethodBeat.i(21812);
                synchronized (c.this.nxn) {
                    try {
                        int cIq;
                        c cVar = c.this;
                        if (cVar.nxo <= 10) {
                            cVar.nxo = 92;
                        }
                        a aVar = i.bHt().nxf;
                        if (aVar.kzq != null) {
                            cIq = aVar.kzq.cIq();
                        } else {
                            cIq = 0;
                        }
                        cVar.nxo = ((cIq + 24) + (cVar.nxo * 3)) / 4;
                        if (cVar.nxp) {
                            ab.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                            aVar = i.bHt().nxf;
                            if (aVar.kzq != null) {
                                i2 = aVar.kzq.cIn();
                            }
                            cVar.nxq = i2;
                            if (cVar.nxq >= cVar.nxo) {
                                cVar.nxq -= cVar.nxo;
                            }
                            cVar.nxo = cVar.nxq;
                            cVar.nxp = false;
                        } else {
                            cVar.nxo = 0;
                        }
                        if (i.bHu().mCurrentState == 5) {
                            if (c.this.nxr) {
                                ab.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                                c.this.nxr = false;
                            }
                            i.bHr().nxx.recordCallback(bArr, i, c.this.nxo);
                        }
                    } finally {
                        AppMethodBeat.o(21812);
                    }
                }
            }

            public final void bN(int i, int i2) {
            }
        };
        this.cFy = false;
        AppMethodBeat.o(21815);
    }

    public final void aDm() {
        AppMethodBeat.i(21816);
        if (this.cFy) {
            ab.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            AppMethodBeat.o(21816);
            return;
        }
        ab.i("MicroMsg.IPCallRecorder", "start record");
        this.cFy = true;
        this.nxo = i.bHt().nxf.nxb;
        if (this.nxo <= 10) {
            if (this.nxo <= 0) {
                ab.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.bHs().bHQ();
            }
            this.nxo = 92;
        }
        synchronized (this.nxn) {
            try {
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21813);
                        try {
                            c cVar = c.this;
                            cVar.nxm = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
                            cVar.nxm.gG(20);
                            cVar.nxm.br(true);
                            cVar.nxm.EJ();
                            cVar.nxm.cpB = -19;
                            cVar.nxm.v(1, false);
                            cVar.nxm.bq(true);
                            cVar.nxm.cpM = cVar.kzo;
                            if (cVar.nxm.EL()) {
                                cVar.nxm.bs(cVar.eif);
                            } else {
                                ab.e("MicroMsg.IPCallRecorder", "start record failed");
                                if (cVar.nxm.cpq != 13) {
                                    i.bHs().bHQ();
                                    AppMethodBeat.o(21813);
                                    return;
                                }
                            }
                            AppMethodBeat.o(21813);
                        } catch (Exception e) {
                            ab.e("MicroMsg.IPCallRecorder", "start record error: %s", e.getMessage());
                            i.bHs().bHQ();
                            AppMethodBeat.o(21813);
                        }
                    }
                }, "IPCallRecorder_startRecord");
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21816);
            }
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(21817);
        ab.i("MicroMsg.IPCallRecorder", "setMute: %b", Boolean.valueOf(z));
        if (this.cFy && this.nxm != null) {
            this.nxm.bs(z);
        }
        this.eif = z;
        AppMethodBeat.o(21817);
    }
}
