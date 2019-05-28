package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    public String cva;
    private b ehh;
    private f ehi;
    public pj kCB;

    public n(int i, com.tencent.mm.bt.b bVar, String str) {
        AppMethodBeat.i(40983);
        a aVar = new a();
        aVar.fsJ = new pi();
        aVar.fsK = new pj();
        aVar.fsI = 1317;
        aVar.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        pi piVar = (pi) this.ehh.fsG.fsP;
        piVar.nUf = i;
        piVar.vWi = 0;
        piVar.kCK = str;
        piVar.vWg = null;
        piVar.vWh = bVar;
        this.cva = str;
        ab.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i), str);
        AppMethodBeat.o(40983);
    }

    public final int getType() {
        return 1317;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40984);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(40984);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40985);
        ab.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.kCB = (pj) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.kCB.kCl), this.kCB.kCm, Integer.valueOf(this.kCB.vWi));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40985);
    }
}
