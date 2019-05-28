package com.google.android.gms.internal.stable;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.m2504i(90470);
        AppMethodBeat.m2505o(90470);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Creator<T> creator) {
        AppMethodBeat.m2504i(90466);
        if (parcel.readInt() == 0) {
            AppMethodBeat.m2505o(90466);
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        AppMethodBeat.m2505o(90466);
        return parcelable;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.m2504i(90469);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.m2505o(90469);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.m2505o(90469);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.m2504i(90467);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.m2505o(90467);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.m2505o(90467);
    }

    public static void zza(Parcel parcel, boolean z) {
        AppMethodBeat.m2504i(90465);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.m2505o(90465);
    }

    public static boolean zza(Parcel parcel) {
        AppMethodBeat.m2504i(90464);
        if (parcel.readInt() != 0) {
            AppMethodBeat.m2505o(90464);
            return true;
        }
        AppMethodBeat.m2505o(90464);
        return false;
    }

    public static void zzb(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.m2504i(90468);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.m2505o(90468);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
        AppMethodBeat.m2505o(90468);
    }
}
