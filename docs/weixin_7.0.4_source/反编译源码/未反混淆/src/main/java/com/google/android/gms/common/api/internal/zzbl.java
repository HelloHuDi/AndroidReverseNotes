package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbl implements SignOutCallbacks {
    final /* synthetic */ zza zzkk;

    zzbl(zza zza) {
        this.zzkk = zza;
    }

    public final void onSignOutComplete() {
        AppMethodBeat.i(60840);
        GoogleApiManager.this.handler.post(new zzbm(this));
        AppMethodBeat.o(60840);
    }
}
