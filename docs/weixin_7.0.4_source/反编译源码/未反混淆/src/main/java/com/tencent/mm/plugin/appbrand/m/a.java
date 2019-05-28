package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.m.b.b;
import com.tencent.mm.plugin.appbrand.m.c.d;
import com.tencent.mm.plugin.appbrand.m.c.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.m.b.a {
    private static Set<String> ipP;

    static {
        AppMethodBeat.i(132325);
        e.iqg = new com.tencent.mm.plugin.appbrand.m.c.e.a() {
            public final void X(int i, String str) {
                AppMethodBeat.i(132322);
                h.pYm.X(i, str);
                AppMethodBeat.o(132322);
            }
        };
        d.iqf = new com.tencent.mm.plugin.appbrand.m.c.d.a() {
            public final void M(int i, int i2, int i3) {
                AppMethodBeat.i(132323);
                h.pYm.k((long) i, (long) i2, (long) i3);
                AppMethodBeat.o(132323);
            }
        };
        b.a(new com.tencent.mm.plugin.appbrand.m.b.b.a() {
            public final void a(i iVar, JSONObject jSONObject) {
                AppMethodBeat.i(132324);
                try {
                    jSONObject.put("notSupport", a.ipP.contains(ag.ck(iVar.mAppId)));
                    jSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_nodejs_websocket_open, 0));
                    jSONObject.put("switchFs", ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_nodejs_fs_open, 0));
                    AppMethodBeat.o(132324);
                } catch (JSONException e) {
                    AppMethodBeat.o(132324);
                }
            }
        });
        HashSet hashSet = new HashSet();
        ipP = hashSet;
        hashSet.add(ag.ck("wxa51f55ab3b2655b9"));
        ipP.add(ag.ck("wx5b5555f4b7c7824b"));
        ipP.add(ag.ck("wx8c67c6eee918d4ea"));
        ipP.add(ag.ck("wx577c74fb940daaea"));
        ipP.add(ag.ck("wx7d9e9cbea92ce71f"));
        ipP.add(ag.ck("wx850d691fd02de8a1"));
        AppMethodBeat.o(132325);
    }
}
