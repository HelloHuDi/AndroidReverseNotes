package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza implements Creator<BinderWrapper> {
    zza() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.i(89861);
        BinderWrapper binderWrapper = new BinderWrapper(parcel, null);
        AppMethodBeat.o(89861);
        return binderWrapper;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
