package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable implements Parcelable {
    public static final Creator<WrapperParcelable> CREATOR = new Creator<WrapperParcelable>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WrapperParcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114106);
            WrapperParcelable wrapperParcelable = new WrapperParcelable();
            if (parcel.readInt() == 1) {
                wrapperParcelable.eGy = c.a(parcel.readString(), parcel);
            }
            AppMethodBeat.o(114106);
            return wrapperParcelable;
        }
    };
    Object eGy;

    /* synthetic */ WrapperParcelable(byte b) {
        this();
    }

    private WrapperParcelable() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114107);
        if (this.eGy != null) {
            a ar = c.ar(this.eGy);
            if (ar != null) {
                parcel.writeInt(1);
                parcel.writeString(ar.getClass().getName());
                ar.a(this.eGy, parcel);
                AppMethodBeat.o(114107);
                return;
            }
        }
        parcel.writeInt(1);
        AppMethodBeat.o(114107);
    }

    static {
        AppMethodBeat.i(114108);
        AppMethodBeat.o(114108);
    }
}
