package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;

public final class al {
    public static boolean aFF() {
        AppMethodBeat.i(47002);
        g.RQ();
        if (((Boolean) g.RP().Ry().get(a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.o(47002);
            return false;
        }
        AppMethodBeat.o(47002);
        return true;
    }
}
