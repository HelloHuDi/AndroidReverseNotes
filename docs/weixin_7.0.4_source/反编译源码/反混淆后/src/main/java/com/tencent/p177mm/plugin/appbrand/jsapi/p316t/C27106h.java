package com.tencent.p177mm.plugin.appbrand.jsapi.p316t;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.h */
public final class C27106h extends C45578c {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131677);
        if (view instanceof C45622a) {
            String optString = jSONObject.optString("src", "");
            C4990ab.m7416i("URL", optString);
            if (TextUtils.isEmpty(optString)) {
                AppMethodBeat.m2505o(131677);
                return true;
            }
            MMWebView webView = ((C45622a) view).getWebView();
            if (optString.indexOf("#") < 0 || TextUtils.isEmpty(webView.getUrl())) {
                webView.loadUrl(optString);
            } else {
                webView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[]{optString}), null);
            }
            AppMethodBeat.m2505o(131677);
            return true;
        }
        AppMethodBeat.m2505o(131677);
        return false;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(131678);
        int i = jSONObject.getInt("htmlId");
        AppMethodBeat.m2505o(131678);
        return i;
    }
}
