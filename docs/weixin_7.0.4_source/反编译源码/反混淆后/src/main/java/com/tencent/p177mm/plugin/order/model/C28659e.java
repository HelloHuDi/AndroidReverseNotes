package com.tencent.p177mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.order.model.e */
public final class C28659e extends C5749m {
    public int kCd;
    private int nYh;
    public List<C43364i> pcP = null;
    public List<C21421d> pcQ = null;
    public String pcR;

    public C28659e(int i, String str) {
        AppMethodBeat.m2504i(43773);
        HashMap hashMap = new HashMap();
        hashMap.put("Limit", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
        hashMap.put("Offset", String.valueOf(i));
        hashMap.put("Extbuf", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43773);
    }

    public final int bgI() {
        return 105;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.m2504i(43774);
        C4990ab.m7410d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i + " errMsg: " + str);
        this.pcP = new LinkedList();
        try {
            this.kCd = jSONObject.getInt("TotalNum");
            this.nYh = jSONObject.getInt("RecNum");
            this.pcR = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    C43364i c43364i = new C43364i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    c43364i.pdc = jSONObject2.optInt("PayType");
                    c43364i.pcU = jSONObject2.optString("Transid");
                    c43364i.pcV = jSONObject2.optDouble("TotalFee");
                    c43364i.pcW = jSONObject2.optString("GoodsName");
                    c43364i.pcX = jSONObject2.optInt("CreateTime");
                    c43364i.pcZ = jSONObject2.optInt("ModifyTime");
                    c43364i.pda = jSONObject2.optString("FeeType");
                    c43364i.pdf = jSONObject2.optString("AppThumbUrl");
                    c43364i.pcY = jSONObject2.optString("TradeStateName");
                    c43364i.pdk = jSONObject2.optString("StatusColor");
                    c43364i.pdl = jSONObject2.optString("FeeColor");
                    c43364i.pdm = jSONObject2.optDouble("ActualPayFee");
                    c43364i.pdn = jSONObject2.optString("BillId");
                    this.pcP.add(c43364i);
                }
            }
            this.pcQ = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    C21421d c21421d = new C21421d();
                    c21421d.year = jSONObject3.optInt("year");
                    c21421d.month = jSONObject3.optInt("month");
                    c21421d.pcO = jSONObject3.optString("feetext");
                    this.pcQ.add(c21421d);
                    i2++;
                }
            }
            AppMethodBeat.m2505o(43774);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e.getLocalizedMessage());
            AppMethodBeat.m2505o(43774);
        }
    }
}
