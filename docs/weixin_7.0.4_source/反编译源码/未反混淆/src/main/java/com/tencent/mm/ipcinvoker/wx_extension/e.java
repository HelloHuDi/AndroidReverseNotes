package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;

public final class e implements a {
    public final boolean aq(Object obj) {
        return obj instanceof Parcel;
    }

    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(126201);
        Parcel parcel2 = (Parcel) obj;
        parcel2.setDataPosition(0);
        parcel.writeInt(parcel2.dataSize());
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        AppMethodBeat.o(126201);
    }

    public final Object d(Parcel parcel) {
        AppMethodBeat.i(126202);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.appendFrom(parcel, parcel.dataPosition(), parcel.readInt());
        obtain.setDataPosition(0);
        AppMethodBeat.o(126202);
        return obtain;
    }
}
