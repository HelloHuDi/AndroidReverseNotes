package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.ChannelClient.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzap implements ResultConverter {
    static final ResultConverter zzbx = new zzap();

    static {
        AppMethodBeat.i(71025);
        AppMethodBeat.o(71025);
    }

    private zzap() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.i(71024);
        Channel zza = zzao.zza((OpenChannelResult) result);
        AppMethodBeat.o(71024);
        return zza;
    }
}
