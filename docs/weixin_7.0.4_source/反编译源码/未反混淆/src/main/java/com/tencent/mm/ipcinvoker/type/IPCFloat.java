package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCFloat implements Parcelable {
    public static final Creator<IPCFloat> CREATOR = new Creator<IPCFloat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCFloat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114145);
            IPCFloat iPCFloat = new IPCFloat();
            iPCFloat.value = parcel.readFloat();
            AppMethodBeat.o(114145);
            return iPCFloat;
        }
    };
    public float value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114146);
        parcel.writeFloat(this.value);
        AppMethodBeat.o(114146);
    }

    public String toString() {
        AppMethodBeat.i(114147);
        String f = Float.toString(this.value);
        AppMethodBeat.o(114147);
        return f;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114148);
        if (obj == this) {
            AppMethodBeat.o(114148);
            return true;
        } else if (obj instanceof IPCFloat) {
            if (this.value == ((IPCFloat) obj).value) {
                AppMethodBeat.o(114148);
                return true;
            }
            AppMethodBeat.o(114148);
            return false;
        } else if (obj instanceof Float) {
            boolean equals = obj.equals(Float.valueOf(this.value));
            AppMethodBeat.o(114148);
            return equals;
        } else {
            AppMethodBeat.o(114148);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114149);
        AppMethodBeat.o(114149);
    }
}
