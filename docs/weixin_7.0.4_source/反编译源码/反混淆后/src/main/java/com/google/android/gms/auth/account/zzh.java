package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzd;
import com.google.android.gms.internal.auth.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh extends zzd implements zzf {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    public final void zzd(zzd zzd, Account account) {
        AppMethodBeat.m2504i(76972);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzd);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) account);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(76972);
    }

    public final void zzd(zzd zzd, String str) {
        AppMethodBeat.m2504i(76971);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzd);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(76971);
    }

    public final void zze(boolean z) {
        AppMethodBeat.m2504i(76970);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, z);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(76970);
    }
}
