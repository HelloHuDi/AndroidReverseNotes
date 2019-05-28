package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzfa implements ResultConverter {
    static final ResultConverter zzbx = new zzfa();

    static {
        AppMethodBeat.m2504i(71307);
        AppMethodBeat.m2505o(71307);
    }

    private zzfa() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71306);
        Integer valueOf = Integer.valueOf(((SendMessageResult) result).getRequestId());
        AppMethodBeat.m2505o(71306);
        return valueOf;
    }
}
