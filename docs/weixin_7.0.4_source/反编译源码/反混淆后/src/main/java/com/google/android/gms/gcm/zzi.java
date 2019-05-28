package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzi implements Creator<OneoffTask> {
    zzi() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(70031);
        OneoffTask oneoffTask = new OneoffTask(parcel, null);
        AppMethodBeat.m2505o(70031);
        return oneoffTask;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new OneoffTask[i];
    }
}
