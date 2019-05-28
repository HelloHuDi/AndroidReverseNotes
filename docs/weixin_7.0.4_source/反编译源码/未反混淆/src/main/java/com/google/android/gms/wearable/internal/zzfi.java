package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzfi extends zzn<GetConnectedNodesResult> {
    zzfi(zzfg zzfg, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(71319);
        zzfj zzfj = new zzfj(status, new ArrayList());
        AppMethodBeat.o(71319);
        return zzfj;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71318);
        ((zzep) ((zzhg) anyClient).getService()).zzc(new zzgu(this));
        AppMethodBeat.o(71318);
    }
}
