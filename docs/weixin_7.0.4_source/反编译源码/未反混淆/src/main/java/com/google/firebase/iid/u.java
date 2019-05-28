package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class u {
    private final PendingResult bwr;
    private final ScheduledFuture<?> bws;
    final Intent intent;
    private boolean zzt = false;

    u(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(108774);
        this.intent = intent;
        this.bwr = pendingResult;
        this.bws = scheduledExecutorService.schedule(new v(this, intent), 9500, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(108774);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void finish() {
        AppMethodBeat.i(108775);
        if (!this.zzt) {
            this.bwr.finish();
            this.bws.cancel(false);
            this.zzt = true;
        }
        AppMethodBeat.o(108775);
    }
}
