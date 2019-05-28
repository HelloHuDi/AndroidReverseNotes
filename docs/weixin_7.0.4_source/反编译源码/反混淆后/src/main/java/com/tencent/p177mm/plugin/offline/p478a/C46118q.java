package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.q */
public final class C46118q extends C5749m {
    public C43353n oYH;
    public C35475y oYI = new C35475y(null, 8);
    public C24144d oYJ;
    public C24144d oYK;

    public C46118q(int i) {
        AppMethodBeat.m2504i(43416);
        this.oYH = new C43353n(System.currentTimeMillis(), i);
        mo70323M(this.oYH.oYG);
        mo70326aZ(this.oYI.oYG);
        mo70328ba(this.oYI.toe);
        AppMethodBeat.m2505o(43416);
    }

    public final int bgI() {
        return 1742;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1742;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43417);
        if (i != 0) {
            AppMethodBeat.m2505o(43417);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("queryuser_resp");
        this.oYJ = C46118q.m86071ab(optJSONObject);
        this.oYH.mo9383a(this.oYJ.errCode, this.oYJ.aIm, optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bindquerynew_resp");
        this.oYK = C46118q.m86071ab(optJSONObject2);
        this.oYI.mo9383a(this.oYK.errCode, this.oYK.aIm, optJSONObject2);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("card_list");
            if (optString != null) {
                C28630a.m45498Uf(optString);
            }
        }
        AppMethodBeat.m2505o(43417);
    }

    /* renamed from: ab */
    private static C24144d m86071ab(JSONObject jSONObject) {
        int i;
        AppMethodBeat.m2504i(43418);
        C24144d c24144d = new C24144d();
        c24144d.aIm = C4996ah.getContext().getString(C25738R.string.fdx);
        String string = C4996ah.getContext().getString(C25738R.string.fdx);
        try {
            i = jSONObject.getInt("retcode");
            string = jSONObject.optString("retmsg");
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + e.toString());
            i = -10089;
        }
        if (i != 0) {
            C4990ab.m7420w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
            if (i != -10089) {
                c24144d.mo39942f(1000, i, string, 2);
            } else {
                c24144d.mo39942f(1000, 2, string, 2);
            }
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
        }
        AppMethodBeat.m2505o(43418);
        return c24144d;
    }

    public static boolean isEnabled() {
        AppMethodBeat.m2504i(43419);
        boolean z = false;
        C5141c ll = C18624c.abi().mo17131ll("100337");
        if (ll.isValid()) {
            Map dru = ll.dru();
            String str = "enabled";
            if (dru.containsKey(str) && "1".equals(dru.get(str))) {
                z = true;
            }
        }
        C4990ab.m7418v("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "isUserBindQueryEnabled: ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(43419);
        return z;
    }
}
