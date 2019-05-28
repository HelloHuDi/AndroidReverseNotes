package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzha extends zzgm<OpenChannelResult> {
    public zzha(ResultHolder<OpenChannelResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzfq zzfq) {
        AppMethodBeat.m2504i(71389);
        zza(new zzam(zzgd.zzb(zzfq.statusCode), zzfq.zzck));
        AppMethodBeat.m2505o(71389);
    }
}
