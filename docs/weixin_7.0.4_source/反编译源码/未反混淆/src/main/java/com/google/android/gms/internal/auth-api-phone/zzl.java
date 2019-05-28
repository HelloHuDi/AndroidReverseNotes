package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl extends zzh {
    private final /* synthetic */ zzk zze;

    zzl(zzk zzk) {
        this.zze = zzk;
    }

    public final void zza(Status status) {
        AppMethodBeat.i(80435);
        this.zze.zzb(status);
        AppMethodBeat.o(80435);
    }
}
