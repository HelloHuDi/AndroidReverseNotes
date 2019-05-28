package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk implements Creator<PeriodicTask> {
    zzk() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(70033);
        PeriodicTask periodicTask = new PeriodicTask(parcel, null);
        AppMethodBeat.m2505o(70033);
        return periodicTask;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PeriodicTask[i];
    }
}
