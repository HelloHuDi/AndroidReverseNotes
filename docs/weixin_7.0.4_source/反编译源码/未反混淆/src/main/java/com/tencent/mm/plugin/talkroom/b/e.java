package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends f {
    private final b ehh;
    private f ehi;
    private final String nNq;
    private int sceneType = 0;

    public e(String str, int i, long j, int i2) {
        AppMethodBeat.i(25882);
        this.sceneType = i2;
        a aVar = new a();
        aVar.fsJ = new cgj();
        aVar.fsK = new cgk();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.fsI = 335;
        aVar.fsL = 149;
        aVar.fsM = 1000000149;
        this.ehh = aVar.acD();
        cgj cgj = (cgj) this.ehh.fsG.fsP;
        cgj.wem = i;
        cgj.wen = j;
        cgj.vEr = (int) bo.anT();
        this.nNq = str;
        cgj.Scene = i2;
        AppMethodBeat.o(25882);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(25883);
        ab.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25883);
        return a;
    }

    public final int getType() {
        return 335;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25884);
        ab.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25884);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25884);
    }

    public final String cED() {
        return this.nNq;
    }

    public final int cEE() {
        return this.sceneType;
    }
}
