package com.tencent.p177mm.plugin.appbrand.jsapi.p317u;

import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p893e.C19213f;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a */
public abstract class C45624a extends C10296a {
    public abstract String aGC();

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        if (c2241c == null) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
            c2241c.mo6107M(i, mo73394j("fail:component is null", null));
        } else if (jSONObject == null || !jSONObject.has("viewId")) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
            c2241c.mo6107M(i, mo73394j("fail:no viewId in data", null));
        } else {
            C6747i aBx;
            if (c2241c instanceof C44709u) {
                aBx = c2241c.aBx();
            } else {
                if (c2241c instanceof C38492q) {
                    C44709u currentPageView = ((C38492q) c2241c).getCurrentPageView();
                    if (currentPageView != null) {
                        aBx = currentPageView.aBx();
                    }
                }
                aBx = null;
            }
            if (aBx == null || !(aBx instanceof C19496c)) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "js runtime not appbrand webview");
                c2241c.mo6107M(i, mo73394j("fail:invalid runtime", null));
                return;
            }
            C19213f webViewPluginClientProxy = ((C19496c) aBx).getWebViewPluginClientProxy();
            if (webViewPluginClientProxy == null) {
                C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
                c2241c.mo6107M(i, mo73394j("fail:webview has no plugin client", null));
                return;
            }
            webViewPluginClientProxy.mo21633a(aGC(), jSONObject.optInt("viewId"), c2241c, jSONObject, this, i);
        }
    }
}
