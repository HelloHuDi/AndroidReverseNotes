package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k extends m implements com.tencent.mm.network.k {
    public b ehh;
    private f ehi;

    public k(String str, LinkedList<azo> linkedList) {
        AppMethodBeat.i(13855);
        a aVar = new a();
        aVar.fsJ = new azr();
        aVar.fsK = new azs();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        this.ehh = aVar.acD();
        azr azr = (azr) this.ehh.fsG.fsP;
        azr.wxX = str;
        azr.wDy = linkedList;
        AppMethodBeat.o(13855);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13856);
        ab.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(13856);
    }

    public final int getType() {
        return 1030;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13857);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13857);
        return a;
    }
}
