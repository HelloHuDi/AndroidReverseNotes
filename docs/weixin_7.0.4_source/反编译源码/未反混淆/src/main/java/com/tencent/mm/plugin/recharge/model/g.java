package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.storage.e;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.u;

public final class g extends u implements i {
    private b ehh;
    private f ehi;
    public String mAppId;
    public PayInfo pGr;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.pFP, mallRechargeProduct.cwg, str);
    }

    public g(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(44205);
        a aVar = new a();
        aVar.fsJ = new cfp();
        aVar.fsK = new cfq();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.fsI = e.CTRL_INDEX;
        aVar.fsL = 230;
        aVar.fsM = 1000000230;
        this.ehh = aVar.acD();
        cfp cfp = (cfp) this.ehh.fsG.fsP;
        ab.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", str4);
        this.mAppId = str;
        cfp.wjW = str;
        cfp.wjV = str2;
        cfp.wpE = str3;
        cfp.wjX = str4;
        cfp.wdB = c.cQT().acH(str2);
        AppMethodBeat.o(44205);
    }

    public final void e(int i, int i2, String str, q qVar) {
        Object str2;
        AppMethodBeat.i(44206);
        this.pGr = new PayInfo();
        cfq cfq = (cfq) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + cfq.vHD);
            this.pGr.appId = this.mAppId;
            this.pGr.tRb = cfq.wlc;
            this.pGr.czZ = cfq.vHD;
        }
        if (i2 == 0) {
            i2 = cfq.wjY;
        }
        if (bo.isNullOrNil(str2)) {
            str2 = cfq.wjZ;
        }
        this.pGr.vwg = String.valueOf(i2);
        this.pGr.aIm = str2 != null ? String.valueOf(str2) : "";
        ab.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str2);
        this.ehi.onSceneEnd(i, i2, str2, this);
        AppMethodBeat.o(44206);
    }

    public final int getType() {
        return e.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(44207);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44207);
        return a;
    }
}
