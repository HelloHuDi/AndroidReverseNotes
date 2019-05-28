package com.tencent.p177mm.plugin.ipcall.p438a.p439b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.voip.model.C29495b;
import com.tencent.p177mm.plugin.voip.model.C29496c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.b.a */
public final class C39254a {
    public boolean cFy = false;
    public C29496c kzq = null;
    public final Object nxa = new Object();
    public int nxb = 0;
    public boolean nxc = false;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.a$a */
    public class C21078a implements Runnable {
        private C29496c nxe = null;

        public C21078a(C29496c c29496c) {
            this.nxe = c29496c;
        }

        public final void run() {
            AppMethodBeat.m2504i(21799);
            if (this.nxe != null) {
                this.nxe.cIr();
                this.nxe.cIo();
                this.nxe = null;
                C39254a.this.nxc = false;
            }
            C9638aw.m17191ZL().setMode(0);
            AppMethodBeat.m2505o(21799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.a$1 */
    public class C392551 implements C29495b {
        /* renamed from: N */
        public final int mo45518N(byte[] bArr, int i) {
            AppMethodBeat.m2504i(21798);
            if (C39254a.this.cFy) {
                if (C21088i.bHr().nxx.playCallback(bArr, i) < 0) {
                    C4990ab.m7413e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", Integer.valueOf(C21088i.bHr().nxx.playCallback(bArr, i)));
                    AppMethodBeat.m2505o(21798);
                    return -1;
                }
                AppMethodBeat.m2505o(21798);
                return 0;
            }
            AppMethodBeat.m2505o(21798);
            return -1;
        }
    }

    public C39254a() {
        AppMethodBeat.m2504i(21800);
        AppMethodBeat.m2505o(21800);
    }

    /* renamed from: io */
    public final void mo62156io(boolean z) {
        AppMethodBeat.m2504i(21801);
        C4990ab.m7417i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", Boolean.valueOf(this.nxc), Boolean.valueOf(z));
        C9638aw.m17191ZL().mo4832bF(z);
        C21088i.bHr().mo7682io(z);
        if (z != this.nxc) {
            this.nxc = z;
            m66901ip(z);
        }
        AppMethodBeat.m2505o(21801);
    }

    /* renamed from: ip */
    private void m66901ip(boolean z) {
        AppMethodBeat.m2504i(21802);
        if (this.kzq != null && this.kzq.sNi) {
            this.kzq.mo47758mj(z);
        }
        AppMethodBeat.m2505o(21802);
    }

    /* renamed from: KU */
    public static boolean m66900KU() {
        AppMethodBeat.m2504i(139021);
        boolean isSpeakerphoneOn = C9638aw.m17191ZL().eoY.isSpeakerphoneOn();
        AppMethodBeat.m2505o(139021);
        return isSpeakerphoneOn;
    }
}
