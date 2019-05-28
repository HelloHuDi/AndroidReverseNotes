package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class StatusPendingResult extends BasePendingResult<Status> {
    @Deprecated
    public StatusPendingResult(Looper looper) {
        super(looper);
    }

    public StatusPendingResult(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
