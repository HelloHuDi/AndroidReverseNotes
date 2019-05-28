package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class an implements Runnable {
    private final aj bwX;
    private final c bwY;

    an(aj ajVar, c cVar) {
        this.bwX = ajVar;
        this.bwY = cVar;
    }

    public final void run() {
        AppMethodBeat.i(108833);
        this.bwX.fk(this.bwY.bvC);
        AppMethodBeat.o(108833);
    }
}
