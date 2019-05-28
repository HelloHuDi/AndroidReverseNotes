package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgo extends zzgm<Status> {
    public zzgo(ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    public final void zzb(zzbt zzbt) {
        AppMethodBeat.m2504i(71376);
        zza(new Status(zzbt.statusCode));
        AppMethodBeat.m2505o(71376);
    }
}
