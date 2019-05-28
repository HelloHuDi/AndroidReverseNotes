package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhc extends zzgm<Status> {
    public zzhc(ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzbp zzbp) {
        AppMethodBeat.m2504i(71391);
        zza(new Status(zzbp.statusCode));
        AppMethodBeat.m2505o(71391);
    }
}
