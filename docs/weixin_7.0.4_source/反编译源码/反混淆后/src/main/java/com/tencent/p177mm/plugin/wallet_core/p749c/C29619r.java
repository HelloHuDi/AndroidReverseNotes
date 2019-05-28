package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.r */
public final class C29619r extends C5749m {
    private int scene;
    public String token;
    public String tuh;

    public C29619r(String str, int i, String str2) {
        AppMethodBeat.m2504i(46532);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        if (i == 6) {
            hashMap.put("time_stamp", System.currentTimeMillis());
        }
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        if (C36379x.dNS()) {
            hashMap.put("uuid_for_bindcard", C36379x.dNU());
            hashMap.put("bindcard_scene", C36379x.dNT());
        }
        mo70328ba(hashMap);
        this.scene = i;
        AppMethodBeat.m2505o(46532);
    }

    public final int bgI() {
        return 18;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46533);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (this.scene == 6 || this.scene == 8 || this.scene == 18) {
            this.token = jSONObject.optString("usertoken");
            this.tuh = jSONObject.optString("token_type");
        }
        AppMethodBeat.m2505o(46533);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return JsApiOpenAdCanvas.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
    }
}
