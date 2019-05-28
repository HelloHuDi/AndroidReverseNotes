package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ab */
public final class C39317ab extends C34440aa {
    public C39317ab(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(42389);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("timeStamp", str2);
        hashMap.put("nonceStr", str3);
        if (str4 != null) {
            hashMap.put("package", URLEncoder.encode(str4));
        }
        hashMap.put("signType", str5);
        if (str6 != null) {
            hashMap.put("paySign", URLEncoder.encode(str6));
        }
        hashMap.put("way", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (str7 != null) {
            hashMap.put("jsapiH5Url", URLEncoder.encode(str7));
        }
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42389);
    }

    public C39317ab(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.m2504i(42390);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("timeStamp", str2);
        hashMap.put("nonceStr", str3);
        if (str4 != null) {
            hashMap.put("package", URLEncoder.encode(str4));
        }
        hashMap.put("signType", str5);
        if (str6 != null) {
            hashMap.put("paySign", URLEncoder.encode(str6));
        }
        hashMap.put("way", "4");
        if (str7 != null) {
            hashMap.put("androidSign", URLEncoder.encode(str7));
        }
        if (str8 != null) {
            hashMap.put("androidPackage", URLEncoder.encode(str8));
        }
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42390);
    }

    public final int bgG() {
        return 2;
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
    }
}
