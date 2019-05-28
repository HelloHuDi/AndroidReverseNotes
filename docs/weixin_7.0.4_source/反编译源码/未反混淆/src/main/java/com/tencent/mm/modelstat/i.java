package com.tencent.mm.modelstat;

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

public final class i extends m implements k {
    private f eIc;
    private final b ehh;

    public i(int i, String str, int i2) {
        AppMethodBeat.i(35583);
        a aVar = new a();
        aVar.fsJ = new bj();
        aVar.fsK = new bk();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        this.ehh = aVar.acD();
        bj bjVar = (bj) this.ehh.fsG.fsP;
        bp bpVar = new bp();
        bpVar.vDS = i;
        bpVar.vDT = new com.tencent.mm.bt.b(str.getBytes());
        bpVar.vDU = (long) i2;
        bjVar.vDC.add(bpVar);
        ab.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", Integer.valueOf(i), str);
        AppMethodBeat.o(35583);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(35584);
        bk bkVar = (bk) this.ehh.fsH.fsP;
        ab.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bkVar.ret), bkVar.bzH);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(35584);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(35585);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(35585);
        return a;
    }
}
