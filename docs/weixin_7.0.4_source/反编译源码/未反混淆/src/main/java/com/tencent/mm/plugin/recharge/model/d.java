package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends m implements k {
    public b ehh;
    private f ehi;
    public int fmR;
    public String gyD;
    public String pFP;
    public String pFQ = null;
    public MallRechargeProduct pFY = null;
    public List<MallRechargeProduct> pFZ = null;
    public String pGa;

    public d(int i, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(44196);
        this.pFP = str;
        this.fmR = i;
        this.gyD = str5;
        this.pGa = str2;
        a aVar = new a();
        aVar.fsJ = new akd();
        aVar.fsK = new ake();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX;
        aVar.fsL = 229;
        aVar.fsM = 1000000229;
        this.ehh = aVar.acD();
        akd akd = (akd) this.ehh.fsG.fsP;
        akd.wjV = str;
        akd.wjW = str3;
        akd.wpE = str2;
        akd.wjX = str4;
        akd.wdB = c.cQT().acH(str);
        ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
        AppMethodBeat.o(44196);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44197);
        ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        ake ake = (ake) ((b) qVar).fsH.fsP;
        ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + ake.wka);
        String str2 = ake.wka;
        this.pFQ = "";
        if (!bo.isNullOrNil(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.pFQ += " ";
                        } else {
                            obj = null;
                        }
                        this.pFQ += split3[1];
                    }
                }
            }
        }
        if (!bo.isNullOrNil(ake.wpG)) {
            try {
                this.pFZ = b.a(this.pFP, new JSONObject(ake.wpG).optJSONArray("product_info"));
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = ake.wpF;
            ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(str2)));
            if (!bo.isNullOrNil(str2)) {
                try {
                    this.pFY = b.e(this.pFP, new JSONObject(str2));
                    this.pFY.pFQ = this.pFQ;
                } catch (JSONException e2) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        ab.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(ake.wjY), ake.wjZ, Integer.valueOf(ake.wkb), ake.wkc}));
        if (i3 == 0) {
            if (ake.wkb != 0) {
                i3 = ake.wkb;
            } else {
                i3 = ake.wjY;
            }
        }
        if (bo.isNullOrNil(str)) {
            if (bo.isNullOrNil(ake.wkc)) {
                str = ake.wjZ;
            } else {
                str = ake.wkc;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(44197);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44198);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44198);
        return a;
    }
}
