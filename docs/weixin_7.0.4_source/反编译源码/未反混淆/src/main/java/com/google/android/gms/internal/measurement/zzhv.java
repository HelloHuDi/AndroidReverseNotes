package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzhv implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhv(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        AppMethodBeat.i(69227);
        synchronized (this.zzanv) {
            try {
                this.zzanv.set(this.zzanw.zzgg().zzhm());
                this.zzanv.notify();
            } catch (Throwable th) {
                this.zzanv.notify();
            } finally {
                AppMethodBeat.o(69227);
            }
        }
    }
}
