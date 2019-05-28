package com.tencent.ttpic.baseutils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelHelper {
    public static <T> T copy(Parcelable parcelable) {
        AppMethodBeat.i(49791);
        Parcel parcel = null;
        try {
            parcel = Parcel.obtain();
            parcel.writeParcelable(parcelable, 0);
            parcel.setDataPosition(0);
            T readParcelable = parcel.readParcelable(parcelable.getClass().getClassLoader());
            return readParcelable;
        } finally {
            parcel.recycle();
            AppMethodBeat.o(49791);
        }
    }
}
