package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj implements ResultConverter<AddAccountResult, Account> {
    zzj(WorkAccountClient workAccountClient) {
    }

    public final /* synthetic */ Object convert(Result result) {
        AppMethodBeat.i(76974);
        Account account = ((AddAccountResult) result).getAccount();
        AppMethodBeat.o(76974);
        return account;
    }
}
