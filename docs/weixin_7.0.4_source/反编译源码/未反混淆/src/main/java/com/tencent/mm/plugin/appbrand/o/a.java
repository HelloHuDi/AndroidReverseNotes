package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.c;

public final class a {
    public static boolean aLC() {
        boolean z;
        AppMethodBeat.i(132712);
        c ll = com.tencent.mm.model.c.c.abi().ll("100159");
        if (ll.isValid() && "1".equals(ll.dru().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(132712);
            return false;
        }
        AppMethodBeat.o(132712);
        return true;
    }
}
