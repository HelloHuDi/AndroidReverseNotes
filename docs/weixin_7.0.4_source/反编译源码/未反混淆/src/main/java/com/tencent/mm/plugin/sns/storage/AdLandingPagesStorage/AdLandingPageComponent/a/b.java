package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public String rdB = "";

    public b(String str) {
        AppMethodBeat.i(37658);
        this.rdB = str;
        a aVar = new a();
        aVar.fsJ = new abb();
        aVar.fsK = new abc();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
        aVar.fsI = 2874;
        this.ehh = aVar.acD();
        ((abb) this.ehh.fsG.fsP).wio = str;
        ab.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", str);
        AppMethodBeat.o(37658);
    }

    public final int getType() {
        return 2874;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(37659);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(37659);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(37660);
        ab.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(37660);
    }
}
