package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public class e extends u<h> {
    public static final int CTRL_INDEX = 252;
    public static final String NAME = "navigateBackMiniProgram";

    public /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(101982);
        String a = a((h) cVar, jSONObject);
        AppMethodBeat.o(101982);
        return a;
    }

    public String a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(101981);
        hVar.getRuntime().a(MiniProgramNavigationBackResult.a(jSONObject.optJSONObject("extraData"), jSONObject.optJSONObject("privateExtraData")));
        String j = j("ok", null);
        AppMethodBeat.o(101981);
        return j;
    }
}
