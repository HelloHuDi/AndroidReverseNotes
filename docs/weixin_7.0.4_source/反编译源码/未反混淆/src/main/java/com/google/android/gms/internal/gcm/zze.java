package com.google.android.gms.internal.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zze {
    private static final ClassLoader zzf = zze.class.getClassLoader();

    static {
        AppMethodBeat.i(57622);
        AppMethodBeat.o(57622);
    }

    private zze() {
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(57621);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(57621);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(57621);
    }
}
