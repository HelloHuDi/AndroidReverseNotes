package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class PendingCallback implements Parcelable, ReflectedParcelable {
    public static final Creator<PendingCallback> CREATOR = new zzj();
    final IBinder zzal;

    static {
        AppMethodBeat.m2504i(69996);
        AppMethodBeat.m2505o(69996);
    }

    public PendingCallback(Parcel parcel) {
        AppMethodBeat.m2504i(69994);
        this.zzal = parcel.readStrongBinder();
        AppMethodBeat.m2505o(69994);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(69995);
        parcel.writeStrongBinder(this.zzal);
        AppMethodBeat.m2505o(69995);
    }
}
