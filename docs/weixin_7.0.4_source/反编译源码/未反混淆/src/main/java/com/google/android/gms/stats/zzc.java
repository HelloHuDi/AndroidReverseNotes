package com.google.android.gms.stats;

import com.google.android.gms.stats.WakeLock.HeldLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzc implements Runnable {
    private final /* synthetic */ WeakReference zzaej;

    zzc(WeakReference weakReference) {
        this.zzaej = weakReference;
    }

    public final void run() {
        AppMethodBeat.i(113996);
        HeldLock heldLock = (HeldLock) this.zzaej.get();
        if (heldLock != null) {
            heldLock.release(0);
        }
        AppMethodBeat.o(113996);
    }
}
