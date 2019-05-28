package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzab implements ResultConverter {
    static final ResultConverter zzbx = new zzab();

    static {
        AppMethodBeat.m2504i(70981);
        AppMethodBeat.m2505o(70981);
    }

    private zzab() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(70980);
        CapabilityInfo capability = ((GetCapabilityResult) result).getCapability();
        AppMethodBeat.m2505o(70980);
        return capability;
    }
}
