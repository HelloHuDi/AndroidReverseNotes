package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    public String cva;
    public long cvc;
    public int cvd;
    private f ehi;
    private b gme;
    public pa kCf;
    public long kCg;
    private long kCh;

    public i(int i, com.tencent.mm.bt.b bVar, String str, int i2, long j) {
        AppMethodBeat.i(40967);
        a aVar = new a();
        aVar.fsJ = new oz();
        aVar.fsK = new pa();
        aVar.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        oz ozVar = (oz) this.gme.fsG.fsP;
        ozVar.nUf = i;
        ozVar.vWi = 0;
        ozVar.kCK = str;
        ozVar.vWg = null;
        ozVar.vWh = bVar;
        this.cva = str;
        this.cvd = i2;
        this.cvc = j;
        this.kCh = System.currentTimeMillis();
        ab.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i), str);
        AppMethodBeat.o(40967);
    }

    public final int getType() {
        return 1384;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40968);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40968);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40969);
        ab.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.kCf = (pa) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.kCf.kCl), this.kCf.kCm, Integer.valueOf(this.kCf.vWi));
        this.kCg = System.currentTimeMillis() - this.kCh;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40969);
    }
}
