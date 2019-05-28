package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgm implements Runnable {
    private final /* synthetic */ zzhj zzana;
    private final /* synthetic */ zzgl zzanb;

    zzgm(zzgl zzgl, zzhj zzhj) {
        this.zzanb = zzgl;
        this.zzana = zzhj;
    }

    public final void run() {
        AppMethodBeat.i(69089);
        this.zzanb.zza(this.zzana);
        this.zzanb.start();
        AppMethodBeat.o(69089);
    }
}
