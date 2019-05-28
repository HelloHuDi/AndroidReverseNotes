package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcd extends zzn<GetFdForAssetResult> {
    private final /* synthetic */ DataItemAsset zzde;

    zzcd(zzbw zzbw, GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        this.zzde = dataItemAsset;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71134);
        zzci zzci = new zzci(status, null);
        AppMethodBeat.o(71134);
        return zzci;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71133);
        ((zzhg) anyClient).zza((ResultHolder) this, Asset.createFromRef(this.zzde.getId()));
        AppMethodBeat.o(71133);
    }
}
