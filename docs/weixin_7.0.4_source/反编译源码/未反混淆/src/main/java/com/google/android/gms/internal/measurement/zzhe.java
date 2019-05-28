package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhe implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzhe(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(69126);
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzf(this.zzane);
        AppMethodBeat.o(69126);
    }
}
