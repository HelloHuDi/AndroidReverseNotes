package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(131677);
        if (view instanceof a) {
            String optString = jSONObject.optString("src", "");
            ab.i("URL", optString);
            if (TextUtils.isEmpty(optString)) {
                AppMethodBeat.o(131677);
                return true;
            }
            MMWebView webView = ((a) view).getWebView();
            if (optString.indexOf("#") < 0 || TextUtils.isEmpty(webView.getUrl())) {
                webView.loadUrl(optString);
            } else {
                webView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[]{optString}), null);
            }
            AppMethodBeat.o(131677);
            return true;
        }
        AppMethodBeat.o(131677);
        return false;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(131678);
        int i = jSONObject.getInt("htmlId");
        AppMethodBeat.o(131678);
        return i;
    }
}
