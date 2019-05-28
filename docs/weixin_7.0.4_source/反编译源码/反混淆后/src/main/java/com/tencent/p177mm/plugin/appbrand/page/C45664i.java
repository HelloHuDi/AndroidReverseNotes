package com.tencent.p177mm.plugin.appbrand.page;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.page.i */
public class C45664i extends C38369p {
    private static final int CTRL_INDEX = 50;
    private static final String NAME = "onAppEnterForeground";

    /* renamed from: a */
    public final void mo73457a(C6750i c6750i, boolean z) {
        String atc;
        AppMethodBeat.m2504i(87065);
        HashMap hashMap = new HashMap();
        JSONObject ayF = c6750i.mo15035yf().hgF.ayF();
        if (ayF != null) {
            hashMap.put("referrerInfo", ayF);
        }
        hashMap.put("relaunch", Boolean.valueOf(z));
        hashMap.put("reLaunch", Boolean.valueOf(z));
        if (z) {
            atc = c6750i.atc();
            hashMap.put("rawPath", atc);
            hashMap.put("path", C8874h.m15847bO(atc));
            hashMap.put(SearchIntents.EXTRA_QUERY, C8874h.m15848bP(atc));
        } else {
            atc = c6750i.asV().getCurrentUrl();
        }
        C4990ab.m7417i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", hashMap.get("path"), hashMap.get(SearchIntents.EXTRA_QUERY), hashMap.get("relaunch"), atc);
        C32192i.m52509d(hashMap);
        mo34958t(hashMap).mo61031i(c6750i.mo15032xT()).aCj();
        AppMethodBeat.m2505o(87065);
    }
}
