package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.bd */
public abstract class C46419bd<T extends C24905d> extends C22840bc<T> {
    /* renamed from: a */
    public final void mo38432a(C32183a c32183a) {
        String aek;
        Object obj;
        JSONObject jSONObject = c32183a.bPa.bOf;
        String url = ((C24905d) c32183a.bOZ).getUrl();
        LuggageGetA8Key cWM = ((C24905d) c32183a.bOZ).cWM();
        if (cWM != null) {
            aek = cWM.aek(url);
        } else {
            aek = null;
        }
        if (C5046bo.isNullOrNil(aek)) {
            obj = url;
        } else {
            String obj2 = aek;
        }
        GameWebPerformanceInfo.m63878kU(((C24905d) c32183a.bOZ).cWL()).eBQ = 1;
        try {
            jSONObject.put("currentUrl", url);
            jSONObject.put("shareUrl", obj2);
            jSONObject.put("preVerifyAppId", ((C24905d) c32183a.bOZ).uij.getAppId());
            if (getClass().getName().equals(C14492ap.class.getName())) {
                jSONObject.put("sendAppMessageScene", C14492ap.cXn());
                C14492ap.cXo();
            }
        } catch (JSONException e) {
        }
        super.mo38432a(c32183a);
    }
}
