package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgx extends zzgm<GetFdForAssetResult> {
    public zzgx(ResultHolder<GetFdForAssetResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzee zzee) {
        AppMethodBeat.m2504i(71387);
        zza(new zzci(zzgd.zzb(zzee.statusCode), zzee.zzdz));
        AppMethodBeat.m2505o(71387);
    }
}
