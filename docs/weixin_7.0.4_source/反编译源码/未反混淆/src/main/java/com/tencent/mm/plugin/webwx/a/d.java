package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    private f ehi;
    final b fAT;

    public d(String str) {
        AppMethodBeat.i(26500);
        a aVar = new a();
        zm zmVar = new zm();
        zn znVar = new zn();
        aVar.fsJ = zmVar;
        aVar.fsK = znVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        this.fAT = aVar.acD();
        zmVar.weG = str;
        ab.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", str);
        AppMethodBeat.o(26500);
    }

    public final int getType() {
        return 971;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26501);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(26501);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26502);
        ab.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26502);
    }
}
