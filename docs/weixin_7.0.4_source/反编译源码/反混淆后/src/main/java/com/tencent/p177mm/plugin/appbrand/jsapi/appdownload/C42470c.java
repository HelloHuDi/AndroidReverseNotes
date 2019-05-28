package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.game.preload.C45564d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45603d;
import com.tencent.p177mm.plugin.appbrand.p321l.C19548m;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b.C27147a;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.c */
public final class C42470c extends C45603d {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    /* renamed from: a */
    public final void mo67976a(C2241c c2241c, C38414a c38414a, boolean z, JSONObject jSONObject, int i, Map<String, String> map, C27147a c27147a, String str) {
        AppMethodBeat.m2504i(130678);
        String optString = jSONObject.optString("url");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7416i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
            C45603d.m84159a(c2241c, str, "url is null or nil");
            AppMethodBeat.m2505o(130678);
            return;
        }
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_predownload, false) && C45564d.aBz().isDownloading(optString)) {
            C19548m c19548m = C45564d.aBz().hto;
            if (c19548m != null) {
                c19548m.mo34743a(jSONObject, i, map, z ? c38414a.bQI : null, c38414a.hfK, c27147a, str, "createDownloadTask");
                AppMethodBeat.m2505o(130678);
                return;
            }
        }
        super.mo67976a(c2241c, c38414a, z, jSONObject, i, map, c27147a, str);
        AppMethodBeat.m2505o(130678);
    }
}
