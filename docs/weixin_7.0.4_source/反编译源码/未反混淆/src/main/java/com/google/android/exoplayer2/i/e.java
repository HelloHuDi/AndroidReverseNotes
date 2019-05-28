package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    private boolean RP;

    public final synchronized boolean open() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(95873);
            if (this.RP) {
                z = false;
                AppMethodBeat.o(95873);
            } else {
                this.RP = true;
                notifyAll();
                AppMethodBeat.o(95873);
            }
        }
        return z;
    }

    public final synchronized boolean tw() {
        boolean z;
        z = this.RP;
        this.RP = false;
        return z;
    }

    public final synchronized void block() {
        AppMethodBeat.i(95874);
        while (!this.RP) {
            wait();
        }
        AppMethodBeat.o(95874);
    }
}
