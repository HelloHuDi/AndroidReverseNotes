package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcl implements ResultConverter {
    static final ResultConverter zzbx = new zzcl();

    static {
        AppMethodBeat.i(71158);
        AppMethodBeat.o(71158);
    }

    private zzcl() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.i(71157);
        DataItem dataItem = ((DataItemResult) result).getDataItem();
        AppMethodBeat.o(71157);
        return dataItem;
    }
}
