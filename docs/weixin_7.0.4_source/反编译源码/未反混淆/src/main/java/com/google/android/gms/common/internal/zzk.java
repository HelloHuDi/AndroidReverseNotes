package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.StatusConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk implements StatusConverter {
    zzk() {
    }

    public final ApiException convert(Status status) {
        AppMethodBeat.i(61407);
        ApiException fromStatus = ApiExceptionUtil.fromStatus(status);
        AppMethodBeat.o(61407);
        return fromStatus;
    }
}
