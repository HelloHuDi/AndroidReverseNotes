package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCString implements Parcelable {
    public static final Creator<IPCString> CREATOR = new Creator<IPCString>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCString[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114160);
            IPCString iPCString = new IPCString();
            iPCString.value = parcel.readString();
            AppMethodBeat.o(114160);
            return iPCString;
        }
    };
    public String value;

    public IPCString(String str) {
        this.value = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114161);
        parcel.writeString(this.value);
        AppMethodBeat.o(114161);
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114162);
        if (obj == this) {
            AppMethodBeat.o(114162);
            return true;
        } else if (obj instanceof IPCString) {
            IPCString iPCString = (IPCString) obj;
            if (this.value == iPCString.value || (this.value != null && this.value.equals(iPCString.value))) {
                AppMethodBeat.o(114162);
                return true;
            }
            AppMethodBeat.o(114162);
            return false;
        } else if (obj instanceof String) {
            boolean equals = obj.equals(this.value);
            AppMethodBeat.o(114162);
            return equals;
        } else {
            AppMethodBeat.o(114162);
            return false;
        }
    }

    static {
        AppMethodBeat.i(114163);
        AppMethodBeat.o(114163);
    }
}
