package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.protocal.protobuf.ij;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class j extends m implements k {
    private f ehi;
    LinkedList<bts> fsa = null;
    LinkedList<auk> fsb = null;

    public j(LinkedList<bts> linkedList) {
        this.fsa = linkedList;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(77930);
        if (this.fsa == null || this.fsa.size() <= 0) {
            ab.e("MicroMsg.NetSceneBatchGetHeadImg", g.Mq() + "doScene ReqSize==0");
            AppMethodBeat.o(77930);
            return -1;
        }
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new ii();
        aVar.fsK = new ij();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.fsI = 123;
        aVar.fsL = 15;
        aVar.fsM = 1000000015;
        b acD = aVar.acD();
        ii iiVar = (ii) acD.fsG.fsP;
        iiVar.vEg = this.fsa;
        iiVar.jBv = this.fsa.size();
        int a = a(eVar, acD, this);
        AppMethodBeat.o(77930);
        return a;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 20;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77931);
        ab.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.fsb = ((ij) ((b) qVar).fsH.fsP).vKC;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(77931);
    }

    public final int getType() {
        return 123;
    }
}
