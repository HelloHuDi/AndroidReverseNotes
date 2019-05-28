package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gg;

public class bk {
    private cg a = null;

    public bk(cg cgVar) {
        this.a = cgVar;
    }

    public void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public gg b() {
        AppMethodBeat.i(100838);
        if (this.a == null) {
            AppMethodBeat.o(100838);
            return null;
        }
        gg f = this.a.f();
        AppMethodBeat.o(100838);
        return f;
    }
}
