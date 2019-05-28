package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzip implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzip(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69328);
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Failed to send measurementEnabled to service");
            AppMethodBeat.m2505o(69328);
            return;
        }
        try {
            zzd.zzb(this.zzane);
            zzii.zze(this.zzape);
            AppMethodBeat.m2505o(69328);
        } catch (RemoteException e) {
            this.zzape.zzge().zzim().zzg("Failed to send measurementEnabled to the service", e);
            AppMethodBeat.m2505o(69328);
        }
    }
}
