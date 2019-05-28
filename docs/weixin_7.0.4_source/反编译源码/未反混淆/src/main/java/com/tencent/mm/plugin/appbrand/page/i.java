package com.tencent.mm.plugin.appbrand.page;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public class i extends p {
    private static final int CTRL_INDEX = 50;
    private static final String NAME = "onAppEnterForeground";

    public final void a(com.tencent.mm.plugin.appbrand.i iVar, boolean z) {
        String atc;
        AppMethodBeat.i(87065);
        HashMap hashMap = new HashMap();
        JSONObject ayF = iVar.yf().hgF.ayF();
        if (ayF != null) {
            hashMap.put("referrerInfo", ayF);
        }
        hashMap.put("relaunch", Boolean.valueOf(z));
        hashMap.put("reLaunch", Boolean.valueOf(z));
        if (z) {
            atc = iVar.atc();
            hashMap.put("rawPath", atc);
            hashMap.put("path", h.bO(atc));
            hashMap.put(SearchIntents.EXTRA_QUERY, h.bP(atc));
        } else {
            atc = iVar.asV().getCurrentUrl();
        }
        ab.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", hashMap.get("path"), hashMap.get(SearchIntents.EXTRA_QUERY), hashMap.get("relaunch"), atc);
        com.tencent.luggage.g.i.d(hashMap);
        t(hashMap).i(iVar.xT()).aCj();
        AppMethodBeat.o(87065);
    }
}
