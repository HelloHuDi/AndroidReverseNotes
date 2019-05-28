package com.tencent.p177mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.p */
public final class C43720p implements C1406a {
    public static int cri = 100;
    public C9742k chd = null;
    public String fileName = "";
    public C45293b gar;
    private int jJI = 0;
    public long ljM = 0;
    public C43721b sLB;
    public String sLC;
    public boolean sLD = false;
    public C40018a sLE = null;
    public boolean sth = false;
    public int stk = 0;

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.p$1 */
    public class C140171 extends C7306ak {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(26122);
            C4990ab.m7410d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
            if (C43720p.this.sth) {
                AppMethodBeat.m2505o(26122);
                return;
            }
            C9638aw.m17191ZL().mo4829b(C43720p.this);
            C9638aw.m17191ZL().mo4818KN();
            C43720p.this.mo4815gE(200);
            AppMethodBeat.m2505o(26122);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.p$a */
    public interface C40018a {
        void cHQ();
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.p$b */
    final class C43721b extends Thread {
        C7306ak handler;

        public C43721b() {
            AppMethodBeat.m2504i(26124);
            this.handler = new C7306ak(C43720p.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.m2504i(26123);
                    if (C43720p.this.stk <= 0) {
                        AppMethodBeat.m2505o(26123);
                        return;
                    }
                    C43720p.this.stk = 2;
                    AppMethodBeat.m2505o(26123);
                }
            };
            AppMethodBeat.m2505o(26124);
        }

        public final void run() {
            AppMethodBeat.m2504i(26125);
            if (C43720p.this.chd == null) {
                C4990ab.m7412e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
                AppMethodBeat.m2505o(26125);
                return;
            }
            synchronized (C43720p.this) {
                try {
                    String by = C22449m.m34137by(C43720p.this.fileName, true);
                    C4990ab.m7411d("MicroMsg.VoicePrintRecoder", "fullPathName %s", by);
                    C43720p.this.sLC = by;
                    if (C43720p.this.gar != null) {
                        C43720p.this.gar.requestFocus();
                    }
                    if (C43720p.this.chd.mo5467el(by)) {
                        if (C43720p.this.sLE != null) {
                            C43720p.this.sLE;
                        }
                        C43720p.this.ljM = C5046bo.m7588yz();
                        C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + C43720p.this.fileName + "]");
                        this.handler.sendEmptyMessageDelayed(0, 1);
                        AppMethodBeat.m2505o(26125);
                        return;
                    }
                    C43720p.this.fileName = null;
                    C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + C43720p.this.fileName + "]");
                    C43720p.this.chd.mo5464EB();
                    C43720p.this.chd = null;
                    if (C43720p.this.gar != null) {
                        C43720p.this.gar.mo73178Mm();
                    }
                    if (C43720p.this.sLE != null) {
                        C43720p.this.sLE.cHQ();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(26125);
                }
            }
        }
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(26126);
        C4990ab.m7410d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(i)));
        if (this.sth) {
            AppMethodBeat.m2505o(26126);
            return;
        }
        this.sth = true;
        C9638aw.m17191ZL().mo4829b((C1406a) this);
        this.chd = new C9742k();
        this.sLB = new C43721b();
        this.sLB.start();
        this.sLD = false;
        this.stk = 1;
        AppMethodBeat.m2505o(26126);
    }

    /* renamed from: EH */
    public final boolean mo69408EH() {
        long j = 0;
        AppMethodBeat.m2504i(26127);
        C9638aw.m17191ZL().mo4818KN();
        this.sLD = false;
        C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
        synchronized (this) {
            try {
                C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
                if (this.chd != null) {
                    this.chd.mo5464EB();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(26127);
                }
            }
        }
        if (this.stk != 2) {
            this.fileName = null;
            this.sLD = false;
            C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        } else {
            if (this.ljM > 0) {
                j = C5046bo.m7525az(this.ljM);
            }
            this.jJI = (int) j;
            if (this.jJI < 1000) {
                C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.jJI);
                this.fileName = "";
                this.sLD = false;
            } else {
                this.sLD = true;
                C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
        }
        this.stk = -1;
        C4990ab.m7410d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.sLD);
        if (this.gar != null) {
            this.gar.mo73178Mm();
        }
        boolean z = this.sLD;
        AppMethodBeat.m2505o(26127);
        return z;
    }
}
