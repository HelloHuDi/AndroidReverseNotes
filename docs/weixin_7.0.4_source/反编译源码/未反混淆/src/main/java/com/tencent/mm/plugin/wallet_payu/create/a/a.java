package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String cEW;
    public String pin;
    public String tTb;
    public String tTc;
    public String tTd;
    public String tTe;
    public String tTf;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(48369);
        this.tTb = str;
        this.tTc = str2;
        this.pin = str3;
        this.tTe = str4;
        this.tTd = str4;
        this.tTf = str6;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", String.valueOf(str2));
        hashMap.put("pin", String.valueOf(str3));
        hashMap.put("secret_question_id", String.valueOf(str4));
        hashMap.put("secret_question_answer", String.valueOf(str5));
        hashMap.put("payu_reference", str6);
        M(hashMap);
        AppMethodBeat.o(48369);
    }

    public final int cOX() {
        return 5;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48370);
        ab.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48370);
    }
}
