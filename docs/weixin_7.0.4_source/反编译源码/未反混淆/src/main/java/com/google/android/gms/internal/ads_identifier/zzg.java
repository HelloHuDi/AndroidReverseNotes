package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg extends zza implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String getId() {
        AppMethodBeat.i(115351);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        AppMethodBeat.o(115351);
        return readString;
    }

    public final boolean zzb(boolean z) {
        AppMethodBeat.i(115352);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, true);
        obtainAndWriteInterfaceToken = transactAndReadException(2, obtainAndWriteInterfaceToken);
        boolean zza = zzc.zza(obtainAndWriteInterfaceToken);
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.o(115352);
        return zza;
    }

    public final boolean zzc() {
        AppMethodBeat.i(115353);
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        boolean zza = zzc.zza(transactAndReadException);
        transactAndReadException.recycle();
        AppMethodBeat.o(115353);
        return zza;
    }
}
