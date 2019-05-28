package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.audio.p195b.C45162a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.modelvoice.k */
public final class C9742k implements C45162a {
    private static int fZW = 100;
    private int coK = 0;
    public C1292c coZ;
    C1293a cpM = new C97411();
    private C41768d fZX;
    private String mFileName = null;
    public int mStatus = 0;

    /* renamed from: com.tencent.mm.modelvoice.k$1 */
    class C97411 implements C1293a {
        C97411() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(116589);
            if (C9742k.this.fZX != null) {
                C9742k.this.fZX.mo43823a(new C32305a(bArr, i), 0, false);
            }
            C9742k.m17376a(C9742k.this, bArr, i);
            AppMethodBeat.m2505o(116589);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    public C9742k() {
        AppMethodBeat.m2504i(116590);
        AppMethodBeat.m2505o(116590);
    }

    /* renamed from: el */
    public final boolean mo5467el(String str) {
        AppMethodBeat.m2504i(116591);
        if (C5046bo.isNullOrNil(this.mFileName)) {
            C4990ab.m7417i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", str);
            this.mStatus = 1;
            this.coK = 0;
            this.coZ = new C1292c(TXRecordCommon.AUDIO_SAMPLERATE_16000, 1, 0);
            this.coZ.cpB = -19;
            if (C1427q.etn.erW > 0) {
                this.coZ.mo4599v(C1427q.etn.erW, true);
            } else {
                this.coZ.mo4599v(5, false);
            }
            this.coZ.mo4595bq(false);
            this.coZ.cpM = this.cpM;
            this.fZX = new C41768d();
            if (!this.fZX.mo43824eo(str)) {
                C4990ab.m7412e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                AppMethodBeat.m2505o(116591);
                return false;
            } else if (this.coZ.mo4592EL()) {
                this.mFileName = str;
                AppMethodBeat.m2505o(116591);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                AppMethodBeat.m2505o(116591);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        AppMethodBeat.m2505o(116591);
        return false;
    }

    /* renamed from: a */
    public final void mo5466a(C37445a c37445a) {
    }

    /* renamed from: EB */
    public final boolean mo5464EB() {
        AppMethodBeat.m2504i(116592);
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        AppMethodBeat.m2505o(116592);
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        AppMethodBeat.m2504i(116593);
        if (this.coZ != null) {
            this.coZ.mo4590EB();
            this.coZ = null;
        }
        if (this.fZX != null) {
            this.fZX.mo43820Fe();
            this.fZX = null;
        }
        AppMethodBeat.m2505o(116593);
    }

    public final int getMaxAmplitude() {
        int i = this.coK;
        this.coK = 0;
        if (i > fZW) {
            fZW = i;
        }
        return (i * 100) / fZW;
    }

    /* renamed from: EC */
    public final int mo5465EC() {
        return this.coZ.cpR;
    }

    /* renamed from: a */
    static /* synthetic */ void m17376a(C9742k c9742k, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > c9742k.coK) {
                c9742k.coK = s;
            }
        }
    }
}
