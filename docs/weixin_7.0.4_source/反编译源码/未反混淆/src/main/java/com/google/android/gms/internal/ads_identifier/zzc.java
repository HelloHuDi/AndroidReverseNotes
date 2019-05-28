package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(115350);
        AppMethodBeat.o(115350);
    }

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean z) {
        AppMethodBeat.i(115349);
        parcel.writeInt(1);
        AppMethodBeat.o(115349);
    }

    public static boolean zza(Parcel parcel) {
        AppMethodBeat.i(115348);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(115348);
            return true;
        }
        AppMethodBeat.o(115348);
        return false;
    }
}
