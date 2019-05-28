package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbe extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ long zzcq;
    private final /* synthetic */ long zzcr;

    zzbe(zzay zzay, GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
        this.zzcm = zzay;
        this.zzco = uri;
        this.zzcq = j;
        this.zzcr = j2;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71068);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzcm.zzce, this.zzco, this.zzcq, this.zzcr);
        AppMethodBeat.m2505o(71068);
    }
}
