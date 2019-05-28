package com.tencent.p177mm.plugin.voip_cs.p547b.p548a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.voip.model.C29495b;
import com.tencent.p177mm.plugin.voip.model.C29496c;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1310b.C43747a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.a.c */
public final class C43745c {
    public C1292c kzb = new C1292c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    private C1293a kzo = new C368341();
    private C29495b oFT = new C353872();
    public C29496c sPL;

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.c$2 */
    class C353872 implements C29495b {
        C353872() {
        }

        /* renamed from: N */
        public final int mo45518N(byte[] bArr, int i) {
            AppMethodBeat.m2504i(135362);
            C4990ab.m7410d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
            int playCallback = C43749c.cMe().tew.playCallback(bArr, i);
            if (playCallback != 0) {
                C4990ab.m7410d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
            }
            if (playCallback != 0) {
                AppMethodBeat.m2505o(135362);
                return 1;
            }
            AppMethodBeat.m2505o(135362);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.c$1 */
    class C368341 implements C1293a {
        C368341() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(135360);
            if (i <= 0) {
                C4990ab.m7412e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
                AppMethodBeat.m2505o(135360);
                return;
            }
            C4990ab.m7410d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
            C4990ab.m7410d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:".concat(String.valueOf(C43749c.cMe().tew.recordCallback(bArr, i, 200))));
            AppMethodBeat.m2505o(135360);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(135361);
            C4990ab.m7417i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(135361);
        }
    }

    public C43745c() {
        AppMethodBeat.m2504i(135363);
        this.kzb.mo4598gG(20);
        this.kzb.mo4596br(true);
        this.kzb.mo4591EJ();
        this.kzb.mo4599v(1, false);
        this.kzb.mo4595bq(true);
        this.kzb.cpM = this.kzo;
        this.sPL = new C29496c();
        this.sPL.mo47750G(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
        this.sPL.mo47759x(C4996ah.getContext(), false);
        this.sPL.sNt = this.oFT;
        AppMethodBeat.m2505o(135363);
    }

    /* renamed from: mj */
    private boolean m78428mj(boolean z) {
        AppMethodBeat.m2504i(135364);
        if (this.sPL != null) {
            boolean mj = this.sPL.mo47758mj(z);
            AppMethodBeat.m2505o(135364);
            return mj;
        }
        AppMethodBeat.m2505o(135364);
        return false;
    }

    /* renamed from: mr */
    public final void mo69452mr(boolean z) {
        AppMethodBeat.m2504i(135365);
        C4990ab.m7408b("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: ".concat(String.valueOf(z)), new Object[0]);
        C4990ab.m7410d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + C1407g.m2946KK().mo4820KT());
        if (C1407g.m2946KK().mo4819KP()) {
            z = false;
        }
        if (C1427q.etd.epG) {
            C1427q.etd.dump();
            if (C1427q.etd.epH > 0) {
                m78428mj(z);
            }
        }
        if (C1427q.etd.eqj >= 0 || C1427q.etd.eqk >= 0) {
            m78428mj(z);
        }
        if (this.sPL != null) {
            int appCmd;
            C1407g.m2946KK().mo4830b(z, this.sPL.cIt(), false);
            C43747a cMe = C43749c.cMe();
            if (z) {
                appCmd = cMe.tew.setAppCmd(401);
            } else {
                appCmd = cMe.tew.setAppCmd(402);
            }
            if (appCmd < 0) {
                C46317a.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(appCmd)));
            }
        }
        AppMethodBeat.m2505o(135365);
    }

    public final int cIt() {
        AppMethodBeat.m2504i(135366);
        if (this.sPL != null) {
            int cIt = this.sPL.cIt();
            AppMethodBeat.m2505o(135366);
            return cIt;
        }
        AppMethodBeat.m2505o(135366);
        return 0;
    }
}
