package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs extends zzn<RemoveLocalCapabilityResult> {
    private final /* synthetic */ String zzbp;

    zzs(zzo zzo, GoogleApiClient googleApiClient, String str) {
        this.zzbp = str;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71471);
        zzu zzu = new zzu(status);
        AppMethodBeat.o(71471);
        return zzu;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71470);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zzb(new zzhd(this), this.zzbp);
        AppMethodBeat.o(71470);
    }
}
