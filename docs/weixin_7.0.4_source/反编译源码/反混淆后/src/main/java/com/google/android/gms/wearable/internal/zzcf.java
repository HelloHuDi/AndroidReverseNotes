package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcf extends zzn<Status> {
    private final /* synthetic */ DataListener zzdf;

    zzcf(zzbw zzbw, GoogleApiClient googleApiClient, DataListener dataListener) {
        this.zzdf = dataListener;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71136);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzdf);
        AppMethodBeat.m2505o(71136);
    }
}
