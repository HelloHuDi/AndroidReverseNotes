package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgp extends zzgm<DeleteDataItemsResult> {
    public zzgp(ResultHolder<DeleteDataItemsResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzdg zzdg) {
        AppMethodBeat.i(71377);
        zza(new zzch(zzgd.zzb(zzdg.statusCode), zzdg.zzdh));
        AppMethodBeat.o(71377);
    }
}
