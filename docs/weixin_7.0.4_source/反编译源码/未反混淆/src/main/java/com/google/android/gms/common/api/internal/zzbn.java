package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

final class zzbn implements Runnable {
    private final /* synthetic */ ConnectionResult zzkl;
    private final /* synthetic */ zzc zzkr;

    zzbn(zzc zzc, ConnectionResult connectionResult) {
        this.zzkr = zzc;
        this.zzkl = connectionResult;
    }

    public final void run() {
        AppMethodBeat.i(60842);
        if (this.zzkl.isSuccess()) {
            this.zzkr.zzkq = true;
            if (this.zzkr.zzka.requiresSignIn()) {
                zzc.zzb(this.zzkr);
                AppMethodBeat.o(60842);
                return;
            }
            this.zzkr.zzka.getRemoteService(null, Collections.emptySet());
            AppMethodBeat.o(60842);
            return;
        }
        ((zza) GoogleApiManager.this.zzju.get(this.zzkr.zzhc)).onConnectionFailed(this.zzkl);
        AppMethodBeat.o(60842);
    }
}
