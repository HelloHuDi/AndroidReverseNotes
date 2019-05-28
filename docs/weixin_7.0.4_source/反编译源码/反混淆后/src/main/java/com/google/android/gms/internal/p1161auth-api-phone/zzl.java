package com.google.android.gms.internal.p1161auth-api-phone;

import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzl */
final class zzl extends zzh {
    private final /* synthetic */ zzk zze;

    zzl(zzk zzk) {
        this.zze = zzk;
    }

    public final void zza(Status status) {
        AppMethodBeat.m2504i(80435);
        this.zze.zzb(status);
        AppMethodBeat.m2505o(80435);
    }
}
