package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<s> {
    public static final int CTRL_INDEX = 585;
    public static final String NAME = "hideSplashScreen";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130190);
        s sVar = (s) cVar;
        ab.i("MicroMsg.JsApiHideSplashScreen", "hideSplashScreen jsApi");
        if (!((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_splashscreen, false)) {
            sVar.M(i, j("ok", null));
            d.aBz().aBC();
            AppMethodBeat.o(130190);
        } else if (sVar.getRuntime() != null) {
            sVar.getRuntime().atb();
            d.aBz().aBC();
            sVar.M(i, j("ok", null));
            AppMethodBeat.o(130190);
        } else {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130190);
        }
    }
}
