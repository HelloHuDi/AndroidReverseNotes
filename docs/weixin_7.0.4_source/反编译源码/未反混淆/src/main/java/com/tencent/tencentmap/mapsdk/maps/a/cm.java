package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class cm {
    private static cm a = new cm();
    private Timer b = new Timer("halley_" + bt.c() + "_" + "ConnectionTimer", true);
    private Map<Runnable, TimerTask> c = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(98653);
        AppMethodBeat.o(98653);
    }

    public static cm a() {
        return a;
    }

    private void a(Runnable runnable, boolean z, long j) {
        AppMethodBeat.i(98651);
        synchronized (runnable) {
            try {
                a(runnable);
                cn cnVar = new cn(this, runnable);
                if (z) {
                    this.b.schedule(cnVar, j, j);
                } else {
                    this.b.schedule(cnVar, j);
                }
                this.c.put(runnable, cnVar);
            } finally {
                AppMethodBeat.o(98651);
            }
        }
    }

    public final void a(Runnable runnable, long j) {
        AppMethodBeat.i(98649);
        a(runnable, false, j);
        AppMethodBeat.o(98649);
    }

    public final boolean a(Runnable runnable) {
        boolean cancel;
        AppMethodBeat.i(98652);
        synchronized (runnable) {
            try {
                TimerTask timerTask = (TimerTask) this.c.get(runnable);
                if (timerTask != null) {
                    this.c.remove(runnable);
                    cancel = timerTask.cancel();
                } else {
                    AppMethodBeat.o(98652);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98652);
            }
        }
        return cancel;
    }

    public final void b(Runnable runnable, long j) {
        AppMethodBeat.i(98650);
        a(runnable, true, j);
        AppMethodBeat.o(98650);
    }

    private cm() {
        AppMethodBeat.i(98648);
        AppMethodBeat.o(98648);
    }
}
