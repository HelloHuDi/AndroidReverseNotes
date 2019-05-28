package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.plugin.downloader_app.b.j;

public class PluginDownloaderApp extends f implements c, com.tencent.mm.plugin.downloader_app.a.f {
    public void execute(g gVar) {
        AppMethodBeat.i(136027);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(e.class, new c());
            com.tencent.mm.kernel.g.a(d.class, new b());
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.downloader_app.a.c.class, new a());
        }
        AppMethodBeat.o(136027);
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(136028);
        com.tencent.mm.plugin.downloader_app.b.d.bie();
        j.biO();
        AppMethodBeat.o(136028);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(136029);
        com.tencent.mm.plugin.downloader_app.b.d.bgr();
        j.stop();
        AppMethodBeat.o(136029);
    }
}
