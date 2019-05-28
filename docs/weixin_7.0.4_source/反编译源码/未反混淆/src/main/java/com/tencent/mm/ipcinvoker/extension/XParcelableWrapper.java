package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;

public class XParcelableWrapper implements Parcelable {
    public static final Creator<XParcelableWrapper> CREATOR = new Creator<XParcelableWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XParcelableWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114103);
            XParcelableWrapper xParcelableWrapper = new XParcelableWrapper();
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (xParcelableWrapper.eGC == null) {
                    xParcelableWrapper.eGC = (f) k.c(readString, f.class);
                }
                if (xParcelableWrapper.eGC != null) {
                    xParcelableWrapper.eGC.readFromParcel(parcel);
                }
            }
            AppMethodBeat.o(114103);
            return xParcelableWrapper;
        }
    };
    public f eGC;

    /* synthetic */ XParcelableWrapper(byte b) {
        this();
    }

    private XParcelableWrapper() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114104);
        if (this.eGC != null) {
            parcel.writeInt(1);
            parcel.writeString(this.eGC.getClass().getName());
            this.eGC.e(parcel);
            AppMethodBeat.o(114104);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(114104);
    }

    static {
        AppMethodBeat.i(114105);
        AppMethodBeat.o(114105);
    }
}
