package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class k extends c<hp> {
    public k() {
        AppMethodBeat.i(45839);
        this.xxI = hp.class.getName().hashCode();
        AppMethodBeat.o(45839);
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        AppMethodBeat.i(45840);
        hp hpVar = (hp) bVar;
        if (hpVar instanceof hp) {
            hpVar.cCu.cCw = r.cPI().cQn();
            String bhp = r.cPI().bhp();
            if (bo.isNullOrNil(bhp)) {
                hpVar.cCu.cCv = "";
            } else {
                String str = "";
                while (i < bhp.length() - 1) {
                    str = str + "*";
                    i++;
                }
                hpVar.cCu.cCv = str + bhp.substring(bhp.length() - 1, bhp.length());
            }
            AppMethodBeat.o(45840);
            return true;
        }
        AppMethodBeat.o(45840);
        return false;
    }
}
