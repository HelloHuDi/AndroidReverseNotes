package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcn implements ResultConverter {
    static final ResultConverter zzbx = new zzcn();

    static {
        AppMethodBeat.i(71160);
        AppMethodBeat.o(71160);
    }

    private zzcn() {
    }

    public final Object convert(Result result) {
        return (DataItemBuffer) result;
    }
}
