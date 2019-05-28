package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fav.ui.b.d;
import com.tencent.mm.plugin.fav.ui.c.a;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI extends f implements b, c {
    private a mkV = new a();
    private a mkW = new a();
    private m mkX = new m();

    public PluginFavUI() {
        AppMethodBeat.i(74289);
        AppMethodBeat.o(74289);
    }

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(74290);
        this.mkV.dnU();
        this.mkW.dnU();
        this.mkX.dnU();
        ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                AppMethodBeat.i(74288);
                ((n) com.tencent.mm.kernel.g.M(n.class)).registerFTSUILogic(new d());
                ((n) com.tencent.mm.kernel.g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fav.ui.b.b());
                AppMethodBeat.o(74288);
                return true;
            }

            public final String getName() {
                return "InitFTSFavUIPluginTask";
            }
        });
        AppMethodBeat.o(74290);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(74291);
        this.mkV.dead();
        this.mkW.dead();
        this.mkX.dead();
        AppMethodBeat.o(74291);
    }
}
