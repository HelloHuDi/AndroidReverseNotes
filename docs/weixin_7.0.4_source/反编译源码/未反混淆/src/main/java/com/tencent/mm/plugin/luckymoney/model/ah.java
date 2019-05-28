package com.tencent.mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ah extends ak {
    public String kCI;

    public ah(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.i(42403);
        HashMap hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bo.nullAsNil(str)));
        hashMap.put(b.CURRENCY, String.valueOf(i3));
        if (!bo.isNullOrNil(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
        }
        hashMap.put("nickName", URLEncoder.encode(bo.nullAsNil(str4)));
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("username", URLEncoder.encode(str2));
        }
        M(hashMap);
        AppMethodBeat.o(42403);
    }

    public final int getType() {
        return 1647;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5requestwxhb";
    }

    public final int bgG() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42404);
        ab.i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=".concat(String.valueOf(i)));
        if (i == 0) {
            this.kCI = jSONObject.optString("payUrl");
        }
        AppMethodBeat.o(42404);
    }
}
