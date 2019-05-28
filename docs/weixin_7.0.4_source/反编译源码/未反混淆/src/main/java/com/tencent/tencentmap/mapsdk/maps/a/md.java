package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class md extends RuntimeException {
    public md(Throwable th) {
        super(th.getMessage(), th);
        AppMethodBeat.i(100504);
        AppMethodBeat.o(100504);
    }
}
