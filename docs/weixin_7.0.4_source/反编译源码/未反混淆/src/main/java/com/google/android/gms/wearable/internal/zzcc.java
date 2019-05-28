package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcc extends zzn<GetFdForAssetResult> {
    private final /* synthetic */ Asset zzdd;

    zzcc(zzbw zzbw, GoogleApiClient googleApiClient, Asset asset) {
        this.zzdd = asset;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71132);
        zzci zzci = new zzci(status, null);
        AppMethodBeat.o(71132);
        return zzci;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71131);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzdd);
        AppMethodBeat.o(71131);
    }
}
