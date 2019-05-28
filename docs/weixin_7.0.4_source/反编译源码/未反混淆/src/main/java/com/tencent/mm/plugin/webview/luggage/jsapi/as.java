package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class as extends bd<d> {
    public final String name() {
        return "setNavigationBarButtons";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6373);
        ab.i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
        String optString = aVar.bPa.bOf.optString("left");
        String optString2 = aVar.bPa.bOf.optString("right");
        if (bo.isNullOrNil(optString) && bo.isNullOrNil(optString2)) {
            aVar.a("fail", null);
            AppMethodBeat.o(6373);
            return;
        }
        Bundle bundle = new Bundle();
        try {
            optString = new JSONObject(optString).optString("color", "");
            if (!bo.isNullOrNil(optString)) {
                bundle.putString("set_navigation_bar_buttons_left_text_color", optString);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", e, "setNavigationBarButtons opt left ", new Object[0]);
        }
        try {
            JSONObject jSONObject = new JSONObject(optString2);
            boolean optBoolean = jSONObject.optBoolean("hidden", false);
            String optString3 = jSONObject.optString("text", "");
            String nullAsNil = bo.nullAsNil(u.akm(jSONObject.optString("iconData", "")));
            String optString4 = jSONObject.optString("color", "");
            boolean optBoolean2 = jSONObject.optBoolean("needClickEvent", false);
            if (optBoolean) {
                bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
            } else {
                bundle.putString("set_navigation_bar_buttons_text", optString3);
                bundle.putString("set_navigation_bar_buttons_icon_data", nullAsNil);
                bundle.putString("set_navigation_bar_buttons_text_color", optString4);
                bundle.putBoolean("set_navigation_bar_buttons_need_click_event", optBoolean2);
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", e2, "setNavigationBarButtons opt right ", new Object[0]);
        }
        if (bundle.size() < 0) {
            aVar.a("fail", null);
            AppMethodBeat.o(6373);
            return;
        }
        k cWH = ((d) aVar.bOZ).cWH();
        if (cWH == null) {
            aVar.a("fail", null);
            AppMethodBeat.o(6373);
            return;
        }
        cWH.setNavigationBarButtons(bundle);
        aVar.a("", null);
        AppMethodBeat.o(6373);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
