package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class f extends a {
    public static final int CTRL_INDEX = 251;
    public static final String NAME = "navigateToMiniProgram";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(101984);
        final d dVar = (d) cVar;
        String optString = jSONObject.optString("appId", null);
        if (bo.isNullOrNil(optString)) {
            dVar.M(i, j("fail:appID is empty", null));
            AppMethodBeat.o(101984);
        } else if (optString.equals(dVar.getAppId())) {
            dVar.M(i, j("fail:target appId is the same as the caller appId", null));
            AppMethodBeat.o(101984);
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
            int i2 = dVar.getRuntime().ye().hhd.gVt;
            int i3 = b.a(jSONObject.optString("envVersion"), b.RELEASE).har;
            if (!(i2 == 1 || i2 == 2)) {
                i3 = 0;
            }
            int optInt = jSONObject.optInt("sourcetype", 0);
            String optString3 = jSONObject.optString("agentId");
            a aVar = new a();
            aVar.scene = jSONObject.optInt("scene", 0);
            aVar.cst = jSONObject.optString("sceneNote");
            aVar.cOq = jSONObject.optInt("preScene", 0);
            aVar.cOr = jSONObject.optString("preSceneNote");
            aVar.cvp = optInt;
            aVar.hgS = optString3;
            aVar.hQF = jSONObject.optString("adInfo");
            aDv().a(dVar, optString, i3, optString2, aVar, optJSONObject, optJSONObject2, new c.c() {
                public final void dY(boolean z) {
                    String str;
                    AppMethodBeat.i(101983);
                    d dVar = dVar;
                    int i = i;
                    f fVar = f.this;
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    dVar.M(i, fVar.j(str, null));
                    AppMethodBeat.o(101983);
                }
            });
            AppMethodBeat.o(101984);
        }
    }
}
