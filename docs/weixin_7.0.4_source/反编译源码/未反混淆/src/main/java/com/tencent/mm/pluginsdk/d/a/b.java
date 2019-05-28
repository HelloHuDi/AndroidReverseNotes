package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b {
    private CountDownLatch vaN = null;

    public final void countDown() {
        AppMethodBeat.i(27230);
        if (this.vaN != null) {
            this.vaN.countDown();
            this.vaN = null;
        }
        AppMethodBeat.o(27230);
    }

    public final void b(long j, Runnable runnable) {
        AppMethodBeat.i(27231);
        ab.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.vaN == null) {
            this.vaN = new CountDownLatch(1);
        }
        al.d(runnable);
        ab.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.vaN != null) {
            try {
                this.vaN.await(j, TimeUnit.MILLISECONDS);
                AppMethodBeat.o(27231);
                return;
            } catch (InterruptedException e) {
                ab.w("MicroMsg.SyncJob", e.getMessage());
                ab.printErrStackTrace("MicroMsg.SyncJob", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(27231);
    }
}
