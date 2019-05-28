package com.tencent.p177mm.plugin.voiceprint.model;

import android.os.Looper;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.p230g.p231a.C42067ud;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.o */
public final class C22452o {
    public C9742k sLw;
    public C7564ap sLx;
    int sLy;
    int sLz;

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.o$1 */
    class C224511 implements C5015a {
        C224511() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26117);
            C22452o.this.sLy += 100;
            C22452o.this.sLz += (C22452o.this.sLw.getMaxAmplitude() * 100) / 100;
            if (C22452o.this.sLy >= AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) {
                C22452o c22452o = C22452o.this;
                C4990ab.m7410d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
                c22452o.sLw.mo5464EB();
                c22452o.sLx.stopTimer();
                c22452o.sLz /= 30;
                C4990ab.m7411d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", Integer.valueOf(c22452o.sLz), Boolean.valueOf(c22452o.sLz >= 30));
                C42067ud c42067ud = new C42067ud();
                c42067ud.cQm.cQn = r0;
                C4879a.xxA.mo10055m(c42067ud);
                AppMethodBeat.m2505o(26117);
                return false;
            }
            AppMethodBeat.m2505o(26117);
            return true;
        }
    }

    public C22452o() {
        AppMethodBeat.m2504i(26118);
        this.sLw = null;
        this.sLx = null;
        this.sLy = 0;
        this.sLz = 0;
        this.sLw = new C9742k();
        this.sLx = new C7564ap(Looper.getMainLooper(), new C224511(), true);
        AppMethodBeat.m2505o(26118);
    }

    private void stopRecord() {
        AppMethodBeat.m2504i(26119);
        this.sLw.mo5464EB();
        C4990ab.m7410d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        AppMethodBeat.m2505o(26119);
    }

    public final void cHP() {
        AppMethodBeat.m2504i(26120);
        C4990ab.m7410d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        reset();
        if (this.sLw.mo5467el(C22449m.m34137by("voice_pt_voice_print_noise_detect.rec", true))) {
            C4990ab.m7410d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            this.sLw.mo5464EB();
            reset();
            C4990ab.m7410d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        this.sLx.mo16770ae(100, 100);
        AppMethodBeat.m2505o(26120);
    }

    public final void reset() {
        AppMethodBeat.m2504i(26121);
        stopRecord();
        this.sLx.stopTimer();
        this.sLy = 0;
        this.sLz = 0;
        AppMethodBeat.m2505o(26121);
    }
}
