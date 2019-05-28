package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.storage.ac.a;

public final class ad extends ai {
    public final void transfer(int i) {
        AppMethodBeat.i(129715);
        if (kw(i)) {
            g.RP().Ry().set(a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.FALSE);
        }
        AppMethodBeat.o(129715);
    }

    public final boolean kw(int i) {
        int i2 = 1;
        int i3 = i != 0 ? 1 : 0;
        if (i >= 637927936) {
            i2 = 0;
        }
        return i2 & i3;
    }

    public final String getTag() {
        return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
    }
}
