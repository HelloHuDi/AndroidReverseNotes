package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.h */
public final class C35477h extends C5749m {
    public C35477h(String str, String str2, String str3, Profession profession, String str4) {
        AppMethodBeat.m2504i(46652);
        C4990ab.m7411d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s, nationality: %s", str, str2, str3, str4);
        HashMap hashMap = new HashMap();
        if (!C5046bo.isNullOrNil(str)) {
            hashMap.put("user_country", str);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("user_province", str2);
        }
        if (!C5046bo.isNullOrNil(str3)) {
            hashMap.put("user_city", str3);
        }
        if (profession != null) {
            C4990ab.m7411d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", profession.tvN, Integer.valueOf(profession.tvO));
            hashMap.put("profession_name", profession.tvN);
            hashMap.put("profession_type", String.valueOf(profession.tvO));
        }
        if (!C5046bo.isNullOrNil(str4)) {
            hashMap.put("nationality", str4);
        }
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46652);
    }

    public final int bgI() {
        return 1978;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46653);
        C4990ab.m7417i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(46653);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1978;
    }
}
