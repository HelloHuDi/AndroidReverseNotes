package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    public boolean cFy = false;

    public void start() {
        AppMethodBeat.i(21881);
        reset();
        this.cFy = true;
        AppMethodBeat.o(21881);
    }

    public void reset() {
    }

    /* Access modifiers changed, original: protected */
    public void bHT() {
    }

    public final void finish() {
        AppMethodBeat.i(21882);
        if (this.cFy) {
            bHT();
            this.cFy = false;
        }
        AppMethodBeat.o(21882);
    }
}
