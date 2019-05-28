package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzil implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzil(zzii zzii, AtomicReference atomicReference, zzdz zzdz) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(69324);
        synchronized (this.zzapf) {
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().log("Failed to get app instance id");
                    this.zzapf.notify();
                    AppMethodBeat.o(69324);
                    return;
                }
                this.zzapf.set(zzd.zzc(this.zzane));
                String str = (String) this.zzapf.get();
                if (str != null) {
                    this.zzape.zzfu().zzbr(str);
                    this.zzape.zzgf().zzakb.zzbs(str);
                }
                zzii.zze(this.zzape);
                this.zzapf.notify();
            } catch (RemoteException e) {
                this.zzape.zzge().zzim().zzg("Failed to get app instance id", e);
                this.zzapf.notify();
            } catch (Throwable th) {
                AppMethodBeat.o(69324);
            }
        }
        AppMethodBeat.o(69324);
    }
}
