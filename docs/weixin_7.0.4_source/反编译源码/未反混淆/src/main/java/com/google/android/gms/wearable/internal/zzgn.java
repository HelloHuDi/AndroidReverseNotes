package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgn extends zzgm<Status> {
    public zzgn(ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzbt zzbt) {
        AppMethodBeat.i(71375);
        zza(new Status(zzbt.statusCode));
        AppMethodBeat.o(71375);
    }
}
