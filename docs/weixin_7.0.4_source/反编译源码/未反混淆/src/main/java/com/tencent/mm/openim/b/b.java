package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    public String geZ;

    public b(String str, String str2) {
        AppMethodBeat.i(78836);
        a aVar = new a();
        aVar.fsJ = new cq();
        aVar.fsK = new cr();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimcontact";
        this.ehh = aVar.acD();
        this.geZ = str;
        cq cqVar = (cq) this.ehh.fsG.fsP;
        cqVar.geZ = str;
        cqVar.vEP = str2;
        ab.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", str, str2);
        AppMethodBeat.o(78836);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78837);
        ab.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78837);
    }

    public final int getType() {
        return 667;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78838);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78838);
        return a;
    }
}
