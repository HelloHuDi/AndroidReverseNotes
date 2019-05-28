package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzir implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ boolean zzapg = true;
    private final /* synthetic */ boolean zzaph;
    private final /* synthetic */ zzed zzapi;
    private final /* synthetic */ zzed zzapj;

    zzir(zzii zzii, boolean z, boolean z2, zzed zzed, zzdz zzdz, zzed zzed2) {
        this.zzape = zzii;
        this.zzaph = z2;
        this.zzapi = zzed;
        this.zzane = zzdz;
        this.zzapj = zzed2;
    }

    public final void run() {
        AppMethodBeat.m2504i(69330);
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to send conditional user property to service");
            AppMethodBeat.m2505o(69330);
            return;
        }
        if (this.zzapg) {
            this.zzape.zza(zzd, this.zzaph ? null : this.zzapi, this.zzane);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzapj.packageName)) {
                    zzd.zza(this.zzapi, this.zzane);
                } else {
                    zzd.zzb(this.zzapi);
                }
            } catch (RemoteException e) {
                this.zzape.zzge().zzim().zzg("Failed to send conditional user property to the service", e);
            }
        }
        zzii.zze(this.zzape);
        AppMethodBeat.m2505o(69330);
    }
}
