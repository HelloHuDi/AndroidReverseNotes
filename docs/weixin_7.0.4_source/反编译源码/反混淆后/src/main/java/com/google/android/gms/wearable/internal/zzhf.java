package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhf extends zzgm<Status> {
    public zzhf(ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzbn zzbn) {
        AppMethodBeat.m2504i(71394);
        zza(new Status(zzbn.statusCode));
        AppMethodBeat.m2505o(71394);
    }
}
