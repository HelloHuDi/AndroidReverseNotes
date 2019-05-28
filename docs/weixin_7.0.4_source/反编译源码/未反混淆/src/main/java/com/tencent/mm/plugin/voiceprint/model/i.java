package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    private final b ehh;
    private f ehi;
    public int mStatus;
    public int sLm;

    public i(int i) {
        AppMethodBeat.i(26101);
        a aVar = new a();
        aVar.fsJ = new cfv();
        aVar.fsK = new cfw();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        aVar.fsI = c.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((cfv) this.ehh.fsG.fsP).cAd = i;
        AppMethodBeat.o(26101);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26102);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(26102);
        return a;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26103);
        ab.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        cfw cfw = (cfw) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = cfw.wPr;
            this.sLm = cfw.xeV;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26103);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26103);
    }
}
