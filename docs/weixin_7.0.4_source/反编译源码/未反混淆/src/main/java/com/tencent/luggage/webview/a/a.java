package com.tencent.luggage.webview.a;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements c {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public final String yk() {
        return "^luggage://bridge$";
    }

    public final WebResourceResponse bG(String str) {
        AppMethodBeat.i(90943);
        try {
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", this.mContext.getAssets().open("LuggageBridge.js"));
            AppMethodBeat.o(90943);
            return webResourceResponse;
        } catch (Exception e) {
            AppMethodBeat.o(90943);
            return null;
        }
    }
}
