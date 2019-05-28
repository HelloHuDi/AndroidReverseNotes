package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class y extends a {
    public int kCv = 0;
    public String kCx;
    public String kCy;
    public String pQy = "";
    public String pQz = "";

    public y(int i) {
        AppMethodBeat.i(44790);
        ab.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(44790);
    }

    public final int bgG() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44791);
        ab.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            ab.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            AppMethodBeat.o(44791);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.kCv = jSONObject.optInt(b.CURRENCY);
        this.pQy = jSONObject.optString("currencyUint");
        this.pQz = jSONObject.optString("currencyWording");
        this.kCx = jSONObject.optString("notice");
        this.kCy = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.kCv);
        stringBuffer.append(" currencyuint:" + this.pQy);
        stringBuffer.append(" currencywording:" + this.pQz);
        stringBuffer.append(" notice:" + this.kCx);
        stringBuffer.append(" notice_url:" + this.kCy);
        ab.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
        AppMethodBeat.o(44791);
    }

    public final int getType() {
        return 1574;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
