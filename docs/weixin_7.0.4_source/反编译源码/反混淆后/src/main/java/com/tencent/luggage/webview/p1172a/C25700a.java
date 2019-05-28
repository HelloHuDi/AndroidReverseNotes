package com.tencent.luggage.webview.p1172a;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.webview.a.a */
public final class C25700a implements C17831c {
    private Context mContext;

    public C25700a(Context context) {
        this.mContext = context;
    }

    /* renamed from: yk */
    public final String mo23954yk() {
        return "^luggage://bridge$";
    }

    /* renamed from: bG */
    public final WebResourceResponse mo23953bG(String str) {
        AppMethodBeat.m2504i(90943);
        try {
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", this.mContext.getAssets().open("LuggageBridge.js"));
            AppMethodBeat.m2505o(90943);
            return webResourceResponse;
        } catch (Exception e) {
            AppMethodBeat.m2505o(90943);
            return null;
        }
    }
}
