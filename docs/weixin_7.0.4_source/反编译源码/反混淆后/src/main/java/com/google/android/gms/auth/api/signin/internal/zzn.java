package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn extends zzp<Status> {
    zzn(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(50449);
        zzh zzh = (zzh) anyClient;
        ((zzv) zzh.getService()).zzf(new zzo(this), zzh.zzn());
        AppMethodBeat.m2505o(50449);
    }
}
