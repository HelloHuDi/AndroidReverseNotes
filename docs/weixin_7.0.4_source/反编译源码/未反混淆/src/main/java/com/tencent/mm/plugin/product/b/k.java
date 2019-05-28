package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends m implements com.tencent.mm.network.k {
    private b ehh;
    private f ehi;
    public String phn;

    public k(cad cad) {
        AppMethodBeat.i(43997);
        a aVar = new a();
        aVar.fsJ = new cfl();
        aVar.fsK = new cfm();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        aVar.fsI = JsApiGetLabInfo.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((cfl) this.ehh.fsG.fsP).xeP = cad;
        AppMethodBeat.o(43997);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43998);
        cfm cfm = (cfm) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + cfm.xeQ);
            this.phn = cfm.xeQ;
        }
        ab.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43998);
    }

    public final int getType() {
        return JsApiGetLabInfo.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43999);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43999);
        return a;
    }
}
