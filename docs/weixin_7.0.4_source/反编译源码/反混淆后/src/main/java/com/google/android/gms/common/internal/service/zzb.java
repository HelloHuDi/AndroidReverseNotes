package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends zzd {
    zzb(CommonApiImpl commonApiImpl, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(61400);
        ((ICommonService) ((CommonClient) anyClient).getService()).clearDefaultAccount(new zza(this));
        AppMethodBeat.m2505o(61400);
    }
}
