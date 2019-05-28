package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends m {
    public h(String str, String str2, String str3, Profession profession, String str4) {
        AppMethodBeat.i(46652);
        ab.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s, nationality: %s", str, str2, str3, str4);
        HashMap hashMap = new HashMap();
        if (!bo.isNullOrNil(str)) {
            hashMap.put("user_country", str);
        }
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("user_province", str2);
        }
        if (!bo.isNullOrNil(str3)) {
            hashMap.put("user_city", str3);
        }
        if (profession != null) {
            ab.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", profession.tvN, Integer.valueOf(profession.tvO));
            hashMap.put("profession_name", profession.tvN);
            hashMap.put("profession_type", String.valueOf(profession.tvO));
        }
        if (!bo.isNullOrNil(str4)) {
            hashMap.put("nationality", str4);
        }
        M(hashMap);
        AppMethodBeat.o(46652);
    }

    public final int bgI() {
        return 1978;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46653);
        ab.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", Integer.valueOf(i), str);
        AppMethodBeat.o(46653);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
    }

    public final int ZU() {
        return 1978;
    }
}
