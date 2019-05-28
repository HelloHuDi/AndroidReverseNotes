package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends m {
    public String cFl = "";
    public String oYi = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String oYj = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private boolean oYk = false;

    public i(Bankcard bankcard, String str, String str2, int i, String str3) {
        AppMethodBeat.i(43397);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("oper", str2);
        if (str2.equals("changeto")) {
            if (TextUtils.isEmpty(str3)) {
                hashMap.put("verify_code", "");
            } else {
                hashMap.put("verify_code", str3);
            }
            hashMap.put("chg_fee", String.valueOf(i));
            hashMap.put("bind_serialno", bankcard.field_bindSerial);
            hashMap.put("bank_type", bankcard.field_bankcardType);
            hashMap.put("card_tail", bankcard.field_bankcardTail);
        }
        this.cFl = bankcard.field_mobile;
        M(hashMap);
        AppMethodBeat.o(43397);
    }

    public final int bgI() {
        return 50;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43398);
        if (jSONObject != null) {
            this.oYi = jSONObject.optString("verify_flag");
            this.oYj = jSONObject.optString("limit_fee");
        }
        AppMethodBeat.o(43398);
    }
}
