package com.tencent.p177mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C45622a;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.j */
public final class C19610j extends C10642a<C27242w> {

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.j$a */
    public static final class C19613a extends C38369p {
        private static final int CTRL_INDEX = 75;
        public static final String NAME = "onShareAppMessage";
    }

    public C19610j() {
        super(C38449o.ShareAppMsg.ordinal());
        AppMethodBeat.m2504i(132241);
        AppMethodBeat.m2505o(132241);
    }

    /* renamed from: a */
    static void m30407a(C27242w c27242w, C42636n c42636n) {
        Object url;
        AppMethodBeat.m2504i(132242);
        AppBrandSysConfigWC atH = c27242w.getRuntime().atH();
        C19613a c19613a = new C19613a();
        HashMap hashMap = new HashMap();
        hashMap.put("title", atH.cwz);
        hashMap.put("desc", "");
        hashMap.put("path", c27242w.aBm());
        String str = "webViewUrl";
        C45622a aJS = c27242w.aJS();
        if (aJS != null) {
            url = aJS.getWebView().getUrl();
        } else {
            url = null;
        }
        hashMap.put(str, url);
        hashMap.put("imgUrl", atH.hgW);
        hashMap.put("mode", c42636n.hAx.mo53357nX("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(c42636n.hAx.mo53357nX("enable_share_dynamic")));
        c42636n.hAx.mo53359z("user_clicked_share_btn", true);
        c19613a.mo61030b(c27242w.getRuntime().atK(), c27242w.hashCode()).mo34958t(hashMap).aCj();
        AppMethodBeat.m2505o(132242);
    }
}
