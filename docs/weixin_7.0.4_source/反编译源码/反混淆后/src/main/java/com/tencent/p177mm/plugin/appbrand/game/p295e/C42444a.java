package com.tencent.p177mm.plugin.appbrand.game.p295e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.game.preload.C45564d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.a */
public final class C42444a extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 585;
    public static final String NAME = "hideSplashScreen";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130190);
        C19722s c19722s = (C19722s) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiHideSplashScreen", "hideSplashScreen jsApi");
        if (!((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_splashscreen, false)) {
            c19722s.mo6107M(i, mo73394j("ok", null));
            C45564d.aBz().aBC();
            AppMethodBeat.m2505o(130190);
        } else if (c19722s.getRuntime() != null) {
            c19722s.getRuntime().atb();
            C45564d.aBz().aBC();
            c19722s.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(130190);
        } else {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130190);
        }
    }
}
