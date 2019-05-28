package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;

public final class j {
    private static j ces;
    HandlerThread cet;
    d ceu;
    ak handler = new ak(this.cet.getLooper());

    public static j Bm() {
        AppMethodBeat.i(15380);
        if (ces == null) {
            ces = new j("initThread");
        }
        j jVar = ces;
        AppMethodBeat.o(15380);
        return jVar;
    }

    private j(String str) {
        AppMethodBeat.i(15381);
        this.cet = com.tencent.mm.sdk.g.d.ek(str, 10);
        this.cet.start();
        this.ceu = new h(com.tencent.mm.ci.d.c(this.handler), str);
        AppMethodBeat.o(15381);
    }

    public final void Bn() {
        AppMethodBeat.i(15382);
        if (this.cet == null || !this.cet.isAlive()) {
            ab.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            AppMethodBeat.o(15382);
            return;
        }
        int threadId = this.cet.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                ab.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                AppMethodBeat.o(15382);
                return;
            }
            Process.setThreadPriority(threadId, -8);
            ab.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(15382);
        } catch (Exception e) {
            ab.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            ab.printErrStackTrace("MicroMsg.InitThreadController", e, "", new Object[0]);
            AppMethodBeat.o(15382);
        }
    }
}
