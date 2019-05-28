package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o implements k {
    public final void a(a aVar) {
        AppMethodBeat.i(41556);
        ab.i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
        if (bo.isNullOrNil(v.tCn.msn)) {
            ab.e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
            aVar.aC(-1, "no challenge");
            AppMethodBeat.o(41556);
            return;
        }
        aVar.aC(0, "");
        AppMethodBeat.o(41556);
    }
}
