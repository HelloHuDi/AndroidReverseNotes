package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo extends ApiMethodImpl<Result, zzu> {
    private final /* synthetic */ Account zzr;

    zzo(zzk zzk, Api api, GoogleApiClient googleApiClient, Account account) {
        this.zzr = account;
        super(api, googleApiClient);
    }

    public final Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(77140);
        zzt zzt = new zzt(status);
        AppMethodBeat.m2505o(77140);
        return zzt;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(77141);
        ((zzf) ((zzu) anyClient).getService()).zzd(new zzp(this), this.zzr);
        AppMethodBeat.m2505o(77141);
    }
}
