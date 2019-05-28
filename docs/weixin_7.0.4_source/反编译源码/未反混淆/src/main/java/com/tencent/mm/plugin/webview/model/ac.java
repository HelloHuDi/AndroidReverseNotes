package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;

public final class ac extends m implements k {
    private f eIc;
    public final b ehh;

    public ac(String str, String str2) {
        AppMethodBeat.i(6650);
        a aVar = new a();
        aVar.fsJ = new cih();
        aVar.fsK = new cii();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        this.ehh = aVar.acD();
        cih cih = (cih) this.ehh.fsG.fsP;
        cih.csB = str;
        cih.vGs = str2;
        AppMethodBeat.o(6650);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6651);
        ab.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6651);
    }

    public final int getType() {
        return 1142;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6652);
        ab.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6652);
        return a;
    }
}
