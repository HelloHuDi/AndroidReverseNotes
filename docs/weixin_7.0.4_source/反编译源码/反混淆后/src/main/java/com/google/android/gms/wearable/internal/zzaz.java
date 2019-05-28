package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaz extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;

    zzaz(zzay zzay, GoogleApiClient googleApiClient) {
        this.zzcm = zzay;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71058);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zzc(new zzgn(this), this.zzcm.zzce);
        AppMethodBeat.m2505o(71058);
    }
}
