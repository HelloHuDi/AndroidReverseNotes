package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class PathClosePathActionArg extends BasePathActionArg {
    public static final Creator<PathClosePathActionArg> CREATOR = new Creator<PathClosePathActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathClosePathActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103607);
            PathClosePathActionArg pathClosePathActionArg = new PathClosePathActionArg(parcel);
            AppMethodBeat.o(103607);
            return pathClosePathActionArg;
        }
    };

    public PathClosePathActionArg(Parcel parcel) {
        super(parcel);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103608);
        super.j(jSONObject);
        AppMethodBeat.o(103608);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(103609);
        AppMethodBeat.o(103609);
    }
}
