package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    private long iRu;
    private long iRv;
    private a iRw;

    public interface a {
        boolean j(Object... objArr);
    }

    public j(long j, a aVar) {
        this.iRu = j;
        this.iRw = aVar;
    }

    private boolean aOa() {
        AppMethodBeat.i(126636);
        if (System.currentTimeMillis() - this.iRv < this.iRu) {
            AppMethodBeat.o(126636);
            return true;
        }
        AppMethodBeat.o(126636);
        return false;
    }

    public final boolean l(Object... objArr) {
        boolean z = false;
        AppMethodBeat.i(126637);
        if (aOa()) {
            AppMethodBeat.o(126637);
        } else if (this.iRw == null) {
            AppMethodBeat.o(126637);
        } else {
            z = this.iRw.j(objArr);
            if (z) {
                this.iRv = System.currentTimeMillis();
            }
            AppMethodBeat.o(126637);
        }
        return z;
    }
}
