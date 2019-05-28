package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzfo zzaq;

    zzn(zzd zzd, zzfo zzfo) {
        this.zzao = zzd;
        this.zzaq = zzfo;
    }

    public final void run() {
        AppMethodBeat.i(71484);
        WearableListenerService.this.onPeerConnected(this.zzaq);
        AppMethodBeat.o(71484);
    }
}
