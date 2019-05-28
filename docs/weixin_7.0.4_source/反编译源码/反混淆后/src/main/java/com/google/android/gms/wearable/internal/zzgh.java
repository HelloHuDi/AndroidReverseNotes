package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgh implements ResultHolder<Status> {
    private final TaskCompletionSource<Void> zzes;

    zzgh(TaskCompletionSource<Void> taskCompletionSource) {
        this.zzes = taskCompletionSource;
    }

    public final void setFailedResult(Status status) {
        AppMethodBeat.m2504i(71367);
        this.zzes.setException(new ApiException(status));
        AppMethodBeat.m2505o(71367);
    }

    public final /* synthetic */ void setResult(Object obj) {
        AppMethodBeat.m2504i(71368);
        Status status = (Status) obj;
        int statusCode = status.getStatusCode();
        if (statusCode == 0 || statusCode == WearableStatusCodes.DUPLICATE_LISTENER) {
            this.zzes.setResult(null);
            AppMethodBeat.m2505o(71368);
            return;
        }
        setFailedResult(status);
        AppMethodBeat.m2505o(71368);
    }
}
