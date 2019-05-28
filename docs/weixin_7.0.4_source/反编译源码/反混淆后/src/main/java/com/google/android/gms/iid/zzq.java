package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzq implements Creator<MessengerCompat> {
    zzq() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(57598);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            MessengerCompat messengerCompat = new MessengerCompat(readStrongBinder);
            AppMethodBeat.m2505o(57598);
            return messengerCompat;
        }
        AppMethodBeat.m2505o(57598);
        return null;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MessengerCompat[i];
    }
}
