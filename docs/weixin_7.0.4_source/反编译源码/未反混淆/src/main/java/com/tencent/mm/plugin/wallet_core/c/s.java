package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends m {
    public String tui;
    public int tuj;
    public String tuk;
    public String tul;

    public s(String str, String str2) {
        AppMethodBeat.i(46534);
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        hashMap.put("use_touch", "1");
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("soter_req", str2);
        ba(hashMap);
        AppMethodBeat.o(46534);
    }

    public s(String str, String str2, byte b) {
        AppMethodBeat.i(46535);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        M(hashMap);
        ba(new HashMap());
        AppMethodBeat.o(46535);
    }

    public s(String str, String str2, char c) {
        AppMethodBeat.i(46536);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        M(hashMap);
        ba(new HashMap());
        AppMethodBeat.o(46536);
    }

    public final int bgI() {
        return 100;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46537);
        ab.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i + " errMsg: " + str);
        this.tui = jSONObject.optString("usertoken");
        this.tuj = jSONObject.optInt("is_free_sms");
        this.tuk = jSONObject.optString("mobile_no");
        this.tul = jSONObject.optString("relation_key");
        AppMethodBeat.o(46537);
    }

    public final boolean cOT() {
        return this.tuj == 0;
    }

    public final int ZU() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
