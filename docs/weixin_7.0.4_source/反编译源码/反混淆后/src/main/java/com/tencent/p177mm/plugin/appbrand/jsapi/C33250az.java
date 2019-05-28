package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandAuthorizeUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.az */
public final class C33250az extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130519);
        final C19722s c19722s = (C19722s) c2241c;
        if (c19722s.getRuntime().atH() == null) {
            C4990ab.m7412e("MicroMsg.JsApiOpenSetting", "config is null!");
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130519);
            return;
        }
        Context context = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (context == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            AppMethodBeat.m2505o(130519);
            return;
        }
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130518);
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
                        jSONObject.put("errMsg", C33250az.this.getName() + ":ok");
                        jSONObject.put("authSetting", jSONArray);
                    } catch (JSONException e2) {
                        C4990ab.m7412e("MicroMsg.JsApiOpenSetting", "set json error!");
                        C4990ab.printErrStackTrace("MicroMsg.JsApiOpenSetting", e2, "", new Object[0]);
                    }
                    c19722s.mo6107M(i, jSONObject.toString());
                }
                AppMethodBeat.m2505o(130518);
            }
        };
        Intent putExtra = new Intent(c19722s.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", c19722s.getRuntime().atI().username);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        C25985d.m41468b(context, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra, 1);
        AppMethodBeat.m2505o(130519);
    }
}
