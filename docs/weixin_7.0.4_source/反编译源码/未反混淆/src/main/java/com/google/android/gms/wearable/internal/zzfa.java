package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzfa implements ResultConverter {
    static final ResultConverter zzbx = new zzfa();

    static {
        AppMethodBeat.i(71307);
        AppMethodBeat.o(71307);
    }

    private zzfa() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.i(71306);
        Integer valueOf = Integer.valueOf(((SendMessageResult) result).getRequestId());
        AppMethodBeat.o(71306);
        return valueOf;
    }
}
