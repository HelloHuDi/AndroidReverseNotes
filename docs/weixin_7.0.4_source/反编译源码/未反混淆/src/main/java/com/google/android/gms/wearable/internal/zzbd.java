package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbd extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ boolean zzcp;

    zzbd(zzay zzay, GoogleApiClient googleApiClient, Uri uri, boolean z) {
        this.zzcm = zzay;
        this.zzco = uri;
        this.zzcp = z;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71067);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzcm.zzce, this.zzco, this.zzcp);
        AppMethodBeat.o(71067);
    }
}
