package com.tencent.p177mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C27084e;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.cfp;
import com.tencent.p177mm.protocal.protobuf.cfq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p649c.C44426i;

/* renamed from: com.tencent.mm.plugin.recharge.model.g */
public final class C39571g extends C36378u implements C44426i {
    private C7472b ehh;
    private C1202f ehi;
    public String mAppId;
    public PayInfo pGr;

    public C39571g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.pFP, mallRechargeProduct.cwg, str);
    }

    public C39571g(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(44205);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cfp();
        c1196a.fsK = new cfq();
        c1196a.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        c1196a.fsI = C27084e.CTRL_INDEX;
        c1196a.fsL = 230;
        c1196a.fsM = 1000000230;
        this.ehh = c1196a.acD();
        cfp cfp = (cfp) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", str4);
        this.mAppId = str;
        cfp.wjW = str;
        cfp.wjV = str2;
        cfp.wpE = str3;
        cfp.wjX = str4;
        cfp.wdB = C40113c.cQT().acH(str2);
        AppMethodBeat.m2505o(44205);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        Object str2;
        AppMethodBeat.m2504i(44206);
        this.pGr = new PayInfo();
        cfq cfq = (cfq) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + cfq.vHD);
            this.pGr.appId = this.mAppId;
            this.pGr.tRb = cfq.wlc;
            this.pGr.czZ = cfq.vHD;
        }
        if (i2 == 0) {
            i2 = cfq.wjY;
        }
        if (C5046bo.isNullOrNil(str2)) {
            str2 = cfq.wjZ;
        }
        this.pGr.vwg = String.valueOf(i2);
        this.pGr.aIm = str2 != null ? String.valueOf(str2) : "";
        C4990ab.m7410d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str2);
        this.ehi.onSceneEnd(i, i2, str2, this);
        AppMethodBeat.m2505o(44206);
    }

    public final int getType() {
        return C27084e.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44207);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44207);
        return a;
    }
}
