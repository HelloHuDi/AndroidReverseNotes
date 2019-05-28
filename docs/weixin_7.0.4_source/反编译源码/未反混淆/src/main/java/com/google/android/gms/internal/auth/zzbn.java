package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbn implements ProxyApi {
    public final PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        AppMethodBeat.i(77107);
        Preconditions.checkNotNull(googleApiClient);
        Preconditions.checkNotNull(proxyRequest);
        ApiMethodImpl execute = googleApiClient.execute(new zzbo(this, googleApiClient, proxyRequest));
        AppMethodBeat.o(77107);
        return execute;
    }
}
