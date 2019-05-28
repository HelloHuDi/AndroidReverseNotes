package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class az extends a<s> {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130519);
        final s sVar = (s) cVar;
        if (sVar.getRuntime().atH() == null) {
            ab.e("MicroMsg.JsApiOpenSetting", "config is null!");
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130519);
            return;
        }
        Context context = (MMActivity) sVar.ad(MMActivity.class);
        if (context == null) {
            sVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130519);
            return;
        }
        context.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130518);
                if (i == 1) {
                    String stringExtra;
                    Object jSONArray;
                    String str = "";
                    if (intent != null) {
                        stringExtra = intent.getStringExtra("key_app_authorize_state");
                    } else {
                        stringExtra = str;
                    }
                    try {
                        jSONArray = new JSONArray(stringExtra);
                    } catch (JSONException e) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errMsg", az.this.getName() + ":ok");
                        jSONObject.put("authSetting", jSONArray);
                    } catch (JSONException e2) {
                        ab.e("MicroMsg.JsApiOpenSetting", "set json error!");
                        ab.printErrStackTrace("MicroMsg.JsApiOpenSetting", e2, "", new Object[0]);
                    }
                    sVar.M(i, jSONObject.toString());
                }
                AppMethodBeat.o(130518);
            }
        };
        Intent putExtra = new Intent(sVar.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", sVar.getRuntime().atI().username);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        d.b(context, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra, 1);
        AppMethodBeat.o(130519);
    }
}
