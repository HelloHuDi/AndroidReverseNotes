package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class o extends m implements k {
    private f eIc;
    private final b fpJ;

    public o(LinkedList<cfx> linkedList) {
        AppMethodBeat.i(93730);
        a aVar = new a();
        aVar.fsJ = new ir();
        aVar.fsK = new is();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        this.fpJ = aVar.acD();
        ((ir) this.fpJ.fsG.fsP).vKN = linkedList;
        AppMethodBeat.o(93730);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93731);
        ab.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(93731);
    }

    public final int getType() {
        return 1176;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(93732);
        ab.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.fpJ, this);
        AppMethodBeat.o(93732);
        return a;
    }
}
