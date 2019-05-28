package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzq extends zzn<GetAllCapabilitiesResult> {
    private final /* synthetic */ int zzbq;

    zzq(zzo zzo, GoogleApiClient googleApiClient, int i) {
        this.zzbq = i;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71467);
        zzx zzx = new zzx(status, null);
        AppMethodBeat.m2505o(71467);
        return zzx;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71466);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzgq(this), this.zzbq);
        AppMethodBeat.m2505o(71466);
    }
}
