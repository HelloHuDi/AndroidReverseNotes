package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class e extends p {
    private final String TAG = "MicroMsg.NetSceneBeforeTransfer";
    public px pOI;

    public e(String str) {
        AppMethodBeat.i(44727);
        a aVar = new a();
        aVar.fsJ = new pw();
        aVar.fsK = new px();
        aVar.fsI = 2783;
        aVar.uri = "/cgi-bin/mmpay-bin/beforetransfer";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        pw pwVar = (pw) this.ehh.fsG.fsP;
        pwVar.vFf = str;
        if (!f.dlH()) {
            pwVar.vWV = f.dlI();
        }
        ab.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", str);
        AppMethodBeat.o(44727);
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44728);
        ab.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pOI = (px) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOI.kCl), this.pOI.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44728);
    }

    public final void f(q qVar) {
        px pxVar = (px) ((b) qVar).fsH.fsP;
        this.AfC = pxVar.kCl;
        this.AfD = pxVar.kCm;
    }

    public final int getType() {
        return 2783;
    }
}
