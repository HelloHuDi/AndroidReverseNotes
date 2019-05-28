package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfe;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzfe zzap;

    zzm(zzd zzd, zzfe zzfe) {
        this.zzao = zzd;
        this.zzap = zzfe;
    }

    public final void run() {
        AppMethodBeat.i(71483);
        WearableListenerService.this.onMessageReceived(this.zzap);
        AppMethodBeat.o(71483);
    }
}
