package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class a extends u {
    private b ehh;
    private f ehi;
    public String jumpUrl;
    public String prepayId;
    public String tRb;
    public String tRo;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        AppMethodBeat.i(48212);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bjb();
        aVar.fsK = new bjc();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        this.ehh = aVar.acD();
        bjb bjb = (bjb) this.ehh.fsG.fsP;
        bjb.fKh = str;
        bjb.vYP = str4;
        bjb.vYO = str2;
        bjb.vYQ = str5;
        bjb.vYR = str6;
        bjb.vLo = str3;
        bjb.vXP = str7;
        bjb.wla = str8;
        bjb.vAM = i;
        ab.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
        AppMethodBeat.o(48212);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48213);
        ab.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        bjc bjc = (bjc) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(bjc.luT), bjc.luU);
            str = bjc.luU;
            i2 = bjc.luT;
            this.jumpUrl = bjc.mZj;
            this.prepayId = bjc.wlb;
            this.tRb = bjc.wlc;
            this.tRo = bjc.wMr;
        } else {
            ab.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (bo.isNullOrNil(str)) {
            str = ah.getContext().getString(R.string.fdx);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(48213);
    }

    public final int getType() {
        return 1563;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48214);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48214);
        return a;
    }
}
