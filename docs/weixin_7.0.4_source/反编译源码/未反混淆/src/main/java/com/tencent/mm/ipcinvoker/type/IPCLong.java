package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCLong implements Parcelable {
    public static final Creator<IPCLong> CREATOR = new Creator<IPCLong>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCLong[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114155);
            IPCLong iPCLong = new IPCLong();
            iPCLong.value = parcel.readLong();
            AppMethodBeat.o(114155);
            return iPCLong;
        }
    };
    public long value;

    public IPCLong(long j) {
        this.value = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114156);
        parcel.writeLong(this.value);
        AppMethodBeat.o(114156);
    }

    public String toString() {
        AppMethodBeat.i(114157);
        String l = Long.toString(this.value);
        AppMethodBeat.o(114157);
        return l;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114158);
        if (obj == this) {
            AppMethodBeat.o(114158);
            return true;
        } else if (obj instanceof IPCLong) {
            if (this.value == ((IPCLong) obj).value) {
                AppMethodBeat.o(114158);
                return true;
            }
            AppMethodBeat.o(114158);
            return false;
        } else if (obj instanceof Long) {
            boolean equals = obj.equals(Long.valueOf(this.value));
            AppMethodBeat.o(114158);
            return equals;
        } else {
            AppMethodBeat.o(114158);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114159);
        AppMethodBeat.o(114159);
    }
}
