package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl extends ApiMethodImpl<Result, zzu> {
    private final /* synthetic */ boolean zzag;

    zzl(zzk zzk, Api api, GoogleApiClient googleApiClient, boolean z) {
        this.zzag = z;
        super(api, googleApiClient);
    }

    public final Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(77135);
        zzs zzs = new zzs(status);
        AppMethodBeat.m2505o(77135);
        return zzs;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(77136);
        ((zzf) ((zzu) anyClient).getService()).zze(this.zzag);
        setResult(new zzs(Status.RESULT_SUCCESS));
        AppMethodBeat.m2505o(77136);
    }
}
