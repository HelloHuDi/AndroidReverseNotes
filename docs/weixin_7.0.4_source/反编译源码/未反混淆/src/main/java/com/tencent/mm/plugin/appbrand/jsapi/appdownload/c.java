package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.l.a;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.appbrand.l.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, a aVar, boolean z, JSONObject jSONObject, int i, Map<String, String> map, b.a aVar2, String str) {
        AppMethodBeat.i(130678);
        String optString = jSONObject.optString("url");
        if (bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
            d.a(cVar, str, "url is null or nil");
            AppMethodBeat.o(130678);
            return;
        }
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_predownload, false) && com.tencent.mm.plugin.appbrand.game.preload.d.aBz().isDownloading(optString)) {
            m mVar = com.tencent.mm.plugin.appbrand.game.preload.d.aBz().hto;
            if (mVar != null) {
                mVar.a(jSONObject, i, map, z ? aVar.bQI : null, aVar.hfK, aVar2, str, "createDownloadTask");
                AppMethodBeat.o(130678);
                return;
            }
        }
        super.a(cVar, aVar, z, jSONObject, i, map, aVar2, str);
        AppMethodBeat.o(130678);
    }
}
