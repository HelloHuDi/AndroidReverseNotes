package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcs implements ResultConverter {
    static final ResultConverter zzbx = new zzcs();

    static {
        AppMethodBeat.m2504i(71169);
        AppMethodBeat.m2505o(71169);
    }

    private zzcs() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71168);
        zzcu zzcu = new zzcu((GetFdForAssetResult) result);
        AppMethodBeat.m2505o(71168);
        return zzcu;
    }
}
