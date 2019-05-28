package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.e */
public final class C44791e implements C43967b {
    private MMWebView fow;
    private C44786d uDd;

    public C44791e(MMWebView mMWebView, C44786d c44786d) {
        this.fow = mMWebView;
        this.uDd = c44786d;
    }

    public final boolean afS(String str) {
        AppMethodBeat.m2504i(9018);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(9018);
            return false;
        }
        boolean t = C30152u.m47751t(str, "weixin://private/setresult/");
        AppMethodBeat.m2505o(9018);
        return t;
    }

    public final boolean afM(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(9019);
        if (this.fow != null) {
            this.fow.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (C5046bo.isNullOrNil(substring)) {
            C4990ab.m7412e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            AppMethodBeat.m2505o(9019);
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            C4990ab.m7413e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", Integer.valueOf(indexOf));
            AppMethodBeat.m2505o(9019);
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        if (decode != null) {
            str2 = new String(decode);
        }
        C4990ab.m7417i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", substring2, str2);
        this.uDd.keep_setReturnValue(substring2, str2);
        AppMethodBeat.m2505o(9019);
        return true;
    }
}
