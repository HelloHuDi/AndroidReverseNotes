package com.tencent.mm.ipcinvoker.extension;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.k;

public final class b implements a {
    public final boolean aq(Object obj) {
        return obj instanceof a;
    }

    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(114079);
        a aVar = (a) obj;
        parcel.writeString(aVar.getClass().getName());
        parcel.writeBundle(aVar.toBundle());
        AppMethodBeat.o(114079);
    }

    public final Object d(Parcel parcel) {
        AppMethodBeat.i(114080);
        String readString = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        a aVar = (a) k.c(readString, a.class);
        if (aVar != null) {
            aVar.fromBundle(readBundle);
            AppMethodBeat.o(114080);
            return aVar;
        }
        AppMethodBeat.o(114080);
        return null;
    }
}
