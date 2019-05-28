package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgg implements ResultHolder<Status> {
    private final TaskCompletionSource<Boolean> zzes;

    zzgg(TaskCompletionSource<Boolean> taskCompletionSource) {
        this.zzes = taskCompletionSource;
    }

    public final void setFailedResult(Status status) {
        AppMethodBeat.i(71365);
        this.zzes.setException(new ApiException(status));
        AppMethodBeat.o(71365);
    }

    public final /* synthetic */ void setResult(Object obj) {
        AppMethodBeat.i(71366);
        Status status = (Status) obj;
        int statusCode = status.getStatusCode();
        if (statusCode == 0) {
            this.zzes.setResult(Boolean.TRUE);
            AppMethodBeat.o(71366);
        } else if (statusCode == WearableStatusCodes.UNKNOWN_LISTENER) {
            this.zzes.setResult(Boolean.FALSE);
            AppMethodBeat.o(71366);
        } else {
            setFailedResult(status);
            AppMethodBeat.o(71366);
        }
    }
}
