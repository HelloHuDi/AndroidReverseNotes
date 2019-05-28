package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.soter.p769ui.SoterAuthenticationUIWC;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.c */
public final class C2233c extends C10296a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(3225);
        C4990ab.m7416i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        Context context = c2241c.getContext() instanceof MMActivity ? (MMActivity) c2241c.getContext() : null;
        if (context == null) {
            C4990ab.m7413e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", c2241c.getAppId());
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(3225);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent(context, SoterAuthenticationUIWC.class);
        intent.putExtra("auth_mode", C45582a.m84098m(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                Bundle bundle = null;
                AppMethodBeat.m2504i(3224);
                if (i == 1000) {
                    C2233c c2233c;
                    C2241c c2241c;
                    int i3;
                    if (i2 == -1) {
                        C4990ab.m7416i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
                        c2233c = C2233c.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C2233c.m4446a(c2233c, c2241c, i3, bundle, "ok");
                        AppMethodBeat.m2505o(3224);
                        return;
                    } else if (i2 == 1) {
                        C4990ab.m7420w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
                        c2233c = C2233c.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C2233c.m4446a(c2233c, c2241c, i3, bundle, "fail");
                        AppMethodBeat.m2505o(3224);
                        return;
                    } else {
                        C4990ab.m7412e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
                        c2233c = C2233c.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C2233c.m4446a(c2233c, c2241c, i3, bundle, "cancel");
                    }
                }
                AppMethodBeat.m2505o(3224);
            }
        };
        context.startActivityForResult(intent, 1000);
        AppMethodBeat.m2505o(3225);
    }

    /* renamed from: a */
    static /* synthetic */ void m4446a(C2233c c2233c, C2241c c2241c, int i, Bundle bundle, String str) {
        int i2;
        AppMethodBeat.m2504i(3226);
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
        JSONArray oc = C45582a.m84099oc(i2);
        Object obj3 = "";
        if (oc.length() > 0) {
            try {
                obj3 = oc.getString(0);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiStartSoterAuthentication", e, "hy: json error in callback", new Object[0]);
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
        c2241c.mo6107M(i, c2233c.mo73394j(str, hashMap));
        AppMethodBeat.m2505o(3226);
    }
}
