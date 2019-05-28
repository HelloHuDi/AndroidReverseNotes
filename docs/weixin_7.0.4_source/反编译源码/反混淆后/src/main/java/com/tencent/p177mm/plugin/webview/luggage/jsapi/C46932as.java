package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.as */
public class C46932as extends C46419bd<C24905d> {
    public final String name() {
        return "setNavigationBarButtons";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6373);
        C4990ab.m7416i("MicroMsg.JsApiSetNavigationBarButtons", "invokeInOwn");
        String optString = c32183a.bPa.bOf.optString("left");
        String optString2 = c32183a.bPa.bOf.optString("right");
        if (C5046bo.isNullOrNil(optString) && C5046bo.isNullOrNil(optString2)) {
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6373);
            return;
        }
        Bundle bundle = new Bundle();
        try {
            optString = new JSONObject(optString).optString("color", "");
            if (!C5046bo.isNullOrNil(optString)) {
                bundle.putString("set_navigation_bar_buttons_left_text_color", optString);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", e, "setNavigationBarButtons opt left ", new Object[0]);
        }
        try {
            JSONObject jSONObject = new JSONObject(optString2);
            boolean optBoolean = jSONObject.optBoolean("hidden", false);
            String optString3 = jSONObject.optString("text", "");
            String nullAsNil = C5046bo.nullAsNil(C30152u.akm(jSONObject.optString("iconData", "")));
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
            C4990ab.printErrStackTrace("MicroMsg.JsApiSetNavigationBarButtons", e2, "setNavigationBarButtons opt right ", new Object[0]);
        }
        if (bundle.size() < 0) {
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6373);
            return;
        }
        C22857k cWH = ((C24905d) c32183a.bOZ).cWH();
        if (cWH == null) {
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6373);
            return;
        }
        cWH.setNavigationBarButtons(bundle);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6373);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
