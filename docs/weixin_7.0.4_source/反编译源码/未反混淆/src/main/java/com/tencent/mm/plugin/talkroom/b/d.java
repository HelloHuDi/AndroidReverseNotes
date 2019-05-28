package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends f {
    public int actionType;
    private final b ehh;
    private f ehi;
    private final String nNq;
    private int sceneType = 0;
    public int syE;

    public d(int i, long j, int i2, String str, int i3) {
        AppMethodBeat.i(25879);
        this.sceneType = i3;
        a aVar = new a();
        aVar.fsJ = new cgh();
        aVar.fsK = new cgi();
        aVar.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        aVar.fsI = 334;
        aVar.fsL = 146;
        aVar.fsM = 1000000146;
        this.ehh = aVar.acD();
        cgh cgh = (cgh) this.ehh.fsG.fsP;
        cgh.wem = i;
        cgh.wen = j;
        cgh.wkB = i2;
        cgh.vEr = (int) bo.anT();
        this.actionType = i2;
        this.nNq = str;
        cgh.Scene = i3;
        AppMethodBeat.o(25879);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25880);
        ab.d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25880);
        return a;
    }

    public final int getType() {
        return 334;
    }

    public final String cED() {
        return this.nNq;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25881);
        ab.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.syE = ((cgi) this.ehh.fsH.fsP).weo;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25881);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25881);
    }

    public final int cEE() {
        return this.sceneType;
    }
}
