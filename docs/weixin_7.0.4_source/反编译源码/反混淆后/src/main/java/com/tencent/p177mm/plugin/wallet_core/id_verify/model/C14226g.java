package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.g */
public final class C14226g extends C5749m {
    public int tup;
    public int tuq;
    public Profession[] tvM = null;

    public C14226g() {
        AppMethodBeat.m2504i(46650);
        HashMap hashMap = new HashMap();
        if (!C5046bo.isNullOrNil(null)) {
            hashMap.put("scene", null);
        }
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46650);
    }

    public final int bgI() {
        return 1976;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1976;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.m2504i(46651);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", Integer.valueOf(i), str);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", jSONObject.toString());
        this.tup = jSONObject.optInt("need_area");
        this.tuq = jSONObject.optInt("need_profession");
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        if (optJSONArray != null) {
            this.tvM = new Profession[optJSONArray.length()];
            while (i2 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("profession_name");
                    int optInt = optJSONObject.optInt("profession_type");
                    if (C5046bo.isNullOrNil(optString)) {
                        C4990ab.m7416i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
                    } else {
                        this.tvM[i2] = new Profession(optString, optInt);
                    }
                }
                i2++;
            }
        }
        AppMethodBeat.m2505o(46651);
    }
}
