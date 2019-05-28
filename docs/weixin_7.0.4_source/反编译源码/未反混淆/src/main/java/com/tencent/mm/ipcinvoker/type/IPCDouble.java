package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCDouble implements Parcelable {
    public static final Creator<IPCDouble> CREATOR = new Creator<IPCDouble>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCDouble[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114140);
            IPCDouble iPCDouble = new IPCDouble();
            iPCDouble.value = parcel.readDouble();
            AppMethodBeat.o(114140);
            return iPCDouble;
        }
    };
    public double value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114141);
        parcel.writeDouble(this.value);
        AppMethodBeat.o(114141);
    }

    public String toString() {
        AppMethodBeat.i(114142);
        String d = Double.toString(this.value);
        AppMethodBeat.o(114142);
        return d;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114143);
        if (obj == this) {
            AppMethodBeat.o(114143);
            return true;
        } else if (obj instanceof IPCDouble) {
            if (this.value == ((IPCDouble) obj).value) {
                AppMethodBeat.o(114143);
                return true;
            }
            AppMethodBeat.o(114143);
            return false;
        } else if (obj instanceof Double) {
            boolean equals = obj.equals(Double.valueOf(this.value));
            AppMethodBeat.o(114143);
            return equals;
        } else {
            AppMethodBeat.o(114143);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114144);
        AppMethodBeat.o(114144);
    }
}
