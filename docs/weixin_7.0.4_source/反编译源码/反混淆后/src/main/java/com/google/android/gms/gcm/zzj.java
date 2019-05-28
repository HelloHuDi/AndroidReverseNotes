package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj implements Creator<PendingCallback> {
    zzj() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(70032);
        PendingCallback pendingCallback = new PendingCallback(parcel);
        AppMethodBeat.m2505o(70032);
        return pendingCallback;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PendingCallback[i];
    }
}
