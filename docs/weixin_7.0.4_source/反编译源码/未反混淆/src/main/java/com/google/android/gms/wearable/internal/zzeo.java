package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzeo extends zza implements zzem {
    zzeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    public final void onConnectedNodes(List<zzfo> list) {
        AppMethodBeat.i(71252);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeTypedList(list);
        transactOneway(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71252);
    }

    public final void zza(DataHolder dataHolder) {
        AppMethodBeat.i(71248);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) dataHolder);
        transactOneway(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71248);
    }

    public final void zza(zzah zzah) {
        AppMethodBeat.i(71255);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzah);
        transactOneway(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71255);
    }

    public final void zza(zzaw zzaw) {
        AppMethodBeat.i(71254);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaw);
        transactOneway(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71254);
    }

    public final void zza(zzfe zzfe) {
        AppMethodBeat.i(71249);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfe);
        transactOneway(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71249);
    }

    public final void zza(zzfo zzfo) {
        AppMethodBeat.i(71250);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfo);
        transactOneway(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71250);
    }

    public final void zza(zzi zzi) {
        AppMethodBeat.i(71256);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzi);
        transactOneway(9, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71256);
    }

    public final void zza(zzl zzl) {
        AppMethodBeat.i(71253);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzl);
        transactOneway(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71253);
    }

    public final void zzb(zzfo zzfo) {
        AppMethodBeat.i(71251);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfo);
        transactOneway(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71251);
    }
}
