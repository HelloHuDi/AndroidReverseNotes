package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class p implements com.tencent.mm.compatible.b.g.a {
    public static int cri = 100;
    public k chd = null;
    public String fileName = "";
    public com.tencent.mm.compatible.util.b gar;
    private int jJI = 0;
    public long ljM = 0;
    public b sLB;
    public String sLC;
    public boolean sLD = false;
    public a sLE = null;
    public boolean sth = false;
    public int stk = 0;

    public interface a {
        void cHQ();
    }

    final class b extends Thread {
        ak handler;

        public b() {
            AppMethodBeat.i(26124);
            this.handler = new ak(p.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(26123);
                    if (p.this.stk <= 0) {
                        AppMethodBeat.o(26123);
                        return;
                    }
                    p.this.stk = 2;
                    AppMethodBeat.o(26123);
                }
            };
            AppMethodBeat.o(26124);
        }

        public final void run() {
            AppMethodBeat.i(26125);
            if (p.this.chd == null) {
                ab.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
                AppMethodBeat.o(26125);
                return;
            }
            synchronized (p.this) {
                try {
                    String by = m.by(p.this.fileName, true);
                    ab.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", by);
                    p.this.sLC = by;
                    if (p.this.gar != null) {
                        p.this.gar.requestFocus();
                    }
                    if (p.this.chd.el(by)) {
                        if (p.this.sLE != null) {
                            p.this.sLE;
                        }
                        p.this.ljM = bo.yz();
                        ab.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.this.fileName + "]");
                        this.handler.sendEmptyMessageDelayed(0, 1);
                        AppMethodBeat.o(26125);
                        return;
                    }
                    p.this.fileName = null;
                    ab.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.this.fileName + "]");
                    p.this.chd.EB();
                    p.this.chd = null;
                    if (p.this.gar != null) {
                        p.this.gar.Mm();
                    }
                    if (p.this.sLE != null) {
                        p.this.sLE.cHQ();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(26125);
                }
            }
        }
    }

    public final void gE(int i) {
        AppMethodBeat.i(26126);
        ab.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(i)));
        if (this.sth) {
            AppMethodBeat.o(26126);
            return;
        }
        this.sth = true;
        aw.ZL().b((com.tencent.mm.compatible.b.g.a) this);
        this.chd = new k();
        this.sLB = new b();
        this.sLB.start();
        this.sLD = false;
        this.stk = 1;
        AppMethodBeat.o(26126);
    }

    public final boolean EH() {
        long j = 0;
        AppMethodBeat.i(26127);
        aw.ZL().KN();
        this.sLD = false;
        ab.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
        synchronized (this) {
            try {
                ab.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
                if (this.chd != null) {
                    this.chd.EB();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(26127);
                }
            }
        }
        if (this.stk != 2) {
            this.fileName = null;
            this.sLD = false;
            ab.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        } else {
            if (this.ljM > 0) {
                j = bo.az(this.ljM);
            }
            this.jJI = (int) j;
            if (this.jJI < 1000) {
                ab.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.jJI);
                this.fileName = "";
                this.sLD = false;
            } else {
                this.sLD = true;
                ab.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
        }
        this.stk = -1;
        ab.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.sLD);
        if (this.gar != null) {
            this.gar.Mm();
        }
        boolean z = this.sLD;
        AppMethodBeat.o(26127);
        return z;
    }
}
