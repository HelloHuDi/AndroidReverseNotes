package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.xweb.c.g;

public final class j implements g {
    public final void deleteOrigin(String str) {
        AppMethodBeat.i(84882);
        WebStorage.getInstance().deleteOrigin(str);
        AppMethodBeat.o(84882);
    }
}
