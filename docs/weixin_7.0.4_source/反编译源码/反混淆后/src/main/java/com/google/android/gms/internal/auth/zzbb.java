package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzbb extends zze implements zzba {
    public zzbb() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzd((Status) zzf.zzd(parcel, Status.CREATOR), (Credential) zzf.zzd(parcel, Credential.CREATOR));
                break;
            case 2:
                zze((Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            case 3:
                zzd((Status) zzf.zzd(parcel, Status.CREATOR), parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
