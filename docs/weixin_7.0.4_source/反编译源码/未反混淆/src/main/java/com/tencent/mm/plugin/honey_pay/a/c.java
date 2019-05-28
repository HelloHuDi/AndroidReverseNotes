package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class c extends p {
    private final String TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    public us nqz;

    public c(String str, long j, String str2, String str3, int i, String str4) {
        AppMethodBeat.i(41721);
        a aVar = new a();
        aVar.fsJ = new ur();
        aVar.fsK = new us();
        aVar.fsI = 2662;
        aVar.uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ur urVar = (ur) this.ehh.fsG.fsP;
        urVar.wcg = str;
        urVar.wch = j;
        urVar.vYh = str2;
        urVar.vYl = str3;
        urVar.iAd = i;
        urVar.nSd = str4;
        ab.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", str, str3, str4);
        ab.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", str2, Long.valueOf(j));
        AppMethodBeat.o(41721);
    }

    public final int getType() {
        return 2662;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41722);
        ab.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqz = (us) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqz.kdT), this.nqz.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41722);
    }

    public final void f(q qVar) {
        us usVar = (us) ((b) qVar).fsH.fsP;
        this.AfC = usVar.kdT;
        this.AfD = usVar.kdU;
    }
}
