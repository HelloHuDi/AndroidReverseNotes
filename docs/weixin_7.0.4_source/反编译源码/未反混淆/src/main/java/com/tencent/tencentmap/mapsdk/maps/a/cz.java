package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class cz implements Runnable {
    private /* synthetic */ cs a;
    private /* synthetic */ long b;
    private /* synthetic */ cy c;

    cz(cy cyVar, cs csVar, long j) {
        this.c = cyVar;
        this.a = csVar;
        this.b = j;
    }

    public final void run() {
        boolean z = false;
        AppMethodBeat.i(98687);
        try {
            cv a = this.a.a();
            this.a.k = SystemClock.elapsedRealtime() - this.b;
            this.a.a(false);
            if (a.a == 0 && a.c == 200) {
                z = true;
            }
            cy.a(this.c, z);
            AppMethodBeat.o(98687);
        } catch (Throwable th) {
            cy.a(this.c, false);
            AppMethodBeat.o(98687);
            throw th;
        }
    }
}
