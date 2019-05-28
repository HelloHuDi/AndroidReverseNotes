package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzaw;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzt implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzaw zzav;

    zzt(zzd zzd, zzaw zzaw) {
        this.zzao = zzd;
        this.zzav = zzaw;
    }

    public final void run() {
        AppMethodBeat.i(71490);
        this.zzav.zza(WearableListenerService.this);
        this.zzav.zza(WearableListenerService.this.zzaj);
        AppMethodBeat.o(71490);
    }
}
