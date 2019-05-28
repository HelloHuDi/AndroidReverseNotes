package com.tencent.mm.plugin.forcenotify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.forcenotify.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;

public class PluginForceNotify extends f implements a, c, com.tencent.mm.plugin.forcenotify.a.c {
    public static HashMap<Integer, d> eaA = new HashMap();

    public void installed() {
        AppMethodBeat.i(51010);
        alias(com.tencent.mm.plugin.forcenotify.a.c.class);
        AppMethodBeat.o(51010);
    }

    public void dependency() {
        AppMethodBeat.i(51011);
        dependsOn(p.class);
        AppMethodBeat.o(51011);
    }

    static {
        AppMethodBeat.i(51014);
        final String[] strArr = new String[]{j.a(b.ccO, "ForceNotifyInfo")};
        eaA.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return strArr;
            }
        });
        AppMethodBeat.o(51014);
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return eaA;
    }

    public void configure(g gVar) {
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(51012);
        com.tencent.mm.plugin.forcenotify.b.c.mtf.start();
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.forcenotify.a.b.class, com.tencent.mm.plugin.forcenotify.b.c.mtf);
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.forcenotify.a.a.class, com.tencent.mm.plugin.forcenotify.b.b.mtb);
        AppMethodBeat.o(51012);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(51013);
        com.tencent.mm.plugin.forcenotify.b.c.mtf.release();
        com.tencent.mm.kernel.g.L(com.tencent.mm.plugin.forcenotify.a.b.class);
        AppMethodBeat.o(51013);
    }
}
