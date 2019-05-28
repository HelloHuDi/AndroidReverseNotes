package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.internal.wearable.zzb;

public abstract class zzej extends zzb implements zzei {
    public zzej() {
        super("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
    }

    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        zza(parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
