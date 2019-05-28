package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class af extends bd<d> {
    public final String name() {
        return "openCustomWebview";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        int i = 0;
        AppMethodBeat.i(6340);
        ab.i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
        final String optString = aVar.bPa.bOf.optString("url");
        if (bo.isNullOrNil(optString)) {
            aVar.a("invalid_url", null);
            AppMethodBeat.o(6340);
            return;
        }
        boolean optBoolean;
        final boolean equals;
        boolean equals2;
        String optString2;
        final Bundle bundle;
        final a aVar2;
        ab.i("MicroMsg.JsApiOpenCustomWebView", "url: %s", optString);
        String optString3 = aVar.bPa.bOf.optString("orientation");
        if (!bo.isNullOrNil(optString3)) {
            if (!optString3.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                if (optString3.equals("vertical")) {
                    i = 1;
                }
            }
            optBoolean = aVar.bPa.bOf.optBoolean("fullscreen");
            equals = aVar.bPa.bOf.optString("finish_recent_webview").equals("1");
            equals2 = aVar.bPa.bOf.optString("disable_swipe_back").equals("1");
            optString2 = aVar.bPa.bOf.optString("username");
            bundle = new Bundle();
            bundle.putString("rawUrl", optString);
            bundle.putInt("screen_orientation", i);
            bundle.putBoolean("show_full_screen", optBoolean);
            bundle.putBoolean("disable_swipe_back", equals2);
            bundle.putString("shortcut_user_name", optString2);
            bundle.putString("game_hv_menu_appid", bo.nullAsNil(aVar.bPa.bOf.optString("gameAppid")));
            aVar2 = aVar;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6339);
                    if (equals) {
                        ((d) aVar2.bOZ).bPe.xi().i(optString, bundle);
                        AppMethodBeat.o(6339);
                        return;
                    }
                    ((d) aVar2.bOZ).bPe.xi().h(optString, bundle);
                    AppMethodBeat.o(6339);
                }
            });
            aVar.a("", null);
            AppMethodBeat.o(6340);
        }
        i = -1;
        optBoolean = aVar.bPa.bOf.optBoolean("fullscreen");
        equals = aVar.bPa.bOf.optString("finish_recent_webview").equals("1");
        equals2 = aVar.bPa.bOf.optString("disable_swipe_back").equals("1");
        optString2 = aVar.bPa.bOf.optString("username");
        bundle = new Bundle();
        bundle.putString("rawUrl", optString);
        bundle.putInt("screen_orientation", i);
        bundle.putBoolean("show_full_screen", optBoolean);
        bundle.putBoolean("disable_swipe_back", equals2);
        bundle.putString("shortcut_user_name", optString2);
        bundle.putString("game_hv_menu_appid", bo.nullAsNil(aVar.bPa.bOf.optString("gameAppid")));
        aVar2 = aVar;
        al.d(/* anonymous class already generated */);
        aVar.a("", null);
        AppMethodBeat.o(6340);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
