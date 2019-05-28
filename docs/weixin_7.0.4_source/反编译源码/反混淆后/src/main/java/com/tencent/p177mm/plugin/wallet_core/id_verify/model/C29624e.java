package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.e */
public final class C29624e extends C5749m {
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

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46647);
        C4990ab.m7416i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.tvB = jSONObject.optString("agreed_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.title = jSONObject.optString("title", "");
            this.tvC = jSONObject.optString("service_protocol_wording", "");
            this.tvD = jSONObject.optString("service_protocol_url", "");
            this.tvE = jSONObject.optString("button_wording", "");
            this.tvG = jSONObject.optLong("delay_expired_time", 0);
            if (this.tvG > 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.tvG * 1000)));
            }
        }
        AppMethodBeat.m2505o(46647);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1614;
    }
}
