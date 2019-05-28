package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.d.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;

public final class k implements a {
    private static int fZW = 100;
    private int coK = 0;
    public c coZ;
    c.a cpM = new c.a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(116589);
            if (k.this.fZX != null) {
                k.this.fZX.a(new g.a(bArr, i), 0, false);
            }
            k.a(k.this, bArr, i);
            AppMethodBeat.o(116589);
        }

        public final void bN(int i, int i2) {
        }
    };
    private d fZX;
    private String mFileName = null;
    public int mStatus = 0;

    public k() {
        AppMethodBeat.i(116590);
        AppMethodBeat.o(116590);
    }

    public final boolean el(String str) {
        AppMethodBeat.i(116591);
        if (bo.isNullOrNil(this.mFileName)) {
            ab.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", str);
            this.mStatus = 1;
            this.coK = 0;
            this.coZ = new c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 0);
            this.coZ.cpB = -19;
            if (q.etn.erW > 0) {
                this.coZ.v(q.etn.erW, true);
            } else {
                this.coZ.v(5, false);
            }
            this.coZ.bq(false);
            this.coZ.cpM = this.cpM;
            this.fZX = new d();
            if (!this.fZX.eo(str)) {
                ab.e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                AppMethodBeat.o(116591);
                return false;
            } else if (this.coZ.EL()) {
                this.mFileName = str;
                AppMethodBeat.o(116591);
                return true;
            } else {
                ab.e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                AppMethodBeat.o(116591);
                return false;
            }
        }
        ab.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        AppMethodBeat.o(116591);
        return false;
    }

    public final void a(j.a aVar) {
    }

    public final boolean EB() {
        AppMethodBeat.i(116592);
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        AppMethodBeat.o(116592);
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        AppMethodBeat.i(116593);
        if (this.coZ != null) {
            this.coZ.EB();
            this.coZ = null;
        }
        if (this.fZX != null) {
            this.fZX.Fe();
            this.fZX = null;
        }
        AppMethodBeat.o(116593);
    }

    public final int getMaxAmplitude() {
        int i = this.coK;
        this.coK = 0;
        if (i > fZW) {
            fZW = i;
        }
        return (i * 100) / fZW;
    }

    public final int EC() {
        return this.coZ.cpR;
    }

    static /* synthetic */ void a(k kVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > kVar.coK) {
                kVar.coK = s;
            }
        }
    }
}
