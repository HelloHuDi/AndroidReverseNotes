package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    private ait mbU;
    public aiu mbV;

    public b(String str, String str2, float f, String str3, String str4, int i, String str5, String str6) {
        AppMethodBeat.i(673);
        a aVar = new a();
        aVar.fsJ = new ait();
        aVar.fsK = new aiu();
        aVar.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.mbU = (ait) this.ehh.fsG.fsP;
        this.mbU.person_id = str;
        this.mbU.woJ = str2;
        this.mbU.woM = (int) f;
        this.mbU.woN = str3;
        this.mbU.woO = str4;
        this.mbU.scene = i;
        this.mbU.vYl = str5;
        this.mbU.kKO = str6;
        this.mbU.woh = ((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).bQO();
        ab.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s", str, str2, Float.valueOf(f), str3, Integer.valueOf(i), str5, str6);
        AppMethodBeat.o(673);
    }

    public final int getType() {
        return 2726;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(674);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(674);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(675);
        ab.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        h.pYm.a(917, i3 == 0 ? 54 : 55, 1, false);
        this.mbV = (aiu) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(675);
    }
}
