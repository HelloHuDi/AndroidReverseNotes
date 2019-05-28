package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;

public final class g implements a {
    public final boolean aq(Object obj) {
        return obj instanceof f;
    }

    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(114101);
        f fVar = (f) obj;
        parcel.writeString(fVar.getClass().getName());
        fVar.e(parcel);
        AppMethodBeat.o(114101);
    }

    public final Object d(Parcel parcel) {
        AppMethodBeat.i(114102);
        f fVar = (f) k.c(parcel.readString(), f.class);
        if (fVar != null) {
            fVar.readFromParcel(parcel);
            AppMethodBeat.o(114102);
            return fVar;
        }
        AppMethodBeat.o(114102);
        return null;
    }
}
