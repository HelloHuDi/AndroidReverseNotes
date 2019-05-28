package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class RealSetStrokeStyleActionArg extends BaseDrawActionArg {
    public static final Creator<RealSetStrokeStyleActionArg> CREATOR = new Creator<RealSetStrokeStyleActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103398);
            RealSetStrokeStyleActionArg realSetStrokeStyleActionArg = new RealSetStrokeStyleActionArg(parcel);
            AppMethodBeat.o(103398);
            return realSetStrokeStyleActionArg;
        }
    };

    public RealSetStrokeStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    public void f(JSONArray jSONArray) {
    }

    static {
        AppMethodBeat.i(103399);
        AppMethodBeat.o(103399);
    }
}
