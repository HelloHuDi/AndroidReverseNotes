package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c {
    public com.tencent.mm.audio.b.c kzb = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    private a kzo = new a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(135360);
            if (i <= 0) {
                ab.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
                AppMethodBeat.o(135360);
                return;
            }
            ab.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
            ab.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.recordCallback(bArr, i, 200))));
            AppMethodBeat.o(135360);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(135361);
            ab.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(135361);
        }
    };
    private b oFT = new b() {
        public final int N(byte[] bArr, int i) {
            AppMethodBeat.i(135362);
            ab.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
            int playCallback = com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.playCallback(bArr, i);
            if (playCallback != 0) {
                ab.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
            }
            if (playCallback != 0) {
                AppMethodBeat.o(135362);
                return 1;
            }
            AppMethodBeat.o(135362);
            return 0;
        }
    };
    public com.tencent.mm.plugin.voip.model.c sPL;

    public c() {
        AppMethodBeat.i(135363);
        this.kzb.gG(20);
        this.kzb.br(true);
        this.kzb.EJ();
        this.kzb.v(1, false);
        this.kzb.bq(true);
        this.kzb.cpM = this.kzo;
        this.sPL = new com.tencent.mm.plugin.voip.model.c();
        this.sPL.G(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
        this.sPL.x(ah.getContext(), false);
        this.sPL.sNt = this.oFT;
        AppMethodBeat.o(135363);
    }

    private boolean mj(boolean z) {
        AppMethodBeat.i(135364);
        if (this.sPL != null) {
            boolean mj = this.sPL.mj(z);
            AppMethodBeat.o(135364);
            return mj;
        }
        AppMethodBeat.o(135364);
        return false;
    }

    public final void mr(boolean z) {
        AppMethodBeat.i(135365);
        ab.b("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: ".concat(String.valueOf(z)), new Object[0]);
        ab.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + g.KK().KT());
        if (g.KK().KP()) {
            z = false;
        }
        if (q.etd.epG) {
            q.etd.dump();
            if (q.etd.epH > 0) {
                mj(z);
            }
        }
        if (q.etd.eqj >= 0 || q.etd.eqk >= 0) {
            mj(z);
        }
        if (this.sPL != null) {
            int appCmd;
            g.KK().b(z, this.sPL.cIt(), false);
            com.tencent.mm.plugin.voip_cs.b.b.a cMe = com.tencent.mm.plugin.voip_cs.b.c.cMe();
            if (z) {
                appCmd = cMe.tew.setAppCmd(401);
            } else {
                appCmd = cMe.tew.setAppCmd(402);
            }
            if (appCmd < 0) {
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(appCmd)));
            }
        }
        AppMethodBeat.o(135365);
    }

    public final int cIt() {
        AppMethodBeat.i(135366);
        if (this.sPL != null) {
            int cIt = this.sPL.cIt();
            AppMethodBeat.o(135366);
            return cIt;
        }
        AppMethodBeat.o(135366);
        return 0;
    }
}
