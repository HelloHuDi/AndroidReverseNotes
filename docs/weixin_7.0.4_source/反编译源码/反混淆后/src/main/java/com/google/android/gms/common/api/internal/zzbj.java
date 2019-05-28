package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbj implements Runnable {
    private final /* synthetic */ zza zzkk;

    zzbj(zza zza) {
        this.zzkk = zza;
    }

    public final void run() {
        AppMethodBeat.m2504i(60838);
        zza.zzd(this.zzkk);
        AppMethodBeat.m2505o(60838);
    }
}
