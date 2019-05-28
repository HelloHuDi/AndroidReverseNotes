package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final /* synthetic */ class zzfn implements ResultConverter {
    static final ResultConverter zzbx = new zzfn();

    static {
        AppMethodBeat.m2504i(71327);
        AppMethodBeat.m2505o(71327);
    }

    private zzfn() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71326);
        List nodes = ((GetConnectedNodesResult) result).getNodes();
        AppMethodBeat.m2505o(71326);
        return nodes;
    }
}
