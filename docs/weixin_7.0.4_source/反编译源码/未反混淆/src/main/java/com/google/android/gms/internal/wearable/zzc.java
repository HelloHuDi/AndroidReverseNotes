package com.google.android.gms.internal.wearable;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(70673);
        AppMethodBeat.o(70673);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Creator<T> creator) {
        AppMethodBeat.i(70670);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(70670);
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        AppMethodBeat.o(70670);
        return parcelable;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(70672);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(70672);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(70672);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(70671);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(70671);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(70671);
    }
}
