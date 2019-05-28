package com.tencent.p177mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.protocal.protobuf.ama;
import com.tencent.p177mm.protocal.protobuf.amb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.recharge.model.e */
public final class C12956e extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String pFP;
    public ArrayList<MallRechargeProduct> pGb = null;
    public String pGc;
    public String pGd;
    public String pGe;
    public String pGf;

    public C12956e(String str) {
        AppMethodBeat.m2504i(44199);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ama();
        c1196a.fsK = new amb();
        c1196a.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        c1196a.fsI = C19486m.CTRL_INDEX;
        c1196a.fsL = 228;
        c1196a.fsM = 1000000228;
        this.ehh = c1196a.acD();
        ama ama = (ama) this.ehh.fsG.fsP;
        this.pFP = str;
        ama.wjV = str;
        AppMethodBeat.m2505o(44199);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44200);
        C4990ab.m7410d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            amb amb = (amb) ((C7472b) c1929q).fsH.fsP;
            String str2 = amb.wpG;
            C4990ab.m7410d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(str2)));
            if (!C5046bo.isNullOrNil(str2)) {
                try {
                    this.pGb = C43421b.m77504a(this.pFP, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!C5046bo.isNullOrNil(amb.wrf)) {
                try {
                    JSONObject jSONObject = new JSONObject(amb.wrf);
                    this.pGc = jSONObject.optString("balance_link");
                    this.pGe = jSONObject.optString("recharge_link");
                    this.pGd = jSONObject.optString("balance_wording");
                    this.pGf = jSONObject.optString("recharge_wording");
                } catch (JSONException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(44200);
    }

    public final int getType() {
        return C19486m.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44201);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44201);
        return a;
    }
}
