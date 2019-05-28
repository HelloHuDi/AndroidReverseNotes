package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.w */
public final class C35473w extends C5749m {
    public String tuu;

    public C35473w(String str, int i, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(46542);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        hashMap.put("package", URLEncoder.encode(str2));
        hashMap.put("sign", str3);
        hashMap.put("sign_type", str4);
        hashMap.put("busi_id", str5);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46542);
    }

    public C35473w(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        AppMethodBeat.m2504i(46543);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        hashMap.put("package", URLEncoder.encode(str2));
        hashMap.put("sign", str3);
        hashMap.put("sign_type", str4);
        hashMap.put("busi_id", str5);
        hashMap.put("use_touch", String.valueOf(i2));
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("soter_req", str6);
        hashMap.put("fingerData", str7);
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(46543);
    }

    public final int bgI() {
        return 2704;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 2704;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/getpaypwdtoken";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46544);
        this.tuu = jSONObject.optString("usertoken", "");
        AppMethodBeat.m2505o(46544);
    }

    public final boolean cOW() {
        return true;
    }
}
