package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class RealSetFillStyleActionArg extends BaseDrawActionArg {
    public static final Creator<RealSetFillStyleActionArg> CREATOR = new Creator<RealSetFillStyleActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103360);
            RealSetFillStyleActionArg realSetFillStyleActionArg = new RealSetFillStyleActionArg(parcel);
            AppMethodBeat.o(103360);
            return realSetFillStyleActionArg;
        }
    };

    public RealSetFillStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    public void f(JSONArray jSONArray) {
    }

    static {
        AppMethodBeat.i(103361);
        AppMethodBeat.o(103361);
    }
}
