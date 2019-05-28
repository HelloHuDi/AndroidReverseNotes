package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PathArcToActionArg extends PathActionArg {
    public static final Creator<PathArcToActionArg> CREATOR = new Creator<PathArcToActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathArcToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103599);
            PathArcToActionArg pathArcToActionArg = new PathArcToActionArg(parcel);
            AppMethodBeat.o(103599);
            return pathArcToActionArg;
        }
    };

    public PathArcToActionArg(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(103600);
        AppMethodBeat.o(103600);
    }
}
