package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhe extends zzgm<SendMessageResult> {
    public zzhe(ResultHolder<SendMessageResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzga zzga) {
        AppMethodBeat.m2504i(71393);
        zza(new zzey(zzgd.zzb(zzga.statusCode), zzga.zzeh));
        AppMethodBeat.m2505o(71393);
    }
}
