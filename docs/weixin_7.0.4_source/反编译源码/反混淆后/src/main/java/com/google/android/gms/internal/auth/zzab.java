package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.auth.api.accounttransfer.zzw;
import com.google.android.gms.common.api.Status;

public abstract class zzab extends zze implements zzaa {
    public zzab() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zze((Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            case 2:
                zzd((Status) zzf.zzd(parcel, Status.CREATOR), (zzw) zzf.zzd(parcel, zzw.CREATOR));
                break;
            case 3:
                zzd((Status) zzf.zzd(parcel, Status.CREATOR), (zzo) zzf.zzd(parcel, zzo.CREATOR));
                break;
            case 4:
                zzi();
                break;
            case 5:
                onFailure((Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            case 6:
                zzd(parcel.createByteArray());
                break;
            case 7:
                zzd((DeviceMetaData) zzf.zzd(parcel, DeviceMetaData.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
