package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class z implements Creator<zzi> {
    z() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.i(108792);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            zzi zzi = new zzi(readStrongBinder);
            AppMethodBeat.o(108792);
            return zzi;
        }
        AppMethodBeat.o(108792);
        return null;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzi[i];
    }
}
