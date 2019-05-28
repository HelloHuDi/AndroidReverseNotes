package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class a implements o {
    public static volatile n gkE;
    public static volatile m gkF;

    public final void a(n nVar) {
        gkE = nVar;
    }

    public final void a(m mVar) {
        AppMethodBeat.i(73678);
        ab.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", mVar);
        gkF = mVar;
        AppMethodBeat.o(73678);
    }
}
