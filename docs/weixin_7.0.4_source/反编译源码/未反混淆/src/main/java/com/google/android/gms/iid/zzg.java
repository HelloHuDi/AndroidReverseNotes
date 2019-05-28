package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzg {
    final Intent intent;
    private final PendingResult zzbe;
    private boolean zzbf = false;
    private final ScheduledFuture<?> zzbg;

    zzg(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(57564);
        this.intent = intent;
        this.zzbe = pendingResult;
        this.zzbg = scheduledExecutorService.schedule(new zzh(this, intent), 9500, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(57564);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void finish() {
        AppMethodBeat.i(57565);
        if (!this.zzbf) {
            this.zzbe.finish();
            this.zzbg.cancel(false);
            this.zzbf = true;
        }
        AppMethodBeat.o(57565);
    }
}
