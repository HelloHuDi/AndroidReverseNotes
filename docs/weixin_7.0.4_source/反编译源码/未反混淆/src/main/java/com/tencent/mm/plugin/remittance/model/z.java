package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class z extends a {
    public int kCv = 0;
    public String pPf = "";
    public int pPl;
    public String pQA = "";
    public int pQB;

    public z(double d, String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.i(44792);
        ab.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", Math.round(100.0d * d));
            hashMap.put("pay_nickname", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            hashMap.put("rcvd_username", String.valueOf(str2));
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, ProtocolPackage.ServerEncoding));
            hashMap.put("reason", URLEncoder.encode(bo.bc(str4, ""), ProtocolPackage.ServerEncoding));
            hashMap.put(b.CURRENCY, String.valueOf(i));
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneTenpayh5Pay", "error " + e.getMessage());
        }
        M(hashMap);
        AppMethodBeat.o(44792);
    }

    public final int bgG() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44793);
        ab.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            ab.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            AppMethodBeat.o(44793);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.pPf = jSONObject.optString("payurl");
        this.pQA = jSONObject.optString("tradeurl");
        this.pPl = jSONObject.optInt("transfering_num");
        this.pQB = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.pPf);
        stringBuffer.append(" tradeurl:" + this.pQA);
        stringBuffer.append(" transfering_num:" + this.pPl);
        stringBuffer.append(" transfering_type:" + this.pQB);
        ab.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
        AppMethodBeat.o(44793);
    }

    public final int getType() {
        return 1622;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
