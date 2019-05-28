package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    static int kze = 3;
    d kza;
    volatile com.tencent.mm.audio.b.c kzb;
    private b kzc = new b();
    private e kzd;
    int kzf = 1;
    int kzg = 92;
    private int kzh = 1;
    private final Object kzi = new Object();
    int kzj = 0;
    private int kzk = 1;
    private long kzl = 0;
    boolean kzm = false;
    int kzn = 20;
    a kzo = new a() {
        public final void u(byte[] bArr, int i) {
            Object obj = null;
            int i2 = -1;
            AppMethodBeat.i(135468);
            synchronized (c.this.kzi) {
                try {
                    if (c.this.kzf == 2) {
                        if (c.this.kza.kzq != null) {
                            obj = 1;
                        }
                        if (obj != null) {
                            int cIq;
                            if (c.this.kzg <= 10) {
                                c.this.kzg = 92;
                            }
                            d b = c.this.kza;
                            if (b.kzq != null) {
                                cIq = b.kzq.cIq();
                            } else {
                                cIq = -1;
                            }
                            c.this.kzg = ((cIq + 24) + (c.this.kzg * 3)) / 4;
                            if (c.this.kzh == 1) {
                                b = c.this.kza;
                                if (b.kzq != null) {
                                    i2 = b.kzq.cIn();
                                }
                                if (i2 >= c.this.kzg) {
                                    i2 -= c.this.kzg;
                                }
                                c.this.kzg = i2;
                                c.this.kzh = 0;
                            } else {
                                c.this.kzg = 0;
                            }
                            if (1 == c.this.kzk) {
                                c.this.kzk = 0;
                                c.this.kzl = System.currentTimeMillis();
                                ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                long h = currentTimeMillis - c.this.kzl;
                                if (h > 1000) {
                                    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(h)));
                                }
                                c.this.kzl = currentTimeMillis;
                            }
                            j jVar = j.kzW;
                            j.t(bArr, bArr.length, c.this.kzg);
                        }
                    }
                } finally {
                    AppMethodBeat.o(135468);
                }
            }
        }

        public final void bN(int i, int i2) {
        }
    };
    int mChannels = 1;
    int mSampleRate = v2protocal.VOICE_SAMPLERATE;

    public c(e eVar) {
        AppMethodBeat.i(135470);
        this.kzd = eVar;
        this.kza = new d();
        AppMethodBeat.o(135470);
    }

    public final boolean EL() {
        boolean z = true;
        AppMethodBeat.i(135471);
        ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
        if (this.kzf != 2) {
            ab.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
        }
        synchronized (this.kzi) {
            try {
                if (this.kzb.EL()) {
                    ab.d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.kzj);
                    AppMethodBeat.o(135471);
                } else {
                    if (this.kzb.cpq != 13) {
                        this.kzj = 1;
                    }
                    z = false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135471);
            }
        }
        return z;
    }
}
