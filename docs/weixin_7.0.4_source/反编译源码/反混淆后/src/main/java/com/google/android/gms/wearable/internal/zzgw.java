package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgw extends zzgm<DataItemBuffer> {
    public zzgw(ResultHolder<DataItemBuffer> resultHolder) {
        super(resultHolder);
    }

    public final void zzb(DataHolder dataHolder) {
        AppMethodBeat.m2504i(71386);
        zza(new DataItemBuffer(dataHolder));
        AppMethodBeat.m2505o(71386);
    }
}
