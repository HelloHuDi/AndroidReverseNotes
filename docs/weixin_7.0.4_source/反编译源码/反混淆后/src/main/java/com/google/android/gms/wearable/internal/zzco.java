package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzco implements ResultConverter {
    static final ResultConverter zzbx = new zzco();

    static {
        AppMethodBeat.m2504i(71161);
        AppMethodBeat.m2505o(71161);
    }

    private zzco() {
    }

    public final Object convert(Result result) {
        return (DataItemBuffer) result;
    }
}
