package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class zzfa extends zzn implements zzey {
    zzfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        AppMethodBeat.m2504i(68764);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken = transactAndReadException(7, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzjx.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68764);
        return createTypedArrayList;
    }

    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        AppMethodBeat.m2504i(68772);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        obtainAndWriteInterfaceToken = transactAndReadException(16, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzed.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68772);
        return createTypedArrayList;
    }

    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(68771);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken = transactAndReadException(15, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzjx.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68771);
        return createTypedArrayList;
    }

    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        AppMethodBeat.m2504i(68770);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        obtainAndWriteInterfaceToken = transactAndReadException(14, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzjx.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68770);
        return createTypedArrayList;
    }

    public final void zza(long j, String str, String str2, String str3) {
        AppMethodBeat.m2504i(68766);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68766);
    }

    public final void zza(zzdz zzdz) {
        AppMethodBeat.m2504i(68761);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68761);
    }

    public final void zza(zzed zzed, zzdz zzdz) {
        AppMethodBeat.m2504i(68768);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzed);
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68768);
    }

    public final void zza(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.m2504i(68759);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzeu);
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68759);
    }

    public final void zza(zzeu zzeu, String str, String str2) {
        AppMethodBeat.m2504i(68762);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzeu);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68762);
    }

    public final void zza(zzjx zzjx, zzdz zzdz) {
        AppMethodBeat.m2504i(68760);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzjx);
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68760);
    }

    public final byte[] zza(zzeu zzeu, String str) {
        AppMethodBeat.m2504i(68765);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzeu);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken = transactAndReadException(9, obtainAndWriteInterfaceToken);
        byte[] createByteArray = obtainAndWriteInterfaceToken.createByteArray();
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68765);
        return createByteArray;
    }

    public final void zzb(zzdz zzdz) {
        AppMethodBeat.m2504i(68763);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68763);
    }

    public final void zzb(zzed zzed) {
        AppMethodBeat.m2504i(68769);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzed);
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68769);
    }

    public final String zzc(zzdz zzdz) {
        AppMethodBeat.m2504i(68767);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        obtainAndWriteInterfaceToken = transactAndReadException(11, obtainAndWriteInterfaceToken);
        String readString = obtainAndWriteInterfaceToken.readString();
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68767);
        return readString;
    }

    public final void zzd(zzdz zzdz) {
        AppMethodBeat.m2504i(68774);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdz);
        transactAndReadExceptionReturnVoid(18, obtainAndWriteInterfaceToken);
        AppMethodBeat.m2505o(68774);
    }

    public final List<zzed> zze(String str, String str2, String str3) {
        AppMethodBeat.m2504i(68773);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        obtainAndWriteInterfaceToken = transactAndReadException(17, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzed.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        AppMethodBeat.m2505o(68773);
        return createTypedArrayList;
    }
}
