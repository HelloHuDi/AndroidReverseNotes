package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class mc extends RuntimeException {
    public mc(String str, Throwable th) {
        super(str, th);
    }

    public mc(Throwable th) {
        super(th.getMessage(), th);
        AppMethodBeat.i(100503);
        AppMethodBeat.o(100503);
    }
}
