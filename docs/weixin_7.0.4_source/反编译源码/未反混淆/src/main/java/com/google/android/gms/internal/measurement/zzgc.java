package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgc implements Runnable {
    private final /* synthetic */ zzgl zzalb;
    private final /* synthetic */ zzfg zzalc;

    zzgc(zzgb zzgb, zzgl zzgl, zzfg zzfg) {
        this.zzalb = zzgl;
        this.zzalc = zzfg;
    }

    public final void run() {
        AppMethodBeat.i(68984);
        if (this.zzalb.zzjp() == null) {
            this.zzalc.zzim().log("Install Referrer Reporter is null");
            AppMethodBeat.o(68984);
            return;
        }
        this.zzalb.zzjp().zzjh();
        AppMethodBeat.o(68984);
    }
}
