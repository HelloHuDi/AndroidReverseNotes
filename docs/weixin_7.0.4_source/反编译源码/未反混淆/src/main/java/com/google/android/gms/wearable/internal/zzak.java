package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzak extends zzn<OpenChannelResult> {
    private final /* synthetic */ String zzcb;
    private final /* synthetic */ String zzcc;

    zzak(zzaj zzaj, GoogleApiClient googleApiClient, String str, String str2) {
        this.zzcb = str;
        this.zzcc = str2;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71001);
        zzam zzam = new zzam(status, null);
        AppMethodBeat.o(71001);
        return zzam;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71000);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzha(this), this.zzcb, this.zzcc);
        AppMethodBeat.o(71000);
    }
}
