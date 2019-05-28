package com.tencent.p177mm.plugin.wallet_payu.create.p1317a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.create.a.a */
public final class C36854a extends C36383a {
    public String cEW;
    public String pin;
    public String tTb;
    public String tTc;
    public String tTd;
    public String tTe;
    public String tTf;

    public C36854a(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(48369);
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
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48369);
    }

    public final int cOX() {
        return 5;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48370);
        C4990ab.m7411d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48370);
    }
}
