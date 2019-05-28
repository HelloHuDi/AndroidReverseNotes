package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gs.c;

public class is implements ft {
    private final iz a;

    public is(iz izVar) {
        this.a = izVar;
    }

    public void a(c cVar) {
        AppMethodBeat.i(99871);
        if (this.a == null || cVar != c.SCALE_LEVEL_CHANGED) {
            AppMethodBeat.o(99871);
            return;
        }
        this.a.B();
        this.a.C();
        AppMethodBeat.o(99871);
    }
}
