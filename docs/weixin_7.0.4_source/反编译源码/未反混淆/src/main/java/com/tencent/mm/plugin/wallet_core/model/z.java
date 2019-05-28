package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;

public final class z {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";

    public static void acA(String str) {
        AppMethodBeat.i(46909);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, (Object) str);
        AppMethodBeat.o(46909);
    }
}
