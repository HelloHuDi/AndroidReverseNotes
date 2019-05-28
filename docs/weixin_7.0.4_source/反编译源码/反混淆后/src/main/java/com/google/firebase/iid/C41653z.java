package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.z */
final class C41653z implements Creator<zzi> {
    C41653z() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(108792);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            zzi zzi = new zzi(readStrongBinder);
            AppMethodBeat.m2505o(108792);
            return zzi;
        }
        AppMethodBeat.m2505o(108792);
        return null;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzi[i];
    }
}
