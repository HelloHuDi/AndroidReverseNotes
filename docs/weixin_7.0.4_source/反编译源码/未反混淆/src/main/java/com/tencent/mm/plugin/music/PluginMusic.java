package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.music.a.a;
import com.tencent.mm.plugin.music.b.a.d;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class PluginMusic extends f implements a {
    public void installed() {
        AppMethodBeat.i(104809);
        alias(a.class);
        AppMethodBeat.o(104809);
    }

    public String name() {
        return "plugin-music";
    }

    public void configure(g gVar) {
        AppMethodBeat.i(104810);
        b.init(ah.getContext());
        b.a(c.class, new com.tencent.mm.plugin.music.model.a.c());
        b.a(d.class, new com.tencent.mm.plugin.music.b.a.c());
        b.a(com.tencent.mm.plugin.music.e.b.class, new l());
        com.tencent.mm.plugin.music.b.d.init();
        com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
        if (gVar.SG()) {
            ab.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
            pin(new q(e.class));
        }
        AppMethodBeat.o(104810);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(104811);
        if (gVar.SG()) {
            ab.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
            com.tencent.mm.bp.c.aks("music");
        }
        AppMethodBeat.o(104811);
    }

    public void uninstalled() {
        AppMethodBeat.i(104812);
        super.uninstalled();
        com.tencent.mm.plugin.music.b.d.release();
        b.L(c.class);
        b.L(d.class);
        b.L(com.tencent.mm.plugin.music.e.b.class);
        b.release();
        AppMethodBeat.o(104812);
    }
}
