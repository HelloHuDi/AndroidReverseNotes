package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.c */
public final class C16666c extends C10296a {
    public static final int CTRL_INDEX = 615;
    public static final String NAME = "checkNetworkAPIURL";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(108020);
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data nil", null));
            C4990ab.m7420w("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
            AppMethodBeat.m2505o(108020);
            return;
        }
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString(ProviderConstants.API_PATH, "");
        String optString2 = jSONObject.optString("url", "");
        if (C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7421w("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", optString, optString2);
            hashMap.put("isValid", Boolean.FALSE);
            c2241c.mo6107M(i, mo73394j("fail:api or url invalid", hashMap));
            AppMethodBeat.m2505o(108020);
            return;
        }
        boolean b;
        int i2;
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        if (optString.equalsIgnoreCase(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
            b = C19538j.m30273b(c38414a.bQF, optString2, false);
        } else if (optString.equalsIgnoreCase("websocket")) {
            b = C19538j.m30273b(c38414a.bQG, optString2, c38414a.bQB);
        } else if (optString.equalsIgnoreCase("downloadFile")) {
            b = C19538j.m30273b(c38414a.bQI, optString2, false);
        } else if (optString.equalsIgnoreCase("uploadFile")) {
            b = C19538j.m30273b(c38414a.bQH, optString2, false);
        } else if (optString.equalsIgnoreCase("udp")) {
            b = C19538j.m30273b(c38414a.bQJ, optString2, false);
        } else {
            hashMap.put("isValid", Boolean.FALSE);
            c2241c.mo6107M(i, mo73394j("fail:unknow api", hashMap));
            AppMethodBeat.m2505o(108020);
            return;
        }
        String str = (String) C19538j.m30258CP(optString2).get("host");
        if (C5046bo.isNullOrNil(str)) {
            i2 = 0;
        } else {
            C4990ab.m7417i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", str);
            i2 = C19538j.m30260CR(str);
        }
        C4990ab.m7417i("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", Boolean.valueOf(b), Integer.valueOf(i2), optString, optString2);
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
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(108020);
    }
}
