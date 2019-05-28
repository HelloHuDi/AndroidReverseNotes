package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzad extends zzd implements zzac {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zzd(zzaa zzaa, zzae zzae) {
        AppMethodBeat.m2504i(77084);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzae);
        transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(77084);
    }

    public final void zzd(zzaa zzaa, zzag zzag) {
        AppMethodBeat.m2504i(77081);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzag);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(77081);
    }

    public final void zzd(zzaa zzaa, zzai zzai) {
        AppMethodBeat.m2504i(77080);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzai);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(77080);
    }

    public final void zzd(zzaa zzaa, zzak zzak) {
        AppMethodBeat.m2504i(77083);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzak);
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(77083);
    }

    public final void zzd(zzaa zzaa, zzy zzy) {
        AppMethodBeat.m2504i(77082);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) zzy);
        transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(77082);
    }
}
