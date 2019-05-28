package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgy extends zzgm<GetLocalNodeResult> {
    public zzgy(ResultHolder<GetLocalNodeResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzeg zzeg) {
        AppMethodBeat.m2504i(71388);
        zza(new zzfk(zzgd.zzb(zzeg.statusCode), zzeg.zzea));
        AppMethodBeat.m2505o(71388);
    }
}
