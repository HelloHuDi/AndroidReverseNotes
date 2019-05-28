package com.tencent.luggage.bridge;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r {
    private n bOO;

    r(n nVar) {
        this.bOO = nVar;
    }

    @JavascriptInterface
    public final String send(String str, boolean z) {
        AppMethodBeat.i(90746);
        String h = this.bOO.h(str, z);
        AppMethodBeat.o(90746);
        return h;
    }
}
