package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzba extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;
    private final /* synthetic */ int zzcn;

    zzba(zzay zzay, GoogleApiClient googleApiClient, int i) {
        this.zzcm = zzay;
        this.zzcn = i;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71062);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zzb(new zzgo(this), this.zzcm.zzce, this.zzcn);
        AppMethodBeat.o(71062);
    }
}
