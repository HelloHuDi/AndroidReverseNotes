package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class s extends m implements k {
    private f eIc = null;
    private String lst = null;
    private b ltG = null;

    public s(String str, String str2, String str3, int i) {
        AppMethodBeat.i(19335);
        a aVar = new a();
        aVar.fsJ = new asx();
        aVar.fsK = new asy();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ltG = aVar.acD();
        asx asx = (asx) this.ltG.fsG.fsP;
        asx.vKe = com.tencent.mm.bt.b.akB(str2);
        asx.vKc = com.tencent.mm.bt.b.akB(str3);
        asx.nbk = i;
        this.lst = str;
        AppMethodBeat.o(19335);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19336);
        ab.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        ad.boW().Kv(this.lst);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + ((asy) this.ltG.fsH.fsP).getBaseResponse().Ret + ",msg=" + str);
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19336);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19337);
        this.eIc = fVar;
        int a = a(eVar, this.ltG, this);
        AppMethodBeat.o(19337);
        return a;
    }
}
