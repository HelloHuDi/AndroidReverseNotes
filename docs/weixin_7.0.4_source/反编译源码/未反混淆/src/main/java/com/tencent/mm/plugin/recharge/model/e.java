package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends m implements k {
    private b ehh;
    private f ehi;
    public String pFP;
    public ArrayList<MallRechargeProduct> pGb = null;
    public String pGc;
    public String pGd;
    public String pGe;
    public String pGf;

    public e(String str) {
        AppMethodBeat.i(44199);
        a aVar = new a();
        aVar.fsJ = new ama();
        aVar.fsK = new amb();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
        aVar.fsL = 228;
        aVar.fsM = 1000000228;
        this.ehh = aVar.acD();
        ama ama = (ama) this.ehh.fsG.fsP;
        this.pFP = str;
        ama.wjV = str;
        AppMethodBeat.o(44199);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44200);
        ab.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            amb amb = (amb) ((b) qVar).fsH.fsP;
            String str2 = amb.wpG;
            ab.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(str2)));
            if (!bo.isNullOrNil(str2)) {
                try {
                    this.pGb = b.a(this.pFP, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!bo.isNullOrNil(amb.wrf)) {
                try {
                    JSONObject jSONObject = new JSONObject(amb.wrf);
                    this.pGc = jSONObject.optString("balance_link");
                    this.pGe = jSONObject.optString("recharge_link");
                    this.pGd = jSONObject.optString("balance_wording");
                    this.pGf = jSONObject.optString("recharge_wording");
                } catch (JSONException e2) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(44200);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(44201);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44201);
        return a;
    }
}
