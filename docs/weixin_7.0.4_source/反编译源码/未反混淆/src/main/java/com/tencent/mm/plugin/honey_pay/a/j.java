package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class j extends p {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    public bdb nqH;

    public j(bkc bkc, String str) {
        AppMethodBeat.i(41735);
        a aVar = new a();
        aVar.fsJ = new bda();
        aVar.fsK = new bdb();
        aVar.fsI = 2941;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bda bda = (bda) this.ehh.fsG.fsP;
        bda.wxt = bkc;
        bda.wpp = str;
        ab.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", str, bkc.wNl, bkc.pbn);
        AppMethodBeat.o(41735);
    }

    public final int getType() {
        return 2941;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41736);
        ab.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqH = (bdb) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqH.kdT), this.nqH.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41736);
    }

    public final void f(q qVar) {
        bdb bdb = (bdb) ((b) qVar).fsH.fsP;
        this.AfC = bdb.kdT;
        this.AfD = bdb.kdU;
    }
}
