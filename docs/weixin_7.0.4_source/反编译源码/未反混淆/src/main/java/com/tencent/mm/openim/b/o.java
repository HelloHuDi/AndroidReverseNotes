package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    private final b ehh;
    private f ehi;
    private String geZ;

    public o(String str, String str2, String str3) {
        AppMethodBeat.i(78875);
        this.geZ = str;
        a aVar = new a();
        aVar.fsJ = new bwn();
        aVar.fsK = new bwo();
        aVar.uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
        this.ehh = aVar.acD();
        bwn bwn = (bwn) this.ehh.fsG.fsP;
        bwn.geZ = str;
        bwn.wWZ = str2;
        bwn.vEP = str3;
        ab.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", str, str3);
        AppMethodBeat.o(78875);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78876);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78876);
        return a;
    }

    public final int getType() {
        return 243;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78877);
        ab.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (!(i2 == 0 && i3 == 0)) {
            ab.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78877);
    }
}
