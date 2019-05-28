package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzbr;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class zzh implements zzm<TokenData> {
    private final /* synthetic */ Bundle val$options;
    private final /* synthetic */ Account zzr;
    private final /* synthetic */ String zzs;

    zzh(Account account, String str, Bundle bundle) {
        this.zzr = account;
        this.zzs = str;
        this.val$options = bundle;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) {
        AppMethodBeat.m2504i(77074);
        Bundle bundle = (Bundle) zzg.zze(zzi.zzd(iBinder).zzd(this.zzr, this.zzs, this.val$options));
        TokenData zzd = TokenData.zzd(bundle, "tokenDetails");
        if (zzd != null) {
            AppMethodBeat.m2505o(77074);
            return zzd;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzbr zzh = zzbr.zzh(string);
        if (zzbr.zzd(zzh)) {
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(zzh);
            objArr[0] = new StringBuilder(String.valueOf(valueOf).length() + 31).append("isUserRecoverableError status: ").append(valueOf).toString();
            zzg.zzq.mo59638w("GoogleAuthUtil", objArr);
            UserRecoverableAuthException userRecoverableAuthException = new UserRecoverableAuthException(string, intent);
            AppMethodBeat.m2505o(77074);
            throw userRecoverableAuthException;
        }
        int i = (zzbr.NETWORK_ERROR.equals(zzh) || zzbr.SERVICE_UNAVAILABLE.equals(zzh)) ? 1 : 0;
        if (i != 0) {
            IOException iOException = new IOException(string);
            AppMethodBeat.m2505o(77074);
            throw iOException;
        }
        GoogleAuthException googleAuthException = new GoogleAuthException(string);
        AppMethodBeat.m2505o(77074);
        throw googleAuthException;
    }
}
