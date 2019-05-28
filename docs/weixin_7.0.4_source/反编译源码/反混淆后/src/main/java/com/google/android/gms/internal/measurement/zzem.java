package com.google.android.gms.internal.measurement;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

abstract class zzem {
    private static volatile Handler handler;
    private final zzhi zzafj;
    private final Runnable zzyd;
    private volatile long zzye;

    zzem(zzhi zzhi) {
        Preconditions.checkNotNull(zzhi);
        this.zzafj = zzhi;
        this.zzyd = new zzen(this, zzhi);
    }

    private final Handler getHandler() {
        if (handler != null) {
            return handler;
        }
        Handler handler;
        synchronized (zzem.class) {
            if (handler == null) {
                handler = new Handler(this.zzafj.getContext().getMainLooper());
            }
            handler = handler;
        }
        return handler;
    }

    /* Access modifiers changed, original: final */
    public final void cancel() {
        this.zzye = 0;
        getHandler().removeCallbacks(this.zzyd);
    }

    public abstract void run();

    public final boolean zzef() {
        return this.zzye != 0;
    }

    public final void zzh(long j) {
        cancel();
        if (j >= 0) {
            this.zzye = this.zzafj.zzbt().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzyd, j)) {
                this.zzafj.zzge().zzim().zzg("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
