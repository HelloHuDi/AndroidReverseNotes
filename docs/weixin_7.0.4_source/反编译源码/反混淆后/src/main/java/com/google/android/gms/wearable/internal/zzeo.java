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
        AppMethodBeat.m2504i(71252);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeTypedList(list);
        transactOneway(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71252);
    }

    public final void zza(DataHolder dataHolder) {
        AppMethodBeat.m2504i(71248);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) dataHolder);
        transactOneway(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71248);
    }

    public final void zza(zzah zzah) {
        AppMethodBeat.m2504i(71255);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzah);
        transactOneway(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71255);
    }

    public final void zza(zzaw zzaw) {
        AppMethodBeat.m2504i(71254);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaw);
        transactOneway(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71254);
    }

    public final void zza(zzfe zzfe) {
        AppMethodBeat.m2504i(71249);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfe);
        transactOneway(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71249);
    }

    public final void zza(zzfo zzfo) {
        AppMethodBeat.m2504i(71250);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfo);
        transactOneway(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71250);
    }

    public final void zza(zzi zzi) {
        AppMethodBeat.m2504i(71256);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzi);
        transactOneway(9, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71256);
    }

    public final void zza(zzl zzl) {
        AppMethodBeat.m2504i(71253);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzl);
        transactOneway(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71253);
    }

    public final void zzb(zzfo zzfo) {
        AppMethodBeat.m2504i(71251);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfo);
        transactOneway(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(71251);
    }
}
