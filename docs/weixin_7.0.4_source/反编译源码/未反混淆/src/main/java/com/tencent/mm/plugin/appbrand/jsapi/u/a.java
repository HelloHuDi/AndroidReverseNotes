package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.mm.plugin.appbrand.e.f;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public abstract String aGC();

    public final void a(c cVar, JSONObject jSONObject, int i) {
        if (cVar == null) {
            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
            cVar.M(i, j("fail:component is null", null));
        } else if (jSONObject == null || !jSONObject.has("viewId")) {
            ab.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
            cVar.M(i, j("fail:no viewId in data", null));
        } else {
            i aBx;
            if (cVar instanceof u) {
                aBx = cVar.aBx();
            } else {
                if (cVar instanceof q) {
                    u currentPageView = ((q) cVar).getCurrentPageView();
                    if (currentPageView != null) {
                        aBx = currentPageView.aBx();
                    }
                }
                aBx = null;
            }
            if (aBx == null || !(aBx instanceof c)) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "js runtime not appbrand webview");
                cVar.M(i, j("fail:invalid runtime", null));
                return;
            }
            f webViewPluginClientProxy = ((c) aBx).getWebViewPluginClientProxy();
            if (webViewPluginClientProxy == null) {
                ab.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
                cVar.M(i, j("fail:webview has no plugin client", null));
                return;
            }
            webViewPluginClientProxy.a(aGC(), jSONObject.optInt("viewId"), cVar, jSONObject, this, i);
        }
    }
}
