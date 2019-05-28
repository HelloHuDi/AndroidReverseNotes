package com.tencent.p177mm.plugin.appbrand.jsapi.p1226o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.d */
public class C42555d extends C10296a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(73181);
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("value");
        C4990ab.m7417i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(73181);
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            C4990ab.m7412e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(73181);
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(c2241c.getAppId())) {
                C4990ab.m7412e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                c2241c.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(73181);
                return;
            }
            C4990ab.m7417i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", c2241c.getAppId());
            int i2 = 0;
            if (C5023at.isConnected(c2241c.getContext())) {
                if (C5023at.isWifi(c2241c.getContext())) {
                    i2 = 1;
                } else if (C5023at.is4G(c2241c.getContext())) {
                    i2 = 4;
                } else if (C5023at.is3G(c2241c.getContext())) {
                    i2 = 3;
                } else if (C5023at.is2G(c2241c.getContext())) {
                    i2 = 2;
                }
                C4990ab.m7417i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i2));
            }
            long anT = C5046bo.anT();
            C4990ab.m7411d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(anT), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2);
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(C5046bo.nullAsNil(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                str6 = URLEncoder.encode(optString, "UTF-8");
                str7 = URLEncoder.encode(optString2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
            }
            C7060h.pYm.mo8381e(13579, r12, Integer.valueOf(i2), str4, str5, str, str6, str7, Long.valueOf(anT), Long.valueOf(anT));
            c2241c.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(73181);
        }
    }
}
