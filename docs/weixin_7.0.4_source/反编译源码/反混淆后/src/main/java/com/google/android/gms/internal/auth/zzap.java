package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzap extends zzav<CredentialRequestResult> {
    private final /* synthetic */ CredentialRequest zzdr;

    zzap(zzao zzao, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        this.zzdr = credentialRequest;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(50478);
        zzan zzf = zzan.zzf(status);
        AppMethodBeat.m2505o(50478);
        return zzf;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(Context context, zzbc zzbc) {
        AppMethodBeat.m2504i(50477);
        zzbc.zzd(new zzaq(this), this.zzdr);
        AppMethodBeat.m2505o(50477);
    }
}
