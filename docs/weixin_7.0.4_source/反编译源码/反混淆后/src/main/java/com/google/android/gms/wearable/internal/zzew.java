package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzew extends zzn<Status> {
    private final /* synthetic */ MessageListener zzef;

    zzew(zzeu zzeu, GoogleApiClient googleApiClient, MessageListener messageListener) {
        this.zzef = messageListener;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71294);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzef);
        AppMethodBeat.m2505o(71294);
    }
}
