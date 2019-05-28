package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgp implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzed zzang;

    zzgp(zzgn zzgn, zzed zzed, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzang = zzed;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69111);
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzc(this.zzang, this.zzane);
        AppMethodBeat.m2505o(69111);
    }
}
