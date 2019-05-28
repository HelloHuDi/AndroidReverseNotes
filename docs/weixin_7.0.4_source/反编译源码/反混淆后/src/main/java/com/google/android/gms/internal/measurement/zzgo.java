package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgo implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzgo(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69110);
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zze(this.zzane);
        AppMethodBeat.m2505o(69110);
    }
}
