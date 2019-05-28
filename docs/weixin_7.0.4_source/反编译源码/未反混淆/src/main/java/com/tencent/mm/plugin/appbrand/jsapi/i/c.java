package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 615;
    public static final String NAME = "checkNetworkAPIURL";

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(108020);
        if (jSONObject == null) {
            cVar.M(i, j("fail:data nil", null));
            ab.w("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
            AppMethodBeat.o(108020);
            return;
        }
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString(ProviderConstants.API_PATH, "");
        String optString2 = jSONObject.optString("url", "");
        if (bo.isNullOrNil(optString) || bo.isNullOrNil(optString2)) {
            ab.w("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", optString, optString2);
            hashMap.put("isValid", Boolean.FALSE);
            cVar.M(i, j("fail:api or url invalid", hashMap));
            AppMethodBeat.o(108020);
            return;
        }
        boolean b;
        int i2;
        com.tencent.mm.plugin.appbrand.l.a aVar = (com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
        if (optString.equalsIgnoreCase(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
            b = j.b(aVar.bQF, optString2, false);
        } else if (optString.equalsIgnoreCase("websocket")) {
            b = j.b(aVar.bQG, optString2, aVar.bQB);
        } else if (optString.equalsIgnoreCase("downloadFile")) {
            b = j.b(aVar.bQI, optString2, false);
        } else if (optString.equalsIgnoreCase("uploadFile")) {
            b = j.b(aVar.bQH, optString2, false);
        } else if (optString.equalsIgnoreCase("udp")) {
            b = j.b(aVar.bQJ, optString2, false);
        } else {
            hashMap.put("isValid", Boolean.FALSE);
            cVar.M(i, j("fail:unknow api", hashMap));
            AppMethodBeat.o(108020);
            return;
        }
        String str = (String) j.CP(optString2).get("host");
        if (bo.isNullOrNil(str)) {
            i2 = 0;
        } else {
            ab.i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", str);
            i2 = j.CR(str);
        }
        ab.i("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", Boolean.valueOf(b), Integer.valueOf(i2), optString, optString2);
        if (b) {
            hashMap.put("isInDomainList", Boolean.TRUE);
        } else {
            hashMap.put("isInDomainList", Boolean.FALSE);
        }
        switch (i2) {
            case 0:
                hashMap.put("isInLAN", Boolean.FALSE);
                hashMap.put("isLocalHost", Boolean.FALSE);
                break;
            case 1:
                hashMap.put("isInLAN", Boolean.TRUE);
                hashMap.put("isLocalHost", Boolean.TRUE);
                break;
            case 2:
                hashMap.put("isInLAN", Boolean.TRUE);
                hashMap.put("isLocalHost", Boolean.FALSE);
                break;
        }
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(108020);
    }
}
