package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B> {
}
