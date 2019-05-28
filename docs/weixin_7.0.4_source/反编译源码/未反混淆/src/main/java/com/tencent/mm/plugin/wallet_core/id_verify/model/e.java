package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class e extends m {
    public String title;
    public String tvB;
    public String tvC;
    public String tvD;
    public String tvE;
    public int tvF;
    public long tvG;

    public final int bgI() {
        return 1614;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46647);
        ab.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.tvB = jSONObject.optString("agreed_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.title = jSONObject.optString("title", "");
            this.tvC = jSONObject.optString("service_protocol_wording", "");
            this.tvD = jSONObject.optString("service_protocol_url", "");
            this.tvE = jSONObject.optString("button_wording", "");
            this.tvG = jSONObject.optLong("delay_expired_time", 0);
            if (this.tvG > 0) {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.tvG * 1000)));
            }
        }
        AppMethodBeat.o(46647);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    public final int ZU() {
        return 1614;
    }
}
