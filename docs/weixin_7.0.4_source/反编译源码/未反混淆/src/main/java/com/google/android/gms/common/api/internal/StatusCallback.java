package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.IStatusCallback.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class StatusCallback extends Stub {
    @KeepForSdk
    private final ResultHolder<Status> mResultHolder;

    @KeepForSdk
    public StatusCallback(ResultHolder<Status> resultHolder) {
        this.mResultHolder = resultHolder;
    }

    @KeepForSdk
    public void onResult(Status status) {
        AppMethodBeat.i(60662);
        this.mResultHolder.setResult(status);
        AppMethodBeat.o(60662);
    }
}
