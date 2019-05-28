package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.e;

public class a extends u {
    private b ehh;
    private f ehi;

    public a(String str, int i, int i2) {
        AppMethodBeat.i(45933);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        nd ndVar = new nd();
        ndVar.vHD = str;
        ndVar.vRK = i;
        ndVar.vRL = i2;
        aVar.fsJ = ndVar;
        aVar.fsK = new ne();
        aVar.uri = getUri();
        aVar.fsI = ZU();
        aVar.fsO = e.atB(str);
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", getUri(), str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(45933);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(45934);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(45934);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(45935);
        ab.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", getUri(), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            try {
                ne neVar = (ne) ((b) qVar).fsH.fsP;
                ab.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", Integer.valueOf(neVar.BaseResponse.Ret), neVar.BaseResponse.ErrMsg);
            } catch (Exception e) {
                ab.i("MicroMsg.NetSceneCancelPay", e.getMessage());
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(45935);
    }

    public final int getType() {
        AppMethodBeat.i(138992);
        int ZU = ZU();
        AppMethodBeat.o(138992);
        return ZU;
    }

    public int ZU() {
        return 2823;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
    }
}
