package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class a extends m implements k {
    public String ceI;
    public String cws;
    private f ehi;
    private b fAT;

    public a(String str, String str2) {
        AppMethodBeat.i(26372);
        this.ceI = str;
        this.cws = str2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA;
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.fsJ = new asv();
        aVar.fsK = new asw();
        this.fAT = aVar.acD();
        asv asv = (asv) this.fAT.fsG.fsP;
        asv.vKc = new com.tencent.mm.bt.b(str.getBytes());
        asv.vKe = new com.tencent.mm.bt.b(str2.getBytes());
        asv.wwF = new com.tencent.mm.bt.b("5".getBytes());
        AppMethodBeat.o(26372);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26373);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(26373);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26374);
        ab.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26374);
    }
}
