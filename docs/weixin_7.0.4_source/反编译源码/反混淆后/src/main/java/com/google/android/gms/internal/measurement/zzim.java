package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzim implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzim(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69325);
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to send app launch");
            AppMethodBeat.m2505o(69325);
            return;
        }
        try {
            zzd.zza(this.zzane);
            this.zzape.zza(zzd, null, this.zzane);
            zzii.zze(this.zzape);
            AppMethodBeat.m2505o(69325);
        } catch (RemoteException e) {
            this.zzape.zzge().zzim().zzg("Failed to send app launch to the service", e);
            AppMethodBeat.m2505o(69325);
        }
    }
}
