package com.tencent.mm.plugin.clean.c.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b implements c {
    public HashMap<Long, ak> kwM;
    private HashSet<Long> kwN;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        AppMethodBeat.i(18727);
        this.kwN = new HashSet(5);
        this.kwM = new HashMap(5);
        for (int i = 0; i <= 5; i++) {
            d.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18726);
                    Looper.prepare();
                    b.this.kwM.put(Long.valueOf(Thread.currentThread().getId()), new ak(Looper.myLooper()));
                    Looper.loop();
                    AppMethodBeat.o(18726);
                }
            }, "ThreadController_handler", 1).start();
        }
        AppMethodBeat.o(18727);
    }

    private synchronized void e(Long l) {
        AppMethodBeat.i(18729);
        if (this.kwN.remove(l)) {
            ab.d("MicroMsg.ThreadController", "thread is idle, id=%d", l);
        }
        AppMethodBeat.o(18729);
    }

    public final void f(Long l) {
        AppMethodBeat.i(18730);
        e(l);
        AppMethodBeat.o(18730);
    }

    public final synchronized boolean b(a aVar) {
        boolean z;
        AppMethodBeat.i(18728);
        aVar.kwL = this;
        ab.d("MicroMsg.ThreadController", "running threads %s", this.kwN.toString());
        for (Entry entry : this.kwM.entrySet()) {
            if (!this.kwN.contains(entry.getKey())) {
                ((ak) entry.getValue()).post(aVar);
                this.kwN.add(entry.getKey());
                AppMethodBeat.o(18728);
                z = true;
                break;
            }
        }
        AppMethodBeat.o(18728);
        z = false;
        return z;
    }
}
