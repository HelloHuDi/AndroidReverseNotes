package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bm {
    private bt a;

    public final void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public final void b() {
        AppMethodBeat.i(100841);
        if (this.a == null) {
            AppMethodBeat.o(100841);
            return;
        }
        this.a.b();
        AppMethodBeat.o(100841);
    }
}
