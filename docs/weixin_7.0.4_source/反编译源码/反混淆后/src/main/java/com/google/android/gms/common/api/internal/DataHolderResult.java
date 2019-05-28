package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class DataHolderResult implements Releasable, Result {
    @KeepForSdk
    protected final DataHolder mDataHolder;
    @KeepForSdk
    protected final Status mStatus;

    @KeepForSdk
    protected DataHolderResult(DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.getStatusCode()));
        AppMethodBeat.m2504i(60568);
        AppMethodBeat.m2505o(60568);
    }

    @KeepForSdk
    protected DataHolderResult(DataHolder dataHolder, Status status) {
        this.mStatus = status;
        this.mDataHolder = dataHolder;
    }

    @KeepForSdk
    public Status getStatus() {
        return this.mStatus;
    }

    @KeepForSdk
    public void release() {
        AppMethodBeat.m2504i(60569);
        if (this.mDataHolder != null) {
            this.mDataHolder.close();
        }
        AppMethodBeat.m2505o(60569);
    }
}
