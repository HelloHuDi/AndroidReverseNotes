package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzfm implements ResultConverter {
    static final ResultConverter zzbx = new zzfm();

    static {
        AppMethodBeat.m2504i(71325);
        AppMethodBeat.m2505o(71325);
    }

    private zzfm() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71324);
        Node node = ((GetLocalNodeResult) result).getNode();
        AppMethodBeat.m2505o(71324);
        return node;
    }
}
