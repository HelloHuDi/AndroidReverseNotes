package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends c<ga> {
    public f() {
        AppMethodBeat.i(108329);
        this.xxI = ga.class.getName().hashCode();
        AppMethodBeat.o(108329);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(108330);
        ga gaVar = (ga) bVar;
        gaVar.cAk.cAl = l.wf(gaVar.cAj.cAg);
        if (bo.isNullOrNil(gaVar.cAk.cAl)) {
            gaVar.cAk.cAl = l.wf(gaVar.cAj.cAh);
        }
        AppMethodBeat.o(108330);
        return false;
    }
}
