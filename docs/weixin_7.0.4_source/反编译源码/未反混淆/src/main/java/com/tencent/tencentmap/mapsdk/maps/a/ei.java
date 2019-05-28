package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ei implements Runnable {
    private /* synthetic */ ec a;

    ei(ec ecVar) {
        this.a = ecVar;
    }

    public final void run() {
        AppMethodBeat.i(98788);
        try {
            ce.e();
            a a = ec.a(this.a, ce.b());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - a.a > ((long) ec.a(this.a, a.b)) || elapsedRealtime < a.a) {
                ec.a = 2;
                this.a.e.removeCallbacks(this.a.i);
                this.a.e.post(this.a.i);
            }
            AppMethodBeat.o(98788);
        } catch (Throwable th) {
            AppMethodBeat.o(98788);
            throw th;
        }
    }
}
