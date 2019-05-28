package com.tencent.mm.plugin.wallet_core.c;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends m {
    public d() {
        AppMethodBeat.i(46498);
        r.cPM().bSd.hY("WalletBulletin", "delete from WalletBulletin");
        M(new HashMap());
        AppMethodBeat.o(46498);
    }

    public final int bgI() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    public final int ZU() {
        return 1679;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46499);
        ab.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            u.aC(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            ab.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=".concat(String.valueOf(optLong)));
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    k cPt = k.cPt();
                    if (optJSONArray != null) {
                        ab.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        cPt.tzo = optJSONArray;
                        g.RQ();
                        g.RP().Ry().set(a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, optJSONArray.toString());
                    }
                }
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_LBS_REPORT_DIALOG_TITLE_STRING_SYNC, optJSONObject.optString("title"));
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_LBS_REPORT_DIALOG_CONTENT_STRING_SYNC, optJSONObject.optString(b.CONTENT));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("title");
                Object optString2 = optJSONObject.optString("balance_title");
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, optString);
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, optString2);
            }
        }
        AppMethodBeat.o(46499);
    }
}
