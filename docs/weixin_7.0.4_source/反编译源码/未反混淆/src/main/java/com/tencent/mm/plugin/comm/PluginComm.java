package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.pluginsdk.g.a.c.o;

public class PluginComm extends f implements c, a {
    public void configure(g gVar) {
    }

    public void execute(g gVar) {
        AppMethodBeat.i(79088);
        if (gVar.SG()) {
            pin(com.tencent.mm.plugin.a.aob());
            pin(com.tencent.mm.plugin.g.a.beP());
            pin(com.tencent.mm.plugin.h.a.bic());
            pin(com.tencent.mm.plugin.i.c.bGE());
            pin(b.bGD());
            pin(com.tencent.mm.plugin.t.a.bZt());
            pin(com.tencent.mm.plugin.m.b.bOh());
            pin(com.tencent.mm.plugin.c.a.ask());
            pin(com.tencent.mm.plugin.s.a.bYF());
            pin(com.tencent.mm.plugin.r.a.bVs());
            pin(o.vfu);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.m.a.a.class, new com.tencent.mm.plugin.m.a());
            ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.g.a.beP());
            com.tencent.mm.ui.e.a.a.a(new com.tencent.mm.ui.e.a.b() {
                public final void b(ImageView imageView, String str) {
                    AppMethodBeat.i(79087);
                    com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
                    AppMethodBeat.o(79087);
                }
            });
        }
        AppMethodBeat.o(79088);
    }

    public void onAccountInitialized(e.c cVar) {
    }

    public void onAccountRelease() {
    }
}
