package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzbm extends ApiMethodImpl<ProxyResult, zzbh> {
    public zzbm(GoogleApiClient googleApiClient) {
        super(zzf.API, googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbq(status);
    }

    public /* synthetic */ void doExecute(AnyClient anyClient) {
        zzbh zzbh = (zzbh) anyClient;
        zzd(zzbh.getContext(), (zzbk) zzbh.getService());
    }

    public abstract void zzd(Context context, zzbk zzbk);
}
