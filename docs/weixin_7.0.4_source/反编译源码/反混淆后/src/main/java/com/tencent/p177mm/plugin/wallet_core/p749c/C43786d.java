package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14265u;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.d */
public final class C43786d extends C5749m {
    public C43786d() {
        AppMethodBeat.m2504i(46498);
        C14241r.cPM().bSd.mo10108hY("WalletBulletin", "delete from WalletBulletin");
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(46498);
    }

    public final int bgI() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1679;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46499);
        C4990ab.m7416i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            C14265u.m22455aC(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            C4990ab.m7416i("MicroMsg.NetSceneGetBannerInfo", "update_interval=".concat(String.valueOf(optLong)));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    C22594k cPt = C22594k.cPt();
                    if (optJSONArray != null) {
                        C4990ab.m7410d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        cPt.tzo = optJSONArray;
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, optJSONArray.toString());
                    }
                }
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LBS_REPORT_DIALOG_TITLE_STRING_SYNC, optJSONObject.optString("title"));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LBS_REPORT_DIALOG_CONTENT_STRING_SYNC, optJSONObject.optString(C8741b.CONTENT));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("title");
                Object optString2 = optJSONObject.optString("balance_title");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, optString);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, optString2);
            }
        }
        AppMethodBeat.m2505o(46499);
    }
}
