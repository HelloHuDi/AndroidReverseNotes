package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private b ehh;
    private f ehi;
    public String jsonString;

    public c(String str, String str2, String str3) {
        AppMethodBeat.i(37661);
        a aVar = new a();
        aVar.fsJ = new ajf();
        aVar.fsK = new ajg();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        this.ehh = aVar.acD();
        ajf ajf = (ajf) this.ehh.fsG.fsP;
        ajf.fKh = str;
        ajf.wpc = str2;
        ajf.wpd = str3;
        ab.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
        AppMethodBeat.o(37661);
    }

    public c(String str) {
        AppMethodBeat.i(37662);
        a aVar = new a();
        aVar.fsJ = new bex();
        aVar.fsK = new bey();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
        this.ehh = aVar.acD();
        ((bex) this.ehh.fsG.fsP).wIS = str;
        ab.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(str)));
        AppMethodBeat.o(37662);
    }

    public final int getType() {
        return this.ehh.fsI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(37663);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(37663);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(37664);
        ab.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str + " sceneType: " + this.ehh.fsI);
        if (this.ehh.fsI == 1337) {
            this.jsonString = ((ajg) ((b) qVar).fsH.fsP).wlX;
        } else if (this.ehh.fsI == 2721) {
            this.jsonString = ((bey) ((b) qVar).fsH.fsP).wIT;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(37664);
    }
}
