package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultDrawActionArg extends BaseDrawActionArg {
    public static final Creator<DefaultDrawActionArg> CREATOR = new Creator<DefaultDrawActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DefaultDrawActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103316);
            DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg(parcel);
            AppMethodBeat.o(103316);
            return defaultDrawActionArg;
        }
    };

    public DefaultDrawActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(103317);
        AppMethodBeat.o(103317);
    }
}
