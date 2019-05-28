package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends ApiMethodImpl<AddAccountResult, zzu> {
    private final /* synthetic */ String zzt;

    zzm(zzk zzk, Api api, GoogleApiClient googleApiClient, String str) {
        this.zzt = str;
        super(api, googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(77138);
        zzr zzr = new zzr(status, null);
        AppMethodBeat.m2505o(77138);
        return zzr;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(77137);
        ((zzf) ((zzu) anyClient).getService()).zzd(new zzn(this), this.zzt);
        AppMethodBeat.m2505o(77137);
    }
}
