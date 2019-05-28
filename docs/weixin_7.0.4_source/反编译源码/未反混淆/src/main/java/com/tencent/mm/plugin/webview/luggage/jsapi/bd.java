package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bd<T extends d> extends bc<T> {
    public final void a(a aVar) {
        String aek;
        Object obj;
        JSONObject jSONObject = aVar.bPa.bOf;
        String url = ((d) aVar.bOZ).getUrl();
        LuggageGetA8Key cWM = ((d) aVar.bOZ).cWM();
        if (cWM != null) {
            aek = cWM.aek(url);
        } else {
            aek = null;
        }
        if (bo.isNullOrNil(aek)) {
            obj = url;
        } else {
            String obj2 = aek;
        }
        GameWebPerformanceInfo.kU(((d) aVar.bOZ).cWL()).eBQ = 1;
        try {
            jSONObject.put("currentUrl", url);
            jSONObject.put("shareUrl", obj2);
            jSONObject.put("preVerifyAppId", ((d) aVar.bOZ).uij.getAppId());
            if (getClass().getName().equals(ap.class.getName())) {
                jSONObject.put("sendAppMessageScene", ap.cXn());
                ap.cXo();
            }
        } catch (JSONException e) {
        }
        super.a(aVar);
    }
}
