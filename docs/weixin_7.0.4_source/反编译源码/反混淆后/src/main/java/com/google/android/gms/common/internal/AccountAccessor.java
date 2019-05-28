package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountAccessor extends Stub {
    private Context mContext;
    private int zzqu = -1;
    private Account zzs;

    public AccountAccessor(Context context, Account account) {
        AppMethodBeat.m2504i(89557);
        this.mContext = context.getApplicationContext();
        this.zzs = account;
        AppMethodBeat.m2505o(89557);
    }

    public static AccountAccessor fromGoogleAccountName(Context context, String str) {
        AppMethodBeat.m2504i(89555);
        AccountAccessor accountAccessor = new AccountAccessor(context, TextUtils.isEmpty(str) ? null : new Account(str, "com.google"));
        AppMethodBeat.m2505o(89555);
        return accountAccessor;
    }

    public static Account getAccountBinderSafe(IAccountAccessor iAccountAccessor) {
        AppMethodBeat.m2504i(89556);
        Account account = null;
        if (iAccountAccessor != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = iAccountAccessor.getAccount();
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } catch (RemoteException e) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
                AppMethodBeat.m2505o(89556);
            }
        }
        AppMethodBeat.m2505o(89556);
        return account;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(89559);
        if (this == obj) {
            AppMethodBeat.m2505o(89559);
            return true;
        } else if (obj instanceof AccountAccessor) {
            boolean equals = this.zzs.equals(((AccountAccessor) obj).zzs);
            AppMethodBeat.m2505o(89559);
            return equals;
        } else {
            AppMethodBeat.m2505o(89559);
            return false;
        }
    }

    public Account getAccount() {
        AppMethodBeat.m2504i(89558);
        int callingUid = Binder.getCallingUid();
        Account account;
        if (callingUid == this.zzqu) {
            account = this.zzs;
            AppMethodBeat.m2505o(89558);
            return account;
        } else if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.mContext, callingUid)) {
            this.zzqu = callingUid;
            account = this.zzs;
            AppMethodBeat.m2505o(89558);
            return account;
        } else {
            SecurityException securityException = new SecurityException("Caller is not GooglePlayServices");
            AppMethodBeat.m2505o(89558);
            throw securityException;
        }
    }
}
