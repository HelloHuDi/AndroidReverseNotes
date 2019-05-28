package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeq extends zza implements zzep {
    zzeq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    public final void zza(zzek zzek) {
        AppMethodBeat.i(71259);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71259);
    }

    public final void zza(zzek zzek, int i) {
        AppMethodBeat.i(71267);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(43, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71267);
    }

    public final void zza(zzek zzek, Uri uri) {
        AppMethodBeat.i(71258);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) uri);
        transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71258);
    }

    public final void zza(zzek zzek, Uri uri, int i) {
        AppMethodBeat.i(71260);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) uri);
        obtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(40, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71260);
    }

    public final void zza(zzek zzek, Asset asset) {
        AppMethodBeat.i(71263);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) asset);
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71263);
    }

    public final void zza(zzek zzek, PutDataRequest putDataRequest) {
        AppMethodBeat.i(71257);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) putDataRequest);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71257);
    }

    public final void zza(zzek zzek, zzd zzd) {
        AppMethodBeat.i(71270);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzd);
        transactAndReadExceptionReturnVoid(16, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71270);
    }

    public final void zza(zzek zzek, zzei zzei, String str) {
        AppMethodBeat.i(71275);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzei);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(34, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71275);
    }

    public final void zza(zzek zzek, zzfw zzfw) {
        AppMethodBeat.i(71271);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfw);
        transactAndReadExceptionReturnVoid(17, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71271);
    }

    public final void zza(zzek zzek, String str) {
        AppMethodBeat.i(71268);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(46, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71268);
    }

    public final void zza(zzek zzek, String str, int i) {
        AppMethodBeat.i(71266);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(42, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71266);
    }

    public final void zza(zzek zzek, String str, ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(71277);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) parcelFileDescriptor);
        transactAndReadExceptionReturnVoid(38, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71277);
    }

    public final void zza(zzek zzek, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
        AppMethodBeat.i(71278);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) parcelFileDescriptor);
        obtainAndWriteInterfaceToken.writeLong(j);
        obtainAndWriteInterfaceToken.writeLong(j2);
        transactAndReadExceptionReturnVoid(39, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71278);
    }

    public final void zza(zzek zzek, String str, String str2) {
        AppMethodBeat.i(71272);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(31, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71272);
    }

    public final void zza(zzek zzek, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(71262);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeByteArray(bArr);
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71262);
    }

    public final void zzb(zzek zzek) {
        AppMethodBeat.i(71264);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        transactAndReadExceptionReturnVoid(14, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71264);
    }

    public final void zzb(zzek zzek, Uri uri, int i) {
        AppMethodBeat.i(71261);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) uri);
        obtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(41, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71261);
    }

    public final void zzb(zzek zzek, zzei zzei, String str) {
        AppMethodBeat.i(71276);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzei);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(35, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71276);
    }

    public final void zzb(zzek zzek, String str) {
        AppMethodBeat.i(71269);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(47, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71269);
    }

    public final void zzb(zzek zzek, String str, int i) {
        AppMethodBeat.i(71274);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(33, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71274);
    }

    public final void zzc(zzek zzek) {
        AppMethodBeat.i(71265);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        transactAndReadExceptionReturnVoid(15, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71265);
    }

    public final void zzc(zzek zzek, String str) {
        AppMethodBeat.i(71273);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(32, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(71273);
    }
}
