package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgz implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzeu zzank;

    zzgz(zzgn zzgn, zzeu zzeu, String str) {
        this.zzanf = zzgn;
        this.zzank = zzeu;
        this.zzanj = str;
    }

    public final void run() {
        AppMethodBeat.i(69121);
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzc(this.zzank, this.zzanj);
        AppMethodBeat.o(69121);
    }
}
