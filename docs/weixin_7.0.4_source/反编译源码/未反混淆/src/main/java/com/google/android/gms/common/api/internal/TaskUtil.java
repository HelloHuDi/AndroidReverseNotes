package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class TaskUtil {
    @KeepForSdk
    public static void setResultOrApiException(Status status, TaskCompletionSource<Void> taskCompletionSource) {
        AppMethodBeat.i(60664);
        setResultOrApiException(status, null, taskCompletionSource);
        AppMethodBeat.o(60664);
    }

    @KeepForSdk
    public static <TResult> void setResultOrApiException(Status status, TResult tResult, TaskCompletionSource<TResult> taskCompletionSource) {
        AppMethodBeat.i(60665);
        if (status.isSuccess()) {
            taskCompletionSource.setResult(tResult);
            AppMethodBeat.o(60665);
            return;
        }
        taskCompletionSource.setException(new ApiException(status));
        AppMethodBeat.o(60665);
    }

    @KeepForSdk
    @Deprecated
    public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> task) {
        AppMethodBeat.i(60666);
        Task continueWith = task.continueWith(new zzcg());
        AppMethodBeat.o(60666);
        return continueWith;
    }
}
