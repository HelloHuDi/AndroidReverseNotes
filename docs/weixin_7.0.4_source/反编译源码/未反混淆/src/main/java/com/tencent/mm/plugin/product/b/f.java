package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class f extends m implements k {
    private b ehh;
    private com.tencent.mm.ai.f ehi;

    public f(LinkedList<btx> linkedList, String str) {
        int i = 0;
        AppMethodBeat.i(43982);
        a aVar = new a();
        aVar.fsJ = new nf();
        aVar.fsK = new ng();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        this.ehh = aVar.acD();
        nf nfVar = (nf) this.ehh.fsG.fsP;
        nfVar.vRM = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        nfVar.pdi = i;
        nfVar.vRN = str;
        ab.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId ".concat(String.valueOf(str)));
        AppMethodBeat.o(43982);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43983);
        ng ngVar = (ng) ((b) qVar).fsH.fsP;
        if (i3 == 0 && ngVar.vKp != 0) {
            i3 = ngVar.vKp;
            str = ngVar.vKq;
        }
        ab.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43983);
    }

    public final int getType() {
        return 555;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(43984);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43984);
        return a;
    }
}
