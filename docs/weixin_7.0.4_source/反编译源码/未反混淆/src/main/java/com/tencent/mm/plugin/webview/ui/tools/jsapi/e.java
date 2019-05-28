package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

public final class e implements b {
    private MMWebView fow;
    private d uDd;

    public e(MMWebView mMWebView, d dVar) {
        this.fow = mMWebView;
        this.uDd = dVar;
    }

    public final boolean afS(String str) {
        AppMethodBeat.i(9018);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(9018);
            return false;
        }
        boolean t = u.t(str, "weixin://private/setresult/");
        AppMethodBeat.o(9018);
        return t;
    }

    public final boolean afM(String str) {
        String str2 = null;
        AppMethodBeat.i(9019);
        if (this.fow != null) {
            this.fow.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (bo.isNullOrNil(substring)) {
            ab.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            AppMethodBeat.o(9019);
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            ab.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", Integer.valueOf(indexOf));
            AppMethodBeat.o(9019);
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        if (decode != null) {
            str2 = new String(decode);
        }
        ab.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", substring2, str2);
        this.uDd.keep_setReturnValue(substring2, str2);
        AppMethodBeat.o(9019);
        return true;
    }
}
