package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final /* synthetic */ class zzac implements ResultConverter {
    static final ResultConverter zzbx = new zzac();

    static {
        AppMethodBeat.m2504i(70983);
        AppMethodBeat.m2505o(70983);
    }

    private zzac() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(70982);
        Map allCapabilities = ((GetAllCapabilitiesResult) result).getAllCapabilities();
        AppMethodBeat.m2505o(70982);
        return allCapabilities;
    }
}
