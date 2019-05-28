package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.webview.p1172a.C17831c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b */
public final class C14462b implements C17831c {
    private String uhL = "";

    public C14462b(String str) {
        this.uhL = str;
    }

    /* renamed from: yk */
    public final String mo23954yk() {
        return "weixin://bridge.js";
    }

    /* renamed from: bG */
    public final WebResourceResponse mo23953bG(String str) {
        AppMethodBeat.m2504i(5979);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(5979);
            return null;
        }
        try {
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream((C32192i.m52511p(C4996ah.getContext(), "LuggageBridge.js") + this.uhL).getBytes("UTF-8")));
            HashMap hashMap = new HashMap();
            hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            webResourceResponse.setResponseHeaders(hashMap);
            AppMethodBeat.m2505o(5979);
            return webResourceResponse;
        } catch (Exception e) {
            C45124d.m82923b("MicroMsg.LuggageMMJsBridgeResourceProvider", "", e);
            AppMethodBeat.m2505o(5979);
            return null;
        }
    }
}
