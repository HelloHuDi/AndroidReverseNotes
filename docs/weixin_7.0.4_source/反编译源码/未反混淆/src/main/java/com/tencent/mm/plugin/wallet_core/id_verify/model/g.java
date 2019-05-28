package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends m {
    public int tup;
    public int tuq;
    public Profession[] tvM = null;

    public g() {
        AppMethodBeat.i(46650);
        HashMap hashMap = new HashMap();
        if (!bo.isNullOrNil(null)) {
            hashMap.put("scene", null);
        }
        M(hashMap);
        AppMethodBeat.o(46650);
    }

    public final int bgI() {
        return 1976;
    }

    public final int ZU() {
        return 1976;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.i(46651);
        ab.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", Integer.valueOf(i), str);
        ab.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", jSONObject.toString());
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
                    if (bo.isNullOrNil(optString)) {
                        ab.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
                    } else {
                        this.tvM[i2] = new Profession(optString, optInt);
                    }
                }
                i2++;
            }
        }
        AppMethodBeat.o(46651);
    }
}
