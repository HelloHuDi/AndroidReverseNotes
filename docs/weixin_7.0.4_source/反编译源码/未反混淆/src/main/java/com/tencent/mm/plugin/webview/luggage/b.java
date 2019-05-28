package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.g.d;
import com.tencent.luggage.g.i;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public final class b implements c {
    private String uhL = "";

    public b(String str) {
        this.uhL = str;
    }

    public final String yk() {
        return "weixin://bridge.js";
    }

    public final WebResourceResponse bG(String str) {
        AppMethodBeat.i(5979);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(5979);
            return null;
        }
        try {
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream((i.p(ah.getContext(), "LuggageBridge.js") + this.uhL).getBytes("UTF-8")));
            HashMap hashMap = new HashMap();
            hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            webResourceResponse.setResponseHeaders(hashMap);
            AppMethodBeat.o(5979);
            return webResourceResponse;
        } catch (Exception e) {
            d.b("MicroMsg.LuggageMMJsBridgeResourceProvider", "", e);
            AppMethodBeat.o(5979);
            return null;
        }
    }
}
