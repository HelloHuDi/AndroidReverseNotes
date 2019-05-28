package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public interface ProxyApi {

    @KeepForSdk
    public interface ProxyResult extends Result {
        @KeepForSdk
        ProxyResponse getResponse();
    }

    @KeepForSdk
    PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest);
}
