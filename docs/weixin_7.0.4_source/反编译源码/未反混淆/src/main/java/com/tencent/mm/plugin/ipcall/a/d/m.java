package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class m extends com.tencent.mm.ai.m implements k {
    private b ehh = null;
    private f ehi;
    private bxb nyE = null;
    public bxc nyF = null;

    public m(int i, int i2, LinkedList<cru> linkedList) {
        AppMethodBeat.i(21872);
        a aVar = new a();
        aVar.fsJ = new bxb();
        aVar.fsK = new bxc();
        aVar.fsI = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyE = (bxb) this.ehh.fsG.fsP;
        this.nyE.wGh = i2;
        this.nyE.wXk = linkedList;
        this.nyE.wXj = linkedList.size();
        this.nyE.wXl = i;
        ab.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(21872);
    }

    public final int getType() {
        return 871;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21873);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21873);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21874);
        ab.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyF = (bxc) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21874);
    }
}
