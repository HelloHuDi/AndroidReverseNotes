package com.tencent.mm.plugin.fts.ui;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.d;
import com.tencent.mm.plugin.fts.ui.b.h;
import com.tencent.mm.plugin.fts.ui.b.i;
import com.tencent.mm.plugin.fts.ui.b.j;
import com.tencent.mm.plugin.fts.ui.b.k;

public class PluginFTSUI extends f implements b, c {
    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(61965);
        registerUILogic();
        AppMethodBeat.o(61965);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(61966);
        ((n) g.M(n.class)).unregisterFTSUILogic(16);
        ((n) g.M(n.class)).unregisterFTSUILogic(32);
        ((n) g.M(n.class)).unregisterFTSUILogic(48);
        ((n) g.M(n.class)).unregisterFTSUILogic(64);
        ((n) g.M(n.class)).unregisterFTSUILogic(112);
        ((n) g.M(n.class)).unregisterFTSUILogic(4112);
        ((n) g.M(n.class)).unregisterFTSUILogic(4128);
        ((n) g.M(n.class)).unregisterFTSUILogic(4176);
        ((n) g.M(n.class)).unregisterFTSUILogic(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        ((n) g.M(n.class)).unregisterFTSUILogic(160);
        AppMethodBeat.o(61966);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    private void registerUILogic() {
        AppMethodBeat.i(61967);
        ((n) g.M(n.class)).registerFTSUILogic(new k());
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.e());
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.c());
        ((n) g.M(n.class)).registerFTSUILogic(new h());
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.g());
        ((n) g.M(n.class)).registerFTSUILogic(new j());
        ((n) g.M(n.class)).registerFTSUILogic(new d());
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.b());
        ((n) g.M(n.class)).registerFTSUILogic(new i());
        ((n) g.M(n.class)).registerFTSUILogic(new a());
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fts.ui.b.f());
        AppMethodBeat.o(61967);
    }
}
