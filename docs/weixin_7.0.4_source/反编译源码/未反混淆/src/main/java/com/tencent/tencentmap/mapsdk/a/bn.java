package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.iz;

public class bn implements bt {
    private bo a;
    private iz b;

    public void a() {
        this.b = null;
    }

    public void b() {
        AppMethodBeat.i(100842);
        if (this.a == null) {
            AppMethodBeat.o(100842);
            return;
        }
        this.a.e();
        this.b.s();
        this.b.h();
        this.a = null;
        AppMethodBeat.o(100842);
    }
}
