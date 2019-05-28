package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.commlib.a.a;
import com.tencent.mm.plugin.game.commlib.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginCommLib extends f implements c, b {
    private com.tencent.mm.sdk.b.c lOc = new com.tencent.mm.sdk.b.c<jt>() {
        {
            AppMethodBeat.i(59410);
            this.xxI = jt.class.getName().hashCode();
            AppMethodBeat.o(59410);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(59411);
            ab.i("MicroMsg.PluginCommLib", "manual force login");
            b.bDn().hI(true);
            AppMethodBeat.o(59411);
            return false;
        }
    };

    public PluginCommLib() {
        AppMethodBeat.i(59412);
        AppMethodBeat.o(59412);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(59414);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(a.class, new d());
        }
        AppMethodBeat.o(59414);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(59415);
        com.tencent.mm.sdk.b.a.xxA.b(this.lOc);
        AppMethodBeat.o(59415);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(59416);
        com.tencent.mm.sdk.b.a.xxA.d(this.lOc);
        com.tencent.mm.plugin.game.commlib.d.a.aNR();
        AppMethodBeat.o(59416);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(59413);
        e.NL(gVar.eHT);
        AppMethodBeat.o(59413);
    }
}
