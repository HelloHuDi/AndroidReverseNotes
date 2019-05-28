package com.google.android.gms.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf implements Runnable {
    private final /* synthetic */ Intent zzbb;
    private final /* synthetic */ Intent zzbc;
    private final /* synthetic */ zze zzbd;

    zzf(zze zze, Intent intent, Intent intent2) {
        this.zzbd = zze;
        this.zzbb = intent;
        this.zzbc = intent2;
    }

    public final void run() {
        AppMethodBeat.i(57563);
        this.zzbd.handleIntent(this.zzbb);
        this.zzbd.zzf(this.zzbc);
        AppMethodBeat.o(57563);
    }
}
