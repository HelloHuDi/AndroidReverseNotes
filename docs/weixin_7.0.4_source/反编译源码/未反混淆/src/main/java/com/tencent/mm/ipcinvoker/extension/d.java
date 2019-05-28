package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements a {
    public final boolean aq(Object obj) {
        return obj instanceof Parcelable;
    }

    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(114086);
        parcel.writeParcelable((Parcelable) obj, 0);
        AppMethodBeat.o(114086);
    }

    public final Object d(Parcel parcel) {
        AppMethodBeat.i(114087);
        Parcelable readParcelable = parcel.readParcelable(getClass().getClassLoader());
        AppMethodBeat.o(114087);
        return readParcelable;
    }
}
