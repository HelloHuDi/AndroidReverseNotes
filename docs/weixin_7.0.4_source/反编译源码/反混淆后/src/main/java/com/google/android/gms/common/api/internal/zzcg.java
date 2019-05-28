package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcg implements Continuation<Boolean, Void> {
    zzcg() {
    }

    public final /* synthetic */ Object then(Task task) {
        AppMethodBeat.m2504i(60876);
        if (((Boolean) task.getResult()).booleanValue()) {
            AppMethodBeat.m2505o(60876);
            return null;
        }
        ApiException apiException = new ApiException(new Status(13, "listener already unregistered"));
        AppMethodBeat.m2505o(60876);
        throw apiException;
    }
}
