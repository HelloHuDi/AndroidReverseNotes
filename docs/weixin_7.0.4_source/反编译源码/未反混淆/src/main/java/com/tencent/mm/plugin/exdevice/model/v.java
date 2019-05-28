package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends m implements k {
    public b ehh = null;
    private f ehi = null;

    public v(String str, String str2, String str3) {
        AppMethodBeat.i(19344);
        a aVar = new a();
        aVar.fsJ = new bvt();
        aVar.fsK = new bvu();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        aVar.fsI = 1270;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bvt bvt = (bvt) this.ehh.fsG.fsP;
        bvt.vLi = new asq();
        bvt.vLi.vIk = str;
        bvt.vLi.jBE = str2;
        bvt.wWE = str3;
        AppMethodBeat.o(19344);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19345);
        ab.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19345);
    }

    public final int getType() {
        return 1270;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19346);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19346);
        return a;
    }
}
