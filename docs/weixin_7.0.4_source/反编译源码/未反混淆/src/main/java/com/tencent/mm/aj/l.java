package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l implements o, b, com.tencent.mm.kernel.api.bucket.b, c {
    private o fwE;
    private p fwF;

    public final o XP() {
        return this.fwE;
    }

    public final p XQ() {
        return this.fwF;
    }

    public final String Yf() {
        AppMethodBeat.i(11416);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("brandicon/").toString();
        AppMethodBeat.o(11416);
        return stringBuilder2;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.i(11417);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"brandicon/"});
        AppMethodBeat.o(11417);
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(11418);
        h bOr = ((j) g.K(j.class)).bOr();
        com.tencent.mm.storage.e oVar = new o(bOr);
        this.fwE = oVar;
        bOr.a(oVar);
        this.fwF = new p(((j) g.K(j.class)).XR());
        AppMethodBeat.o(11418);
    }

    public final void onAccountRelease() {
    }

    public final void parallelsDependency() {
        AppMethodBeat.i(11419);
        a.a(this, c.class).aJ(g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class));
        AppMethodBeat.o(11419);
    }
}
