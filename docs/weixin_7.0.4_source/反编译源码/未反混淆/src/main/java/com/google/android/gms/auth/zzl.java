package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzbr;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl implements zzm<Boolean> {
    private final /* synthetic */ String zzw;

    zzl(String str) {
        this.zzw = str;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) {
        AppMethodBeat.i(77078);
        Bundle bundle = (Bundle) zzg.zze(zzi.zzd(iBinder).zzd(this.zzw));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzbr zzh = zzbr.zzh(string);
        if (zzbr.SUCCESS.equals(zzh)) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(77078);
            return bool;
        } else if (zzbr.zzd(zzh)) {
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(zzh);
            objArr[0] = new StringBuilder(String.valueOf(valueOf).length() + 31).append("isUserRecoverableError status: ").append(valueOf).toString();
            zzg.zzq.w("GoogleAuthUtil", objArr);
            UserRecoverableAuthException userRecoverableAuthException = new UserRecoverableAuthException(string, intent);
            AppMethodBeat.o(77078);
            throw userRecoverableAuthException;
        } else {
            GoogleAuthException googleAuthException = new GoogleAuthException(string);
            AppMethodBeat.o(77078);
            throw googleAuthException;
        }
    }
}
