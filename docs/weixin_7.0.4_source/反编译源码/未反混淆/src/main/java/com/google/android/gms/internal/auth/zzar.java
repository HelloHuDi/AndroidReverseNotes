package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzar extends zzav<Status> {
    private final /* synthetic */ Credential zzdt;

    zzar(zzao zzao, GoogleApiClient googleApiClient, Credential credential) {
        this.zzdt = credential;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(Context context, zzbc zzbc) {
        AppMethodBeat.i(50481);
        zzbc.zzd(new zzau(this), new zzbe(this.zzdt));
        AppMethodBeat.o(50481);
    }
}
