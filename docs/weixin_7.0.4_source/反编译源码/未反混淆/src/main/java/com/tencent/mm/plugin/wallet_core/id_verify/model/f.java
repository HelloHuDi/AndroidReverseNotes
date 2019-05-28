package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m {
    public String tvH;
    public String tvI;
    public String tvJ;
    public String tvK;
    public String tvL;

    public f(String str) {
        AppMethodBeat.i(46648);
        HashMap hashMap = new HashMap();
        hashMap.put("channel", "1");
        M(hashMap);
        this.tvL = str;
        AppMethodBeat.o(46648);
    }

    public final int bgI() {
        return 1630;
    }

    public final int ZU() {
        return 1630;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46649);
        if (i == 0 && jSONObject != null) {
            this.tvH = jSONObject.optString("guide_flag");
            this.tvI = jSONObject.optString("guide_wording");
            this.tvJ = jSONObject.optString("left_button_wording");
            this.tvK = jSONObject.optString("right_button_wording");
        }
        AppMethodBeat.o(46649);
    }
}
