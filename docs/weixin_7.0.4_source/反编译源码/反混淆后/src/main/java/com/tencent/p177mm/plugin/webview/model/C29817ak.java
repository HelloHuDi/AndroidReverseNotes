package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.model.ak */
public final class C29817ak {
    private static C29817ak umy = new C29817ak();
    HashMap<String, WebViewJSSDKFileItem> umz = new HashMap();

    static {
        AppMethodBeat.m2504i(6717);
        AppMethodBeat.m2505o(6717);
    }

    public static final C29817ak cXM() {
        return umy;
    }

    public C29817ak() {
        AppMethodBeat.m2504i(6714);
        AppMethodBeat.m2505o(6714);
    }

    /* renamed from: b */
    public final void mo48046b(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        AppMethodBeat.m2504i(6715);
        if (webViewJSSDKFileItem == null || C5046bo.isNullOrNil(webViewJSSDKFileItem.czD)) {
            C4990ab.m7412e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            AppMethodBeat.m2505o(6715);
            return;
        }
        C4990ab.m7417i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", webViewJSSDKFileItem.czD, webViewJSSDKFileItem.heo);
        this.umz.put(webViewJSSDKFileItem.czD, webViewJSSDKFileItem);
        AppMethodBeat.m2505o(6715);
    }

    public final WebViewJSSDKFileItem aex(String str) {
        AppMethodBeat.m2504i(6716);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
            AppMethodBeat.m2505o(6716);
            return null;
        }
        WebViewJSSDKFileItem webViewJSSDKFileItem = (WebViewJSSDKFileItem) this.umz.get(str);
        AppMethodBeat.m2505o(6716);
        return webViewJSSDKFileItem;
    }
}
