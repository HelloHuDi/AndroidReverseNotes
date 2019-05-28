package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzin implements Runnable {
    private final /* synthetic */ zzie zzaow;
    private final /* synthetic */ zzii zzape;

    zzin(zzii zzii, zzie zzie) {
        this.zzape = zzii;
        this.zzaow = zzie;
    }

    public final void run() {
        AppMethodBeat.m2504i(69326);
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Failed to send current screen to service");
            AppMethodBeat.m2505o(69326);
            return;
        }
        try {
            if (this.zzaow == null) {
                zzd.zza(0, null, null, this.zzape.getContext().getPackageName());
            } else {
                zzd.zza(this.zzaow.zzaoj, this.zzaow.zzul, this.zzaow.zzaoi, this.zzape.getContext().getPackageName());
            }
            zzii.zze(this.zzape);
            AppMethodBeat.m2505o(69326);
        } catch (RemoteException e) {
            this.zzape.zzge().zzim().zzg("Failed to send current screen to the service", e);
            AppMethodBeat.m2505o(69326);
        }
    }
}
