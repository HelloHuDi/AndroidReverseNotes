package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class w extends m {
    public String tuu;

    public w(String str, int i, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(46542);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        hashMap.put("package", URLEncoder.encode(str2));
        hashMap.put("sign", str3);
        hashMap.put("sign_type", str4);
        hashMap.put("busi_id", str5);
        M(hashMap);
        AppMethodBeat.o(46542);
    }

    public w(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        AppMethodBeat.i(46543);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        hashMap.put("package", URLEncoder.encode(str2));
        hashMap.put("sign", str3);
        hashMap.put("sign_type", str4);
        hashMap.put("busi_id", str5);
        hashMap.put("use_touch", String.valueOf(i2));
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("soter_req", str6);
        hashMap.put("fingerData", str7);
        ba(hashMap);
        AppMethodBeat.o(46543);
    }

    public final int bgI() {
        return 2704;
    }

    public final int ZU() {
        return 2704;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/getpaypwdtoken";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46544);
        this.tuu = jSONObject.optString("usertoken", "");
        AppMethodBeat.o(46544);
    }

    public final boolean cOW() {
        return true;
    }
}
