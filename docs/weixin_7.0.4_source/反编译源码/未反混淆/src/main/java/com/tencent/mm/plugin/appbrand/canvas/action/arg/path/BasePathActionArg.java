package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;

public class BasePathActionArg extends BaseDrawActionArg {
    public static final Creator<BasePathActionArg> CREATOR = new Creator<BasePathActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BasePathActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103585);
            BasePathActionArg basePathActionArg = new BasePathActionArg(parcel);
            AppMethodBeat.o(103585);
            return basePathActionArg;
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103586);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(103586);
    }

    protected BasePathActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    static {
        AppMethodBeat.i(103587);
        AppMethodBeat.o(103587);
    }
}
