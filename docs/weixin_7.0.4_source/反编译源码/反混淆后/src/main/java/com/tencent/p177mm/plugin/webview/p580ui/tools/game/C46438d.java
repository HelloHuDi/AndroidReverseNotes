package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.os.Build.VERSION;
import android.os.PowerManager;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.d */
public final class C46438d {
    /* renamed from: nX */
    public static WebResourceResponse m87588nX(boolean z) {
        AppMethodBeat.m2504i(8689);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(8689);
            return null;
        }
        String p = C32192i.m52511p(C4996ah.getContext(), "game.js");
        if (!C5046bo.isNullOrNil(p)) {
            boolean z2;
            String replaceFirst = p.replaceFirst("#__usewepkg__#", String.valueOf(z));
            String str = "#__lowPowerMode__#";
            PowerManager powerManager = (PowerManager) C4996ah.getContext().getSystemService("power");
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
                AppMethodBeat.m2505o(8689);
                return webResourceResponse;
            } catch (Exception e) {
                C45124d.m82923b("MicroMsg.GameScriptManager", "", e);
            }
        }
        AppMethodBeat.m2505o(8689);
        return null;
    }
}
