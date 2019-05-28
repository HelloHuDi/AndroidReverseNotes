package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final /* synthetic */ class zzfn implements ResultConverter {
    static final ResultConverter zzbx = new zzfn();

    static {
        AppMethodBeat.i(71327);
        AppMethodBeat.o(71327);
    }

    private zzfn() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.i(71326);
        List nodes = ((GetConnectedNodesResult) result).getNodes();
        AppMethodBeat.o(71326);
        return nodes;
    }
}
