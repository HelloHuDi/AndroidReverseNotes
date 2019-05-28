package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCBoolean implements Parcelable {
    public static final Creator<IPCBoolean> CREATOR = new Creator<IPCBoolean>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCBoolean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(114130);
            IPCBoolean iPCBoolean = new IPCBoolean();
            if (parcel.readInt() != 1) {
                z = false;
            }
            iPCBoolean.value = z;
            AppMethodBeat.o(114130);
            return iPCBoolean;
        }
    };
    public boolean value;

    public IPCBoolean(boolean z) {
        this.value = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114131);
        parcel.writeInt(this.value ? 1 : 0);
        AppMethodBeat.o(114131);
    }

    public String toString() {
        AppMethodBeat.i(114132);
        String bool = Boolean.toString(this.value);
        AppMethodBeat.o(114132);
        return bool;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114133);
        if (obj == this) {
            AppMethodBeat.o(114133);
            return true;
        } else if (obj instanceof IPCBoolean) {
            if (this.value == ((IPCBoolean) obj).value) {
                AppMethodBeat.o(114133);
                return true;
            }
            AppMethodBeat.o(114133);
            return false;
        } else if (obj instanceof Boolean) {
            boolean equals = obj.equals(Boolean.valueOf(this.value));
            AppMethodBeat.o(114133);
            return equals;
        } else {
            AppMethodBeat.o(114133);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114134);
        AppMethodBeat.o(114134);
    }
}
