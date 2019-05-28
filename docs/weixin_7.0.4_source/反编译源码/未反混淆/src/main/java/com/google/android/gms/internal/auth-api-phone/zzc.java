package com.google.android.gms.internal.auth-api-phone;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(80430);
        AppMethodBeat.o(80430);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Creator<T> creator) {
        AppMethodBeat.i(80428);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(80428);
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        AppMethodBeat.o(80428);
        return parcelable;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(80429);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(80429);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(80429);
    }
}
