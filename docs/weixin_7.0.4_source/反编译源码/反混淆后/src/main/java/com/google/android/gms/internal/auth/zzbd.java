package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbd extends zzd implements zzbc {
    zzbd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zzd(zzba zzba) {
        AppMethodBeat.m2504i(50494);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzba);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50494);
    }

    public final void zzd(zzba zzba, CredentialRequest credentialRequest) {
        AppMethodBeat.m2504i(50491);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) credentialRequest);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50491);
    }

    public final void zzd(zzba zzba, zzay zzay) {
        AppMethodBeat.m2504i(50493);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzay);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50493);
    }

    public final void zzd(zzba zzba, zzbe zzbe) {
        AppMethodBeat.m2504i(50492);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzbe);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50492);
    }
}
