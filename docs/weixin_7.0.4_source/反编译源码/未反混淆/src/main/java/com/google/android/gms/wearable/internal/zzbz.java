package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbz extends zzn<DataItemBuffer> {
    zzbz(zzbw zzbw, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71126);
        DataItemBuffer dataItemBuffer = new DataItemBuffer(DataHolder.empty(status.getStatusCode()));
        AppMethodBeat.o(71126);
        return dataItemBuffer;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71125);
        ((zzep) ((zzhg) anyClient).getService()).zza(new zzgw(this));
        AppMethodBeat.o(71125);
    }
}
