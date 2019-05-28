package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class l extends m implements k {
    private b ehh;
    public f ehi;
    private LinkedList<bp> qIT;

    public l(LinkedList<bp> linkedList) {
        AppMethodBeat.i(36242);
        a aVar = new a();
        aVar.fsJ = new bj();
        aVar.fsK = new bk();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        this.ehh = aVar.acD();
        ((bj) this.ehh.fsG.fsP).vDC = linkedList;
        this.qIT = linkedList;
        ab.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", Integer.valueOf(r0.vDC.size()));
        AppMethodBeat.o(36242);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36243);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36243);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36244);
        ab.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36244);
    }
}
