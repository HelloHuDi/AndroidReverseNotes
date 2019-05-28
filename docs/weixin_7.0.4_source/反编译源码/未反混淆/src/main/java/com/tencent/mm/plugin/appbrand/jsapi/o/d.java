package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class d extends a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(73181);
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("value");
        ab.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (bo.isNullOrNil(optString) || bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(73181);
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            ab.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(73181);
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(cVar.getAppId())) {
                ab.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                cVar.M(i, j("fail", null));
                AppMethodBeat.o(73181);
                return;
            }
            ab.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", cVar.getAppId());
            int i2 = 0;
            if (at.isConnected(cVar.getContext())) {
                if (at.isWifi(cVar.getContext())) {
                    i2 = 1;
                } else if (at.is4G(cVar.getContext())) {
                    i2 = 4;
                } else if (at.is3G(cVar.getContext())) {
                    i2 = 3;
                } else if (at.is2G(cVar.getContext())) {
                    i2 = 2;
                }
                ab.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i2));
            }
            long anT = bo.anT();
            ab.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(anT), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2);
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bo.nullAsNil(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                str6 = URLEncoder.encode(optString, "UTF-8");
                str7 = URLEncoder.encode(optString2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
            }
            h.pYm.e(13579, r12, Integer.valueOf(i2), str4, str5, str, str6, str7, Long.valueOf(anT), Long.valueOf(anT));
            cVar.M(i, j("ok", null));
            AppMethodBeat.o(73181);
        }
    }
}
