package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public interface zzh extends IInterface {
    Bundle zzd(Account account);

    Bundle zzd(Account account, String str, Bundle bundle);

    Bundle zzd(String str);

    Bundle zzd(String str, Bundle bundle);

    AccountChangeEventsResponse zzd(AccountChangeEventsRequest accountChangeEventsRequest);
}
