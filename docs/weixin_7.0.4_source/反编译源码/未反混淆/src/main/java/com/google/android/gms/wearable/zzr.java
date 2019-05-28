package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzr implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzl zzat;

    zzr(zzd zzd, zzl zzl) {
        this.zzao = zzd;
        this.zzat = zzl;
    }

    public final void run() {
        AppMethodBeat.i(71488);
        WearableListenerService.this.onNotificationReceived(this.zzat);
        AppMethodBeat.o(71488);
    }
}
