package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.welab.b.b;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class PluginWelab extends f implements a, c, d, com.tencent.mm.plugin.welab.a.a {
    private b uLM = new b();
    private boolean uLN;

    public PluginWelab() {
        AppMethodBeat.i(80518);
        AppMethodBeat.o(80518);
    }

    public void installed() {
        AppMethodBeat.i(80519);
        alias(com.tencent.mm.plugin.welab.a.a.class);
        AppMethodBeat.o(80519);
    }

    public void dependency() {
        AppMethodBeat.i(80520);
        dependsOn(p.class);
        AppMethodBeat.o(80520);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(80521);
        if (gVar.SG()) {
            ab.v("PluginWelab", "configure");
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new e(new c()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.b.a.class, new e(new b()));
            ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
                public final void a(j.f fVar, j.g gVar, boolean z) {
                    AppMethodBeat.i(80516);
                    a.ddj();
                    a.Z(PluginWelab.this.uLN, !z);
                    AppMethodBeat.o(80516);
                }

                public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
                }
            });
            AppMethodBeat.o(80521);
            return;
        }
        AppMethodBeat.o(80521);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(80522);
        ab.v("PluginWelab", "execute");
        AppMethodBeat.o(80522);
    }

    public String toString() {
        return "plugin-welab";
    }

    public void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(80523);
        ab.v("PluginWelab", "onDataBaseOpened");
        a.ddj().uLQ = new com.tencent.mm.plugin.welab.d.a(hVar);
        AppMethodBeat.o(80523);
    }

    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(80524);
        ab.v("PluginWelab", "onAccountInitialized");
        ah.getContext();
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
        this.uLN = cVar.eKe;
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("newabtestlabs", this.uLM, true);
        AppMethodBeat.o(80524);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(80525);
        ab.v("PluginWelab", "onAccountRelease");
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("newabtestlabs", this.uLM, true);
        AppMethodBeat.o(80525);
    }

    public HashMap<Integer, h.d> collectDatabaseFactory() {
        AppMethodBeat.i(80526);
        ab.v("PluginWelab", "collectDatabaseFactory");
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new h.d() {
            public final String[] Af() {
                AppMethodBeat.i(80517);
                String[] strArr = new String[]{com.tencent.mm.sdk.e.j.a(com.tencent.mm.plugin.welab.d.a.a.ccO, "LabAppInfo")};
                AppMethodBeat.o(80517);
                return strArr;
            }
        });
        AppMethodBeat.o(80526);
        return hashMap;
    }
}
