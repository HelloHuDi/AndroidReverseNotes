package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Status;

final class zzr implements AddAccountResult {
    private final Status mStatus;
    private final Account zzn;

    public zzr(Status status, Account account) {
        this.mStatus = status;
        this.zzn = account;
    }

    public final Account getAccount() {
        return this.zzn;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
