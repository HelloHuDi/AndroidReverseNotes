package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.u */
final class C37308u {
    private final PendingResult bwr;
    private final ScheduledFuture<?> bws;
    final Intent intent;
    private boolean zzt = false;

    C37308u(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.m2504i(108774);
        this.intent = intent;
        this.bwr = pendingResult;
        this.bws = scheduledExecutorService.schedule(new C32103v(this, intent), 9500, TimeUnit.MILLISECONDS);
        AppMethodBeat.m2505o(108774);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void finish() {
        AppMethodBeat.m2504i(108775);
        if (!this.zzt) {
            this.bwr.finish();
            this.bws.cancel(false);
            this.zzt = true;
        }
        AppMethodBeat.m2505o(108775);
    }
}
