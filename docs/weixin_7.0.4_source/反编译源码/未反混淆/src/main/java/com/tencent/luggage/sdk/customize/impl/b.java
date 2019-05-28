package com.tencent.luggage.sdk.customize.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.q.a;

public final class b implements a {
    public final String xJ() {
        return " Luggage/";
    }

    public final String xK() {
        AppMethodBeat.i(114301);
        String format = String.format("%s-nano", new Object[]{"unknown"});
        AppMethodBeat.o(114301);
        return format;
    }
}
