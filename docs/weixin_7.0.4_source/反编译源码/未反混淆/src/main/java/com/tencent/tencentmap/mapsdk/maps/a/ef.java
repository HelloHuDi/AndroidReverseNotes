package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ef implements Runnable {
    private /* synthetic */ ed a;

    ef(ed edVar) {
        this.a = edVar;
    }

    public final void run() {
        AppMethodBeat.i(98784);
        try {
            ec.c().d().a(this.a.a.a(), ds.a().b());
            AppMethodBeat.o(98784);
        } catch (Throwable th) {
            AppMethodBeat.o(98784);
        }
    }
}
