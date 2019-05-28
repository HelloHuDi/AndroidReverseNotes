package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbx extends zzn<DataItemResult> {
    private final /* synthetic */ PutDataRequest zzdb;

    zzbx(zzbw zzbw, GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        this.zzdb = putDataRequest;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71122);
        zzcg zzcg = new zzcg(status, null);
        AppMethodBeat.m2505o(71122);
        return zzcg;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71121);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzdb);
        AppMethodBeat.m2505o(71121);
    }
}
