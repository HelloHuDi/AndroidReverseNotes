package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg */
public class PathArcActionArg extends PathActionArg {
    public static final Creator<PathArcActionArg> CREATOR = new C191461();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg$1 */
    static class C191461 implements Creator<PathArcActionArg> {
        C191461() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathArcActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103597);
            PathArcActionArg pathArcActionArg = new PathArcActionArg(parcel);
            AppMethodBeat.m2505o(103597);
            return pathArcActionArg;
        }
    }

    public PathArcActionArg(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.m2504i(103598);
        AppMethodBeat.m2505o(103598);
    }
}
