package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class j {
    HandlerThread handlerThread;
    ak ilv;

    class a extends ak {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(26353);
            d dVar = (d) message.obj;
            if (dVar != null) {
                try {
                    dVar.run();
                    AppMethodBeat.o(26353);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Wear.WearWorker", e.getCause(), "run task %s occur exception", dVar.getName());
                }
            }
            AppMethodBeat.o(26353);
        }
    }

    public j() {
        AppMethodBeat.i(26354);
        if (com.tencent.mm.compatible.util.d.iX(18)) {
            this.handlerThread = com.tencent.mm.sdk.g.d.anM("WearWorker_worker_thread");
            this.handlerThread.start();
            this.ilv = new a(this.handlerThread.getLooper());
            ab.i("MicroMsg.Wear.WearWorker", "start worker %d", Integer.valueOf(this.handlerThread.getThreadId()));
        }
        AppMethodBeat.o(26354);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(26355);
        if (this.ilv != null) {
            this.ilv.sendMessage(this.ilv.obtainMessage(0, dVar));
        }
        AppMethodBeat.o(26355);
    }
}
