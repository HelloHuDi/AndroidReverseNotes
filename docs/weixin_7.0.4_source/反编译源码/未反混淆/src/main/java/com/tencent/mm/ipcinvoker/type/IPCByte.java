package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCByte implements Parcelable {
    public static final Creator<IPCByte> CREATOR = new Creator<IPCByte>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCByte[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114135);
            IPCByte iPCByte = new IPCByte();
            iPCByte.value = parcel.readByte();
            AppMethodBeat.o(114135);
            return iPCByte;
        }
    };
    public byte value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114136);
        parcel.writeByte(this.value);
        AppMethodBeat.o(114136);
    }

    public String toString() {
        AppMethodBeat.i(114137);
        String num = Integer.toString(this.value);
        AppMethodBeat.o(114137);
        return num;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114138);
        if (obj == this) {
            AppMethodBeat.o(114138);
            return true;
        } else if (obj instanceof IPCByte) {
            if (this.value == ((IPCByte) obj).value) {
                AppMethodBeat.o(114138);
                return true;
            }
            AppMethodBeat.o(114138);
            return false;
        } else if (obj instanceof Byte) {
            boolean equals = obj.equals(Byte.valueOf(this.value));
            AppMethodBeat.o(114138);
            return equals;
        } else {
            AppMethodBeat.o(114138);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114139);
        AppMethodBeat.o(114139);
    }
}
