package com.tencent.mm.plugin.wallet.pwd.a;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends com.tencent.mm.wallet_core.tenpay.model.m {
    private Map<String, String> oYG = new HashMap();
    public String token = null;

    public m(Authen authen, boolean z, int i) {
        AppMethodBeat.i(46193);
        this.oYG.put("flag", authen.bJt);
        if (!bo.isNullOrNil(authen.twl)) {
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
        if (!bo.isNullOrNil(authen.twd)) {
            this.oYG.put("true_name", authen.twd);
        }
        if (!bo.isNullOrNil(authen.twe)) {
            this.oYG.put("identify_card", authen.twe);
        }
        this.oYG.put("mobile_no", authen.tuk);
        this.oYG.put("bank_card_id", authen.twg);
        if (!bo.isNullOrNil(authen.twh)) {
            this.oYG.put("cvv2", authen.twh);
        }
        if (!bo.isNullOrNil(authen.twi)) {
            this.oYG.put("valid_thru", authen.twi);
        }
        this.oYG.put("new_card_reset_pwd", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        M(this.oYG);
        AppMethodBeat.o(46193);
    }

    public final boolean bXl() {
        AppMethodBeat.i(46194);
        super.bXl();
        this.oYG.put("is_repeat_send", "1");
        M(this.oYG);
        AppMethodBeat.o(46194);
        return true;
    }

    public final int bgI() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46195);
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.o(46195);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    public final int ZU() {
        return g.CTRL_INDEX;
    }
}
