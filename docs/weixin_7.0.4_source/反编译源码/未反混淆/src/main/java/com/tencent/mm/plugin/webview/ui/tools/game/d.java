package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Build.VERSION;
import android.os.PowerManager;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public final class d {
    public static WebResourceResponse nX(boolean z) {
        AppMethodBeat.i(8689);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(8689);
            return null;
        }
        String p = i.p(ah.getContext(), "game.js");
        if (!bo.isNullOrNil(p)) {
            boolean z2;
            String replaceFirst = p.replaceFirst("#__usewepkg__#", String.valueOf(z));
            String str = "#__lowPowerMode__#";
            PowerManager powerManager = (PowerManager) ah.getContext().getSystemService("power");
            if (powerManager == null || VERSION.SDK_INT < 21) {
                z2 = false;
            } else {
                z2 = powerManager.isPowerSaveMode();
            }
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(replaceFirst.replaceFirst(str, String.valueOf(z2)).replaceFirst("#__lowPower__#", String.valueOf(BatteryManager.uCS)).getBytes("UTF-8")));
                HashMap hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
                hashMap.put("Pragma", "no-cache");
                hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                webResourceResponse.setResponseHeaders(hashMap);
                AppMethodBeat.o(8689);
                return webResourceResponse;
            } catch (Exception e) {
                com.tencent.luggage.g.d.b("MicroMsg.GameScriptManager", "", e);
            }
        }
        AppMethodBeat.o(8689);
        return null;
    }
}
