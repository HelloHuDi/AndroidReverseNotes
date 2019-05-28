package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbk implements Runnable {
    private final /* synthetic */ zza zzkk;
    private final /* synthetic */ ConnectionResult zzkl;

    zzbk(zza zza, ConnectionResult connectionResult) {
        this.zzkk = zza;
        this.zzkl = connectionResult;
    }

    public final void run() {
        AppMethodBeat.m2504i(60839);
        this.zzkk.onConnectionFailed(this.zzkl);
        AppMethodBeat.m2505o(60839);
    }
}
