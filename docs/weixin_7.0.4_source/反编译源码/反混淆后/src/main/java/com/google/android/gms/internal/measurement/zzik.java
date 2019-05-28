package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzik implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzik(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69323);
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Failed to reset data on the service; null service");
            AppMethodBeat.m2505o(69323);
            return;
        }
        try {
            zzd.zzd(this.zzane);
        } catch (RemoteException e) {
            this.zzape.zzge().zzim().zzg("Failed to reset data on the service", e);
        }
        zzii.zze(this.zzape);
        AppMethodBeat.m2505o(69323);
    }
}
