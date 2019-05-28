package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ab extends aa {
    public ab(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(42389);
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
        M(hashMap);
        AppMethodBeat.o(42389);
    }

    public ab(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(42390);
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
        M(hashMap);
        AppMethodBeat.o(42390);
    }

    public final int bgG() {
        return 2;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
