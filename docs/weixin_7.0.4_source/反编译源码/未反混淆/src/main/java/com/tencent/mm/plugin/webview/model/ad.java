package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.platformtools.ab;

public final class ad extends m implements k {
    String appId;
    String czD;
    private f eIc;
    final b ehh;

    public ad(String str, String str2, azh azh) {
        AppMethodBeat.i(6653);
        this.appId = str;
        this.czD = str2;
        a aVar = new a();
        aVar.fsJ = new azm();
        aVar.fsK = new azn();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        this.ehh = aVar.acD();
        azm azm = (azm) this.ehh.fsG.fsP;
        azm.csB = str;
        azm.wDv = azh;
        AppMethodBeat.o(6653);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6654);
        ab.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6654);
    }

    public final int getType() {
        return 1034;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6655);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6655);
        return a;
    }
}
