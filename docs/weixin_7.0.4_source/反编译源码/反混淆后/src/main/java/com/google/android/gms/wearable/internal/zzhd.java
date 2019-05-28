package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhd extends zzgm<RemoveLocalCapabilityResult> {
    public zzhd(ResultHolder<RemoveLocalCapabilityResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzfy zzfy) {
        AppMethodBeat.m2504i(71392);
        zza(new zzu(zzgd.zzb(zzfy.statusCode)));
        AppMethodBeat.m2505o(71392);
    }
}
