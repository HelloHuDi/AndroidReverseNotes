package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PathArcActionArg extends PathActionArg {
    public static final Creator<PathArcActionArg> CREATOR = new Creator<PathArcActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathArcActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103597);
            PathArcActionArg pathArcActionArg = new PathArcActionArg(parcel);
            AppMethodBeat.o(103597);
            return pathArcActionArg;
        }
    };

    public PathArcActionArg(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(103598);
        AppMethodBeat.o(103598);
    }
}
