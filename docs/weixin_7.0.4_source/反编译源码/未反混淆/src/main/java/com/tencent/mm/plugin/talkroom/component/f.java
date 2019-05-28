package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.talkroom.component.d.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends a {
    private c coZ;
    private c.a cqd = new c.a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(25713);
            ab.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(i)));
            if (i <= 0) {
                ab.e("MicroMsg.MicRecoder", "pcm data too low");
                AppMethodBeat.o(25713);
                return;
            }
            f.a(f.this, bArr, i);
            int Send = f.this.sxg.Send(bArr, (short) i);
            if (Send < 0) {
                ab.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(Send)));
                AppMethodBeat.o(25713);
                return;
            }
            AppMethodBeat.o(25713);
        }

        public final void bN(int i, int i2) {
        }
    };
    private v2engine sxg;
    private short sxh;
    private short sxi;

    public f(v2engine v2engine) {
        AppMethodBeat.i(25714);
        this.sxg = v2engine;
        AppMethodBeat.o(25714);
    }

    public final void cEd() {
        AppMethodBeat.i(25715);
        if (this.coZ != null) {
            this.coZ.EB();
            this.coZ = null;
        }
        AppMethodBeat.o(25715);
    }

    public final void akw() {
        AppMethodBeat.i(25716);
        this.coZ = new c(com.tencent.mm.plugin.talkroom.model.a.sxv, 1, 2);
        this.coZ.v(8, false);
        this.coZ.cpM = this.cqd;
        this.coZ.gG(20);
        this.coZ.EL();
        this.sxi = (short) 0;
        this.sxh = (short) 0;
        AppMethodBeat.o(25716);
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
        AppMethodBeat.i(25717);
        cEd();
        AppMethodBeat.o(25717);
    }

    static /* synthetic */ void a(f fVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > fVar.sxh) {
                fVar.sxh = s;
            }
        }
    }
}
