package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.auth.zzd;
import com.google.android.gms.internal.auth.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzw extends zzd implements zzv {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zzd(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.m2504i(50456);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzt);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) googleSignInOptions);
        transactAndReadExceptionReturnVoid(101, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50456);
    }

    public final void zze(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.m2504i(50457);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzt);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) googleSignInOptions);
        transactAndReadExceptionReturnVoid(102, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50457);
    }

    public final void zzf(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.m2504i(50458);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzt);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) googleSignInOptions);
        transactAndReadExceptionReturnVoid(103, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(50458);
    }
}
