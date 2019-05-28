package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends m implements k {
    private b ehh;
    private f ehi;
    public boolean lSY = false;
    public boolean lSZ = false;

    public q(int i) {
        AppMethodBeat.i(95);
        a aVar = new a();
        aVar.fsJ = new cft();
        aVar.fsK = new cfu();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopface";
        aVar.fsI = 938;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((cft) this.ehh.fsG.fsP).OpCode = i;
        AppMethodBeat.o(95);
    }

    public final int getType() {
        return 938;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(96);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(96);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(97);
        cfu cfu = (cfu) ((b) qVar).fsH.fsP;
        this.lSY = cfu.xeT;
        this.lSZ = cfu.xeU;
        ab.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.lSY), Boolean.valueOf(this.lSZ));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(97);
    }
}
