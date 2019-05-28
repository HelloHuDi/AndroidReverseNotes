package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class ak {
    private static ak umy = new ak();
    HashMap<String, WebViewJSSDKFileItem> umz = new HashMap();

    static {
        AppMethodBeat.i(6717);
        AppMethodBeat.o(6717);
    }

    public static final ak cXM() {
        return umy;
    }

    public ak() {
        AppMethodBeat.i(6714);
        AppMethodBeat.o(6714);
    }

    public final void b(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        AppMethodBeat.i(6715);
        if (webViewJSSDKFileItem == null || bo.isNullOrNil(webViewJSSDKFileItem.czD)) {
            ab.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            AppMethodBeat.o(6715);
            return;
        }
        ab.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", webViewJSSDKFileItem.czD, webViewJSSDKFileItem.heo);
        this.umz.put(webViewJSSDKFileItem.czD, webViewJSSDKFileItem);
        AppMethodBeat.o(6715);
    }

    public final WebViewJSSDKFileItem aex(String str) {
        AppMethodBeat.i(6716);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
            AppMethodBeat.o(6716);
            return null;
        }
        WebViewJSSDKFileItem webViewJSSDKFileItem = (WebViewJSSDKFileItem) this.umz.get(str);
        AppMethodBeat.o(6716);
        return webViewJSSDKFileItem;
    }
}
