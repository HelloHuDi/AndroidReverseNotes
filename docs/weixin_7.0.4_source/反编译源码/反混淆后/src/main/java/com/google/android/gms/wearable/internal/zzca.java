package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzca extends zzn<DataItemBuffer> {
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ int zzdc;

    zzca(zzbw zzbw, GoogleApiClient googleApiClient, Uri uri, int i) {
        this.zzco = uri;
        this.zzdc = i;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71128);
        DataItemBuffer dataItemBuffer = new DataItemBuffer(DataHolder.empty(status.getStatusCode()));
        AppMethodBeat.m2505o(71128);
        return dataItemBuffer;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71127);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzgw(this), this.zzco, this.zzdc);
        AppMethodBeat.m2505o(71127);
    }
}
