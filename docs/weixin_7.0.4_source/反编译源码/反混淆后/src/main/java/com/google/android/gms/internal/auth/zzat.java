package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzat extends zzav<Status> {
    zzat(zzao zzao, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(Context context, zzbc zzbc) {
        AppMethodBeat.m2504i(50483);
        zzbc.zzd(new zzau(this));
        AppMethodBeat.m2505o(50483);
    }
}
