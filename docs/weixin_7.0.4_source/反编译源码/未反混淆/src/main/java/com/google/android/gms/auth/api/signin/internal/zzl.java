package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl extends zzp<Status> {
    zzl(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(50447);
        zzh zzh = (zzh) anyClient;
        ((zzv) zzh.getService()).zze(new zzm(this), zzh.zzn());
        AppMethodBeat.o(50447);
    }
}
