package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2322a;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2323c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f */
public class C33378f extends C16672a {
    public static final int CTRL_INDEX = 251;
    public static final String NAME = "navigateToMiniProgram";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(101984);
        final C2119d c2119d = (C2119d) c2241c;
        String optString = jSONObject.optString("appId", null);
        if (C5046bo.isNullOrNil(optString)) {
            c2119d.mo6107M(i, mo73394j("fail:appID is empty", null));
            AppMethodBeat.m2505o(101984);
        } else if (optString.equals(c2119d.getAppId())) {
            c2119d.mo6107M(i, mo73394j("fail:target appId is the same as the caller appId", null));
            AppMethodBeat.m2505o(101984);
        } else {
            String optString2 = jSONObject.optString("path", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("privateExtraData");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            int i2 = c2119d.getRuntime().mo15034ye().hhd.gVt;
            int i3 = C2319b.m4539a(jSONObject.optString("envVersion"), C2319b.RELEASE).har;
            if (!(i2 == 1 || i2 == 2)) {
                i3 = 0;
            }
            int optInt = jSONObject.optInt("sourcetype", 0);
            String optString3 = jSONObject.optString("agentId");
            C2322a c2322a = new C2322a();
            c2322a.scene = jSONObject.optInt("scene", 0);
            c2322a.cst = jSONObject.optString("sceneNote");
            c2322a.cOq = jSONObject.optInt("preScene", 0);
            c2322a.cOr = jSONObject.optString("preSceneNote");
            c2322a.cvp = optInt;
            c2322a.hgS = optString3;
            c2322a.hQF = jSONObject.optString("adInfo");
            aDv().mo6194a(c2119d, optString, i3, optString2, c2322a, optJSONObject, optJSONObject2, new C2323c() {
                /* renamed from: dY */
                public final void mo6193dY(boolean z) {
                    String str;
                    AppMethodBeat.m2504i(101983);
                    C2119d c2119d = c2119d;
                    int i = i;
                    C33378f c33378f = C33378f.this;
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c2119d.mo6107M(i, c33378f.mo73394j(str, null));
                    AppMethodBeat.m2505o(101983);
                }
            });
            AppMethodBeat.m2505o(101984);
        }
    }
}
