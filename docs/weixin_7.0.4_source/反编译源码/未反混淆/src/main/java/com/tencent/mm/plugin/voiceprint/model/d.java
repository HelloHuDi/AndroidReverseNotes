package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    private final b ehh;
    private f ehi;
    String sKW = "";
    int sKX = 0;
    String sKY = "";

    public d(int i, String str) {
        AppMethodBeat.i(26078);
        a aVar = new a();
        aVar.fsJ = new apz();
        aVar.fsK = new aqa();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.fsI = 611;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        apz apz = (apz) this.ehh.fsG.fsP;
        ab.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", Integer.valueOf(i), str);
        apz.wub = i;
        apz.wuc = str;
        AppMethodBeat.o(26078);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26079);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(26079);
        return a;
    }

    public final int getType() {
        return 611;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26080);
        ab.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aqa aqa = (aqa) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            if (aqa.wud != null) {
                this.sKW = new String(aqa.wud.wVc.getBufferToBytes());
                this.sKX = aqa.wud.wTu;
                ab.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", Integer.valueOf(this.sKX), this.sKW);
            } else {
                ab.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26080);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26080);
    }
}
