package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.wearable.Wearable;

abstract class zzn<R extends Result> extends ApiMethodImpl<R, zzhg> {
    public zzn(GoogleApiClient googleApiClient) {
        super(Wearable.API, googleApiClient);
    }
}
