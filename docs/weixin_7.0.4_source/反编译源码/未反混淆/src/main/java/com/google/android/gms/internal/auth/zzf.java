package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzf {
    private static final ClassLoader zzg = zzf.class.getClassLoader();

    static {
        AppMethodBeat.i(77124);
        AppMethodBeat.o(77124);
    }

    private zzf() {
    }

    public static <T extends Parcelable> T zzd(Parcel parcel, Creator<T> creator) {
        AppMethodBeat.i(77121);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(77121);
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        AppMethodBeat.o(77121);
        return parcelable;
    }

    public static void zzd(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(77123);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(77123);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(77123);
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(77122);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(77122);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(77122);
    }

    public static void zzd(Parcel parcel, boolean z) {
        AppMethodBeat.i(77120);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.o(77120);
    }

    public static boolean zzd(Parcel parcel) {
        AppMethodBeat.i(77119);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(77119);
            return true;
        }
        AppMethodBeat.o(77119);
        return false;
    }
}
