package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfh extends zzn<GetLocalNodeResult> {
    zzfh(zzfg zzfg, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71317);
        zzfk zzfk = new zzfk(status, null);
        AppMethodBeat.m2505o(71317);
        return zzfk;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71316);
        ((zzep) ((zzhg) anyClient).getService()).zzb(new zzgy(this));
        AppMethodBeat.m2505o(71316);
    }
}
