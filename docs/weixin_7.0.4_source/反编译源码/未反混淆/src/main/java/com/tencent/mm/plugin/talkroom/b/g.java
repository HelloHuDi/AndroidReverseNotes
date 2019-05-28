package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g extends m implements k {
    private final b ehh;
    private f ehi;

    public g(LinkedList<cgn> linkedList, int i) {
        AppMethodBeat.i(25885);
        a aVar = new a();
        aVar.fsJ = new cgo();
        aVar.fsK = new cgp();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX;
        this.ehh = aVar.acD();
        cgo cgo = (cgo) this.ehh.fsG.fsP;
        cgo.xfv = linkedList.size();
        cgo.xfw = linkedList;
        cgo.Scene = i;
        AppMethodBeat.o(25885);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25886);
        ab.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(25886);
        return a;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25887);
        ab.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(25887);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25887);
    }
}
