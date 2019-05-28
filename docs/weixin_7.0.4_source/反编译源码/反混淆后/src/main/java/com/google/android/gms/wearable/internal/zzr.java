package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzr extends zzn<AddLocalCapabilityResult> {
    private final /* synthetic */ String zzbp;

    zzr(zzo zzo, GoogleApiClient googleApiClient, String str) {
        this.zzbp = str;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71469);
        zzu zzu = new zzu(status);
        AppMethodBeat.m2505o(71469);
        return zzu;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71468);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzgl(this), this.zzbp);
        AppMethodBeat.m2505o(71468);
    }
}
