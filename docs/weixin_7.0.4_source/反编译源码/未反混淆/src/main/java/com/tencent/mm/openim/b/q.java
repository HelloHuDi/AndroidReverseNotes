package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends m implements k {
    private final b ehh;
    private f ehi;
    public String geZ;
    public String gfi;
    public String gfj;

    public q(String str, String str2) {
        AppMethodBeat.i(78881);
        a aVar = new a();
        aVar.fsJ = new cmv();
        aVar.fsK = new cmw();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
        this.ehh = aVar.acD();
        this.geZ = str;
        this.gfi = str2;
        cmv cmv = (cmv) this.ehh.fsG.fsP;
        cmv.geZ = str;
        cmv.gfi = str2;
        ab.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", str, str2);
        AppMethodBeat.o(78881);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(78882);
        ab.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geZ);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78882);
    }

    public final int getType() {
        return 853;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78883);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78883);
        return a;
    }
}
