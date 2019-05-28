package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends c<fz> {
    public e() {
        AppMethodBeat.i(108327);
        this.xxI = fz.class.getName().hashCode();
        AppMethodBeat.o(108327);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(108328);
        fz fzVar = (fz) bVar;
        if (fzVar instanceof fz) {
            fzVar.cAf.cAi = true;
            if (!bo.isNullOrNil(l.wf(fzVar.cAe.cAg))) {
                fzVar.cAf.cAi = false;
                AppMethodBeat.o(108328);
            } else if (bo.isNullOrNil(l.wf(fzVar.cAe.cAh))) {
                ab.i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
                AppMethodBeat.o(108328);
            } else {
                fzVar.cAf.cAi = false;
                AppMethodBeat.o(108328);
            }
        } else {
            AppMethodBeat.o(108328);
        }
        return false;
    }
}
