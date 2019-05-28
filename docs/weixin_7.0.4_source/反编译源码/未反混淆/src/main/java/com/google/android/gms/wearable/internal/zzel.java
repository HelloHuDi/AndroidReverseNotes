package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.zzb;
import com.google.android.gms.internal.wearable.zzc;
import com.tencent.view.d;

public abstract class zzel extends zzb implements zzek {
    public zzel() {
        super("com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zza((zzdw) zzc.zza(parcel, zzdw.CREATOR));
                break;
            case 3:
                zza((zzfu) zzc.zza(parcel, zzfu.CREATOR));
                break;
            case 4:
                zza((zzec) zzc.zza(parcel, zzec.CREATOR));
                break;
            case 5:
                zzb((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case 6:
                zza((zzdg) zzc.zza(parcel, zzdg.CREATOR));
                break;
            case 7:
                zza((zzga) zzc.zza(parcel, zzga.CREATOR));
                break;
            case 8:
                zza((zzee) zzc.zza(parcel, zzee.CREATOR));
                break;
            case 9:
                zza((zzeg) zzc.zza(parcel, zzeg.CREATOR));
                break;
            case 10:
                zza((zzea) zzc.zza(parcel, zzea.CREATOR));
                break;
            case 11:
                zza((Status) zzc.zza(parcel, Status.CREATOR));
                break;
            case 12:
                zza((zzge) zzc.zza(parcel, zzge.CREATOR));
                break;
            case 13:
                zza((zzdy) zzc.zza(parcel, zzdy.CREATOR));
                break;
            case 14:
                zza((zzfq) zzc.zza(parcel, zzfq.CREATOR));
                break;
            case 15:
                zza((zzbt) zzc.zza(parcel, zzbt.CREATOR));
                break;
            case 16:
                zzb((zzbt) zzc.zza(parcel, zzbt.CREATOR));
                break;
            case 17:
                zza((zzdm) zzc.zza(parcel, zzdm.CREATOR));
                break;
            case 18:
                zza((zzdo) zzc.zza(parcel, zzdo.CREATOR));
                break;
            case 19:
                zza((zzbn) zzc.zza(parcel, zzbn.CREATOR));
                break;
            case 20:
                zza((zzbp) zzc.zza(parcel, zzbp.CREATOR));
                break;
            case 22:
                zza((zzdk) zzc.zza(parcel, zzdk.CREATOR));
                break;
            case 23:
                zza((zzdi) zzc.zza(parcel, zzdi.CREATOR));
                break;
            case 26:
                zza((zzf) zzc.zza(parcel, zzf.CREATOR));
                break;
            case 27:
                zza((zzfy) zzc.zza(parcel, zzfy.CREATOR));
                break;
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                zza((zzdr) zzc.zza(parcel, zzdr.CREATOR));
                break;
            case 29:
                zza((zzdv) zzc.zza(parcel, zzdv.CREATOR));
                break;
            case 30:
                zza((zzdt) zzc.zza(parcel, zzdt.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
