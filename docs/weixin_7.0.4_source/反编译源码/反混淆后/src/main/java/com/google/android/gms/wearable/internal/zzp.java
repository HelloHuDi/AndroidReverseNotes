package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp extends zzn<GetCapabilityResult> {
    private final /* synthetic */ String zzbp;
    private final /* synthetic */ int zzbq;

    zzp(zzo zzo, GoogleApiClient googleApiClient, String str, int i) {
        this.zzbp = str;
        this.zzbq = i;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71465);
        zzy zzy = new zzy(status, null);
        AppMethodBeat.m2505o(71465);
        return zzy;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71464);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzgr(this), this.zzbp, this.zzbq);
        AppMethodBeat.m2505o(71464);
    }
}
