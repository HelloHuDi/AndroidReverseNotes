package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCVoid implements Parcelable {
    public static final Creator<IPCVoid> CREATOR = new Creator<IPCVoid>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCVoid[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114164);
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(114164);
            return iPCVoid;
        }
    };
    public static final IPCVoid eGH = new IPCVoid();

    static {
        AppMethodBeat.i(114165);
        AppMethodBeat.o(114165);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
