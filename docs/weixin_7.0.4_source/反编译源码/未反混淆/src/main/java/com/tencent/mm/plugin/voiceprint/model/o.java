package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class o {
    public k sLw;
    public ap sLx;
    int sLy;
    int sLz;

    public o() {
        AppMethodBeat.i(26118);
        this.sLw = null;
        this.sLx = null;
        this.sLy = 0;
        this.sLz = 0;
        this.sLw = new k();
        this.sLx = new ap(Looper.getMainLooper(), new a() {
            public final boolean BI() {
                AppMethodBeat.i(26117);
                o.this.sLy += 100;
                o.this.sLz += (o.this.sLw.getMaxAmplitude() * 100) / 100;
                if (o.this.sLy >= AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) {
                    o oVar = o.this;
                    ab.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
                    oVar.sLw.EB();
                    oVar.sLx.stopTimer();
                    oVar.sLz /= 30;
                    ab.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", Integer.valueOf(oVar.sLz), Boolean.valueOf(oVar.sLz >= 30));
                    ud udVar = new ud();
                    udVar.cQm.cQn = r0;
                    com.tencent.mm.sdk.b.a.xxA.m(udVar);
                    AppMethodBeat.o(26117);
                    return false;
                }
                AppMethodBeat.o(26117);
                return true;
            }
        }, true);
        AppMethodBeat.o(26118);
    }

    private void stopRecord() {
        AppMethodBeat.i(26119);
        this.sLw.EB();
        ab.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        AppMethodBeat.o(26119);
    }

    public final void cHP() {
        AppMethodBeat.i(26120);
        ab.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        reset();
        if (this.sLw.el(m.by("voice_pt_voice_print_noise_detect.rec", true))) {
            ab.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            this.sLw.EB();
            reset();
            ab.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        this.sLx.ae(100, 100);
        AppMethodBeat.o(26120);
    }

    public final void reset() {
        AppMethodBeat.i(26121);
        stopRecord();
        this.sLx.stopTimer();
        this.sLy = 0;
        this.sLz = 0;
        AppMethodBeat.o(26121);
    }
}
