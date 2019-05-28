package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzah;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzq implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzah zzas;

    zzq(zzd zzd, zzah zzah) {
        this.zzao = zzd;
        this.zzas = zzah;
    }

    public final void run() {
        AppMethodBeat.m2504i(71487);
        WearableListenerService.this.onCapabilityChanged(this.zzas);
        AppMethodBeat.m2505o(71487);
    }
}
