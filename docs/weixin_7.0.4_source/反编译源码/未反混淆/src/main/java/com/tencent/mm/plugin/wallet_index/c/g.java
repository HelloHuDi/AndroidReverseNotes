package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bin;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.e;

public class g extends u implements i {
    public b ehh;
    private f ehi;

    public g(PayReq payReq, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(48187);
        a aVar = new a();
        aVar.fsJ = new bin();
        aVar.fsK = new bio();
        aVar.uri = getUri();
        aVar.fsI = getType();
        aVar.fsO = e.atB(payReq.prepayId);
        this.ehh = aVar.acD();
        bin bin = (bin) this.ehh.fsG.fsP;
        bin.fKh = payReq.appId;
        bin.wLU = payReq.partnerId;
        bin.wlb = payReq.prepayId;
        bin.vYO = payReq.nonceStr;
        bin.wLV = payReq.timeStamp;
        bin.vYP = payReq.packageValue;
        bin.vYQ = payReq.sign;
        bin.vYR = payReq.signType;
        bin.wLW = str;
        bin.mZu = str2;
        bin.ncH = str3;
        bin.vRP = k.cPy();
        bin.wLY = str4;
        AppMethodBeat.o(48187);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(48188);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48188);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48189);
        ab.d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(48189);
    }

    public int getType() {
        return 397;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/payauthapp";
    }
}
