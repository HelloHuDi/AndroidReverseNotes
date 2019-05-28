package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.plugin.voip.model.C29495b;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c */
public final class C27667c {
    static int kze = 3;
    C6828d kza;
    volatile C1292c kzb;
    private C11412b kzc = new C11412b();
    private C2818e kzd;
    int kzf = 1;
    int kzg = 92;
    private int kzh = 1;
    private final Object kzi = new Object();
    int kzj = 0;
    private int kzk = 1;
    private long kzl = 0;
    boolean kzm = false;
    int kzn = 20;
    C1293a kzo = new C276661();
    int mChannels = 1;
    int mSampleRate = v2protocal.VOICE_SAMPLERATE;

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c$1 */
    class C276661 implements C1293a {
        C276661() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            Object obj = null;
            int i2 = -1;
            AppMethodBeat.m2504i(135468);
            synchronized (C27667c.this.kzi) {
                try {
                    if (C27667c.this.kzf == 2) {
                        if (C27667c.this.kza.kzq != null) {
                            obj = 1;
                        }
                        if (obj != null) {
                            int cIq;
                            if (C27667c.this.kzg <= 10) {
                                C27667c.this.kzg = 92;
                            }
                            C6828d b = C27667c.this.kza;
                            if (b.kzq != null) {
                                cIq = b.kzq.cIq();
                            } else {
                                cIq = -1;
                            }
                            C27667c.this.kzg = ((cIq + 24) + (C27667c.this.kzg * 3)) / 4;
                            if (C27667c.this.kzh == 1) {
                                b = C27667c.this.kza;
                                if (b.kzq != null) {
                                    i2 = b.kzq.cIn();
                                }
                                if (i2 >= C27667c.this.kzg) {
                                    i2 -= C27667c.this.kzg;
                                }
                                C27667c.this.kzg = i2;
                                C27667c.this.kzh = 0;
                            } else {
                                C27667c.this.kzg = 0;
                            }
                            if (1 == C27667c.this.kzk) {
                                C27667c.this.kzk = 0;
                                C27667c.this.kzl = System.currentTimeMillis();
                                C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                long h = currentTimeMillis - C27667c.this.kzl;
                                if (h > 1000) {
                                    C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(h)));
                                }
                                C27667c.this.kzl = currentTimeMillis;
                            }
                            C33836j c33836j = C33836j.kzW;
                            C33836j.m55382t(bArr, bArr.length, C27667c.this.kzg);
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(135468);
                }
            }
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c$2 */
    class C276682 implements C29495b {
        C276682() {
        }

        /* renamed from: N */
        public final int mo45518N(byte[] bArr, int i) {
            AppMethodBeat.m2504i(135469);
            if (C27667c.this.kzf != 2) {
                AppMethodBeat.m2505o(135469);
                return -1;
            }
            C33836j c33836j = C33836j.kzW;
            int P = C33836j.m55343P(bArr, i);
            if (C27667c.this.kzm) {
                AppMethodBeat.m2505o(135469);
                return -10086;
            } else if (P < 0) {
                AppMethodBeat.m2505o(135469);
                return -1;
            } else {
                AppMethodBeat.m2505o(135469);
                return 0;
            }
        }
    }

    public C27667c(C2818e c2818e) {
        AppMethodBeat.m2504i(135470);
        this.kzd = c2818e;
        this.kza = new C6828d();
        AppMethodBeat.m2505o(135470);
    }

    /* renamed from: EL */
    public final boolean mo45517EL() {
        boolean z = true;
        AppMethodBeat.m2504i(135471);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: trigger start play");
        if (this.kzf != 2) {
            C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: not init when start listen!");
        }
        synchronized (this.kzi) {
            try {
                if (this.kzb.mo4592EL()) {
                    C4990ab.m7410d("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.kzj);
                    AppMethodBeat.m2505o(135471);
                } else {
                    if (this.kzb.cpq != 13) {
                        this.kzj = 1;
                    }
                    z = false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135471);
            }
        }
        return z;
    }
}
