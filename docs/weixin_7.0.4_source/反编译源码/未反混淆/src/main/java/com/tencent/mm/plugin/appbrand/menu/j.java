package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.w;
import java.util.HashMap;

public final class j extends com.tencent.mm.plugin.appbrand.menu.a.a<w> {

    public static final class a extends p {
        private static final int CTRL_INDEX = 75;
        public static final String NAME = "onShareAppMessage";
    }

    public j() {
        super(o.ShareAppMsg.ordinal());
        AppMethodBeat.i(132241);
        AppMethodBeat.o(132241);
    }

    static void a(w wVar, n nVar) {
        Object url;
        AppMethodBeat.i(132242);
        AppBrandSysConfigWC atH = wVar.getRuntime().atH();
        a aVar = new a();
        HashMap hashMap = new HashMap();
        hashMap.put("title", atH.cwz);
        hashMap.put("desc", "");
        hashMap.put("path", wVar.aBm());
        String str = "webViewUrl";
        com.tencent.mm.plugin.appbrand.jsapi.t.a aJS = wVar.aJS();
        if (aJS != null) {
            url = aJS.getWebView().getUrl();
        } else {
            url = null;
        }
        hashMap.put(str, url);
        hashMap.put("imgUrl", atH.hgW);
        hashMap.put("mode", nVar.hAx.nX("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(nVar.hAx.nX("enable_share_dynamic")));
        nVar.hAx.z("user_clicked_share_btn", true);
        aVar.b(wVar.getRuntime().atK(), wVar.hashCode()).t(hashMap).aCj();
        AppMethodBeat.o(132242);
    }
}
