package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbj implements Runnable {
    private final /* synthetic */ zza zzkk;

    zzbj(zza zza) {
        this.zzkk = zza;
    }

    public final void run() {
        AppMethodBeat.i(60838);
        zza.zzd(this.zzkk);
        AppMethodBeat.o(60838);
    }
}
