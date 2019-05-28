package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    private int sceneType;

    public b(int i, long j, String str, int i2) {
        AppMethodBeat.i(25872);
        this.sceneType = i2;
        a aVar = new a();
        aVar.fsJ = new yw();
        aVar.fsK = new yx();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        this.ehh = aVar.acD();
        yw ywVar = (yw) this.ehh.fsG.fsP;
        ywVar.wel = str;
        ywVar.wem = i;
        ywVar.wen = j;
        ywVar.Scene = i2;
        AppMethodBeat.o(25872);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25873);
        ab.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25873);
        return a;
    }

    public final int getType() {
        return 333;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25874);
        ab.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25874);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25874);
    }
}
