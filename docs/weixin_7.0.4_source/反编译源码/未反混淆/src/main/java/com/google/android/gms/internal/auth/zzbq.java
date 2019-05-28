package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzbq implements ProxyResult {
    private Status mStatus;
    private ProxyResponse zzee;

    public zzbq(ProxyResponse proxyResponse) {
        this.zzee = proxyResponse;
        this.mStatus = Status.RESULT_SUCCESS;
    }

    public zzbq(Status status) {
        this.mStatus = status;
    }

    public final ProxyResponse getResponse() {
        return this.zzee;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
