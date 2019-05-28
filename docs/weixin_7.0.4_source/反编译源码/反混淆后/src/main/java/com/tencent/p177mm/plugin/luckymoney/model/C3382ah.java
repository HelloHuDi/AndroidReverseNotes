package com.tencent.p177mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ah */
public final class C3382ah extends C34442ak {
    public String kCI;

    public C3382ah(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.m2504i(42403);
        HashMap hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(C5046bo.nullAsNil(str)));
        hashMap.put(C8741b.CURRENCY, String.valueOf(i3));
        if (!C5046bo.isNullOrNil(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
        }
        hashMap.put("nickName", URLEncoder.encode(C5046bo.nullAsNil(str4)));
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("username", URLEncoder.encode(str2));
        }
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42403);
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

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42404);
        C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=".concat(String.valueOf(i)));
        if (i == 0) {
            this.kCI = jSONObject.optString("payUrl");
        }
        AppMethodBeat.m2505o(42404);
    }
}
