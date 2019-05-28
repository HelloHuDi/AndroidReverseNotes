package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;

public final class b extends q implements c {
    private static b gpL;
    private d gpM = new d();
    private a gpN = new a();

    private b() {
        super(g.class);
        AppMethodBeat.i(118188);
        AppMethodBeat.o(118188);
    }

    public static synchronized b aoM() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(118189);
            if (gpL == null) {
                gpL = new b();
            }
            bVar = gpL;
            AppMethodBeat.o(118189);
        }
        return bVar;
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(118190);
        super.onAccountInitialized(cVar);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(-1879048184), this.gpM);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("abtest", this.gpN);
        AppMethodBeat.o(118190);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(118191);
        super.onAccountRelease();
        com.tencent.mm.ai.e.d.a(Integer.valueOf(-1879048184), this.gpM);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("abtest", this.gpN);
        AppMethodBeat.o(118191);
    }
}
