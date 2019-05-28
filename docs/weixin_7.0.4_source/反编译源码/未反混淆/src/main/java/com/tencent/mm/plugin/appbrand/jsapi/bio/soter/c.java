package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(3225);
        ab.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        Context context = cVar.getContext() instanceof MMActivity ? (MMActivity) cVar.getContext() : null;
        if (context == null) {
            ab.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", cVar.getAppId());
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(3225);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent(context, SoterAuthenticationUIWC.class);
        intent.putExtra("auth_mode", a.m(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                Bundle bundle = null;
                AppMethodBeat.i(3224);
                if (i == 1000) {
                    c cVar;
                    com.tencent.mm.plugin.appbrand.jsapi.c cVar2;
                    int i3;
                    if (i2 == -1) {
                        ab.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
                        cVar = c.this;
                        cVar2 = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        c.a(cVar, cVar2, i3, bundle, "ok");
                        AppMethodBeat.o(3224);
                        return;
                    } else if (i2 == 1) {
                        ab.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
                        cVar = c.this;
                        cVar2 = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        c.a(cVar, cVar2, i3, bundle, "fail");
                        AppMethodBeat.o(3224);
                        return;
                    } else {
                        ab.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
                        cVar = c.this;
                        cVar2 = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        c.a(cVar, cVar2, i3, bundle, "cancel");
                    }
                }
                AppMethodBeat.o(3224);
            }
        };
        context.startActivityForResult(intent, 1000);
        AppMethodBeat.o(3225);
    }

    static /* synthetic */ void a(c cVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar2, int i, Bundle bundle, String str) {
        int i2;
        AppMethodBeat.i(3226);
        int i3 = -1;
        String str2 = "not returned";
        Object obj = "";
        Object obj2 = "";
        if (bundle != null) {
            i3 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("result_json");
            obj2 = bundle.getString("result_json_signature");
            i2 = bundle.getByte("use_mode");
        } else {
            i2 = 0;
        }
        JSONArray oc = a.oc(i2);
        Object obj3 = "";
        if (oc.length() > 0) {
            try {
                obj3 = oc.getString(0);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.JsApiStartSoterAuthentication", e, "hy: json error in callback", new Object[0]);
            }
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("authMode", obj3);
        hashMap.put("errCode", Integer.valueOf(i3));
        hashMap.put("resultJSON", obj);
        hashMap.put("resultJSONSignature", obj2);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        cVar2.M(i, cVar.j(str, hashMap));
        AppMethodBeat.o(3226);
    }
}
