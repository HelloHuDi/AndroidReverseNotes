package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C33244g;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.m */
public final class C43776m extends C5749m {
    private Map<String, String> oYG = new HashMap();
    public String token = null;

    public C43776m(Authen authen, boolean z, int i) {
        AppMethodBeat.m2504i(46193);
        this.oYG.put("flag", authen.bJt);
        if (!C5046bo.isNullOrNil(authen.twl)) {
            this.oYG.put("first_name", authen.twl);
            this.oYG.put("last_name", authen.twm);
            this.oYG.put(UserDataStore.COUNTRY, authen.country);
            this.oYG.put("area", authen.duc);
            this.oYG.put("city", authen.dud);
            this.oYG.put("address", authen.fBg);
            this.oYG.put("phone_number", authen.nuN);
            this.oYG.put("zip_code", authen.gIO);
            this.oYG.put(Scopes.EMAIL, authen.dtV);
        }
        this.oYG.put("business_source", String.valueOf(i));
        this.oYG.put("bank_type", authen.pbn);
        if (authen.twf > 0) {
            this.oYG.put("cre_type", authen.twf);
        }
        if (!C5046bo.isNullOrNil(authen.twd)) {
            this.oYG.put("true_name", authen.twd);
        }
        if (!C5046bo.isNullOrNil(authen.twe)) {
            this.oYG.put("identify_card", authen.twe);
        }
        this.oYG.put("mobile_no", authen.tuk);
        this.oYG.put("bank_card_id", authen.twg);
        if (!C5046bo.isNullOrNil(authen.twh)) {
            this.oYG.put("cvv2", authen.twh);
        }
        if (!C5046bo.isNullOrNil(authen.twi)) {
            this.oYG.put("valid_thru", authen.twi);
        }
        this.oYG.put("new_card_reset_pwd", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(46193);
    }

    public final boolean bXl() {
        AppMethodBeat.m2504i(46194);
        super.bXl();
        this.oYG.put("is_repeat_send", "1");
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(46194);
        return true;
    }

    public final int bgI() {
        return 10;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46195);
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.m2505o(46195);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return C33244g.CTRL_INDEX;
    }
}
