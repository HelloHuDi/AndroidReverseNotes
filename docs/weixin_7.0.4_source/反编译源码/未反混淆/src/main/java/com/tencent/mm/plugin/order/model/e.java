package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends m {
    public int kCd;
    private int nYh;
    public List<i> pcP = null;
    public List<d> pcQ = null;
    public String pcR;

    public e(int i, String str) {
        AppMethodBeat.i(43773);
        HashMap hashMap = new HashMap();
        hashMap.put("Limit", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
        hashMap.put("Offset", String.valueOf(i));
        hashMap.put("Extbuf", str);
        M(hashMap);
        AppMethodBeat.o(43773);
    }

    public final int bgI() {
        return 105;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.i(43774);
        ab.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i + " errMsg: " + str);
        this.pcP = new LinkedList();
        try {
            this.kCd = jSONObject.getInt("TotalNum");
            this.nYh = jSONObject.getInt("RecNum");
            this.pcR = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i iVar = new i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    iVar.pdc = jSONObject2.optInt("PayType");
                    iVar.pcU = jSONObject2.optString("Transid");
                    iVar.pcV = jSONObject2.optDouble("TotalFee");
                    iVar.pcW = jSONObject2.optString("GoodsName");
                    iVar.pcX = jSONObject2.optInt("CreateTime");
                    iVar.pcZ = jSONObject2.optInt("ModifyTime");
                    iVar.pda = jSONObject2.optString("FeeType");
                    iVar.pdf = jSONObject2.optString("AppThumbUrl");
                    iVar.pcY = jSONObject2.optString("TradeStateName");
                    iVar.pdk = jSONObject2.optString("StatusColor");
                    iVar.pdl = jSONObject2.optString("FeeColor");
                    iVar.pdm = jSONObject2.optDouble("ActualPayFee");
                    iVar.pdn = jSONObject2.optString("BillId");
                    this.pcP.add(iVar);
                }
            }
            this.pcQ = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    d dVar = new d();
                    dVar.year = jSONObject3.optInt("year");
                    dVar.month = jSONObject3.optInt("month");
                    dVar.pcO = jSONObject3.optString("feetext");
                    this.pcQ.add(dVar);
                    i2++;
                }
            }
            AppMethodBeat.o(43774);
        } catch (JSONException e) {
            ab.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e.getLocalizedMessage());
            AppMethodBeat.o(43774);
        }
    }
}
