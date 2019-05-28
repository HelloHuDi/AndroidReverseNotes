package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzhx implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhx(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        AppMethodBeat.m2504i(69229);
        synchronized (this.zzanv) {
            try {
                AtomicReference atomicReference = this.zzanv;
                zzef zzgg = this.zzanw.zzgg();
                atomicReference.set(Integer.valueOf(zzgg.zzb(zzgg.zzfv().zzah(), zzew.zzahs)));
                this.zzanv.notify();
            } catch (Throwable th) {
                this.zzanv.notify();
            } finally {
                AppMethodBeat.m2505o(69229);
            }
        }
    }
}
