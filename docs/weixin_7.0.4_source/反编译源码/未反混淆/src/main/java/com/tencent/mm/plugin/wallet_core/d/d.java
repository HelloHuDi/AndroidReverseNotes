package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d extends j<u> {
    public static final String[] fnj = new String[]{j.a(u.ccO, "WalletBulletin")};
    public e bSd;

    static {
        AppMethodBeat.i(47072);
        AppMethodBeat.o(47072);
    }

    public d(e eVar) {
        super(eVar, u.ccO, "WalletBulletin", null);
        this.bSd = eVar;
    }
}
