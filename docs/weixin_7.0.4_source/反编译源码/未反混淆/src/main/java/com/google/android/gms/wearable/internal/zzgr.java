package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgr extends zzgm<GetCapabilityResult> {
    public zzgr(ResultHolder<GetCapabilityResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzdk zzdk) {
        AppMethodBeat.i(71379);
        zza(new zzy(zzgd.zzb(zzdk.statusCode), zzdk.zzdq == null ? null : new zzw(zzdk.zzdq)));
        AppMethodBeat.o(71379);
    }
}
