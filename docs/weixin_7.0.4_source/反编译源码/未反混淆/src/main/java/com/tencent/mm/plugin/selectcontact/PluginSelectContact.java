package com.tencent.mm.plugin.selectcontact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.contact.s;

public class PluginSelectContact extends f implements c, a {
    private com.tencent.mm.sdk.b.c qjs = new com.tencent.mm.sdk.b.c<cq>() {
        {
            AppMethodBeat.i(105150);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(105150);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(105151);
            s.init();
            AppMethodBeat.o(105151);
            return false;
        }
    };

    public PluginSelectContact() {
        AppMethodBeat.i(105152);
        AppMethodBeat.o(105152);
    }

    public String name() {
        return "plugin-selectcontact";
    }

    public void installed() {
        AppMethodBeat.i(105153);
        alias(PluginSelectContact.class);
        AppMethodBeat.o(105153);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(105154);
        gVar.SG();
        AppMethodBeat.o(105154);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(105155);
        gVar.SG();
        AppMethodBeat.o(105155);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(105156);
        s.init();
        this.qjs.dnU();
        AppMethodBeat.o(105156);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(105157);
        this.qjs.dead();
        AppMethodBeat.o(105157);
    }
}
