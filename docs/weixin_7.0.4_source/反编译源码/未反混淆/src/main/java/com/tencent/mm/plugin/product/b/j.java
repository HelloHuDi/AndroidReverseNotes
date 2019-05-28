package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class j extends m implements k {
    private b ehh;
    private f ehi;
    public String pgQ;
    public LinkedList<ze> phb;
    public LinkedList<au> phc;

    public j(LinkedList<btx> linkedList, int i) {
        int i2 = 0;
        AppMethodBeat.i(43994);
        a aVar = new a();
        aVar.fsJ = new bli();
        aVar.fsK = new blj();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        this.ehh = aVar.acD();
        bli bli = (bli) this.ehh.fsG.fsP;
        bli.vRM = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        bli.pdi = i2;
        bli.wOo = i;
        AppMethodBeat.o(43994);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43995);
        blj blj = (blj) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0 && blj.vKp == 0) {
            ab.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + blj.wpD);
            ab.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + blj.vRN);
            this.phb = blj.wOp;
            this.pgQ = blj.vRN;
            this.phc = blj.wOq;
        }
        if (i3 == 0 && blj.vKp != 0) {
            i3 = blj.vKp;
            str = blj.vKq;
        }
        ab.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43995);
    }

    public final int getType() {
        return 554;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43996);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43996);
        return a;
    }
}
