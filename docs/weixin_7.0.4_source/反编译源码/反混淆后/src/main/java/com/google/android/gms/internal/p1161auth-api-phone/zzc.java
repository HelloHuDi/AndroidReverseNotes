package com.google.android.gms.internal.p1161auth-api-phone;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzc */
public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.m2504i(80430);
        AppMethodBeat.m2505o(80430);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Creator<T> creator) {
        AppMethodBeat.m2504i(80428);
        if (parcel.readInt() == 0) {
            AppMethodBeat.m2505o(80428);
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        AppMethodBeat.m2505o(80428);
        return parcelable;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.m2504i(80429);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.m2505o(80429);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.m2505o(80429);
    }
}
