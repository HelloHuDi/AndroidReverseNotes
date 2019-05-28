package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgq implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzed zzang;

    zzgq(zzgn zzgn, zzed zzed, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzang = zzed;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.m2504i(69112);
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzb(this.zzang, this.zzane);
        AppMethodBeat.m2505o(69112);
    }
}
