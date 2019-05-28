package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzk implements WorkAccountApi {
    private static final Status zzaf = new Status(13);

    static {
        AppMethodBeat.m2504i(77134);
        AppMethodBeat.m2505o(77134);
    }

    public final PendingResult<AddAccountResult> addWorkAccount(GoogleApiClient googleApiClient, String str) {
        AppMethodBeat.m2504i(77132);
        ApiMethodImpl execute = googleApiClient.execute(new zzm(this, WorkAccount.API, googleApiClient, str));
        AppMethodBeat.m2505o(77132);
        return execute;
    }

    public final PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, Account account) {
        AppMethodBeat.m2504i(77133);
        ApiMethodImpl execute = googleApiClient.execute(new zzo(this, WorkAccount.API, googleApiClient, account));
        AppMethodBeat.m2505o(77133);
        return execute;
    }

    public final void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, boolean z) {
        AppMethodBeat.m2504i(77130);
        setWorkAuthenticatorEnabledWithResult(googleApiClient, z);
        AppMethodBeat.m2505o(77130);
    }

    public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient googleApiClient, boolean z) {
        AppMethodBeat.m2504i(77131);
        ApiMethodImpl execute = googleApiClient.execute(new zzl(this, WorkAccount.API, googleApiClient, z));
        AppMethodBeat.m2505o(77131);
        return execute;
    }
}
