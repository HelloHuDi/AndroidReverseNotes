package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzig implements Runnable {
    private final /* synthetic */ boolean zzaos;
    private final /* synthetic */ zzie zzaot;
    private final /* synthetic */ zzie zzaou;
    private final /* synthetic */ zzif zzaov;

    zzig(zzif zzif, boolean z, zzie zzie, zzie zzie2) {
        this.zzaov = zzif;
        this.zzaos = z;
        this.zzaot = zzie;
        this.zzaou = zzie2;
    }

    public final void run() {
        AppMethodBeat.m2504i(69274);
        if (this.zzaos && this.zzaov.zzaol != null) {
            zzif.zza(this.zzaov, this.zzaov.zzaol);
        }
        boolean z = (this.zzaot != null && this.zzaot.zzaoj == this.zzaou.zzaoj && zzka.zzs(this.zzaot.zzaoi, this.zzaou.zzaoi) && zzka.zzs(this.zzaot.zzul, this.zzaou.zzul)) ? false : true;
        if (z) {
            Bundle bundle = new Bundle();
            zzif.zza(this.zzaou, bundle, true);
            if (this.zzaot != null) {
                if (this.zzaot.zzul != null) {
                    bundle.putString("_pn", this.zzaot.zzul);
                }
                bundle.putString("_pc", this.zzaot.zzaoi);
                bundle.putLong("_pi", this.zzaot.zzaoj);
            }
            this.zzaov.zzfu().zza("auto", "_vs", bundle);
        }
        this.zzaov.zzaol = this.zzaou;
        this.zzaov.zzfx().zzb(this.zzaou);
        AppMethodBeat.m2505o(69274);
    }
}
