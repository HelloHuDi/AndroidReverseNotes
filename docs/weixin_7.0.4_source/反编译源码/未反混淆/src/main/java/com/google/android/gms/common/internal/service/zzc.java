package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzc<R extends Result> extends ApiMethodImpl<R, CommonClient> {
    public zzc(GoogleApiClient googleApiClient) {
        super(Common.API, googleApiClient);
    }
}
