package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.af */
public class C22833af extends C46419bd<C24905d> {
    public final String name() {
        return "openCustomWebview";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        int i = 0;
        AppMethodBeat.m2504i(6340);
        C4990ab.m7416i("MicroMsg.JsApiOpenCustomWebView", "invokeInOwn");
        final String optString = c32183a.bPa.bOf.optString("url");
        if (C5046bo.isNullOrNil(optString)) {
            c32183a.mo52824a("invalid_url", null);
            AppMethodBeat.m2505o(6340);
            return;
        }
        boolean optBoolean;
        final boolean equals;
        boolean equals2;
        String optString2;
        final Bundle bundle;
        final C32183a c32183a2;
        C4990ab.m7417i("MicroMsg.JsApiOpenCustomWebView", "url: %s", optString);
        String optString3 = c32183a.bPa.bOf.optString("orientation");
        if (!C5046bo.isNullOrNil(optString3)) {
            if (!optString3.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                if (optString3.equals("vertical")) {
                    i = 1;
                }
            }
            optBoolean = c32183a.bPa.bOf.optBoolean("fullscreen");
            equals = c32183a.bPa.bOf.optString("finish_recent_webview").equals("1");
            equals2 = c32183a.bPa.bOf.optString("disable_swipe_back").equals("1");
            optString2 = c32183a.bPa.bOf.optString("username");
            bundle = new Bundle();
            bundle.putString("rawUrl", optString);
            bundle.putInt("screen_orientation", i);
            bundle.putBoolean("show_full_screen", optBoolean);
            bundle.putBoolean("disable_swipe_back", equals2);
            bundle.putString("shortcut_user_name", optString2);
            bundle.putString("game_hv_menu_appid", C5046bo.nullAsNil(c32183a.bPa.bOf.optString("gameAppid")));
            c32183a2 = c32183a;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6339);
                    if (equals) {
                        ((C24905d) c32183a2.bOZ).bPe.mo43477xi().mo60237i(optString, bundle);
                        AppMethodBeat.m2505o(6339);
                        return;
                    }
                    ((C24905d) c32183a2.bOZ).bPe.mo43477xi().mo60236h(optString, bundle);
                    AppMethodBeat.m2505o(6339);
                }
            });
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(6340);
        }
        i = -1;
        optBoolean = c32183a.bPa.bOf.optBoolean("fullscreen");
        equals = c32183a.bPa.bOf.optString("finish_recent_webview").equals("1");
        equals2 = c32183a.bPa.bOf.optString("disable_swipe_back").equals("1");
        optString2 = c32183a.bPa.bOf.optString("username");
        bundle = new Bundle();
        bundle.putString("rawUrl", optString);
        bundle.putInt("screen_orientation", i);
        bundle.putBoolean("show_full_screen", optBoolean);
        bundle.putBoolean("disable_swipe_back", equals2);
        bundle.putString("shortcut_user_name", optString2);
        bundle.putString("game_hv_menu_appid", C5046bo.nullAsNil(c32183a.bPa.bOf.optString("gameAppid")));
        c32183a2 = c32183a;
        C5004al.m7441d(/* anonymous class already generated */);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6340);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
