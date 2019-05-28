package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCInteger implements Parcelable {
    public static final Creator<IPCInteger> CREATOR = new Creator<IPCInteger>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCInteger[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114150);
            IPCInteger iPCInteger = new IPCInteger();
            iPCInteger.value = parcel.readInt();
            AppMethodBeat.o(114150);
            return iPCInteger;
        }
    };
    public int value;

    public IPCInteger(int i) {
        this.value = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114151);
        parcel.writeInt(this.value);
        AppMethodBeat.o(114151);
    }

    public String toString() {
        AppMethodBeat.i(114152);
        String num = Integer.toString(this.value);
        AppMethodBeat.o(114152);
        return num;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114153);
        if (obj == this) {
            AppMethodBeat.o(114153);
            return true;
        } else if (obj instanceof IPCInteger) {
            if (this.value == ((IPCInteger) obj).value) {
                AppMethodBeat.o(114153);
                return true;
            }
            AppMethodBeat.o(114153);
            return false;
        } else if (obj instanceof Integer) {
            boolean equals = obj.equals(Integer.valueOf(this.value));
            AppMethodBeat.o(114153);
            return equals;
        } else {
            AppMethodBeat.o(114153);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114154);
        AppMethodBeat.o(114154);
    }
}
