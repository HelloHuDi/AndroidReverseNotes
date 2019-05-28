package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcq implements ResultConverter {
    static final ResultConverter zzbx = new zzcq();

    static {
        AppMethodBeat.m2504i(71165);
        AppMethodBeat.m2505o(71165);
    }

    private zzcq() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71164);
        Integer valueOf = Integer.valueOf(((DeleteDataItemsResult) result).getNumDeleted());
        AppMethodBeat.m2505o(71164);
        return valueOf;
    }
}
