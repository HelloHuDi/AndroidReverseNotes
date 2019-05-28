package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ir implements gt {
    private iz a;

    public ir(iz izVar) {
        this.a = izVar;
    }

    public void a(gs gsVar) {
        AppMethodBeat.i(99870);
        if (this.a == null) {
            AppMethodBeat.o(99870);
            return;
        }
        if (gsVar != null) {
            this.a.a(this.a.b().j());
        }
        if (this.a.v != null) {
            this.a.v.sendEmptyMessage(0);
        }
        AppMethodBeat.o(99870);
    }
}
