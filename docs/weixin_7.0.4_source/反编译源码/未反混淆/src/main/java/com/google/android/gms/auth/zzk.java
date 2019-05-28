package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk implements zzm<Bundle> {
    private final /* synthetic */ Account zzr;

    zzk(Account account) {
        this.zzr = account;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) {
        AppMethodBeat.i(77077);
        Bundle bundle = (Bundle) zzg.zze(zzi.zzd(iBinder).zzd(this.zzr));
        AppMethodBeat.o(77077);
        return bundle;
    }
}
