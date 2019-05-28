package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends c<ic> {
    public e() {
        AppMethodBeat.i(35608);
        this.xxI = ic.class.getName().hashCode();
        AppMethodBeat.o(35608);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35609);
        ic icVar = (ic) bVar;
        if (icVar instanceof ic) {
            if (icVar.cDb.cAd == 0) {
                g.RQ();
                g.RO().eJo.a(new v(1), 0);
            } else {
                g.RQ();
                g.RO().eJo.a(new v(icVar.cDb.cAd), 0);
            }
            AppMethodBeat.o(35609);
            return true;
        }
        ab.f("MicroMsg.GetSnsTagListListener", "mismatched event");
        AppMethodBeat.o(35609);
        return false;
    }
}
