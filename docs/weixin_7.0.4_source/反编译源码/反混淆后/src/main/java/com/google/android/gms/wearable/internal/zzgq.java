package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgq extends zzgm<GetAllCapabilitiesResult> {
    public zzgq(ResultHolder<GetAllCapabilitiesResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzdi zzdi) {
        AppMethodBeat.m2504i(71378);
        zza(new zzx(zzgd.zzb(zzdi.statusCode), zzgk.zzb(zzdi.zzdp)));
        AppMethodBeat.m2505o(71378);
    }
}
