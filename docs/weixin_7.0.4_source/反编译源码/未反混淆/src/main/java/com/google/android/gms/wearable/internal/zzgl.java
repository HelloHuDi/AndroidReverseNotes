package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgl extends zzgm<AddLocalCapabilityResult> {
    public zzgl(ResultHolder<AddLocalCapabilityResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzf zzf) {
        AppMethodBeat.i(71373);
        zza(new zzu(zzgd.zzb(zzf.statusCode)));
        AppMethodBeat.o(71373);
    }
}
