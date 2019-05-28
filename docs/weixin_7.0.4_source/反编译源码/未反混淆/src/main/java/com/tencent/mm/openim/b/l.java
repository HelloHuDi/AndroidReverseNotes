package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends m implements k {
    private final b ehh;
    private f ehi;
    public j.b gfe;
    private int opType;

    public l(j.b bVar) {
        AppMethodBeat.i(1008);
        a aVar = new a();
        aVar.fsJ = new bgt();
        aVar.fsK = new bgu();
        aVar.uri = "/cgi-bin/micromsg-bin/openimoplog";
        this.ehh = aVar.acD();
        this.opType = bVar.oqP;
        this.gfe = bVar;
        ab.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", Integer.valueOf(this.opType));
        bgt bgt = (bgt) this.ehh.fsG.fsP;
        bgt.type = this.opType;
        bgt.wKq = new com.tencent.mm.bt.b(bVar.getBuffer());
        AppMethodBeat.o(1008);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(1009);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(1009);
        return a;
    }

    public final int getType() {
        return 806;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(1010);
        ab.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.opType));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(1010);
    }
}
