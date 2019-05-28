package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class r extends m {
    private int scene;
    public String token;
    public String tuh;

    public r(String str, int i, String str2) {
        AppMethodBeat.i(46532);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        if (i == 6) {
            hashMap.put("time_stamp", System.currentTimeMillis());
        }
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        if (x.dNS()) {
            hashMap.put("uuid_for_bindcard", x.dNU());
            hashMap.put("bindcard_scene", x.dNT());
        }
        ba(hashMap);
        this.scene = i;
        AppMethodBeat.o(46532);
    }

    public final int bgI() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46533);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (this.scene == 6 || this.scene == 8 || this.scene == 18) {
            this.token = jSONObject.optString("usertoken");
            this.tuh = jSONObject.optString("token_type");
        }
        AppMethodBeat.o(46533);
    }

    public final int ZU() {
        return JsApiOpenAdCanvas.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
    }
}
