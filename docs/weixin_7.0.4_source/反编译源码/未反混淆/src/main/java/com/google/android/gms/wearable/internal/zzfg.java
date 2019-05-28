package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfg implements NodeApi {
    public final PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(71315);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzfi(this, googleApiClient));
        AppMethodBeat.o(71315);
        return enqueue;
    }

    public final PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(71314);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzfh(this, googleApiClient));
        AppMethodBeat.o(71314);
        return enqueue;
    }
}
