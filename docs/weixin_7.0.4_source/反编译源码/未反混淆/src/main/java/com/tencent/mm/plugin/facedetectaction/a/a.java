package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh;
    private f ehi;
    private air mbS;
    public ais mbT;

    public a(int i, String str, String str2) {
        AppMethodBeat.i(670);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new air();
        aVar.fsK = new ais();
        aVar.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.mbS = (air) this.ehh.fsG.fsP;
        this.mbS.scene = i;
        this.mbS.kKO = str;
        this.mbS.woI = str2;
        ab.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", Integer.valueOf(i), str, str2);
        AppMethodBeat.o(670);
    }

    public final int getType() {
        return 2696;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(671);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(671);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(672);
        ab.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.mbT = (ais) ((b) qVar).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(672);
    }
}
