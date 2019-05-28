package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbc extends zzn<GetOutputStreamResult> {
    private final /* synthetic */ zzay zzcm;

    zzbc(zzay zzay, GoogleApiClient googleApiClient) {
        this.zzcm = zzay;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71066);
        zzbh zzbh = new zzbh(status, null);
        AppMethodBeat.o(71066);
        return zzbh;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71065);
        zzhg zzhg = (zzhg) anyClient;
        String zza = this.zzcm.zzce;
        zzei zzbr = new zzbr();
        ((zzep) zzhg.getService()).zzb(new zzgt(this, zzbr), zzbr, zza);
        AppMethodBeat.o(71065);
    }
}
