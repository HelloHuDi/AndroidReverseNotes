package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WorkAccountClient extends GoogleApi<NoOptions> {
    private final WorkAccountApi zzae = new zzk();

    WorkAccountClient(Activity activity) {
        super(activity, WorkAccount.API, null, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.i(76966);
        AppMethodBeat.o(76966);
    }

    WorkAccountClient(Context context) {
        super(context, WorkAccount.API, null, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.i(76965);
        AppMethodBeat.o(76965);
    }

    public Task<Account> addWorkAccount(String str) {
        AppMethodBeat.i(76968);
        Task toTask = PendingResultUtil.toTask(this.zzae.addWorkAccount(asGoogleApiClient(), str), new zzj(this));
        AppMethodBeat.o(76968);
        return toTask;
    }

    public Task<Void> removeWorkAccount(Account account) {
        AppMethodBeat.i(76969);
        Task toVoidTask = PendingResultUtil.toVoidTask(this.zzae.removeWorkAccount(asGoogleApiClient(), account));
        AppMethodBeat.o(76969);
        return toVoidTask;
    }

    public Task<Void> setWorkAuthenticatorEnabled(boolean z) {
        AppMethodBeat.i(76967);
        Task toVoidTask = PendingResultUtil.toVoidTask(this.zzae.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), z));
        AppMethodBeat.o(76967);
        return toVoidTask;
    }
}
