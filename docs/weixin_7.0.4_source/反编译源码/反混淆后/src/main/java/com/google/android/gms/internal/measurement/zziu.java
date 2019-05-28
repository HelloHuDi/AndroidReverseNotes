package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zziu implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzjx zzanl;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ boolean zzaph;

    zziu(zzii zzii, boolean z, zzjx zzjx, zzdz zzdz) {
        this.zzape = zzii;
        this.zzaph = z;
        this.zzanl = zzjx;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69333);
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to set user attribute");
            AppMethodBeat.m2505o(69333);
            return;
        }
        this.zzape.zza(zzd, this.zzaph ? null : this.zzanl, this.zzane);
        zzii.zze(this.zzape);
        AppMethodBeat.m2505o(69333);
    }
}
