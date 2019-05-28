package com.tencent.p177mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.plugin.talkroom.component.C22380d.C4199a;
import com.tencent.p177mm.plugin.talkroom.model.C43682a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.talkroom.component.f */
public final class C22384f extends C4199a {
    private C1292c coZ;
    private C1293a cqd = new C223851();
    private v2engine sxg;
    private short sxh;
    private short sxi;

    /* renamed from: com.tencent.mm.plugin.talkroom.component.f$1 */
    class C223851 implements C1293a {
        C223851() {
        }

        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(25713);
            C4990ab.m7410d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(i)));
            if (i <= 0) {
                C4990ab.m7412e("MicroMsg.MicRecoder", "pcm data too low");
                AppMethodBeat.m2505o(25713);
                return;
            }
            C22384f.m34103a(C22384f.this, bArr, i);
            int Send = C22384f.this.sxg.Send(bArr, (short) i);
            if (Send < 0) {
                C4990ab.m7412e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(Send)));
                AppMethodBeat.m2505o(25713);
                return;
            }
            AppMethodBeat.m2505o(25713);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    public C22384f(v2engine v2engine) {
        AppMethodBeat.m2504i(25714);
        this.sxg = v2engine;
        AppMethodBeat.m2505o(25714);
    }

    public final void cEd() {
        AppMethodBeat.m2504i(25715);
        if (this.coZ != null) {
            this.coZ.mo4590EB();
            this.coZ = null;
        }
        AppMethodBeat.m2505o(25715);
    }

    public final void akw() {
        AppMethodBeat.m2504i(25716);
        this.coZ = new C1292c(C43682a.sxv, 1, 2);
        this.coZ.mo4599v(8, false);
        this.coZ.cpM = this.cqd;
        this.coZ.mo4598gG(20);
        this.coZ.mo4592EL();
        this.sxi = (short) 0;
        this.sxh = (short) 0;
        AppMethodBeat.m2505o(25716);
    }

    public final int cEe() {
        if (this.sxi < this.sxh) {
            this.sxi = this.sxh;
        }
        if (this.sxi == (short) 0) {
            return 0;
        }
        short s = (short) ((this.sxh * 100) / this.sxi);
        this.sxh = (short) 0;
        return s;
    }

    public final void start() {
    }

    public final void release() {
        AppMethodBeat.m2504i(25717);
        cEd();
        AppMethodBeat.m2505o(25717);
    }

    /* renamed from: a */
    static /* synthetic */ void m34103a(C22384f c22384f, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > c22384f.sxh) {
                c22384f.sxh = s;
            }
        }
    }
}
