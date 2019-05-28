package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzby extends zzn<DataItemResult> {
    private final /* synthetic */ Uri zzco;

    zzby(zzbw zzbw, GoogleApiClient googleApiClient, Uri uri) {
        this.zzco = uri;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71124);
        zzcg zzcg = new zzcg(status, null);
        AppMethodBeat.m2505o(71124);
        return zzcg;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71123);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzgv(this), this.zzco);
        AppMethodBeat.m2505o(71123);
    }
}
