package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzz extends zzn<Status> {
    private CapabilityListener zzbs;

    private zzz(GoogleApiClient googleApiClient, CapabilityListener capabilityListener) {
        super(googleApiClient);
        this.zzbs = capabilityListener;
    }

    /* synthetic */ zzz(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, zzp zzp) {
        this(googleApiClient, capabilityListener);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzbs = null;
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71477);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzbs);
        this.zzbs = null;
        AppMethodBeat.o(71477);
    }
}
